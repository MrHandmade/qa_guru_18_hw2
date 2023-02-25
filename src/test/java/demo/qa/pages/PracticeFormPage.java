package demo.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.BaseTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage extends BaseTest {
    private static final ElementsCollection inputFields = $$x("//input");
    private static final SelenideElement radioButtonGender = $x("//label[text()='Male']");
    private static final SelenideElement checkBoxHobbies = $x("//label[text()='Sports']");
    private static final SelenideElement textArea = $x("//textarea");
    private static final ElementsCollection date = $$x("//select");
    private static final SelenideElement monthOfDate = $x("//option[@value = '11']");
    private static final SelenideElement yearOfDate = $x("//option[@value = '2000']");
    private static final SelenideElement dayOfDate = $x("//div[text()='31']");
    private static final SelenideElement myDateOfBirth = $x("//input[@id = 'dateOfBirthInput']");
    private static final SelenideElement state = $x("//div[@id='state']");
    private static final SelenideElement stateNCR = $x("//div[text()='NCR']");
    private static final SelenideElement city = $x("//div[@id='city']");
    private static final SelenideElement cityDelhi = $x("//div[text()='Delhi']");
    private static final SelenideElement submit = $x("//button[@id='submit']");
    private static final ElementsCollection checkFields = $$x("//td");

    private static File pic = new File("src/test/resource/pwa_vertical_1280_55d23da46a4b99f74eedbba9ec98aa80.jpg");

    private static String myBirthDay = "";




    public static void fillPracticeForm(String name, String surname,
                                        String email, String phoneNumber,
                                        String subject, String currentAddress){

        /** Заполнение формы данными*/
        inputFields.get(0).sendKeys(name);
        inputFields.get(1).sendKeys(surname);
        inputFields.get(2).sendKeys(email);
        radioButtonGender.click();
        inputFields.get(6).sendKeys(phoneNumber);

        /** Выбор даты рождения и сохранение даты в перменную */
        inputFields.get(7).click();
        date.first().click();
        monthOfDate.click();
        date.last().click();
        yearOfDate.click();
        myBirthDay = dayOfDate.getText() + " " + monthOfDate.getText() + "," + yearOfDate.getText();
        dayOfDate.click();

        /** Дозаполнение формы  */
        inputFields.get(8).setValue(subject).pressEnter();
        checkBoxHobbies.click();
        inputFields.get(12).uploadFile(pic);
        textArea.sendKeys(currentAddress);
        state.click();
        stateNCR.click();
        city.click();
        cityDelhi.click();
        submit.click();
    }
    @Test
    public static void checkFillForm(String name, String surname,
                                     String email, String phoneNumber,
                                     String subject, String currentAddress){

        checkFields.get(1).shouldHave(Condition.exactText(name + " " + surname));
        checkFields.get(3).shouldHave(Condition.exactText(email));
        checkFields.get(5).shouldHave(Condition.exactText(radioButtonGender.getText()));
        checkFields.get(7).shouldHave(Condition.exactText(phoneNumber));
        checkFields.get(9).shouldHave(Condition.exactText(myBirthDay));
        checkFields.get(11).shouldHave(Condition.exactText(subject));
        checkFields.get(13).shouldHave(Condition.exactText(checkBoxHobbies.getText()));
        checkFields.get(15).shouldHave(Condition.exactText(pic.getName()));
        checkFields.get(17).shouldHave(Condition.exactText(currentAddress));
        checkFields.get(19).shouldHave(Condition.exactText(stateNCR.getText() + " " + cityDelhi.getText()));

    }
}
