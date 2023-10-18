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

public class productDetail {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @When("I open login page at www.saucedemo.com")
    public void iOpenLoginPageAtWwwSaucedemoCom() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @And("I enter user end password")
    public void iEnterUserEndPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("I click login button")
    public void iClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }


    @Then("I can view product detail page")
    public void iCanViewProductDetailPage() {
        driver.findElement(By.id("item_4_title_link")).click();
        String detil = driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")).getText();
        Assert.assertEquals(detil,"Add to cart");
        driver.close();
    }
}
