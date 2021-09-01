package co.com.webapps.screenplay.models.smart;

public class DataBilling {

    private String firstName;
    private String lastName;
    private String id;
    private String email;
    private String city;
    private String address;

    public DataBilling(DataBillingBuilder dataBillingBuilder) {
        this.firstName = dataBillingBuilder.getFirsName();
        this.lastName = dataBillingBuilder.getLastName();
        this.id = dataBillingBuilder.getId();
        this.email = dataBillingBuilder.getEmail();
        this.city = dataBillingBuilder.getCity();
        this.address = dataBillingBuilder.getAddress();
    }

    public String getFirstName() {
        return firstName;
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
