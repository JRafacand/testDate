package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import starter.navigation.navigateTo;

import java.util.List;

import static net.serenitybdd.core.Serenity.getDriver;

public class deleteItems {
    @Given("{actor} abrir carrito de compras")
    public void clickCarrito(Actor actor) {actor.wasAbleTo(navigateTo.navigateTocartpage.theCartPage());}
    private WebDriver driver2;
    public deleteItems() {this.driver2 = getDriver();}

    @And("{actor} eliminar productos outstcock")
        public void deleteItems(Actor actor) throws InterruptedException {
        driver2.findElement(By.xpath("//span[@id='cart-total']")).click();
        Thread.sleep(1000);
        driver2.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[1]/strong[1]")).click();
        WebElement table = driver2.findElement(By.xpath("//body/div[@id='checkout-cart']/div[2]/div[1]/form[1]/div[1]/table[1]"));
        List<WebElement> filas = table.findElements(By.tagName("tr"));
        for (int f = 1; f < filas.size(); f++) {
            WebElement fila = filas.get(f);
            List<WebElement> columnas = fila.findElements(By.tagName("td"));
            WebElement columna = columnas.get(2);
            if ("***".equals(columna.getText())) {
                WebElement columna2 = columnas.get(4);
                columna2.findElement(By.xpath("//tbody/tr['" + f + "']/td[4]/div[1]/span[1]/button[2]/i[1]")).click();
                Thread.sleep(1000);
            }
        }
    }
}
