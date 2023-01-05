package co.com.webapps.screenplay.tasks;

import co.com.webapps.screenplay.interactions.OpenCategories;
import co.com.webapps.screenplay.models.Article;
import co.com.webapps.screenplay.userinterfaces.DetailsArticlePage;
import co.com.webapps.screenplay.utils.enums.CategoriesEnum;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Adds implements Task {

    private List<Article> listArticles;
    private CategoriesEnum categoriesEnum;

    public Adds(List<Article> listArticles) {
        this.listArticles = listArticles;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        listArticles.forEach(article ->
                    actor.attemptsTo(OpenCategories.onCategory(categoriesEnum)
                            ,Add.article(article.getName()).withProductQuantity(article.getQuantity())
                            ,Click.on(DetailsArticlePage.KEEP_SHOPPING_BUTTON))
        );
        actor.attemptsTo(RememberThat.theValueOf("listOfProducts")
                .is(listArticles.stream().map(Article::getName).collect(Collectors.toList())));

    }

    public static Adds articles(List<Article> listArticles){
        return Instrumented.instanceOf(Adds.class).withProperties(listArticles);
    }

    public static Adds articles(Article... listArticles){
        return Instrumented.instanceOf(Adds.class).withProperties(Arrays.asList(listArticles));
    }

    public Adds fromCategory(CategoriesEnum categoriesEnum){
        this.categoriesEnum = categoriesEnum;
        return this;
    }
}
