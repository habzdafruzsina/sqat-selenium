import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;


class MainPage extends PageBase {

    //private By logoBy = By.xpath("/div[@class='baseheader_left']/div[@class='baseheader']");
    private By logoBy = By.className("baseheader");
    private By acceptBtnBy = By.className("rb-cookiealert-button");
    //private By signInBtnBy = By.xpath("/div[@class='popup-login_link']");
    private By signInBtnBy = By.className("popup-login_link");
    private By menuBtnBy = By.id("rbsidebar-menubutton");

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://konyvmolykepzo.hu/");
    }

    public WebElement getLogo(){
        return this.waitAndReturnElement(logoBy);
    }

    public WebElement getSignInBtn() {
        return this.waitAndReturnElement(signInBtnBy);
    }

    public WebElement getMenuBtn() {
        return this.waitAndReturnElement(menuBtnBy);
    }

    public void acceptCookies() {
        WebElement btn = this.waitAndReturnElement(acceptBtnBy);
        btn.click();
    }
}
