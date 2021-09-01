package co.com.webapps.screenplay.utils.enums.smart;

public enum PlansEnum {

    PLAN_A1_A2("presencial Nivel A1 o A2");

    private String plan;

    PlansEnum(String plan) {
        this.plan = plan;
    }

    public String getPlan() {
        return plan;
    }
}
