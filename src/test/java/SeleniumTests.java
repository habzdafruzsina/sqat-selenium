import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.concurrent.TimeUnit; 

import java.net.URL;
import java.net.MalformedURLException;


public class SeleniumTests {
    public WebDriver driver;
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        //chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void smokeTest() {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.acceptCookies();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mainPage.getLogo());
        Assert.assertTrue(mainPage.getTitle().contains("moly"));
    }

    @Test
    public void testLogin(){
        MainPage mainPage = new MainPage(this.driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mainPage.getMenuBtn());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mainPage.getSignInBtn());
        LoginModal loginModal = new LoginModal(this.driver);
        loginModal.getModal();
        loginModal.fillLogin("Nefoba7611!", "nefoba7611@neixos.com");
        loginModal.login();
    }
    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
