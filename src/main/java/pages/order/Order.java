package pages.order;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.qaScooter.Qa_scooter;

public class Order extends BasePage {

    public Order(WebDriver driver) {
        super(driver);
    }

    public By orderInputName = By.xpath("//input[@placeholder='* Имя']");
    public By orderInputSurname = By.xpath("//input[@placeholder='* Фамилия']");
    public By orderInputAddress  = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    public By orderInputTelephone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    public By orderInputMetro = By.xpath("//input[@placeholder='* Станция метро']");
    public By buttonFurther = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public By orderProArendu = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");
    public By buttonMetro = By.xpath("//div[@class='select-search__select']");

    public Order waitElement(By sectionQ) {
        waitElementIsVisible(driver.findElement(sectionQ));
        return this;
    }

    public Order orderInput (By sectionQ, String text) {
        driver.findElement(sectionQ).sendKeys(text);
        return this;
    }

    public Order orderForm (String inputName, String inputSurname, String inputAddress, String inputMetro, String inputTel) {
        waitElement(orderInputTelephone);
        orderInput(orderInputName,inputName);
        orderInput(orderInputSurname,inputSurname);
        orderInput(orderInputAddress,inputAddress);
        orderInput(orderInputMetro,inputMetro);
        clickElement(buttonMetro);
        orderInput(orderInputTelephone,inputTel);
        return this;
    }

    public Order clickElement(By sectionQ) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(sectionQ));
        driver.findElement(sectionQ).click();
        return this;
    }

    public Order checkClickButtonFurther(By sectionQ, By Arenda){

        waitElement(sectionQ);
        clickElement(sectionQ);
        waitElement(Arenda);
        Assert.assertEquals(driver.findElement(Arenda).getText(),"Назад");
        return this;

    }
}
