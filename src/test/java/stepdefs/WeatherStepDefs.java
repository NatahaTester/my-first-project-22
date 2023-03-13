package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import requesters.WeatherRequester;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WeatherStepDefs {

    private long cityId;
    private WeatherResponse response;

    @Given("city ID is: {long}")
    public void set_city_id(long cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather forecast")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityId);
    }

    @Then("coordinates are:")
    public void check_coordinates(Map<String, Double> params) {
        Assertions.assertEquals(params.get("lat"), response.getLat(), "Wrong latitude");
        Assertions.assertEquals(params.get("lon"), response.getLon(), "Wrong longitude");
    }

    @Then("timezone information is:")
    public void check_timezone(Map<String, String> params) {
        Assertions.assertEquals(params.get("timezone"), response.getTimezone(), "Wrong timezone");
        Assertions.assertEquals(Integer.parseInt(params.get("offset")), response.getTimezoneOffset(), "Wrong offset");
    }

    @Then("current weather is:")
    public void check_current_weather(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("current_time")), response.getCurrent().getDt(), "wrong data");
        Assertions.assertEquals(Long.parseLong(params.get("sunrise")), response.getCurrent().getSunrise(), "wrong sunrise");
        Assertions.assertEquals(Long.parseLong(params.get("sunset")), response.getCurrent().getSunset(), "wrong sunset");
        Assertions.assertEquals(Double.parseDouble(params.get("temperature")), response.getCurrent().getTemp(), "wrong temperature");
        Assertions.assertEquals(Double.parseDouble(params.get("feels_like")), response.getCurrent().getFeelsLike(), "wrong feels");
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getCurrent().getPressure(), "wrong pressure");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getCurrent().getHumidity(), "wrong humidity");
        Assertions.assertEquals(Double.parseDouble(params.get("dew_point")), response.getCurrent().getDewPoint(), "Wrong dew point");
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getCurrent().getUvi(), "Wrong uvi");
        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getCurrent().getClouds(), "Wrong clouds");
        Assertions.assertEquals(Integer.parseInt(params.get("visibility")), response.getCurrent().getVisibility(), "Wrong visibility");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getCurrent().getWindSpeed(), "Wrong wind speed");
        Assertions.assertEquals(Integer.parseInt(params.get("wind_deg")), response.getCurrent().getWindDeg(), "Wrong wind deg");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getCurrent().getWindGust(), "Wrong wind gust");
    }

    @Then("current weather condition is:")
    public void check_current_weather_condition(Map<String, String> params) {
        Assertions.assertEquals(Integer.parseInt(params.get("id")), response.getCurrent().getWeathers().get(0).getId(), "wrong id");
        Assertions.assertEquals(params.get("main"), response.getCurrent().getWeathers().get(0).getMain(), "wrong main");
        Assertions.assertEquals(params.get("description"), response.getCurrent().getWeathers().get(0).getDescription(), "wrong description");
        Assertions.assertEquals(params.get("icon"), response.getCurrent().getWeathers().get(0).getIcon(), "wrong icon");

    }

    @Then("minute forecast weather is:")
    public void check_minute_forecast_weather(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("data_time")), response.getMinutely().get(0).getDt(), "wrong data");
        Assertions.assertEquals(Integer.parseInt(params.get("precipitation")), response.getMinutely().get(0).getPrecipitation(), "wrong precipitation");
    }

    @Then("hourly forecast weather is:")
    public void check_hourly_forecast_weather(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("data_time")), response.getHourly().get(0).getDt(), "wrong data");
        Assertions.assertEquals(Double.parseDouble(params.get("temperature")), response.getHourly().get(0).getTemp(), "wrong temperature");
        Assertions.assertEquals(Double.parseDouble(params.get("feels_like")), response.getHourly().get(0).getFeelsLike(), "wrong feels like");
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getHourly().get(0).getPressure(), "wrong pressure");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getHourly().get(0).getHumidity(), "wrong humidity");
        Assertions.assertEquals(Double.parseDouble(params.get("dew_point")), response.getHourly().get(0).getDewPoint(), "wrong dew point");
        Assertions.assertEquals(Double.parseDouble(params.get("UV_index")), response.getHourly().get(0).getUvi(), "wrong UV index");
        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getHourly().get(0).getClouds(), "wrong clouds");
        Assertions.assertEquals(Integer.parseInt(params.get("visibility")), response.getHourly().get(0).getVisibility(), "wrong visibility");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getHourly().get(0).getWindSpeed(), "wrong wind speed");
        Assertions.assertEquals(Integer.parseInt(params.get("wind_direction_degrees")), response.getHourly().get(0).getWindDeg(), "wrong wind direction degrees");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getHourly().get(0).getWindGust(), "wrong wind gust");

        Assertions.assertEquals(Double.parseDouble(params.get("probability_of_precipitation")), response.getHourly().get(0).getPop(), "wrong probability of precipitation");
    }

    @Then("hourly weather condition is:")
    public void check_hourly_weather_condition(Map<String, String> params) {
        Assertions.assertEquals(Integer.parseInt(params.get("id")), response.getHourly().get(0).getWeathers().get(0).getId(), "wrong id");
        Assertions.assertEquals(params.get("main"), response.getHourly().get(0).getWeathers().get(0).getMain(), "wrong main");
        Assertions.assertEquals(params.get("description"), response.getHourly().get(0).getWeathers().get(0).getDescription(), "wrong description");
        Assertions.assertEquals(params.get("icon"), response.getHourly().get(0).getWeathers().get(0).getIcon(), "wrong icon");
    }

    @Then("daily forecast weather is:")
    public void check_daily_forecast_weather(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("data_time")), response.getDaily().get(0).getDt(), "wrong data");
        Assertions.assertEquals(Long.parseLong(params.get("sunrise")), response.getDaily().get(0).getSunrise(), "wrong sunrise");
        Assertions.assertEquals(Long.parseLong(params.get("sunset")), response.getDaily().get(0).getSunset(), "wrong sunset");
        Assertions.assertEquals(Long.parseLong(params.get("moonrise")), response.getDaily().get(0).getMoonrise(), "wrong moonrise");
        Assertions.assertEquals(Long.parseLong(params.get("moonset")), response.getDaily().get(0).getMoonset(), "wrong moonset");
        Assertions.assertEquals(Double.parseDouble(params.get("moon_phase")), response.getDaily().get(0).getMoonPhase(), "wrong moon phase");

        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getDaily().get(0).getPressure(), "wrong pressure");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getDaily().get(0).getHumidity(), "wrong humidity");
        Assertions.assertEquals(Double.parseDouble(params.get("dew_point")), response.getDaily().get(0).getDewPoint(), "wrong dew point");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getDaily().get(0).getWindSpeed(), "wrong wind speed");
        Assertions.assertEquals(Integer.parseInt(params.get("wind_deg")), response.getDaily().get(0).getWindDeg(), "wrong wind deg");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getDaily().get(0).getWindGust(), "wrong wind gust");

        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getDaily().get(0).getClouds(), "wrong clouds");
        Assertions.assertEquals(Double.parseDouble(params.get("probability_of_precipitation")), response.getDaily().get(0).getPop(), "wrong probability of precipitation");
        Assertions.assertEquals(Double.parseDouble(params.get("rain")), response.getDaily().get(0).getRain(), "wrong rain");
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getDaily().get(0).getUvi(), "wrong uvi");
    }
    @Then("daily temperature is:")
    public void check_daily_temperature(Map<String, Double> params) {
        Assertions.assertEquals(params.get("day"), response.getDaily().get(0).getTemp().getDay(), "wrong day");
        Assertions.assertEquals(params.get("min"), response.getDaily().get(0).getTemp().getMin(), "wrong min");
        Assertions.assertEquals(params.get("max"), response.getDaily().get(0).getTemp().getMax(), "wrong max");
        Assertions.assertEquals(params.get("night"), response.getDaily().get(0).getTemp().getNight(), "wrong night");
        Assertions.assertEquals(params.get("evening"), response.getDaily().get(0).getTemp().getEve(), "wrong evening");
        Assertions.assertEquals(params.get("morning"), response.getDaily().get(0).getTemp().getMorn(), "wrong morning");
    }

    @Then("daily temperature feels like:")
    public void check_daily_temp_feels_like(Map<String, Double> params) {
        Assertions.assertEquals(params.get("day"), response.getDaily().get(0).getFeelsLike().getDay(), "wrong day");
        Assertions.assertEquals(params.get("night"), response.getDaily().get(0).getFeelsLike().getNight(), "wrong night");
        Assertions.assertEquals(params.get("evening"), response.getDaily().get(0).getFeelsLike().getEve(), "wrong evening");
        Assertions.assertEquals(params.get("morning"), response.getDaily().get(0).getFeelsLike().getMorn(), "wrong morning");
    }

    @Then("daily weather condition is:")
    public void check_daily_weather_condition(Map<String, String> params) {
        Assertions.assertEquals(Integer.parseInt(params.get("id")), response.getDaily().get(0).getWeathers().get(0).getId(), "wrong id");
        Assertions.assertEquals(params.get("main"), response.getDaily().get(0).getWeathers().get(0).getMain(), "wrong main");
        Assertions.assertEquals(params.get("description"), response.getDaily().get(0).getWeathers().get(0).getDescription(), "wrong description");
        Assertions.assertEquals(params.get("icon"), response.getDaily().get(0).getWeathers().get(0).getIcon(), "wrong icon");
    }

    @Then("alert Nr.{int} received:")
    public void check_alert(int index, Map<String, String> params) {
        Assertions.assertEquals(params.get("sender"), response.getAlerts().get(0).getSenderName(), "wrong sender name");
        Assertions.assertEquals(params.get("event"), response.getAlerts().get(0).getEvent(), "wrong event");
        Assertions.assertEquals(Long.parseLong(params.get("start")), response.getAlerts().get(0).getStart(), "wrong start");
        Assertions.assertEquals(Long.parseLong(params.get("end")), response.getAlerts().get(0).getEnd(), "wrong end");
        Assertions.assertEquals(params.get("description"), response.getAlerts().get(0).getDescription(), "wrong description");
    }

    @Then("tags for an alert Nr.{int} are:")
    public void check_tags(int index, List<String> tags) {
        Assertions.assertEquals(tags.get(0), response.getAlerts().get(0).getTags().get(0), "wrong tag");
        Assertions.assertEquals(tags.get(0), response.getAlerts().get(0).getTags().get(0), "wrong tag2");
    }
}
