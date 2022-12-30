package test.qa_scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;
import pages.order.Order;
import pages.qaScooter.Qa_scooter;
import test.base.BaseTest;

public class Qa_scooterTest extends BaseTest {

@Test
    public void qualitySelect(){
    Qa_scooter qaScooter = new Qa_scooter(driver);
    qaScooter
            .waitElement(qaScooter.importantQuestionsSection1)
            .clickElement(qaScooter.importantQuestionsSection1)
            .alertElementOpen(qaScooter.importantQuestionsSection1)
            .clickElement(qaScooter.importantQuestionsSection2)
            .alertElementOpen(qaScooter.importantQuestionsSection2)
            .clickElement(qaScooter.importantQuestionsSection3)
            .alertElementOpen(qaScooter.importantQuestionsSection3)
            .clickElement(qaScooter.importantQuestionsSection4)
            .alertElementOpen(qaScooter.importantQuestionsSection4)
            .clickElement(qaScooter.importantQuestionsSection5)
            .alertElementOpen(qaScooter.importantQuestionsSection5)
            .clickElement(qaScooter.importantQuestionsSection6)
            .alertElementOpen(qaScooter.importantQuestionsSection6)
            .clickElement(qaScooter.importantQuestionsSection7)
            .alertElementOpen(qaScooter.importantQuestionsSection7)
            .clickElement(qaScooter.importantQuestionsSection8)
            .alertElementOpen(qaScooter.importantQuestionsSection8);
}

}
