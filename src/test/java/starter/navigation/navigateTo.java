package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;

public class navigateTo {

    public static Performable theOpencart() {
        return Task.where("{0} opens the Opencar home page",
                Open.browserOn().the(opHomepage.class));
    }

    public static class navigateTocartpage {
        public static Performable theCartPage() {
            return Task.where("{0} opens the Car page",
                    Open.url("http://opencart.abstracta.us/index.php?route=common/home"));
        }
    }
}
