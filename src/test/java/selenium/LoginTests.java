package selenium;

/**
 * Created by c11456862 on 10/04/2017.
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

public class LoginTests {

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
    public void testAdminLoginWrongPassword() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("user-login")).clear();
        driver.findElement(By.id("user-login")).sendKeys("admin2");
        driver.findElement(By.id("password-login")).clear();
        driver.findElement(By.id("password-login")).sendKeys("adminadmin");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(1000);
        //String text = driver.findElement(By.id("register.logininfo")).getText();
        String text = driver.findElement(By.className("logininfo")).getText();
        System.out.println(text);
        assertEquals("Sorry password is incorrect.", text);
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/", currentUrl);
        Thread.sleep(1000);
    }

    @Test
    public void testAdminLoginWrongUsername() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("user-login")).clear();
        driver.findElement(By.id("user-login")).sendKeys("random123");
        driver.findElement(By.id("password-login")).clear();
        driver.findElement(By.id("password-login")).sendKeys("Admin123");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(1000);
        //String text = driver.findElement(By.id("register.logininfo")).getText();
        String text = driver.findElement(By.className("logininfo")).getText();
        System.out.println(text);
        assertEquals("Sorry username is invalid", text);
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/", currentUrl);
        Thread.sleep(1000);
    }

    @Test
    public void testSuccessfulAdminLogin() throws Exception {
        driver.get(baseUrl);
        Thread.sleep(1000);
        driver.findElement(By.id("user-login")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("user-login")).sendKeys("admin2");
        Thread.sleep(1000);
        driver.findElement(By.id("password-login")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("password-login")).sendKeys("Admin123");
        Thread.sleep(1000);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/home.jsp", currentUrl);
        Thread.sleep(1000);
    }

    @Test
    public void testSuccessfulCustomerServiceLogin() throws Exception {
        driver.get(baseUrl);
        Thread.sleep(1000);
        driver.findElement(By.id("user-login")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("user-login")).sendKeys("customer");
        Thread.sleep(1000);
        driver.findElement(By.id("password-login")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("password-login")).sendKeys("Customer123");
        Thread.sleep(1000);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/home.jsp", currentUrl);
        Thread.sleep(1000);
    }

    @Test
    public void testSuccessfulSupportLogin() throws Exception {
        driver.get(baseUrl);
        Thread.sleep(1000);
        driver.findElement(By.id("user-login")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("user-login")).sendKeys("support");
        Thread.sleep(1000);
        driver.findElement(By.id("password-login")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("password-login")).sendKeys("Support123");
        Thread.sleep(1000);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/home.jsp", currentUrl);
        Thread.sleep(1000);
    }

    @Test
    public void testSuccessfulNetworkLogin() throws Exception {
        driver.get(baseUrl);
        Thread.sleep(1000);
        driver.findElement(By.id("user-login")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("user-login")).sendKeys("network");
        Thread.sleep(1000);
        driver.findElement(By.id("password-login")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("password-login")).sendKeys("Network123");
        Thread.sleep(1000);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/home.jsp", currentUrl);
        Thread.sleep(1000);
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


