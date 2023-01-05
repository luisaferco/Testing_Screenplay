package co.com.webapps.screenplay.questions;

import co.com.webapps.screenplay.userinterfaces.ShoppingCartPage;
import co.com.webapps.screenplay.utils.StringManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;
import java.util.stream.Collectors;

public class Prices implements Question<List<Integer>> {

    @Override
    public List<Integer> answeredBy(Actor actor) {
        return Text.of(ShoppingCartPage.PRICE_ITEMS_SHOPPING_LIST).viewedBy(actor).resolveAll()
                .stream().map(StringManager::priceToInteger).collect(Collectors.toList());
    }

    public static Prices ofArticles(){
        return new Prices();
    }
}
