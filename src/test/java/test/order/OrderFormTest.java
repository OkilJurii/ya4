package test.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.order.Order;
import pages.qaScooter.Qa_scooter;
import test.base.BaseTest;

@RunWith(Parameterized.class)
public class OrderFormTest extends BaseTest {

    private final String inputName;
    private final String inputSurname;
    private final String inputAddress;
    private final String inputMetro;
    private final String inputTel;

    public OrderFormTest(String inputName, String inputSurname, String inputAddress, String inputMetro, String inputTel) {
        this.inputName = inputName;
        this.inputSurname = inputSurname;
        this.inputAddress = inputAddress;
        this.inputMetro = inputMetro;
        this.inputTel = inputTel;
    }

    @Parameterized.Parameters
    public static Object[][] getDataForm() {
        return new Object[][] {
                {"Юрий","Окулов", "Тихорецкий пр. 1", "Лубянка", "89650531111"},
                {"Алеха","Окулов", "Гражданский пр. 1", "Лубянка", "89650532222"},
                {"!№32цуу","Окил", "Гражданский пр. 22", "Лубянка", "89650533333"},
        };
    }
    @Test
    public void orderForm(){
        Qa_scooter qaScooter = new Qa_scooter(driver);
        Order orderForm = new Order(driver);
        qaScooter
                .checkClickOrderURL("//button[@class='Button_Button__ra12g']","https://qa-scooter.praktikum-services.ru/order");
        orderForm
                .waitElement(orderForm.orderInputName)
                .orderForm(inputName, inputSurname, inputAddress, inputMetro, inputTel)
                .checkClickButtonFurther(orderForm.buttonFurther,orderForm.orderProArendu );
    }
}
