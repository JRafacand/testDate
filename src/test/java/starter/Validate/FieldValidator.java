package starter.Validate;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebElement;

public class FieldValidator {

    public void validateName(WebElement campo, String enteredValue) {
        campo.sendKeys(enteredValue);
        String valorIngresado = campo.getAttribute("value");
        if (ValidationUtils.validateName(valorIngresado)) {
            Serenity.recordReportData().withTitle("Validación de campo").andContents("El campo debe contener solo letras.");
            throw new AssertionError("El campo debe contener solo letras.");
        } else {
            Serenity.recordReportData().withTitle("Validación de campo").andContents("El campo contiene letras.");
        }
    }

    public void validateCredit(WebElement campo, String enteredValue) {
        campo.sendKeys(enteredValue);
        String valorIngresado = campo.getAttribute("value");
        if (ValidationCredit.validateCredit(valorIngresado)) {
            Serenity.recordReportData().withTitle("Validación de campo").andContents("El campo debe ser una Tarjeta Validad.");
            throw new AssertionError("El campo es una Tarjeta Validad.");
        } else {
            Serenity.recordReportData().withTitle("Validación de campo").andContents("El campo no es una Tarjeta Valida.");
        }
    }

    public static class ValidationUtils {
        public static boolean validateName(String name) {
            return name.matches("^[A-Za-z]+$^[A-Za-z]+$");
        }
    }

    public static class ValidationCredit {
        public static boolean validateCredit(String name) {
            return name.matches("^\\\\d{4}-\\\\d{4}-\\\\d{4}-\\\\d{4}$");
        }
    }

    public void validateMounth(WebElement campo, String enteredValue) {
        campo.sendKeys(enteredValue);
        String valorIngresado = campo.getAttribute("value");
        System.out.println("Valor recibido:" + valorIngresado);
        try {
            int valorIngresadoint = Integer.parseInt(valorIngresado);
            System.out.println("Valor recibido Funcion: " + valorIngresado);
            if (valorIngresadoint >= 1 && valorIngresadoint <= 12) {
                Serenity.recordReportData().withTitle("Validación de campo").andContents("El campo contiene un Mes Válido.");
            } else {
                Serenity.recordReportData().withTitle("Validación de campo").andContents("El campo no es un Mes válido.");
                throw new AssertionError("El campo no es un Mes válido.");
            }
        } catch (NumberFormatException e) {
            Serenity.recordReportData().withTitle("Validación de campo").andContents("El campo no contiene un valor numérico válido.");
            throw new AssertionError("El campo no contiene un valor numérico válido.");
        }
    }

    public boolean esAnioValido(int anio) {
        return anio >= 2010 && anio <= 2100; // Puedes ajustar los límites según tus necesidades
    }
}
