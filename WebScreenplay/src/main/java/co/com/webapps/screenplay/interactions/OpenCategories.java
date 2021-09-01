package co.com.webapps.screenplay.interactions;

import co.com.webapps.screenplay.userinterfaces.InitPage;
import co.com.webapps.screenplay.utils.enums.CategoriesEnum;
import co.com.webapps.screenplay.utils.enums.SectionsEnum;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class OpenCategories implements Interaction {


    private final CategoriesEnum category;
    private SectionsEnum section = SectionsEnum.DEFAULT;

    public OpenCategories(CategoriesEnum category) {
        this.category = category;
    }

    @Override
    @Step("{0} open categories menu and select #category")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(InitPage.CATEGORY_MENU, isEnabled())
                        .forNoMoreThan(10).seconds()
                , MoveMouse.to(InitPage.CATEGORY_MENU)
                , WaitUntil.the(InitPage.CATEGORY_OPTION.of(category.getCategory()), isEnabled())
                        .forNoMoreThan(10).seconds()
                , Click.on(InitPage.CATEGORY_OPTION.of(category.getCategory()))
                , Check.whether(!section.getSection().equals("default"))
                        .andIfSo(ScrollBy.aBit()
                                ,WaitUntil.the(InitPage.SECTION_CATEGORY.of(section.getSection()), isClickable())
                                        .forNoMoreThan(100).seconds()
                                ,MoveMouse.to(InitPage.SECTION_CATEGORY.of(section.getSection()))
                                ,(Click.on(InitPage.SECTION_CATEGORY.of(section.getSection())
                                        .waitingForNoMoreThan(Duration.ofSeconds(10)))))
        );

    }

    public static OpenCategories onCategory(CategoriesEnum category){
        return Instrumented.instanceOf(OpenCategories.class).withProperties(category);
    }

    public OpenCategories andSection(SectionsEnum section){
        this.section = section;
        return this;
    }
}
