package demo.qa.tests;

import demo.qa.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

public class DemoQaTest extends PracticeFormPage {
    private static final String name = "Maxim";
    private static final String surname = "Maxim";
    private static final String email = "Maxim";
    private static final String phoneNumber = "Maxim";
    private static final String subject = "Maxim";
    private static final String currentAddress = "Maxim";
    private static final String pathToPic = "Maxim";

    @Test
    public void homeWorkTest(){
        fillPracticeForm(name, surname, email, phoneNumber, subject, currentAddress, pathToPic);

    }
}
