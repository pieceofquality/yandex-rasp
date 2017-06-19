package ru.yandex.rasp.selenium.model;

import java.time.LocalTime;

/**
 * Created by piece on 6/16/2017.
 */
public class TripData {
    private final String name;
    private final LocalTime departureTime;
    private final String departurePoint;
    private final String arrivalTime;
    private final String arrivalPoint;
    private final int price;
    private final String travelTime;



    public TripData(String name, LocalTime departureTime, String arrivalTime, int price) {
        this.name = name;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getPrice() {
        return price;
    }
}
