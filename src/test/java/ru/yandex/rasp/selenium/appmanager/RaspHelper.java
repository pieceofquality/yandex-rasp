package ru.yandex.rasp.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.rasp.selenium.model.RaspData;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;


public class RaspHelper extends HelperBase {

    public RaspHelper(WebDriver wd){

        super(wd);
    }

    public void selectDestinationsSearch(RaspData raspData) {
        type(By.cssSelector("[name='fromName']"), raspData.getFrom());
        type(By.cssSelector("[name='toName']"), raspData.getTo());
        type(By.cssSelector(".date-input_search__input"), raspData.getWhen());
        click(By.xpath("//*[.=" + "'" + raspData.getTransport() + "'" + "]"));
    }

    public void submitSearch() {
        click(By.cssSelector("[type='submit']"));
    }

    public void сheckDestinationsTable(RaspData raspData) {
        String destinationsText = wd.findElement(By.cssSelector("h1")).getText();
        String arriveDateText = wd.findElement(By.cssSelector("[class='SearchTitle__subtitle']")).getText();
        String substr = raspData.getFrom().substring(0, raspData.getFrom().length()-2);
        Assert.assertTrue(destinationsText.contains(raspData.getFrom()));
        Assert.assertTrue(destinationsText.contains(raspData.getTo()));
        Assert.assertTrue(arriveDateText.contains(raspData.getWhen()));
    }

    public String nextDayOfWeek(DayOfWeek dayOfWeek) {
        return LocalDate.now().with(TemporalAdjusters.next(dayOfWeek)).toString();    }
}
