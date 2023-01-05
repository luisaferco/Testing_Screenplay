package co.com.webapps.screenplay.utils.enums;

public enum CategoriesEnum {

    CONSOLES_AND_VIDEO_GAMES("Consolas y Videojuegos"),
    SPORTS("Deportes"),
    FASHION("Moda");

    private String category;

    CategoriesEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
