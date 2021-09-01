package co.com.webapps.screenplay.tasks.smart;

import co.com.webapps.screenplay.userinterfaces.smart.SmartPage;
import co.com.webapps.screenplay.utils.enums.smart.PlansEnum;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

public class ChooseAPlan implements Task {

    private final PlansEnum plan;

    public ChooseAPlan(PlansEnum plan) {
        this.plan = plan;
    }

    @Override
    @Step("{0} select plan #plan")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the((SmartPage.TITLE_PLANS), WebElementStateMatchers.isEnabled())
                        .forNoMoreThan(10).seconds()
                ,Scroll.to(SmartPage.TITLE_PLANS).andAlignToTop()
                ,WaitUntil.the(SmartPage.SELECT_PLAN.of(plan.getPlan()), WebElementStateMatchers.isEnabled())
                                .forNoMoreThan(10).seconds()
                ,Click.on(SmartPage.SELECT_PLAN.of(plan.getPlan())));
    }


    public static ChooseAPlan named(PlansEnum plan){
        return Instrumented.instanceOf(ChooseAPlan.class).withProperties(plan);
    }
}
