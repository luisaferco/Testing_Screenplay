package co.com.webapps.screenplay.interactions.sums;

import co.com.webapps.screenplay.integration.TextPlainFile;
import co.com.webapps.screenplay.utils.PathManager;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static co.com.webapps.screenplay.utils.StringManager.priceToInteger;

public class PriceOfSmartPlan implements Interaction, IsSilent {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String price ="0";
        try{
            price =  actor.recall("subtotal");
        }catch (Exception e){
            price = "0";
        }
        TextPlainFile.getInstance(PathManager.FILE_PRICE_SHOPPING_SMART)
                .writeFile(String.valueOf(priceToInteger(price)));
    }

}
