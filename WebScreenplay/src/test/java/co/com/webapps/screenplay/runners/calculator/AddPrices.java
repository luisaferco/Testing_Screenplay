package co.com.webapps.screenplay.runners.calculator;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/calculator/add_prices.feature"
        , glue = "co.com.webapps.screenplay.stepdefinitions"
        , snippets = SnippetType.CAMELCASE
)
public class AddPrices {
}
