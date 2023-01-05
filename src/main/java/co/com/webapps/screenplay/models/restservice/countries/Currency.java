package co.com.webapps.screenplay.models.restservice.countries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Currency{

    public String code;
    public String name;
    public String symbol;
}
