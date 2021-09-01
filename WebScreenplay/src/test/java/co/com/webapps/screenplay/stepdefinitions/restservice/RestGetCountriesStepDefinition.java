package co.com.webapps.screenplay.stepdefinitions.restservice;

import co.com.webapps.screenplay.questions.restservice.Responses;
import co.com.webapps.screenplay.utils.StringManager;
import co.com.webapps.screenplay.utils.restservice.UrlManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.questions.TheResponse;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RestGetCountriesStepDefinition {

    @Given("^consume countries service$")
    public void consumeCountriesService() {
        theActorCalled(StringManager.USER_NAME)
                .can(CallAnApi.at(UrlManager.REST_SERVICE_COUNTRIES));
    }


    @When("^get data list of countries$")
    public void getDataListOfCountries() {
        theActorInTheSpotlight().attemptsTo(Get.resource("/v2/name/united"));
    }

    @Then("^should save all data countries in file$")
    public void shouldSaveAllDataCountriesInFile() {
        theActorInTheSpotlight().should(
                seeThat(Responses.ofServiceDataCountries(), Matchers.notNullValue()),
                seeThat(TheResponse.statusCode(), Matchers.equalTo(200)));
    }
}
