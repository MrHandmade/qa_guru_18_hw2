package demo.qa.tests;

import demo.qa.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

import java.io.File;

public class DemoQaTest extends PracticeFormPage {
    private static final String name = "Maxim";
    private static final String surname = "Shavykin";
    private static final String email = "myemail@hame.com";
    private static final String phoneNumber = "7999888223";
    private static final String subject = "English";
    private static final String currentAddress = "Baker.st";


    @Test
    public void homeWorkTest(){
        fillPracticeForm(name, surname, email, phoneNumber, subject, currentAddress);
        checkFillForm(name, surname, email, phoneNumber, subject, currentAddress);
    }

}
