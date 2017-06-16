package ru.yandex.rasp.selenium.model;

/**
 * Created by piece on 6/16/2017.
 */
public class TripData {
    private final String name;
    private final String departureTime;
    private final String arrivalTime;
    private final int price;



    public TripData(String name, String departureTime, String arrivalTime, int price) {
        this.name = name;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
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

    public int getPrice() {
        return price;
    }
}
