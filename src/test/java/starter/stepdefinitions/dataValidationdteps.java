package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import starter.Validate.FieldValidator;
import starter.navigation.navigateTo;

import static net.serenitybdd.core.Serenity.getDriver;


public class dataValidationdteps {

    private FieldValidator fieldValidator = new FieldValidator();
    private String enteredValue;
    private WebDriver driver1;
    public dataValidationdteps() {
        this.driver1 = getDriver();
    }
    @Given("{actor} I navigate to Opencart")
    public void clickorder(Actor actor) throws InterruptedException {
        actor.wasAbleTo(navigateTo.navigateTocartpage.theCartPage());
        Thread.sleep(2000);
        //driver1.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
    }

    @Then("{actor} Valido el campo {string}")
    public void validateName(Actor actor, String enteredValue) {
        WebElement campo = driver1.findElement(By.xpath("//input[@id='name']"));
        fieldValidator.validateName(campo, enteredValue);
    }

    @Then("{actor} Valido ingreso country {string}")
    public void validateCountry(Actor actor, String enteredValue) {
        WebElement campo = driver1.findElement(By.xpath("//input[@id='country']"));
        fieldValidator.validateName(campo, enteredValue);
    }

    @Then("{actor} Valido ingreso city {string}")
    public void validateCity(Actor actor, String enteredValue) {
        WebElement campo = driver1.findElement(By.xpath("//input[@id='city']"));
        fieldValidator.validateName(campo, enteredValue);
    }

    @Then("{actor} valido ingreso tarjeta {string}")
    public void validateCredit(Actor actor, String enteredValue) {
        WebElement campo = driver1.findElement(By.xpath("//input[@id='card']"));
        fieldValidator.validateCredit(campo, enteredValue);
    }

    @Then("{actor} Ingreso Mes")
    public void validateMounth(Actor actor) {
      driver1.findElement(By.xpath("//input[@id='month']")).sendKeys("Abril");

    }
    @Then("{actor} Valido anio {int}")
    public void ingresoValorEnCampoAnio(Actor actor, int valor) {
       driver1.findElement(By.xpath("//input[@id='year']")).sendKeys(Integer.toString(valor));
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
        driver1.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();
        Thread.sleep(1000);
    }
    @Then("{actor} navigate demoblaze back")
    public void navigateBack(Actor actor) throws InterruptedException {
        driver1.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        Thread.sleep(1000);
        driver1.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
        Thread.sleep(1000);
    }
}

