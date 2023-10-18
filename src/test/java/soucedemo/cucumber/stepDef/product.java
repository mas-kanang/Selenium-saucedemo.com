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

public class product {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @When("User open login page at www.saucedemo.com")
    public void userOpenLoginPageAtWwwSaucedemoCom() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @And("user enter user end password")
    public void userEnterUserEndPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user can view product page")
    public void userCanViewProductPage() {
        String Product = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(Product,"Products");
        driver.close();

    }
}
