package co.com.webapps.screenplay.tasks.filters;

import co.com.webapps.screenplay.userinterfaces.FilterSectionPage;
import co.com.webapps.screenplay.userinterfaces.InitPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class Brand implements Task {

    private String brandOption;

    public Brand(String brandOption) {
        this.brandOption = brandOption;
    }

    @Override
    @Step("{0} filter by brand #brandOption")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Scroll.to(InitPage.TITLE_CATEGORY)
                        ,Click.on(FilterSectionPage.FILTER_BRAND)
                        ,Click.on(FilterSectionPage.BRAND_OPTION.of(brandOption))
        );
    }


}
