package lesson7.project;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModel = new AccuWeatherModel();
    private Map<Integer, DayPeriod> variants = new HashMap<>();

    public Controller() {
        variants.put(1, DayPeriod.NOW);
        variants.put(5, DayPeriod.FIVE_DAYS);
    }

    public void getWeather(String userInput, String selectedCity) throws IOException {
        Integer userIntegerInput = Integer.parseInt(userInput);

        switch (variants.get(userIntegerInput)) {
            case NOW:
                weatherModel.getWeather(selectedCity, DayPeriod.NOW);
                break;
            case FIVE_DAYS:
                weatherModel.getWeather(selectedCity, DayPeriod.FIVE_DAYS);
                break;
        }
    }
}
