package lesson7.project;

import lesson7.project.entity.Weather;

import java.io.IOException;
import java.sql.SQLException;

public interface WeatherModel {
    void getWeather(String city, DayPeriod dayPeriod) throws IOException;

    boolean saveWeather(Weather weather) throws SQLException;

    Weather getSaveToDB();
}
