package ru.yandex.rasp.selenium.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private RaspHelper raspHelper;
    private String browser;
    private NavigationHelper navigationHelper;
    private TripHelper tripHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() throws IOException {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        } else if (browser.equals(BrowserType.EDGE)){
            wd = new EdgeDriver();
        }

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("https://yandex.ru/");
        raspHelper = new RaspHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        tripHelper = new TripHelper(wd);

    }

    public void stop() {
        wd.quit();
    }


    public RaspHelper getRaspHelper() {
        return raspHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public TripHelper getTripHelper() {
        return tripHelper;
    }
}
