package test;

import assertions.SubmitApplicationAssert;
import container.UserContainer;
import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateApplicationPage;

public class SubmitApplicationTest extends BaseTest {

    private UserContainer user;
    private CreateApplicationPage appPage;
    SubmitApplicationAssert applicationAssert;

    @Test(dataProvider = "dataProvider")
    public void SubmitApplicationTest() {
        initStuff();
        emptyCheck();
        positiveCheck();
        applicationAssert.softAssertCheck();
    }

    @Step("Init Stuff")
    public void initStuff() {
        CreateApplicationPage appPage = new CreateApplicationPage().openPage();
        this.appPage = appPage;
        this.applicationAssert = new SubmitApplicationAssert(appPage);
    }


    @Step("Проверяем без заполнения полей")
    public void emptyCheck() {
        appPage.buttonSubmit.click();
        applicationAssert.emptyFieldsAssert();
    }

    @Step("Проверяем корректные данные")
    public void positiveCheck() {
        appPage.fillData(user);
        applicationAssert.positiveFieldsAssert();
    }

    @DataProvider
    public Object[][] dataProvider() {


        this.user = new UserContainer().getPositiveUserData();

        return new Object[][]{
                {}
        };

    }
}
