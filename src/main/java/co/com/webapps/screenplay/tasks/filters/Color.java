package co.com.webapps.screenplay.tasks.filters;

import co.com.webapps.screenplay.userinterfaces.FilterSectionPage;
import co.com.webapps.screenplay.userinterfaces.InitPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class Color implements Task {

    private String colorName;

    public Color(String colorName) {
        this.colorName = colorName;
    }

    @Override
    @Step("{0} filter by color #colorName")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Scroll.to(InitPage.TITLE_CATEGORY).andAlignToTop()
                ,Click.on(FilterSectionPage.FILTER_COLOR)
                ,Scroll.to(InitPage.TITLE_CATEGORY).andAlignToTop()
                );

        actor.attemptsTo(Click.on(FilterSectionPage.OPTION_COLOR.of(colorName)));
    }
}
