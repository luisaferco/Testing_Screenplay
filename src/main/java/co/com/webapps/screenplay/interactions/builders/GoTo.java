package co.com.webapps.screenplay.interactions.builders;

import co.com.webapps.screenplay.interactions.Cart;
import co.com.webapps.screenplay.interactions.NavigatePage;
import co.com.webapps.screenplay.utils.enums.PagesEnum;
import net.serenitybdd.core.steps.Instrumented;

public class GoTo {

    public static NavigatePage Page(PagesEnum page){
        return Instrumented.instanceOf(NavigatePage.class).withProperties(page);
    }

    public static Cart shoppingCart(){
        return Instrumented.instanceOf(Cart.class).newInstance();
    }
}
