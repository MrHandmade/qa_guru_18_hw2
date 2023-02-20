package demo.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.BaseTest;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeFormPage extends BaseTest {
    private static final ElementsCollection inputFields = $$x("//input");
    private static final SelenideElement radio = $x("//input[@id='gender-radio-1']");
    private static final SelenideElement textArea = $x("//textarea");
    private static final SelenideElement dateOfCalendar = $x("//div[contains(@class,'today')]");

    public static void fillPracticeForm(String name, String surname,
                                        String email, String phoneNumber,
                                        String subject, String currentAddress,
                                        String pathToPic){

        inputFields.get(0).sendKeys(name);
        inputFields.get(1).sendKeys(surname);
        inputFields.get(2).sendKeys(email);
//        radio.selectRadio('');
        inputFields.get(6).sendKeys(phoneNumber);
        inputFields.get(7).click();
        dateOfCalendar.click();
        inputFields.get(8).sendKeys(subject);
        inputFields.get(9).click();
        inputFields.get(10).click();
        inputFields.get(13).uploadFile(new File(pathToPic));
        textArea.sendKeys(currentAddress);
    }
}
