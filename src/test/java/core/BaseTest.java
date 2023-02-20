package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.baseUrl;

public class BaseTest {
    @BeforeAll
    public static void setUp(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = false;
        Configuration.headless = false;
        Configuration.savePageSource = false;
        baseUrl = "https://demoqa.com/";


        Selenide.open(baseUrl + "automation-practice-form");
    }

}
