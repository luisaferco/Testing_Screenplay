package co.com.webapps.screenplay.models;

import java.util.Map;

public class ArticleBuilder implements Builder<Article>{

    private String name;
    private String quantity;

    public ArticleBuilder(Map<String,String> data){
        this.name = data.get("name");
        this.quantity = data.get("quantity");
    }

    public static ArticleBuilder getInstance(Map<String,String> data){
        return new ArticleBuilder(data);
    }

    @Override
    public Article build() {
        return new Article(this);
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }
}
