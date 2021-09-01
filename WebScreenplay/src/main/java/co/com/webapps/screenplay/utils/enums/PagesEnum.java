package co.com.webapps.screenplay.utils.enums;

public enum PagesEnum {

    LINIO_PAGE("https://www.linio.com.co/"),
    SMART_PAGE("https://smart.edu.co/ ");


    private String url;

    PagesEnum(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
