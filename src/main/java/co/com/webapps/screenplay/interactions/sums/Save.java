package co.com.webapps.screenplay.interactions.sums;

import net.serenitybdd.core.steps.Instrumented;

public class Save {


    public static PriceOfLinioShopping priceLinioShopping(){
        return Instrumented.instanceOf(PriceOfLinioShopping.class).newInstance();
    }

    public static PriceOfSmartPlan priceSmartPlan(){
        return Instrumented.instanceOf(PriceOfSmartPlan.class).newInstance();
    }


    public Save() {
        super();
    }
}
