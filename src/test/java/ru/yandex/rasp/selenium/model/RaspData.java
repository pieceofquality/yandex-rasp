package ru.yandex.rasp.selenium.model;

import java.util.Date;

public class RaspData {
    private final String to;
    private final String subject;
    private final Date time;

    public RaspData(String from, String to, Date time) {
        this.to = from;
        this.subject = to;
        this.time = time;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public Date getTime() {return time;}

}
