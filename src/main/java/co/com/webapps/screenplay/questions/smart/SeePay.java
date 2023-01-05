package co.com.webapps.screenplay.questions.smart;

import co.com.webapps.screenplay.questions.TextOf;
import co.com.webapps.screenplay.userinterfaces.smart.PayProccessPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class SeePay implements Question<String> {


    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(PayProccessPage.TITLE_SUMMARY_PAY, WebElementStateMatchers.isPresent()));
        actor.should(eventually(seeThat(TextOf.target(PayProccessPage.TITLE_SUMMARY_PAY)
                ,Matchers.containsString("Resumen de la compra")).because("Espera que la plataforma lo lleve al proceso de pago")));
        return BrowseTheWeb.as(actor).getTitle();
    }

    public static SeePay UPlatform(){
        return new SeePay();
    }
}
