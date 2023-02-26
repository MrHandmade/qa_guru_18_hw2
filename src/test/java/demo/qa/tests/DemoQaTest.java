package demo.qa.tests;

import demo.qa.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

public class DemoQaTest extends PracticeFormPage {
    @Test
    public void homeWorkTest(){
        fillPracticeForm();
        checkFillForm();
    }

}
