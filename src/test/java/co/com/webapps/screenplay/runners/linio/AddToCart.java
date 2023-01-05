package co.com.webapps.screenplay.runners.linio;



import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/linio/add_to_cart.feature"
        , glue = "co.com.webapps.screenplay.stepdefinitions"
        , snippets = SnippetType.CAMELCASE

)
public class AddToCart {
}
