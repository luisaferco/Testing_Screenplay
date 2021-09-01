package co.com.webapps.screenplay.models.smart;

import co.com.webapps.screenplay.models.Builder;

import java.util.Map;

public class DataBillingBuilder implements Builder<DataBilling> {


    private String firsName;
    private String lastName;
    private String id;
    private String email;
    private String city;
    private String address;

    public DataBillingBuilder(Map<String,String> data){
        this.firsName = data.get("firstName");
        this.lastName = data.get("lastName");
        this.id = data.get("id");
        this.email = data.get("email");
        this.city = data.get("city");
        this.address = data.get("address");
    }

    public static DataBillingBuilder getInstance(Map<String,String> data){
        return new DataBillingBuilder(data);
    }

    @Override
    public DataBilling build() {
        return new DataBilling(this);
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
