package lesson7.project;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lesson7.project.entity.Weather;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AccuWeatherModel implements WeatherModel {
    //Реализовать корректный вывод информации о текущей погоде.
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String API_KEY = "hGoMhcGoUwCBBMdJBYG7yMX38bWYVVlH";
    private static final String API_KEY_QUERY_PROPERTY = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    //http://dataservice.accuweather.com/forecasts/v1/daily/5day/
    private static final Object FIVE_DAYS = "5day";

    private static final DataBaseRepository dataBaseRepository = new DataBaseRepository();

    @Override
    public void getWeather(String selectedCity, DayPeriod dayPeriod) throws IOException {
        //http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
        switch (dayPeriod) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PROPERTY, API_KEY)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                System.out.println(weatherResponse);
                break;

            //http://dataservice.accuweather.com/forecasts/v1/daily/5day/
            case FIVE_DAYS:
                HttpUrl httpUrl1 = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment((String) FIVE_DAYS)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PROPERTY, API_KEY)
                        .build();

                Request request1 = new Request.Builder()
                        .url(httpUrl1)
                        .build();
//
                Response fiveDayForeCastResponse = okHttpClient.newCall(request1).execute();
                String weatherResponse1 = fiveDayForeCastResponse.body().string();
                System.out.println(weatherResponse1);

                Gson gson = new Gson();
                Map<String, Object> map = gson.fromJson(weatherResponse1, new TypeToken<Map<String, Object>>() {
                }.getType());
                map.forEach((x, y) -> System.out.println("key : " + x + " , value : " + y));


                JsonFactory factory = new JsonFactory();
                ObjectMapper mapper = new ObjectMapper(factory);
                JsonNode rootNode = mapper.readTree(weatherResponse1);

                Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
                Map<String, JsonNode> result = new HashMap<>();
                while (fieldsIterator.hasNext()) {
                    Map.Entry<String, JsonNode> field = fieldsIterator.next();
                    result.put(field.getKey(), field.getValue());
                    System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());
                }

                JsonNode jsonNode = result.get("Headline");
                System.out.println(jsonNode);
                System.out.println(jsonNode.get("Severity"));

                JsonNode jsonNode1 = result.get("DailyForecasts");
                System.out.println(jsonNode1.get(1));
                System.out.println(jsonNode1.get(2));
                break;
        }
    }

    @Override
    public boolean saveWeather(Weather weather) {
        try {
            return dataBaseRepository.saveWeather(weather);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Weather getSaveToDB() {
        return dataBaseRepository.getSaveToDB();
    }


    public void saveWeather(List<Weather> weatherList) {
        try {
            dataBaseRepository.saveWeather(weatherList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Weather> getSaveToDBList() {
        return dataBaseRepository.getSaveToDBList();
    }

    private String detectCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PROPERTY, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

//        Response locationResponse = okHttpClient.newCall(request).execute();
//        String locationResponseString = locationResponse.body().string();
//        System.out.println(locationResponseString);
//        return locationResponseString;
        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        System.out.println(cityKey);
        return cityKey;
    }
}
