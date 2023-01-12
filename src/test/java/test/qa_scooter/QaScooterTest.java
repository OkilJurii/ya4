package test.qa_scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pages.qaScooter.QaScooter;
import test.base.BaseTest;

@RunWith(Parameterized.class)
public class QaScooterTest extends BaseTest {

    private final String questions;
    private final String text;

    public QaScooterTest(String text, String questions) {
        this.questions = questions;
        this.text = text;
    }

    @Parameterized.Parameters
    public static Object[][] getAccordionData() {
        return new Object[][]{
                {"//div[@id='accordion__heading-0']", "//div[@id='accordion__panel-0']//p[contains(text(),\" \")]"},
                {"//div[@id='accordion__heading-1']", "//div[@id='accordion__panel-1']//p[contains(text(),\" \")]"},
                {"//div[@id='accordion__heading-2']", "//div[@id='accordion__panel-2']//p[contains(text(),\" \")]"},
                {"//div[@id='accordion__heading-3']", "//div[@id='accordion__panel-3']//p[contains(text(),\" \")]"},
                {"//div[@id='accordion__heading-4']", "//div[@id='accordion__panel-4']//p[contains(text(),\" \")]"},
                {"//div[@id='accordion__heading-5']", "//div[@id='accordion__panel-5']//p[contains(text(),\" \")]"},
                {"//div[@id='accordion__heading-6']", "//div[@id='accordion__panel-6']//p[contains(text(),\" \")]"},
                {"//div[@id='accordion__heading-7']", "//div[@id='accordion__panel-7']//p[contains(text(),\" \")]"},
        };
    }

@Test
    public void qualitySelect(){
    QaScooter qaScooter = new QaScooter(driver);
    qaScooter
            .waitElement(By.xpath(text))
            .clickElement(By.xpath(text))
            .assertElementOpen(By.xpath(text), By.xpath(questions));
}

}
