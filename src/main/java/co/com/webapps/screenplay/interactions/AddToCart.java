package co.com.webapps.screenplay.interactions;

import co.com.webapps.screenplay.userinterfaces.DetailsArticlePage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

public class AddToCart implements Interaction {

    private String quantity;

    public AddToCart(String quantity) {
        this.quantity = quantity;
    }

    @Override
    @Step("{0} add #quantity of this article and add cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Check.whether(Integer.parseInt(quantity)>1)
                        .andIfSo(Click.on(DetailsArticlePage.LIST_DROPDOWN_PRODUCT_QUANTITY)
                                ,Click.on(DetailsArticlePage.VALUE_LIST_QUANTITY.of(quantity)))
                ,Click.on(DetailsArticlePage.ADD_TO_CART_BUTTON));
    }

    public static AddToCart quantity(String quantity){
        return Instrumented.instanceOf(AddToCart.class).withProperties(quantity);
    }
}
