package com.keji.blog.codelibrary.designpattern.observerpattern;

import java.util.Observable;
import java.util.Observer;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author wb-ny291824
 * @version $Id: CurrentConditionDisplay.java, v 0.1 2018-03-01 15:29 wb-ny291824 Exp $$
 */
public class CurrentConditionDisplay implements Observer, DisplayElement{

    Observable observable;

    private float temperature;

    private float humidity;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)observable;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
