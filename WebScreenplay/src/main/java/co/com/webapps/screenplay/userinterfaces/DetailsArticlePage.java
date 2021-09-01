package co.com.webapps.screenplay.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DetailsArticlePage {

    public static final Target LIST_DROPDOWN_PRODUCT_QUANTITY = Target.the("List of quantities of product")
            .locatedBy("//div[@class='select-dropdown select-dropdown-product-quantity']");

    public static final Target VALUE_LIST_QUANTITY = Target.the("Select dropdown list product quantity")
            .locatedBy("//ul/li[@data-value='{0}']");

    public static final Target ADD_TO_CART_BUTTON = Target.the("Button to add to cart the article")
            .locatedBy("//button[@class='btn btn-lg buy-now-button btn-primary']");

    public static final Target KEEP_SHOPPING_BUTTON = Target.the("button to close and keep shopping ")
            .locatedBy("//button[@class='btn btn-sm btn-close-and-keep-shopping btn-link']");

    public static final Target GO_TO_CART = Target.the("go to cart added product button")
            .locatedBy("//a[@class='btn btn-sm btn-go-to-cart added-product']");

    public static final Target ITEM_OPTION_RETURN_CATEGORY = Target.the("link return category")
            .locatedBy("//li[@itemprop='itemListElement']/a/span[text()='Consolas y Videojuegos']");

    private DetailsArticlePage() {
    }
}
