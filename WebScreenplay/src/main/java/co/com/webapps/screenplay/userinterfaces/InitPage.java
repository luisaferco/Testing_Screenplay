package co.com.webapps.screenplay.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InitPage {


    public static final Target CATEGORY_MENU = Target.the("Left menu categories")
                .locatedBy("//div[contains(text(),'Categor�as')]");

    public static final Target SHOPPING_CART = Target.the("Shopping Cart icon")
            .locatedBy("//a[@href='/cart']/span[@class='icon icon-padding']");

    public static final Target CATEGORY_OPTION = Target.the("the Category to select of list")
            .locatedBy("//a[@title='{0}']");

    public static final Target SECTION_CATEGORY = Target.the("")
            .locatedBy("//span[@class='category-name' and contains(text(),'{0}')]");

    public static final Target ARTICLE = Target.the("Article of list products ")
            .locatedBy("//span[@class='title-section' and contains(text(),'{0}')]");

    public static final Target LIST_GROUP_FILTER_SEARCH = Target.the("list group filter search group")
            .locatedBy("//dl[@class='list-group filter-search-group']");

    public static final Target TITLE_CATEGORY = Target.the("Title of Category")
            .locatedBy("//h1[@class='catalogue-title section-title']");

    public static final Target CATALOG_ROW_PRODUCT = Target.the("Catalog row product")
            .locatedBy("(//div[@class='catalogue-product row '])[{0}]");

    private InitPage() {
    }
}
