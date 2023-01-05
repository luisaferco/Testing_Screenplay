package co.com.webapps.screenplay.questions;

import co.com.webapps.screenplay.userinterfaces.ShoppingCartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;
import java.util.stream.Collectors;

public class Quantities implements Question<List<Integer>> {

    @Override
    public List<Integer> answeredBy(Actor actor) {
        return Text.of(ShoppingCartPage.QUANTITY_ITEMS_SHOPPING_LIST).viewedBy(actor).resolveAll()
                .stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public static Quantities ofEachArticles(){
        return new Quantities();
    }
}
