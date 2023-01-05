package co.com.webapps.screenplay.tasks.filters;

import co.com.webapps.screenplay.userinterfaces.FilterSectionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class Shipment implements Task {


    private String type;

    public Shipment(String type) {
        this.type = type;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(FilterSectionPage.FILTER_SHIP)
                ,Click.on(FilterSectionPage.TYPE_SHIP.of(type)));
    }
}
