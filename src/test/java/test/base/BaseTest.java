package test.base;

import common.CommonAction;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


public class BaseTest {

    protected WebDriver driver = CommonAction.createDriver();

    @Before
    public void baseSetup(){
         // BasePage basePage = new BasePage(driver);
         driver.get("https://qa-scooter.praktikum-services.ru/");
    }
   @After
   public void baseDown(){
   driver.quit();
   CommonAction.setDriver(null);
   }

}
