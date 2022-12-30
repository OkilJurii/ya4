package test.qa_scooter;

import common.CommonAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.qaScooter.Qa_scooter;
import test.base.BaseTest;

// Проверка двух кнопопк - Заказать
@RunWith(Parameterized.class)
public class QascoterClickOrderTest extends BaseTest {

    private final String urlOrder;
    private final String buttonBy;

    public QascoterClickOrderTest(String buttonBy, String urlOrder) {
        this.urlOrder = urlOrder;
        this.buttonBy = buttonBy;
    }

    @Parameterized.Parameters
    public static Object[][] getButtonData() {
        return new Object[][] {
                {"//button[@class='Button_Button__ra12g']","https://qa-scooter.praktikum-services.ru/order"},
                {"//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']","https://qa-scooter.praktikum-services.ru/order"},
        };
    }
    @Test
    public void clickOrder(){
        Qa_scooter qaScooter = new Qa_scooter(driver);
        qaScooter
                .checkClickOrderURL(buttonBy, urlOrder);
    }

}
