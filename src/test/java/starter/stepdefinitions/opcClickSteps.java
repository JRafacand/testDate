package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.support.ui.Select;
import net.thucydides.core.annotations.Screenshots;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import starter.navigation.navigateTo;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class opcClickSteps {
    @Given("{actor} I navigate to opencart")
    public void clickThings(Actor actor) {
        actor.wasAbleTo(navigateTo.theOpencart());
    }
    private WebDriver driver;
    public opcClickSteps() {
        this.driver = getDriver();
    }

    @And("{actor} I select a products")
    @Screenshots(forEachAction = true)
    public void clickOnProducts(Actor actor, List<Map<String, String>> products) throws InterruptedException {
        for (Map<String, String> product : products) {
            String productName = product.get("products");
            seleccionarProducto(productName);
        }
    }
    @SneakyThrows
    @Screenshots(forEachAction = true)
    private void seleccionarProducto(String productName) throws InterruptedException {
        WebDriver driver1 = new ChromeDriver();
        // Realizar clic en el objeto deseado
        if (productName.contains("Apple Cinema 30")) {
            driver.findElement(By.xpath("//a[contains(text(),'" + productName + "')]")).click();
            driver.findElement(By.xpath("//button[@id='button-cart']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/label[1]/input[1]")).click();
            driver.findElement(By.xpath("//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[1]/input[1]")).click();
            driver.findElement(By.xpath("//input[@id='input-option208']")).sendKeys("qaMaster");
            WebElement selectDrop = driver.findElement(By.xpath("//select[@id='input-option217']"));
            Select dropDown = new Select(selectDrop);
            dropDown.selectByIndex(2);
            driver.findElement(By.xpath("//textarea[@id='input-option209']")).sendKeys("QA vas Dev vs Arquitecto Vs Scrum Master");
            WebElement upload = driver.findElement(By.id("button-upload222"));
            upload.click();
            Thread.sleep(1000);
            String filePath = "C:\\img\\img.png";
            Robot robotUp = new Robot();
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            robotUp.keyPress(KeyEvent.VK_CONTROL);
            robotUp.keyPress(KeyEvent.VK_V);
            robotUp.keyRelease(KeyEvent.VK_V);
            robotUp.keyRelease(KeyEvent.VK_CONTROL);
            robotUp.keyPress(KeyEvent.VK_ENTER);
            robotUp.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            Alert alert = driver.switchTo().alert();
            alert.accept();
            Thread.sleep(1000);
            WebElement inputDate = driver.findElement(By.xpath("//input[@id='input-option219']"));
            String date = "2023-12-30";
            ((ChromeDriver) driver1).executeScript ("arguments[0].setAttribute('value', '" + date + "')", inputDate);
            driver.quit();
        } else {
            driver.findElement(By.xpath("//a[contains(text(),'" + productName + "')]")).click();
            driver.findElement(By.xpath("//button[@id='button-cart']")).click();
            WebElement campo = driver.findElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible"));
            String tMac = campo.getText();
            String tMac2 = "Success: You have added " + productName + " to your shopping cart!";
            assertThat(tMac).contains(tMac2);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(text(),'Your Store')]")).click();

        }
    }
}


