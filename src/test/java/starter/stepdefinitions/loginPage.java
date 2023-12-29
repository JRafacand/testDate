package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Screenshots;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import starter.Validate.FieldValidator;
import starter.navigation.navigateTo;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class loginPage {
    @Given("{actor} I navigate to opencart")
    public void clickThings(Actor actor) {
        actor.wasAbleTo(navigateTo.theOpencart());
    }

    private FieldValidator fieldValidator = new FieldValidator();
    private WebDriver driver;

    public loginPage() {
        this.driver = getDriver();
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
        driver.findElement(By.xpath("//a[contains(text(),'Your Store')]")).click();
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
            ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + date + "')", inputDate);
            WebElement inputTime = driver.findElement(By.xpath("//input[@id='input-option221']"));
            String time = "9:37";
            ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + time + "')", inputTime);
            WebElement inputDateTime = driver.findElement(By.xpath("//input[@id='input-option220']"));
            String dateTime = "2023-12-30 9:37";
            ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + dateTime + "')", inputDateTime);
            WebElement inputQty = driver.findElement(By.xpath("//input[@id='input-quantity']"));
            String qTy = "2";
            ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + qTy + "')", inputQty);
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

    public void loginUser(String enteredUser, String enteredPass) throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(enteredUser);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(enteredPass);
        driver.findElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]")).click();
        Thread.sleep(1000);
    }

    @And("{actor} eliminar productos outstcock")
    public void deleteItems(Actor actor) throws InterruptedException {
        driver.findElement(By.xpath("//span[@id='cart-total']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[1]/strong[1]")).click();
        Thread.sleep(1000);
        List<WebElement> fIlas = getTableRows();
        for (int f = 1; f < fIlas.size(); f++) {
            List<WebElement> columnas = fIlas.get(f).findElements(By.tagName("td"));
            WebElement columna = columnas.get(1);
            System.out.println("Entré al Columna " + columna.getText());
            String outStock = columna.getText();
            if (outStock.contains("***")) {
                System.out.println("Size antes: " + fIlas.size());
                Thread.sleep(2000);
                String delete = "//tbody/tr[" + f + "]/td[4]/div[1]/span[1]/button[2]";
                driver.findElement(By.xpath(delete)).click();
                Thread.sleep(2000);
                fIlas = getTableRows();
                System.out.println("Size después: " + fIlas.size());
                f = 0;
            }
        }
    }

    private List<WebElement> getTableRows() {
        WebElement table = driver.findElement(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-12 form:nth-child(2) > div.table-responsive"));
        return table.findElements(By.tagName("tr"));
    }

    @And("{actor} checkout")
    public void checkout(Actor actor) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();

    }

    @Then("{actor} Valido el campo {string}")
    public void validateName(Actor actor, String enteredValue) {
        WebElement campo = driver.findElement(By.xpath("//input[@id='input-payment-firstname']"));
        fieldValidator.validateName(campo, enteredValue);
    }

    @Then("{actor} Valido ingreso country {string}")
    public void validateCountry(Actor actor, String enteredValue) {
        WebElement campo = driver.findElement(By.xpath("//input[@id='country']"));
        fieldValidator.validateName(campo, enteredValue);
    }

    @Then("{actor} Valido ingreso city {string}")
    public void validateCity(Actor actor, String enteredValue) {
        WebElement campo = driver.findElement(By.xpath("//input[@id='city']"));
        fieldValidator.validateName(campo, enteredValue);
    }

    @Then("{actor} valido ingreso tarjeta {string}")
    public void validateCredit(Actor actor, String enteredValue) {
        WebElement campo = driver.findElement(By.xpath("//input[@id='card']"));
        fieldValidator.validateCredit(campo, enteredValue);
    }

    @Then("{actor} Ingreso Mes")
    public void validateMounth(Actor actor) {
        driver.findElement(By.xpath("//input[@id='month']")).sendKeys("Abril");

    }

    @Then("{actor} Valido anio {int}")
    public void ingresoValorEnCampoAnio(Actor actor, int valor) {
        driver.findElement(By.xpath("//input[@id='year']")).sendKeys(Integer.toString(valor));
        if (fieldValidator.esAnioValido(valor)) {
            Serenity.recordReportData().withTitle("Validación de campo").andContents("El campo contiene un Años Válido.");
        } else {
            Serenity.recordReportData().withTitle("Validación de campo").andContents("El campo no es un Año válido.");
            throw new AssertionError("El campo no es un Año válido.");
        }
    }
    // Método para validar si un año es válido (por ejemplo, entre 2010 y 2100)

    @Then("{actor} Finalizar Compra")
    public void endBuy(Actor actor) throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();
        Thread.sleep(1000);
    }

    @Then("{actor} navigate demoblaze back")
    public void navigateBack(Actor actor) throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
        Thread.sleep(1000);
    }
}

