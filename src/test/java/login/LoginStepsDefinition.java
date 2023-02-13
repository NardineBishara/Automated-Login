package login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class LoginStepsDefinition{
    WebDriver driver;
    LoginPage loginPage;
    SoftAssert soft = new SoftAssert();

    @Given("navigated to login page")
    public void navigated_to_login_page() {
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        driver = LoginRunner.driver;
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }
    /*
    @When("valid username and password are entered")
    public void valid_username_and_password_are_entered() {
        loginPage.enterValidUsername();
        loginPage.enterValidPassword();
    }
     */
    @When("clicked on submit button")
    public void clicked_on_submit_button() {
        loginPage.clickOnLoginButton();
    }
    @Then("user's home page is displayed")
    public void user_s_home_page_is_displayed() {
       soft.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
       soft.assertAll();
    }

    @When("invalid username and password are entered")
    public void invalidUsernameAndPasswordAreEntered() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
    }

    @Then("error message will be displayed")
    public void errorMessageWillBeDisplayed() {
        soft.assertEquals(loginPage.checkErrorMessageDisplayed(), true);
        soft.assertAll();
    }

    @When("valid {string} and {string} are entered")
    public void validAndAreEntered(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
}
