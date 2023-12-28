package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Screenshots;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import starter.navigation.navigateTo;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class loginPage {
    @Given("{actor} I navigate to login page")
    public void clickThings(Actor actor) {actor.wasAbleTo(navigateTo.theOpencart());}
    private WebDriver driver;
    public loginPage() {this.driver = getDriver();}

    @And("{actor} usuario ingresa las credenciales")
    public void mapUP(Actor actor, DataTable dateUser) throws InterruptedException {
        List<Map<String, String>> data = dateUser.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String user = row.get("Usuario");
            String pass = row.get("Password");
            System.out.println("Usuario: " + user);
            System.out.println("Contraseña: " + pass);
            Thread.sleep(3000);
            loginUser(user, pass);
        }
    }
   public void loginUser (String enteredUser, String enteredPass) throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(enteredUser);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(enteredPass);
        driver.findElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]")).click();
        Thread.sleep(1000);
   }
    @And("{actor} I select a products")
    @Screenshots(forEachAction = true)
    public void clickOnProducts(Actor actor, List<Map<String, String>> products) throws InterruptedException, AWTException {
        for (Map<String, String> product : products) {
            String productName = product.get("products");
            seleccionarProducto(productName);
        }
    }
    private void seleccionarProducto(String productName) throws InterruptedException, AWTException {
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
            ((JavascriptExecutor) driver).executeScript ("arguments[0].setAttribute('value', '" + date + "')", inputDate);
            WebElement inputTime = driver.findElement(By.xpath("//input[@id='input-option221']"));
            String time = "9:37";
            ((JavascriptExecutor) driver).executeScript ("arguments[0].setAttribute('value', '" + time + "')", inputTime);
            WebElement inputDateTime = driver.findElement(By.xpath("//input[@id='input-option220']"));
            String dateTime = "2023-12-30 9:37";
            ((JavascriptExecutor) driver).executeScript ("arguments[0].setAttribute('value', '" + dateTime + "')", inputDateTime);
            WebElement inputQty = driver.findElement(By.xpath("//input[@id='input-quantity']"));
            String qTy = "2";
            ((JavascriptExecutor) driver).executeScript ("arguments[0].setAttribute('value', '" + qTy + "')", inputQty);
            assertThat(qTy).isEqualTo("2");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[@id='button-cart']")).click();
            Thread.sleep(1000);
            WebElement campo = driver.findElement(By.cssSelector("body:nth-child(2) div.container:nth-child(5) > div.alert.alert-success.alert-dismissible"));
            String tProd = campo.getText();
            String tProd2 = "Success: You have added " + productName + " to your shopping cart!";
            assertThat(tProd).contains(tProd2);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(text(),'Your Store')]")).click();
        } else if (productName.contains("Canon EOS 5D")) {
            driver.findElement(By.xpath("//a[contains(text(),'" + productName + "')]")).click();
            WebElement selectDrop = driver.findElement(By.xpath("//select[@id='input-option226']"));
            Select dropDown = new Select(selectDrop);
            dropDown.selectByIndex(2);
            driver.findElement(By.xpath("//button[@id='button-cart']")).click();
            WebElement campo = driver.findElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible"));
            String tMac = campo.getText();
            String tMac2 = "Success: You have added " + productName + " to your shopping cart!";
            assertThat(tMac).contains(tMac2);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//span[contains(text(),'Shopping Cart')]")).click();
            //driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
            //driver.findElement(By.xpath("//a[contains(text(),'Your Store')]")).click();

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