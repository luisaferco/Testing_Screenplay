package co.com.webapps.screenplay.questions.calculator;

import co.com.webapps.screenplay.userinterfaces.calculator.CalculatorPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("the result of operation")
public class TheResult implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return Integer.parseInt(CalculatorPage.RESULT.resolveFor(actor)
                .getText().replace("Display is", "").replace(".","").trim());
    }

    public static TheResult ofOperation() {
        return new TheResult();
    }
}
