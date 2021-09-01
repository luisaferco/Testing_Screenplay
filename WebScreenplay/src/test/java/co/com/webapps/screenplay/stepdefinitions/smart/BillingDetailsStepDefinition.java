package co.com.webapps.screenplay.stepdefinitions.smart;

import co.com.webapps.screenplay.interactions.builders.GoTo;
import co.com.webapps.screenplay.questions.smart.SeePay;
import co.com.webapps.screenplay.tasks.smart.AddPlan;
import co.com.webapps.screenplay.tasks.smart.Fill;
import co.com.webapps.screenplay.tasks.smart.GotoOnline;
import co.com.webapps.screenplay.utils.enums.smart.PlansEnum;
import co.com.webapps.screenplay.utils.smart.DataDriven;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static co.com.webapps.screenplay.utils.enums.PagesEnum.SMART_PAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BillingDetailsStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("^(.*) enter to smart page$")
    public void samEnterToSmartPage(String userName) {
        OnStage.theActor(userName).attemptsTo(GoTo.Page(SMART_PAGE));
        
    }


    @When("^go to online store to add shopping cart english lesson plan level A1$")
    public void goToOnlineStoreToAddShoppingCartEnglishLessonPlanLevelA() {
        theActorInTheSpotlight().attemptsTo(GotoOnline.storeToCart()
                                    , AddPlan.toCart(PlansEnum.PLAN_A1_A2));
        
    }

    @When("^Sam complete billing details$")
    public void samCompleteBillingDetails() {
        theActorInTheSpotlight().attemptsTo(Fill.informationBilling(DataDriven.getDataBilling()));
        
    }

    @Then("^should see details pay lesson$")
    public void shouldSeeDetailsPayLesson() {
        theActorInTheSpotlight().should(seeThat(SeePay.UPlatform(), Matchers.containsString("Payu - Smart, academia de idiomas")));
        
    }

}
