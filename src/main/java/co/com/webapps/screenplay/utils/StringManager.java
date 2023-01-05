package co.com.webapps.screenplay.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class StringManager {

    public static final String FIRST = "1";
    public static final String USER_NAME = "UserService";
    public static final String USER = "User";
    public static final String LOGIN_FAILED = "Credenciales incorrectas";
    public static final String ARTICLE_FOUND = "found";
    public static final Boolean YES = true;
    public static final boolean NO = false;

    public static int priceToInteger(String priceString){
        int intPrice=0;
        StringBuilder stringPriceBuilder = new StringBuilder();
        stringPriceBuilder.append(priceString);
        stringPriceBuilder.deleteCharAt(0);
        intPrice = Integer.parseInt(stringPriceBuilder.toString().replace(".","").replace(",",""));
        return  intPrice;
    }

    public static String integerToCurrency(int price){
        Locale colDish = new Locale("es","CO");
        NumberFormat colDishFormat = NumberFormat.getCurrencyInstance(colDish);
        return  colDishFormat.format(price);
    }

    public StringManager() {
        super();
    }
}
