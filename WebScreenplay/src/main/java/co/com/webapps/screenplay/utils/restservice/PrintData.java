package co.com.webapps.screenplay.utils.restservice;

public class PrintData {

    public static UsersServiceFile setUserstoTxt(String path){
        return new UsersServiceFile(path);
    }

    public static CountriesServiceFile setCountriesToExcel(String path){
        return new CountriesServiceFile(path);
    }

    public PrintData() {
        super();
    }
}
