package pages;

import com.codeborne.selenide.SelenideElement;
import container.UserContainer;
import core.EnvironmentManager;
import helpers.DownloadFileHelper;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.open;

public class CreateApplicationPage extends PageObject {

    @FindBy(how = How.XPATH, using = "//*[@name='name']")
    public SelenideElement inputName;

    @FindBy(how = How.XPATH, using = "//*[@name='email']")
    public SelenideElement inputEmail;

    @FindBy(how = How.XPATH, using = "//*[@name='phone']")
    public SelenideElement inputPhone;

    @FindBy(how = How.XPATH, using = "//*[@name='message']")
    public SelenideElement inputMessage;

    @FindBy(how = How.XPATH, using = "//*[@name='document']")
    public SelenideElement buttonAttachFile;

    @FindBy(how = How.XPATH, using = "//*[@type='submit']")
    public SelenideElement buttonSubmit;

    @FindBy(how = How.XPATH, using = "(//*[@class='error-message'])[1]")
    public SelenideElement errorNameMessage;

    @FindBy(how = How.XPATH, using = "(//*[@class='error-message'])[2]")
    public SelenideElement errorEmailMessage;

    @FindBy(how = How.XPATH, using = "(//*[@class='error-message'])[3]")
    public SelenideElement errorPhoneMessage;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Прикрепите файл')]")
    public SelenideElement document;

    @FindBy(how = How.XPATH, using = "//*[@class='feedback-page']")
    public SelenideElement textMessageSend;

    public void fillData(UserContainer user) {
        inputName.setValue(user.getName());
        inputEmail.setValue(user.getEmail());
        inputPhone.setValue(user.getPhone());
        inputMessage.setValue(user.getMessage());

        Actions actions = new Actions(document.getWrappedDriver());
        actions.moveToElement(document).click().build().perform();

        new DownloadFileHelper().downloadFileByRobot(user.getFile().getAbsolutePath());

        buttonSubmit.click();

    }


    public CreateApplicationPage openPage() {
        return open(
                EnvironmentManager.getBaseUrl(),
                this.getClass()
        );
    }
}
