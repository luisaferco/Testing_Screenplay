package co.com.webapps.screenplay.tasks.smart;

import co.com.webapps.screenplay.integration.TextPlainFile;
import co.com.webapps.screenplay.models.smart.DataBilling;
import co.com.webapps.screenplay.questions.TextOf;
import co.com.webapps.screenplay.userinterfaces.smart.BillingFormPage;
import co.com.webapps.screenplay.userinterfaces.smart.PayProccessPage;
import co.com.webapps.screenplay.utils.PathManager;
import co.com.webapps.screenplay.utils.StringManager;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

public class Fill implements Task {

    private DataBilling dataBilling;

    public Fill(DataBilling dataBilling) {
        this.dataBilling = dataBilling;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(Enter.theValue(dataBilling.getFirstName()).into(BillingFormPage.INPUT_FIRST_NAME)
                            ,Enter.theValue(dataBilling.getLastName()).into(BillingFormPage.INPUT_LAST_NAME)
                            ,Enter.theValue(dataBilling.getId()).into(BillingFormPage.INPUT_ID_USER)
                            ,Enter.theValue(dataBilling.getEmail()).into(BillingFormPage.INPUT_EMAIL)
                            ,Enter.theValue(dataBilling.getCity()).into(BillingFormPage.INPUT_CITY)
                            ,Enter.theValue(dataBilling.getAddress()).into(BillingFormPage.INPUT_ADDRESS)
                            ,Scroll.to(PayProccessPage.TOTAL_TO_PAY).andAlignToBottom()
                            ,RememberThat.theValueOf("subtotal").is(TextOf.target(PayProccessPage.TOTAL_TO_PAY)));

        TextPlainFile.getInstance(PathManager.FILE_PRICE_SHOPPING_SMART)
                .writeFile(String.valueOf(StringManager.priceToInteger(TextOf.target(PayProccessPage.TOTAL_TO_PAY).answeredBy(actor))));
        actor.attemptsTo(Click.on(BillingFormPage.BUTTON_MAKE_PAY));
    }

    public static Fill informationBilling(DataBilling billing){
        return Instrumented.instanceOf(Fill.class).withProperties(billing);
    }
}
