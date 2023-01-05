package co.com.webapps.screenplay.stepdefinitions.calculator;

import co.com.webapps.screenplay.questions.calculator.TheResult;
import co.com.webapps.screenplay.tasks.calculator.Sum;
import co.com.webapps.screenplay.utils.calculator.GetPrices;
import co.com.webapps.screenplay.utils.driver.Driver;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class AddPricesStepDefinition {

    @Given("^user open calculator$")
    public void userOpenCalculator() {
        OnStage.theActor("Luisa").can(BrowseTheWeb.with(Driver.calculator()));
    }

    @When("^sum total prices of shopping$")
    public void sumTotalPricesOfShopping() {

            theActorInTheSpotlight().attemptsTo(Sum.ofPrices(GetPrices.ofShopping()));
    }

    @Then("^should see total (\\d+)$")
    public void shouldSeeTotal(int total) {
            theActorInTheSpotlight().should(seeThat(TheResult.ofOperation(), is(total)));
    }

    @After()
    public void tearDown() {

        Driver.closeDriver();

    }

}
