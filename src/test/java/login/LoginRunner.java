package login;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@CucumberOptions(glue="login",
    features = "src/test/java/login/login.feature")

public class LoginRunner extends AbstractTestNGCucumberTests {
    public static WebDriver driver;

    @BeforeTest
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void end(){
        driver.quit();
    }
}
