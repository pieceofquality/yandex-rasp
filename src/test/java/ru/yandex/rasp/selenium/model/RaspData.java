package ru.yandex.rasp.selenium.model;

import java.util.Date;

public class RaspData {
    private final String from;
    private final String to;
    private final String when;

    public RaspData(String from, String to, String when) {
        this.from = from;
        this.to = to;
        this.when = when;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getWhen() {return when;}

}
