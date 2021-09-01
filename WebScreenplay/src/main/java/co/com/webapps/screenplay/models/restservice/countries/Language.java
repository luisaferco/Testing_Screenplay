package co.com.webapps.screenplay.models.restservice.countries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language{
    public String iso639_1;
    public String iso639_2;
    public String name;
    public String nativeName;
}
