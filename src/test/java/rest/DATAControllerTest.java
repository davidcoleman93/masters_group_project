package rest;

/**
 * Created by david on 28/03/2017.
 */

import com.jayway.restassured.path.json.*;
import entities.EventCauseID;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.core.IsEqual.equalTo;

public class DATAControllerTest {

    //TEST USER STORY #4
    /*@Test
    public void verifyEventCausePerIMSI () {

        given()
                .pathParam("imsi", 191911000171111L)
                .when()
                .get("/event_cause_per_imsi/{imsi}")
                .then()
                .assertThat()
                .statusCode(204);
    }*/
/*
    //TEST USER STORY #5
    @Test
    public void verifySpecificFailurePerPeriod () {
        given()
                .pathParam("imsi", 191911000171111L)
                .pathParam("startDate", "2011/01/01")
                .pathParam("endDate", "2016/01/01")
                .when()
                .get("/specific_failure_per_period/{startDate}/{endDate}/{imsi}")
                .then()
                .assertThat()
                .body();
    }*/

}