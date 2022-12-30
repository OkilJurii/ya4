package common;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static common.Config.IMPLICIT_WAIT;
import static common.Config.PLATFORM_AND_BROWSER;

public class CommonAction {



    private static WebDriver driver = null;

    public static void setDriver(WebDriver driver) {
        CommonAction.driver = driver;
    }

    private CommonAction() {
    }

    public static WebDriver createDriver() {

        if (driver == null){
            switch (PLATFORM_AND_BROWSER) {
                case "win_chrome":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver1.exe");
                    driver = new ChromeDriver();
                    break;
                default:
                    Assert.fail("Incorrect platform" + PLATFORM_AND_BROWSER);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        }
        return driver;
    }
}
