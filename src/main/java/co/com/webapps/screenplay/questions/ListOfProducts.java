package co.com.webapps.screenplay.questions;

import co.com.webapps.screenplay.userinterfaces.ShoppingCartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.stream.Collectors;

public class ListOfProducts implements Question<List<String>> {

    @Override
    public List<String> answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(ShoppingCartPage.ITEMS_SHOPPING_LIST, WebElementStateMatchers.isEnabled())
                .forNoMoreThan(5).seconds());
        return Text.of(ShoppingCartPage.ITEMS_SHOPPING_LIST).viewedBy(actor).resolveAll().stream()
                .collect(Collectors.toList());
    }

    public static ListOfProducts inShoppingCart(){
        return new ListOfProducts();
    }

}
