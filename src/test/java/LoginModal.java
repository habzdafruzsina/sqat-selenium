import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;

class LoginModal extends MainPage {

    private By loginModalBy = By.id("popup-login_panel");

    private By emailFieldBy = By.xpath("/div[@class='inputpage_field_LoginUserName']/input");
    private By pwdFieldBy = By.id("LoginPassword");
    private By stayLoggedInBy = By.id("LoginRememberMe");
    private By signInBtnBy = By.xpath("/div[@class='login_buttons']/button[@class='okbutton']");

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmailFiled() {
        return this.waitAndReturnElement(emailFieldBy);
    }

    public WebElement getPwdField() {
        return this.waitAndReturnElement(pwdFieldBy);
    }

    public WebElement getStayLoggedInBy() {
        return this.waitAndReturnElement(stayLoggedInBy);
    }

    public WebElement getSingInBtn() {
        return this.waitAndReturnElement(signInBtnBy);
    }

    public WebElement getModal(){
        return this.waitAndReturnElement(loginModalBy);
    }

    public void fillLogin(String pw, String email){
        this.getEmailFiled().sendKeys(email);
        this.getPwdField().sendKeys(pw);
        this.getStayLoggedInBy().click();
    }

    public void login(){
        this.getSingInBtn().click();
    }
}
