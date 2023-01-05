package co.com.webapps.screenplay.tasks.smart;

import co.com.webapps.screenplay.userinterfaces.smart.SmartPage;
import co.com.webapps.screenplay.utils.enums.smart.PlansEnum;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class AddPlan implements Task {

    public PlansEnum plansEnum;

    public AddPlan(PlansEnum plansEnum) {
        this.plansEnum = plansEnum;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ChooseAPlan.named(plansEnum)
                        , Click.on(SmartPage.ADD_TO_CART_BUTTON));
    }

    public static AddPlan toCart(PlansEnum plansEnum){
        return Instrumented.instanceOf(AddPlan.class).withProperties(plansEnum);
    }
}
