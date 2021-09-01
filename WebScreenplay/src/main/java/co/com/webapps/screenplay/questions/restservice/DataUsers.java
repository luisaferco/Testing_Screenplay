package co.com.webapps.screenplay.questions.restservice;

import co.com.webapps.screenplay.models.restservice.users.DataUser;
import co.com.webapps.screenplay.utils.restservice.PrintData;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.util.Arrays;
import java.util.List;

import static co.com.webapps.screenplay.utils.PathManager.FILE_RESPONSE_DATA_REST;

@Subject("See response service data users list")
public class DataUsers implements Question< List<DataUser>> {


    @Override
    public  List<DataUser> answeredBy(Actor actor) {

        actor.attemptsTo(RememberThat.theValueOf("Response").isAnsweredBy(LastResponse.received()));
        Response response = actor.recall("Response");
        List<DataUser> requestService = Arrays.asList(response.as(DataUser[].class));
        Serenity.recordReportData().withTitle("Response of service").andContents(requestService.toString());
        PrintData.setUserstoTxt(FILE_RESPONSE_DATA_REST).theData(requestService);
        return requestService;
    }


}
