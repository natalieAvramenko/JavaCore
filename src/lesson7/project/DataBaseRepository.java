package lesson7.project;

import lesson7.project.entity.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    private static final String DB_PATH = "jdbc:sqlite:C:Users:Александр:IdeaProjects:JavaCore:geekbrains.db";
    private String insertWeatherQuery = "insert into weather (city, local_date, temperature) values (?, ?, ?))";
    private String selectWeatherQuery = "select * from weather";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public boolean saveWeather(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement insertWeather = connection.prepareStatement(insertWeatherQuery);
            insertWeather.setString(1, weather.getCity());
            insertWeather.setString(2, weather.getLocalDate());
            insertWeather.setDouble(3, weather.getTemperature());

            return insertWeather.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw  new SQLException("Сохранение погоды не выполнено!");
    }
    public void saveWeather(List<Weather> weatherList) throws SQLException{
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement insertWeather = connection.prepareStatement(insertWeatherQuery);
            for (Weather weather : weatherList) {
                insertWeather.setString(1, weather.getCity());
                insertWeather.setString(2, weather.getLocalDate());
                insertWeather.setDouble(3, weather.getTemperature());
                insertWeather.addBatch();
            }
            insertWeather.executeBatch();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Weather getSaveToDB() {
        //TODO
        return null;
    }
    public List<Weather> getSaveToDBList() {
        List weatherList = new ArrayList();

        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(selectWeatherQuery);

            while (resultSet.next()) {
                weatherList.add(new Weather(resultSet.getString("city"),
                                                resultSet.getString("local_date"),
                                                resultSet.getDouble("temperature")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return weatherList;
    }
}
