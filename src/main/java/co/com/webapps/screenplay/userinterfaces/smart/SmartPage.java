package co.com.webapps.screenplay.userinterfaces.smart;

import net.serenitybdd.screenplay.targets.Target;

public class SmartPage {

    public static final Target ONLINE_STORE_OPTION = Target.the("Enter to online store")
            .locatedBy("//nav//li[contains(@id,'menu-item-94510')]/a[contains(text(),'Tienda Virtual')]");

    public static final Target GO_TO_CART = Target.the("Go to shopping cart")
            .locatedBy("//nav//li[contains(@id,'menu-item-94510')]//ul[@class='sub-menu']//span[contains(text(),'Carrito de Compras')]");

    public static final Target TITLE_PLANS = Target.the("Plans to add to cart")
            .locatedBy("//h1[contains(text(),'Programas presenciales en nuestras sedes')]");

    public static final Target SELECT_PLAN = Target.the("Select plan ")
            .locatedBy("//h2[contains(text(),'{0}')]");

    public static final Target ADD_TO_CART_BUTTON = Target.the("Add to cart")
            .locatedBy("//button[@name='add-to-cart']");

    public SmartPage() {
        super();
    }
}
