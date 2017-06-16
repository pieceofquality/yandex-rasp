package ru.yandex.rasp.selenium.model;

import java.util.Date;

public class RaspData {
    private final String from;
    private final String to;
    private final String when;
    private final String transport;


    public RaspData(String from, String to, String when, String transport) {
        this.from = from;
        this.to = to;
        this.when = when;
        this.transport = transport;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getWhen() {return when;}

    public String getTransport() {
        return transport;
    }

}
