package co.com.webapps.screenplay.utils.restservice;

import co.com.webapps.screenplay.integration.ExcelFile;
import co.com.webapps.screenplay.models.restservice.countries.DataCountries;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountriesServiceFile {

    private String path;
    private List<DataCountries> dataCountries;

    public CountriesServiceFile(String path) {
        this.path = path;
    }

    public void theData(List<DataCountries> dataCountries){
        this.dataCountries = dataCountries;
        write();
    }

    private void write(){
        ExcelFile.newInstance().writeExcelMap(path,objectsToMaps());
    }

    private List objectsToMaps(){
        ObjectMapper oMapper = new ObjectMapper();
        return dataCountries.stream().map(contryobject->oMapper.convertValue(contryobject,Map.class))
                .collect(Collectors.toList());
    }


}
