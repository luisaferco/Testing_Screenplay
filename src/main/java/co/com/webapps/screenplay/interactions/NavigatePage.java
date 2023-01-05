package co.com.webapps.screenplay.interactions;

import co.com.webapps.screenplay.utils.enums.PagesEnum;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class NavigatePage implements Task {

    private final PagesEnum page;

    public NavigatePage(PagesEnum page) {
        this.page = page;
    }

    @Override
    @Step("{0} navigate to page #page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(page.getUrl()));
    }

}
