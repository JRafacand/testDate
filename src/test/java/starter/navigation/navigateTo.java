package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;

public class navigateTo {
    private static WebDriver driver1;
    public static Performable theOpencart() {
        return Task.where("{0} opens the opencart home page",
                Open.browserOn().the(opHomepage.class));
    }

    public static class navigateToCartPage {
        public static Performable theCartPage() {
            return Task.where("{0} opens the Cart page",
                    Open.url("https://opencart.abstracta.us/"));
        }
    }
}
