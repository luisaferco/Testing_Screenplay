package co.com.webapps.screenplay.tasks.calculator;

import co.com.webapps.screenplay.userinterfaces.calculator.CalculatorPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Sum implements Task {

    private List<String> listNumbers;

    public Sum(List<String> listNumbers) {
        this.listNumbers = listNumbers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Iterator<String> numbers = listNumbers.iterator();
         while (numbers.hasNext()){
             String price = numbers.next();
             for(char digit:price.toCharArray()){
                    actor.attemptsTo( Click.on(CalculatorPage.NUMBER_BUTTON.of(String.valueOf(digit))));
             }
            if(numbers.hasNext()){
                actor.attemptsTo( Click.on(CalculatorPage.ADD_BUTTON));
            }
        }

        actor.attemptsTo( Click.on(CalculatorPage.TOTAL_BUTTON));
    }

    public static Sum ofPrices(String... prices){
       return Instrumented.instanceOf(Sum.class).withProperties(Arrays.asList(prices));
    }

    public static Sum ofPrices(List<String> prices){
        return Instrumented.instanceOf(Sum.class).withProperties(prices);
    }
}
