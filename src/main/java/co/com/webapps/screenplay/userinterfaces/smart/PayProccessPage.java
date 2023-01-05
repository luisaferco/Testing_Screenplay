package co.com.webapps.screenplay.userinterfaces.smart;

import net.serenitybdd.screenplay.targets.Target;

public class PayProccessPage {

    public static final Target TITLE_SUMMARY_PAY = Target.the("Summary pay")
            .locatedBy("//h2[@translate='purchase_summary.title']");

    public static final Target TOTAL_TO_PAY = Target.the("Total to pay")
            .locatedBy("//*[@id='order_review']/table/tfoot/tr[2]/td/strong/span/bdi");
}
