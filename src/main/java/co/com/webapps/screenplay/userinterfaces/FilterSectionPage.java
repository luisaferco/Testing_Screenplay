package co.com.webapps.screenplay.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FilterSectionPage {

    public static final Target LIST_GROUP_FILTER_SEARCH = Target.the("list group filter search group")
            .locatedBy("//dl[@class='list-group filter-search-group']");

    public static final Target FILTER_BRAND = Target.the("Filter brand")
            .locatedBy("//dd[@id='brand-body']/parent::div");

    public static final Target BRAND_OPTION = Target.the("option List brand")
            .locatedBy("//label[@for='brand-{0}']");

    public static final Target FILTER_PRICE = Target.the("Filter PRice")
            .locatedBy("//dd[@id='price-body']/parent::div");

    public static final Target PRICE_MIN = Target.the("Price min")
            .locatedBy("//input[@id='price-min']");

    public static final Target PRICE_MAX = Target.the("Price max")
            .locatedBy("//input[@id='price-max']");

    public static final Target ESTABLISH_PRICES = Target.the("Establish range prices")
            .locatedBy("//button[@class='btn btn-default-outline btn-xsm']");

    public static final Target FILTER_SHIP = Target.the("Filter shipment")
            .locatedBy("//dd[@id='is_international-body']/parent::div");

    public static final Target TYPE_SHIP = Target.the("Select check button to type shipment")
            .locatedBy("//label//a[contains(text(),'{0}')]");

    public static final Target FILTER_COLOR = Target.the("Filter color")
            .locatedBy("//dd[@id='filter_color-body']/parent::div");

    public static final Target OPTION_COLOR = Target.the("Select color")
            .locatedBy("//label[@for='filter_color-{0}']");

    public static final Target OPTION_LETTER_COLOR = Target.the("Scroll to first letter color")
            .locatedBy("//dd[@id='filter_color-body']/ul/div[@class='group-item' and contains(text(),'{0}')]");


    public static final Target SORT_FILTER = Target.the("Sort searching")
            .locatedBy("//span[contains(@class,'sort-by-title')]");

    public static final Target SORT_TYPE = Target.the("Select type sort")
            .locatedBy("//label[@for='{0}-order']");

}
