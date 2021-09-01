package co.com.webapps.screenplay.interactions;

import co.com.webapps.screenplay.questions.TextOf;
import co.com.webapps.screenplay.userinterfaces.InitPage;
import co.com.webapps.screenplay.userinterfaces.ShoppingCartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class Cart implements Interaction {

    @Override
    @Step("{0} go to shopping cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(InitPage.SHOPPING_CART,WebElementStateMatchers.isClickable()).forNoMoreThan(2).seconds()
                ,Click.on(InitPage.SHOPPING_CART)
                , WaitUntil.the(ShoppingCartPage.SUBTOTAL_PRICE, WebElementStateMatchers.isEnabled())
                .forNoMoreThan(10).seconds());
        actor.should(eventually(seeThat(TextOf.target(ShoppingCartPage.SUBTOTAL_PRICE), Matchers.any(String.class))));
        actor.attemptsTo(RememberThat.theValueOf("subtotal").isAnsweredBy(TextOf.target(ShoppingCartPage.SUBTOTAL_PRICE)));
    }

}
