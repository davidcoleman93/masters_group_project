package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by c11456862 on 27/04/2017.
 */
public class RegisterTests {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //System.setProperty("webdriver.gecko.driver", "C:\\JavaTools\\Testing\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\JavaTools\\Testing\\chromedriver.exe");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        baseUrl = "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testRegisterAdmin() throws Exception {
        driver.get(baseUrl);
        Thread.sleep(1000);
        driver.findElement(By.id("user-login")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("user-login")).sendKeys("admin");
        Thread.sleep(1000);
        driver.findElement(By.id("password-login")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("password-login")).sendKeys("@Admin123");
        Thread.sleep(1000);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("li.sub-menz > a > span")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("role-type-toggle")).click();

        Thread.sleep(3000);
        driver.findElement(By.id("admin")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("username")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("username")).sendKeys("admin2");
        Thread.sleep(1000);
        driver.findElement(By.id("email-id")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("email-id")).sendKeys("admin@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("Admin123");
        Thread.sleep(1000);
        driver.findElement(By.id("confirm-password")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("confirm-password")).sendKeys("Admin123");
        Thread.sleep(1000);
        driver.findElement(By.id("register-submit")).click();
        Thread.sleep(3000);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
