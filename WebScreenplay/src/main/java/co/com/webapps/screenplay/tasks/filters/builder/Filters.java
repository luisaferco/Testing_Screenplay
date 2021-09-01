package co.com.webapps.screenplay.tasks.filters.builder;

import co.com.webapps.screenplay.tasks.filters.*;
import co.com.webapps.screenplay.utils.enums.TypeSort;
import net.serenitybdd.core.steps.Instrumented;

public class Filters {

    public static Brand byBrand(String brand){
        return Instrumented.instanceOf(Brand.class).withProperties(brand);
    }

    public static Price byPriceFrom(String min){
     return Instrumented.instanceOf(Price.class).withProperties(min);
    }

    public static Shipment byShipment(String type){
        return Instrumented.instanceOf(Shipment.class).withProperties(type);
    }

    public static Color byColor(String colorName){
        return Instrumented.instanceOf(Color.class).withProperties(colorName);
    }

    public static Sort sortBy(TypeSort typeSort){
        return Instrumented.instanceOf(Sort.class).withProperties(typeSort);
    }
}
