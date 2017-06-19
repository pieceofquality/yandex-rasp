package ru.yandex.rasp.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToRasp() {
        click(By.linkText("ещё"));
        click(By.linkText("Расписания"));
    }


}
