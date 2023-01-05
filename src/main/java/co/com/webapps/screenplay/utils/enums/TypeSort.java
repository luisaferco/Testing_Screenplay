package co.com.webapps.screenplay.utils.enums;

public enum TypeSort {

    LOWER_PRICE("Menor precio");

    private String type;

    TypeSort(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
