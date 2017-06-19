package ru.yandex.rasp.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.rasp.selenium.model.RaspData;
import ru.yandex.rasp.selenium.model.TripData;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by piece on 6/16/2017.
 */
public class TripHelper extends HelperBase{
    
    public TripHelper(WebDriver wd) {
        super(wd);
    }

    public void getTripWithTime() {
        List<TripData> trips = new ArrayList<TripData>();
        List<WebElement> elements = wd.findElements(By.cssSelector(".SearchSegment_isVisible"));
        for (WebElement element : elements) {
            String name = element.getText();
            int price = roublePrice(element);
            LocalTime departure_time = getDepartureTime(element);
            TripData trip = new TripData(name, departure_time, null, price);
            if (getDepartureTime(element).isAfter(LocalTime.NOON) && roublePrice(element)>200) {
                System.out.println(getDepartureTime(element) + "    " + roublePrice(element) + "р.     " + dollarPrice(element));
                element.findElement(By.cssSelector("[href]")).click();
                trips.add(trip);
                return;
            }
            }
        if (trips.isEmpty()){
            System.out.println("Рейсов с такими условиями нет");
    }
    }

    private String dollarPrice(WebElement element) {
        click(By.cssSelector(".CurrencySelect"));
        click(By.cssSelector("[data-value='USD']"));
        return element.findElement(By.cssSelector(".SuburbanTariffs__buttonPrice")).getText();
    }

    public int roublePrice(WebElement element) {
        return Integer.parseInt(element.findElement(By.cssSelector(".SuburbanTariffs__buttonPrice")).getText().replace(" Р", ""));
    }

    public LocalTime getDepartureTime(WebElement element) {
        return LocalTime.parse(element.findElement(By.cssSelector("[class='SearchSegment__time Time_important'] span")).getText());
    }


    public void сheckDestinations(RaspData raspData) {
        String destinationsText = wd.findElement(By.cssSelector("h1")).getText();
        String arriveDateText = wd.findElement(By.cssSelector("[class='SearchTitle__subtitle']")).getText();
        String substr = raspData.getFrom().substring(0, raspData.getFrom().length()-2);
        Assert.assertTrue(destinationsText.contains(raspData.getFrom()));
        Assert.assertTrue(destinationsText.contains(raspData.getTo()));
        Assert.assertTrue(arriveDateText.contains(raspData.getWhen()));
    }


}
