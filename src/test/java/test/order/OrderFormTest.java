package test.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.order.Order;
import pages.qaScooter.QaScooter;
import test.base.BaseTest;

@RunWith(Parameterized.class)
public class OrderFormTest extends BaseTest {

    private final String inputName;
    private final String inputSurname;
    private final String inputAddress;
    private final String inputMetro;
    private final String inputTel;
    private final String buttonClick;

    public OrderFormTest(String inputName, String inputSurname, String inputAddress, String inputMetro, String inputTel, String buttonClick) {
        this.inputName = inputName;
        this.inputSurname = inputSurname;
        this.inputAddress = inputAddress;
        this.inputMetro = inputMetro;
        this.inputTel = inputTel;
        this.buttonClick = buttonClick;
    }

    @Parameterized.Parameters
    public static Object[][] getDataForm() {
        return new Object[][] {
                {"Юрий","Окулов", "Тихорецкий пр. 1", "Лубянка", "89650531111", "//button[@class='Button_Button__ra12g']"},
                {"Алеха","Окулов", "Гражданский пр. 1", "Лубянка", "89650532222", "//button[@class='Button_Button__ra12g']"},
                {"!№32цуу","Окил", "Гражданский пр. 22", "Лубянка", "89650533333", "//button[@class='Button_Button__ra12g']"},
                {"Юрий","Окулов", "Тихорецкий пр. 1", "Лубянка", "89650531111", "//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']"},
                {"Алеха","Окулов", "Гражданский пр. 1", "Лубянка", "89650532222", "//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']"},
                {"!№32цуу","Окил", "Гражданский пр. 22", "Лубянка", "89650533333", "//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']"},
        };
    }

    @Test
    public void orderForm(){
        QaScooter qaScooter = new QaScooter(driver);
        Order orderForm = new Order(driver);
        qaScooter
                .checkClickOrderURL(buttonClick, orderForm.urlOrder);
        orderForm
                .waitElement(orderForm.orderInputName)
                .orderForm(inputName, inputSurname, inputAddress, inputMetro, inputTel)
                .checkClickButtonFurther(orderForm.buttonFurther,orderForm.orderProArendu );
    }
}
