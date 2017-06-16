package ru.yandex.rasp.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.rasp.selenium.model.TripData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piece on 6/16/2017.
 */
public class TripHelper extends HelperBase{
    
    public TripHelper(WebDriver wd) {
        super(wd);
    }

    public List <TripData> getTriplist() {
       List<TripData> trips = new ArrayList<TripData>();
       List<WebElement> elements = wd.findElements(By.cssSelector(".SearchSegment_isVisible"));
       for (WebElement element : elements) {
           String name = element.getText();
           TripData trip = new TripData(name, null, null, 0);
           trips.add(trip);
           System.out.println(name);
       }
        return trips;
    }

    public List <TripData> getFirstTrip() {
       List<TripData> trips = new ArrayList<TripData>();
       List<WebElement> elements = wd.findElements(By.cssSelector(".SearchSegment_isVisible"));
       for (WebElement element : elements) {
           if (getDepartureTime(element) != "11:38") {
               System.out.println("Нет рейса на 11:38");;
           }
           String name = element.getText();
           int price = Integer.parseInt(element.findElement(By.cssSelector("SuburbanTariffs__buttonPrice")).getText());
           String departure_time = getDepartureTime(element);
           TripData trip = new TripData(name, departure_time, null, price);
           trips.add(trip);
           System.out.println(price);
       }
        return trips;
    }

    private String getDepartureTime(WebElement element) {
        return element.findElement(By.cssSelector("[class='SearchSegment__time Time_important']")).getText();
    }


}
