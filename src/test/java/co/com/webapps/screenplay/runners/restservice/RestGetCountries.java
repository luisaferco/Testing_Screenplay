package co.com.webapps.screenplay.runners.restservice;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/restservice/rest_get_countries.feature"
        , glue = "co.com.webapps.screenplay.stepdefinitions"
        , snippets = SnippetType.CAMELCASE
)
public class RestGetCountries {
}
