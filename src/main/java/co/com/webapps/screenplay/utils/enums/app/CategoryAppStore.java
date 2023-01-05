package co.com.webapps.screenplay.utils.enums.app;

public enum CategoryAppStore {

    MOBILE_CATEGORY("Celulares");

    private String category;

    CategoryAppStore(String category) {
        this.category = category;
    }

    public String getType() {
        return category;
    }
}
