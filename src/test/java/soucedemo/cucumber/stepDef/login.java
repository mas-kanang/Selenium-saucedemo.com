package soucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user open login page at www.saucedemo.com")
    public void userOpenLoginPageAtWwwSaucedemoCom() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @When("User enter correct username")
    public void userEnterCorrectUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User enter correct password")
    public void userEnterCorrectPassword() {

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User Click Login Button")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User redirected to dashboard page")
    public void userRedirectedToDashboardPage() {
        String Login = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(Login,"Products");
        driver.close();
    }

    @And("User enter incorrect password")
    public void userEnterIncorrectPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce123");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");

        driver.close();
    }
}
