package co.com.webapps.screenplay.utils.calculator;

import co.com.webapps.screenplay.integration.TextPlainFile;
import co.com.webapps.screenplay.utils.PathManager;

import java.util.ArrayList;
import java.util.List;

public class GetPrices {


    public static List<String> ofShopping(){
        String priceLinio = TextPlainFile.getInstance(PathManager.FILE_PRICE_SHOPPING).readFile();
        String priceSmart = TextPlainFile.getInstance(PathManager.FILE_PRICE_SHOPPING_SMART).readFile();
        List<String> listPrices = new ArrayList<>();
        listPrices.add(priceLinio);
        listPrices.add(priceSmart);
        return listPrices;

    }

    public GetPrices(){
        super();
    }
}
