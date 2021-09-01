package co.com.webapps.screenplay.models.restservice.countries;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DataCountries {

    public String name;
    public List<String> topLevelDomain;
    public String alpha2Code;
    public String alpha3Code;
    public List<String> callingCodes;
    public String capital;
    public List<String> altSpellings;
    public String region;
    public String subregion;
    public int population;
    public List<Object> latlng;
    public String demonym;
    public Object area;
    public Object gini;
    public List<String> timezones;
    public List<Object> borders;
    public String nativeName;
    public String numericCode;
    public List<Currency> currencies;
    public List<Language> languages;
    public Translations translations;
    public String flag;
    public List<Object> regionalBlocs;
    public String cioc;

    public DataCountries(DataCountryBuilder d){
        this.name = d.getName();
        this.capital = d.getCapital();
        this.region = d.getRegion();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataCountries {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    capital: ").append(toIndentedString(capital)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
