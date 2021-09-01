package co.com.webapps.screenplay.questions.restservice;

import co.com.webapps.screenplay.models.restservice.countries.DataCountries;
import co.com.webapps.screenplay.models.restservice.countries.DataCountryBuilder;
import co.com.webapps.screenplay.utils.PathManager;
import co.com.webapps.screenplay.utils.restservice.PrintData;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TheCountries implements Question<List<DataCountries>> {

    @Override
    public List<DataCountries> answeredBy(Actor actor) {
        actor.attemptsTo(RememberThat.theValueOf("Response").isAnsweredBy(LastResponse.received()));
        Response response = actor.recall("Response");
        response.getBody().as(DataCountries[].class);

        List<DataCountries> requestService = Arrays.asList(response.as(DataCountries[].class));
        Serenity.recordReportData().withTitle("Response of service countries")
                .andContents(requestService.toString());
        requestService.stream().map(request-> DataCountryBuilder.reduce(request).build())
               .collect(Collectors.toList());
        PrintData.setCountriesToExcel(PathManager.FILE_RESPONSE_COUNTRIES).theData(requestService);
        return requestService;
    }
}
