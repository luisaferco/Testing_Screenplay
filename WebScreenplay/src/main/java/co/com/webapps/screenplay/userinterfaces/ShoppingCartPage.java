package co.com.webapps.screenplay.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ShoppingCartPage {

    public static final Target ITEMS_SHOPPING_LIST = Target.the("Shopping list items")
            .locatedBy("//div[@class='cart-items row']//div[contains(@class,'item-title col-xs-10')]/span/a");

    public static final Target PRICE_ITEMS_SHOPPING_LIST = Target.the("Shopping list price items")
            .locatedBy("//div[@class='cart-items row']//div[@class='price-main-md']");

    public static final Target QUANTITY_ITEMS_SHOPPING_LIST = Target.the("Shopping list quantity items")
            .locatedBy("//div[@class='cart-items row']//select[@ng-model='item.quantity']/option[@selected]");

    public static final Target SUBTOTAL_PRICE = Target.the("Subtotal price")
            .locatedBy("//span[contains(@class,'subtotal-price')]");

    public static final Target DELETE_ITEM = Target.the("Delete any item of shopping cart")
            .locatedBy("//a[contains(text(),'Eliminar')]");

    public static final Target LOADING = Target.the("loading")
            .locatedBy("//ui-spinner[@class='loading-overlay']");

    public static final Target EMPTY_CART_SHOPPING_MESSAGE = Target.the("Empty shopping cart message")
            .locatedBy("//h2[contains(text(),'No tienes productos en tu carrito')]");


    private ShoppingCartPage() {

    }
}
