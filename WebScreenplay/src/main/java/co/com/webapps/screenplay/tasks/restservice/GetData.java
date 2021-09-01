package co.com.webapps.screenplay.tasks.restservice;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class GetData implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo();
    }

    public static GetData service(){
        return Instrumented.instanceOf(GetData.class).newInstance();
    }
}
