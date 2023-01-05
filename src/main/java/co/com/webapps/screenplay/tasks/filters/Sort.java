package co.com.webapps.screenplay.tasks.filters;

import co.com.webapps.screenplay.userinterfaces.FilterSectionPage;
import co.com.webapps.screenplay.utils.enums.TypeSort;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Sort implements Task {

    private TypeSort typeSort;

    public Sort(TypeSort typeSort) {
        this.typeSort = typeSort;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(FilterSectionPage.SORT_FILTER, WebElementStateMatchers.isClickable()),
                Click.on(FilterSectionPage.SORT_FILTER)
                    ,Click.on(FilterSectionPage.SORT_TYPE.of(typeSort.getType())));
    }
}
