package co.com.webapps.screenplay.tasks.smart;

import co.com.webapps.screenplay.userinterfaces.smart.SmartPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class GotoOnline implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(SmartPage.ONLINE_STORE_OPTION)
                            , WaitUntil.the(SmartPage.GO_TO_CART, WebElementStateMatchers.isClickable())
                            ,Click.on(SmartPage.GO_TO_CART));
    }

    public static GotoOnline storeToCart(){
        return Instrumented.instanceOf(GotoOnline.class).newInstance();
    }
}
