package co.com.webapps.screenplay.tasks.filters;

import co.com.webapps.screenplay.userinterfaces.FilterSectionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Price implements Task {

    private String min;
    private String max;

    public Price(String min) {
        this.min = min;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(FilterSectionPage.FILTER_PRICE)
                , Enter.theValue(min).into(FilterSectionPage.PRICE_MIN)
                , Enter.theValue(max).into(FilterSectionPage.PRICE_MAX)
                ,Click.on(FilterSectionPage.ESTABLISH_PRICES)
                    );
    }

    public Price to(String max){
        this.max = max;
        return this;
    }
}
