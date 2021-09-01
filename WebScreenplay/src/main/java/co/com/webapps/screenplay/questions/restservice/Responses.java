package co.com.webapps.screenplay.questions.restservice;


public class Responses {


    public static DataUsers serviceOfDataUsers(){
        return new DataUsers();
    }

    public static TheCountries ofServiceDataCountries(){
        return new TheCountries();
    }

    public Responses() {
        super();
    }
}
