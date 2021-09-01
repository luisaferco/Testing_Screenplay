package co.com.webapps.screenplay.models;

public class Article {

    private String name;
    private String quantity;

    public Article() {
    }

    public Article(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Article(ArticleBuilder articleBuilder){
        this.name = articleBuilder.getName();
        this.quantity = articleBuilder.getQuantity();
    }


    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }
}
