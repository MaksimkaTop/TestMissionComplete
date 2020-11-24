package assertions;

import com.codeborne.selenide.Condition;
import pages.CreateApplicationPage;
import org.testng.asserts.SoftAssert;


public class SubmitApplicationAssert {
    private CreateApplicationPage appPage;
    SoftAssert softAssert = new SoftAssert();


    public SubmitApplicationAssert(CreateApplicationPage appPage) {
        this.appPage = appPage;
    }

    public void emptyFieldsAssert() {
        softAssert.assertEquals(appPage.errorNameMessage.getText(),
                "Заполните поле",
                "Что то пошло не так: ");

        softAssert.assertEquals(appPage.errorEmailMessage.getText(),
                "Заполните поле",
                "Что то пошло не так: ");

        softAssert.assertEquals(appPage.errorPhoneMessage.getText(),
                "Заполните поле",
                "Что то пошло не так: ");
    }

    public void positiveFieldsAssert() {
        softAssert.assertFalse(appPage.errorNameMessage.has(Condition.visible), "Присутствуют поля ошибок!");
        softAssert.assertFalse(appPage.errorEmailMessage.has(Condition.visible), "Присутствуют поля ошибок!");
        softAssert.assertFalse(appPage.errorPhoneMessage.has(Condition.visible), "Присутствуют поля ошибок!");
        softAssert.assertEquals(appPage.textMessageSend.getText(),
                "Сообщение успешно отправлено!",
                "Походу неуспешно неотправлено");
    }

    public void softAssertCheck() {
        softAssert.assertAll();
    }
}
