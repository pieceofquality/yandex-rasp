package ru.yandex.rasp.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.rasp.selenium.model.RaspData;


public class RaspHelper extends HelperBase {

    public RaspHelper(WebDriver wd){

        super(wd);
    }

    public void selectDestinationsSearch(RaspData raspData) {
        type(By.cssSelector("[name='fromName']"), raspData.getFrom());
        type(By.cssSelector("[name='toName']"), raspData.getTo());
        type(By.cssSelector(".date-input_search__input"), raspData.getWhen());
        click(By.linkText(raspData.getTransport()));
    }

    public void submitSearch() {
        click(By.cssSelector("[type='submit']"));
    }

    public void сheckDestinations(RaspData raspData) {
        String destinationsText = wd.findElement(By.cssSelector("h1")).getText();
        String arriveDateText = wd.findElement(By.cssSelector("[class='SearchTitle__subtitle']")).getText();
        String substr = raspData.getFrom().substring(0, raspData.getFrom().length()-2);
//      System.out.println(raspData.getFrom());
//      RaspData raspData = new RaspData(substr, raspData.getTo(), raspData.getWhen());
        Assert.assertTrue(destinationsText.contains(raspData.getFrom()));
        Assert.assertTrue(destinationsText.contains(raspData.getTo()));
        Assert.assertTrue(arriveDateText.contains(raspData.getWhen()));
    }

    public void infoAboutTrip(WebElement el) {
        String departureTime = el.findElement(By.cssSelector("[class='SearchSegment__time Time_important']")).getText();
        String  roublePrice = el.findElement(By.cssSelector("[class='Price SuburbanTariffs__buttonPrice']")).getText();
        wd.findElement(By.cssSelector("[class='Select CurrencySelect']")).click();
        wd.findElement(By.cssSelector("[data-value='USD']")).click();
        String dollarPrice = el.findElement(By.cssSelector("")).getText();
        System.out.println("Время отправления" + departureTime);
        System.out.println("Стоимость билета в рублях" + roublePrice);
        System.out.println("Стоимость билета в долларах" + dollarPrice);

    }
}
