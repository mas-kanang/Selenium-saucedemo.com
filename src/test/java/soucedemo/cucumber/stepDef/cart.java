package soucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class cart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @When("users open login page at www.saucedemo.com")
    public void usersOpenLoginPageAtWwwSaucedemoCom() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @And("users enter user end password")
    public void usersEnterUserEndPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("users click login button")
    public void usersClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("users can view cart page")
    public void usersCanViewCartPage() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        String Cart = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(Cart,"Your Cart");
        driver.close();
    }
}
