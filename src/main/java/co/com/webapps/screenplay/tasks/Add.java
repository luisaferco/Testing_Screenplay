package co.com.webapps.screenplay.tasks;

import co.com.webapps.screenplay.interactions.AddToCart;
import co.com.webapps.screenplay.interactions.ScrollBy;
import co.com.webapps.screenplay.userinterfaces.DetailsArticlePage;
import co.com.webapps.screenplay.userinterfaces.InitPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.webapps.screenplay.utils.StringManager.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class Add implements Task {

    private String articleName;
    private String quantity;

    public Add(String articleName) {
        this.articleName = articleName;
        this.quantity = "1";
    }

    @Override
    @Step("{0} select #articleName then select #quantity articles and finally add to cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ScrollBy.aBit(),
                RememberThat.theValueOf(ARTICLE_FOUND).is(NO));

        while(actor.recall(ARTICLE_FOUND).equals(false)) {
            actor.attemptsTo(ScrollBy.aBit()
                    ,Check.whether(!Text.of(InitPage.ARTICLE.of(articleName)).viewedBy(actor).resolveAll().isEmpty())
                    .andIfSo(Click.on(InitPage.ARTICLE.of(articleName))
                            ,WaitUntil.the(DetailsArticlePage.LIST_DROPDOWN_PRODUCT_QUANTITY, isEnabled())
                                    .forNoMoreThan(5).seconds()
                            ,AddToCart.quantity(quantity)
                            ,RememberThat.theValueOf(ARTICLE_FOUND).is(YES))
                    .otherwise(ScrollBy.aBit(),ScrollBy.aBit()));
        }
          /*  actor.attemptsTo(ScrollBy.aBit(), ScrollBy.aBit()
                    //Scroll.to(InitPage.LIST_GROUP_FILTER_SEARCH).andAlignToTop()
                    , WaitUntil.the(InitPage.ARTICLE.of(articleName), WebElementStateMatchers.isEnabled())
                            .forNoMoreThan(8).seconds()
                    , Scroll.to(InitPage.ARTICLE.of(articleName)).andAlignToBottom()
                    , Click.on(InitPage.ARTICLE.of(articleName))
                    , WaitUntil.the(DetailsArticlePage.LIST_DROPDOWN_PRODUCT_QUANTITY, WebElementStateMatchers.isEnabled())
                            .forNoMoreThan(5).seconds()
                    , AddToCart.quantity(quantity)
            );

           */


    }

    public static Add article(String name){
        return Instrumented.instanceOf(Add.class).withProperties(name);
    }

    public Add withProductQuantity(String quantity){
        this.quantity = quantity;
        return this;
    }
}
