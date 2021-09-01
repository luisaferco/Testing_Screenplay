package co.com.webapps.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class TextOf implements Question<String> {

    private final Target target;

    public TextOf(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(target).viewedBy(actor).resolve();
    }

    public static TextOf target(Target tr){
        return new TextOf(tr);
    }
}
