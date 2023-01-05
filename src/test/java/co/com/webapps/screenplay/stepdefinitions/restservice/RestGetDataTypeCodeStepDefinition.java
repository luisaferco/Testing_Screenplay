package co.com.webapps.screenplay.stepdefinitions.restservice;

import co.com.webapps.screenplay.questions.restservice.Responses;
import co.com.webapps.screenplay.utils.StringManager;
import co.com.webapps.screenplay.utils.restservice.UrlManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.questions.TheResponse;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class RestGetDataTypeCodeStepDefinition {

    @Before
    public void startTest() {
        setTheStage(new OnlineCast());
    }

    @Given("^consume typecode service$")
    public void consumeTypecodeService() {
        theActorCalled(StringManager.USER_NAME)
                .can(CallAnApi.at(UrlManager.REST_SERVICE_TYPECODE));
    }


    @When("^get data user$")
    public void getDataUser() {
        theActorInTheSpotlight().attemptsTo(Get.resource("/users"));
    }

    @Then("^should save data in file$")
    public void shouldSaveDataInFile() {
        theActorInTheSpotlight().should(
                seeThat(Responses.serviceOfDataUsers(), Matchers.notNullValue()),
                seeThat(TheResponse.statusCode(), Matchers.equalTo(200)));
    }




    @After
    public void endTest() {
        //SerenityRest.clear();
    }

}
