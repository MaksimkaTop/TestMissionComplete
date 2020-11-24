package pages;

import com.codeborne.selenide.WebDriverRunner;
import core.EnvironmentManager;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.close;

public  class PageObject {


    public PageObject openPage() {
        try {
            return open(
                    EnvironmentManager.getBaseUrl(),
                    this.getClass()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void resetBrowser() {
        if (!WebDriverRunner.hasWebDriverStarted()) {
            return;
        }
        clearBrowserCookies();
        clearBrowserLocalStorage();
        close();
    }
}
