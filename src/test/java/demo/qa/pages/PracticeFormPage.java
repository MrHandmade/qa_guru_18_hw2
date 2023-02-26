package demo.qa.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.BaseTest;

import java.io.File;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeFormPage extends BaseTest {
    private static final SelenideElement userName = $x("//input[@id='firstName']");
    private static final SelenideElement userLastname = $x("//input[@id='lastName']");
    private static final SelenideElement userEmail = $x("//input[@id='userEmail']");
    private static final SelenideElement userNumber = $x("//input[@id='userNumber']");
    private static final SelenideElement checkBoxHobbiesSports = $x("//label[text()='Sports']");
    private static final SelenideElement checkBoxHobbiesReading = $x("//label[text()='Reading']");
    private static final SelenideElement checkBoxHobbiesMusic = $x("//label[text()='Music']");
    private static final SelenideElement radioButtonGender = $x("//label[text()='Male']");
    private static final SelenideElement calendar = $x("//input[@id = 'dateOfBirthInput']");
    private static final ElementsCollection monthNYear = $$x("//select");
    private static final SelenideElement monthOfDate = $x("//option[@value = '11']");
    private static final SelenideElement yearOfDate = $x("//option[@value = '2000']");
    private static final SelenideElement dayOfDate = $x("//div[text()='31']");
    private static final SelenideElement subject = $x("//input[@id='subjectsInput']");
    private static final File pic = new File("src/test/resource/pwa_vertical_1280_55d23da46a4b99f74eedbba9ec98aa80.jpg");
    private static final SelenideElement uploadPicture = $x("//input[@id='uploadPicture']");
    private static final SelenideElement currentAddress = $x("//textarea[@id='currentAddress']");
    private static final SelenideElement state = $x("//div[@id='state']");
    private static final SelenideElement stateNCR = $x("//div[text()='NCR']");
    private static final SelenideElement city = $x("//div[@id='city']");
    private static final SelenideElement cityDelhi = $x("//div[text()='Delhi']");
    private static final SelenideElement submit = $x("//button[@id='submit']");
    private static final SelenideElement table = $x("//table");
    private static final SelenideElement closeButton = $x("//button[@id='closeLargeModal']");


    public static void fillPracticeForm(){
        userName.sendKeys("Maxim");
        userLastname.sendKeys("Shavykin");
        userEmail.sendKeys("test@email.com");
        radioButtonGender.click();
        userNumber.sendKeys("7999888322");
        calendar.click();
        monthNYear.first().click();
        monthOfDate.click();
        monthNYear.last().click();
        yearOfDate.click();
        dayOfDate.click();
        subject.setValue("English").pressEnter();
        checkBoxHobbiesSports.click();
        checkBoxHobbiesMusic.click();
        checkBoxHobbiesReading.click();
        uploadPicture.uploadFile(pic);
        currentAddress.sendKeys("Baker.st");
        state.click();
        stateNCR.click();
        city.click();
        cityDelhi.click();
        submit.click();
    }

    public static void checkFillForm(){
        table.shouldHave(Condition.text("Maxim Shavykin"));
        table.shouldHave(Condition.text("test@email.com"));
        table.shouldHave(Condition.text("Male"));
        table.shouldHave(Condition.text("7999888322"));
        table.shouldHave(Condition.text("31 December,2000"));
        table.shouldHave(Condition.text("Sports, Music, Reading"));
        table.shouldHave(Condition.text("pwa_vertical_1280_55d23da46a4b99f74eedbba9ec98aa80.jpg"));
        table.shouldHave(Condition.text("Baker.st"));
        table.shouldHave(Condition.text("NCR Delhi"));
        closeButton.click();
    }
}
