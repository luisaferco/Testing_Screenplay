package co.com.webapps.screenplay.utils.smart;

import co.com.webapps.screenplay.integration.CsvFiles;
import co.com.webapps.screenplay.models.Article;
import co.com.webapps.screenplay.models.ArticleBuilder;
import co.com.webapps.screenplay.models.smart.DataBilling;
import co.com.webapps.screenplay.models.smart.DataBillingBuilder;
import co.com.webapps.screenplay.utils.PathManager;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataDriven {

    public static DataBilling getDataBilling(){
        return DataBillingBuilder.getInstance(CsvFiles.inPath(PathManager.FILE_DATA_BILLING_SMART).getData()
        .get(0)).build();
    }
    public static List<Article> getListArticles(){
        List<Map<String,String>> list = CsvFiles.inPath(PathManager.FILE_DATA_LIST_ARTICLES).getData();
        return list.stream().map(element->ArticleBuilder.getInstance(element).build())
                .collect(Collectors.toList());
    }


    public DataDriven() {
    }
}
