package co.com.webapps.screenplay.models.restservice.countries;

import co.com.webapps.screenplay.models.Builder;

public class DataCountryBuilder implements Builder<DataCountries> {

    private String name;
    private String capital;
    private String region;

    public DataCountryBuilder(DataCountries dataCountries){
        this.name = dataCountries.getName();
        this.capital = dataCountries.getCapital();
        this.region = dataCountries.getRegion();
    }

    public static DataCountryBuilder reduce(DataCountries dataCountries){
        return new DataCountryBuilder(dataCountries);
    }


    @Override
    public DataCountries build() {
        return new DataCountries(this);
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }
}
