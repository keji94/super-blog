package com.keji.blog.codelibrary.designpattern.observerpattern;

/**
 * @author wb-ny291824
 * @version $Id: WeatherStationTest.java, v 0.1 2018-03-01 15:52 wb-ny291824 Exp $$
 */
public class WeatherStationTest {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay display = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(80,65,30.4F);
        weatherData.setMeasurements(82,70,30.4F);
        weatherData.setMeasurements(78,72,30.4F);
    }
}
