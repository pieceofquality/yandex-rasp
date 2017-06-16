package ru.yandex.rasp.selenium.model;

/**
 * Created by piece on 6/16/2017.
 */
public class TripData {
    private final String name;
    private final String departureTime;
    private final String arrivalTime;

    public TripData(String name, String departureTime, String arrivalTime) {
        this.name = name;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getName() {
        return name;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }


}
