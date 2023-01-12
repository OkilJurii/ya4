package pages.qaScooter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class QaScooter extends BasePage {

    public QaScooter(WebDriver driver) {
        super(driver);
    }

     public QaScooter clickElement(By sectionQ) {
         JavascriptExecutor je = (JavascriptExecutor) driver;
         je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(sectionQ));
         driver.findElement(sectionQ).click();
         return this;
     }

     public QaScooter waitElement(By sectionQ) {
         waitElementIsVisible(driver.findElement(sectionQ));
         return this;
     }


     public QaScooter assertElementOpen(By sectionQ, By sectionQ2){

         Boolean ariaDisabled = driver.findElement(sectionQ).getAttribute("aria-disabled").equals("true") && driver.findElement(sectionQ2).isDisplayed();
         Assert.assertTrue(ariaDisabled);
         return this;
     }

    public QaScooter checkClickOrderURL(String buttonBy, String urlOrder){

        waitElement(By.xpath(buttonBy));
        clickElement(By.xpath(buttonBy));
        Assert.assertEquals(urlOrder,driver.getCurrentUrl());
        return this;
    }

}
