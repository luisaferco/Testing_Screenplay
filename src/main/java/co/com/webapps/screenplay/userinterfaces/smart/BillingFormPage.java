package co.com.webapps.screenplay.userinterfaces.smart;

import net.serenitybdd.screenplay.targets.Target;

public class BillingFormPage {

        public static final Target INPUT_FIRST_NAME = Target.the("Field to input first name")
                .locatedBy("//input[@id='billing_first_name']");

    public static final Target INPUT_LAST_NAME = Target.the("Field to input last name")
            .locatedBy("//input[@id='billing_last_name']");


    public static final Target INPUT_ID_USER = Target.the("Field to input cedula")
            .locatedBy("//input[@id='billing_cedula']");

    public static final Target INPUT_EMAIL = Target.the("Field to email user")
            .locatedBy("//input[@id='billing_email']");

    public static final Target INPUT_CITY = Target.the("Field to city")
            .locatedBy("//input[@id='billing_city']");


    public static final Target INPUT_ADDRESS = Target.the("Field to city")
            .locatedBy("//input[@id='billing_address_1']");

    public static final Target BUTTON_MAKE_PAY = Target.the("go to Pay ")
            .locatedBy("//button[@id='place_order']");

    public BillingFormPage() {
        super();
    }
}
