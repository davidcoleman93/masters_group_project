package selenium;

/**
 * Created by c11456862 on 27/04/2017.
 */

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class queryTests {

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

    @Test   //IMSI (Cust Rep)
    public void testUserStory4() throws Exception {
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

        //IMSI:  344930000000011

        driver.findElement(By.cssSelector("a.dcjq-parent > span")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ec-imsi")).click();
        Thread.sleep(2000);
        //driver.findElement(By.id("ui-id-2")).click();
        //Thread.sleep(2000);
        driver.findElement(By.id("imsi_text")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("imsi_text")).sendKeys("344930000000011");
        Thread.sleep(1000);
        driver.findElement(By.id("queryBtn")).click();
        Thread.sleep(3000);
    }

    @Test   //Cause Code (Cust Rep)
    public void testUserStory6() throws Exception {
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

        //IMSI:  344930000000011

        driver.findElement(By.cssSelector("a.dcjq-parent > span")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ec-ccode")).click();
        Thread.sleep(2000);
        //driver.findElement(By.id("ui-id-2")).click();
        //Thread.sleep(2000);
        driver.findElement(By.id("imsi_text")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("imsi_text")).sendKeys("344930000000011");
        Thread.sleep(1000);
        driver.findElement(By.id("queryBtn")).click();
        Thread.sleep(3000);
    }

    @Test   //Phone Model (Net Eng.)
    public void testUserStory10() throws Exception {
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

        driver.findElement(By.cssSelector("a.dcjq-parent > span")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ec-pmodel")).click();
        Thread.sleep(2000);
        //driver.findElement(By.id("ui-id-2")).click();
        //Thread.sleep(2000);
        driver.findElement(By.id("phone_model_text")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("phone_model_text")).sendKeys("VEA3");
        Thread.sleep(1000);
        driver.findElement(By.id("queryBtn")).click();
        Thread.sleep(3000);
    }

    @Test   //Phone Model (Net Eng.)
    public void testUserStory7() throws Exception {
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

        //IMSI:  344930000000011

        driver.findElement(By.linkText("Call Failure")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("fail-list-sup")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("fromDate")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("fromDate")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("fromDate")).sendKeys("01/01/2013");
        Thread.sleep(1000);
        driver.findElement(By.id("toDate")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("toDate")).sendKeys("01/12/2013");
        Thread.sleep(1000);
        driver.findElement(By.id("queryBtn")).click();
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
