package com.keji.blog.codelibrary.designpattern.observerpattern;

import java.util.List;
import java.util.Observable;

/**
 * 天气数据主题. 继承Java内置的Observable类。Observable是一个类而不是接口，因此这种方式有局限性。
 *
 * @author wb-ny291824
 * @version $Id: WeatherData.java, v 0.1 2018-03-01 15:12 wb-ny291824 Exp $$
 */
public class WeatherData extends Observable{

    /**
     * 观察者集合
     */
    private List<Observer> observers;

    /**
     * 温度
     */
    private float temperature;

    /**
     * 湿度
     */
    private float humidity;

    /**
     * 大气压
     */
    private float pressure;

    public WeatherData() {

    }

    /**
     * 当天气状况改变通知所有观察者,通知前必须要调用setChanged()
     */
    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
