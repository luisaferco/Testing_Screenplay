package co.com.webapps.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterAndHide implements Interaction {

    private Target target;
    private String value;

    public EnterAndHide(String theText) {
        this.value = theText;
    }

    @Step("{0} enters ****** into #target")
    @Override
    public <T extends Actor> void performAs(T actor) {
        target.resolveFor(actor).sendKeys(value);
    }

    public static EnterAndHide theValue(String theText){
        return instrumented(EnterAndHide.class,theText);
    }

    public EnterAndHide into(Target target){
        this.target=target;
        return this;
    }

}
