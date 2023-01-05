package co.com.webapps.screenplay.tasks;

import co.com.webapps.screenplay.userinterfaces.ShoppingCartPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

public class Clean implements Task {

    @Override
    @Step("{0} remove all articles of shopping cart")
    public <T extends Actor> void performAs(T actor) {
        ShoppingCartPage.DELETE_ITEM.resolveAllFor(actor).forEach(
                webElementFacade ->  actor.attemptsTo(Click.on(webElementFacade),
                        WaitUntil.the(ShoppingCartPage.LOADING, WebElementStateMatchers.isNotPresent())
                                .forNoMoreThan(10).seconds())
        );

    /*    actor.attemptsTo(Click.on(ShoppingCartPage.DELETE_ITEM),
                WaitUntil.the(ShoppingCartPage.LOADING, WebElementStateMatchers.isNotPresent())
                .forNoMoreThan(10).seconds());
    actor.attemptsTo(  Click.on(ShoppingCartPage.DELETE_ITEM) );

     */
    }

    public static Clean allShoppingCart(){
        return Instrumented.instanceOf(Clean.class).newInstance();
    }
}
