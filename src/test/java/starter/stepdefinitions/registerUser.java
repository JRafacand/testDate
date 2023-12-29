package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import starter.navigation.navigateTo;

import java.util.Map;
import java.util.List;

import static net.serenitybdd.core.Serenity.getDriver;

public class registerUser {
    @Given("{actor}I navigate to register page")
    public void clickUser(Actor actor) {
        actor.wasAbleTo(navigateTo.theOpencart());
    }

    private WebDriver driver;

    public registerUser() {
        this.driver = getDriver();
    }

    @And("{actor} I Register user")
    public void mapUS(Actor actor, DataTable dataUser) throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        List<Map<String, String>> data = dataUser.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String firstName = row.get("firstname");
            String lastName = row.get("lastname");
            String email = row.get("email");
            String telephone = row.get("telephone");
            String password = row.get("password");
            String confirmPassword = row.get("confirm");
            driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(firstName);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(lastName);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(telephone);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(confirmPassword);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[2]/input[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]")).click();
        }
    }
}
