package co.com.webapps.screenplay.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

public class ScrollBy implements Interaction {

    @Override
    @Step("{0} scroll a little bit")
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).evaluateJavascript("window.scrollBy(0,10)");
        BrowseTheWeb.as(actor).evaluateJavascript("window.scrollBy(0,20)");
        BrowseTheWeb.as(actor).evaluateJavascript("window.scrollBy(0,30)");
        BrowseTheWeb.as(actor).evaluateJavascript("window.scrollBy(0,40)");
        BrowseTheWeb.as(actor).evaluateJavascript("window.scrollBy(0,50)");

    }


    public static ScrollBy aBit(){
        return Instrumented.instanceOf(ScrollBy.class).newInstance();
    }
}
