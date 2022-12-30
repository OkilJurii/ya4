package pages.qaScooter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class Qa_scooter extends BasePage {

    public Qa_scooter(WebDriver driver) {
        super(driver);
    }

    public By importantQuestionsSection1 = By.xpath("//div[@id='accordion__heading-0']");
    public By importantQuestionsSection2 = By.xpath("//div[@id='accordion__heading-1']");
    public By importantQuestionsSection3 = By.xpath("//div[@id='accordion__heading-2']");
    public By importantQuestionsSection4 = By.xpath("//div[@id='accordion__heading-3']");
    public By importantQuestionsSection5 = By.xpath("//div[@id='accordion__heading-4']");
    public By importantQuestionsSection6 = By.xpath("//div[@id='accordion__heading-5']");
    public By importantQuestionsSection7 = By.xpath("//div[@id='accordion__heading-6']");
    public By importantQuestionsSection8 = By.xpath("//div[@id='accordion__heading-7']");

     public Qa_scooter clickElement(By sectionQ) {
         JavascriptExecutor je = (JavascriptExecutor) driver;
         je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(sectionQ));
         driver.findElement(sectionQ).click();
         return this;
     }

     public Qa_scooter waitElement(By sectionQ) {
         waitElementIsVisible(driver.findElement(sectionQ));
         return this;
     }


     public Qa_scooter alertElementOpen(By sectionQ){

         Boolean ariaDisabled = driver.findElement(sectionQ).getAttribute("aria-disabled").equals("true");
         System.out.println(driver.findElement(sectionQ).getAttribute("aria-disabled") + " ---- ----" + ariaDisabled);
         Assert.assertTrue(ariaDisabled);
         return this;
     }

    public Qa_scooter checkClickOrderURL(String buttonBy, String urlOrder){

        waitElement(By.xpath(buttonBy));
        clickElement(By.xpath(buttonBy));
        Assert.assertEquals(urlOrder,driver.getCurrentUrl());
        return this;
    }

}
