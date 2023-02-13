package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    By usernameLocator = By.xpath("//input[@id='user-name']");
    By passwordLocator = By.xpath("//input[@id='password']");
    By loginButtonLocator = By.xpath("//input[@id='login-button']");
    By errorMessageLocator = By.xpath("//h3[@data-test='error']");

    public void enterUsername(String username){
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }

    public boolean checkErrorMessageDisplayed(){
       return driver.findElement(errorMessageLocator).isDisplayed();
    }
}
