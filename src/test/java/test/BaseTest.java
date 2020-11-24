package test;

import com.codeborne.selenide.Configuration;
import core.EnvironmentManager;
import listener.FailProviderListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.PageObject;

@Listeners({FailProviderListener.class})
public class BaseTest {

    @BeforeSuite
    public void setUp() {
        System.out.println("Environment: " + EnvironmentManager.getBaseUrl());
        Configuration.headless = false;
        Configuration.screenshots = true;
        Configuration.browserSize = "1366x768";
    }


    @AfterMethod()
    public void reset() {
        new PageObject().resetBrowser();
    }
}
