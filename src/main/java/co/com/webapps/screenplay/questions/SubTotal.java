package co.com.webapps.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class SubTotal implements Question<Integer> {

    private final Question<? extends Collection<Integer>> listQuestion;

    public SubTotal(Question<? extends Collection<Integer>> listQuestion) {
        this.listQuestion = listQuestion;
    }

    @Override
    public Integer answeredBy(Actor actor) {
        List<Integer> pricesList= (List<Integer>) listQuestion.answeredBy(actor);
        List<Integer> quantityList = actor.asksFor(Quantities.ofEachArticles());
        return IntStream.range(0,Math.min(pricesList.size(), 1))
                .map(i-> pricesList.get(i)*quantityList.get(i))
                .sum();
    }

    public static SubTotal ofShopping(Question<? extends Collection<Integer>> listQuestion){
        return new SubTotal(listQuestion);
    }


}
