package rest;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import org.junit.Test;

import entities.EventCauseID;

/**
 * Created by david on 09/04/2017.
 */
public class DATAControllerTest extends DATAControllerSetUp {

	// USER STORY #4
	@Test
	public void validEventCausePerIMSI() {
		long testIMSI = 191911000336527L;
		given().when().get("event_cause_per_imsi/" + testIMSI).then().statusCode(200);
	}

	@Test
	public void exactEventCausePerIMSI() {
		long testIMSI = 191911000336527L;
		EventCauseID ec = new EventCauseID(1, 4098);
		given().when().get("event_cause_per_imsi/" + testIMSI).then().statusCode(200).assertThat()
				.body("eventCauseID.eventID", hasItem(ec.getEventID()))
				.body("eventCauseID.causeCode", hasItem(ec.getCauseCode()));
	}

	// USER STORY #5
	@Test
	public void validSpecificFailurePerPeriod() {
		long testIMSI = 191911000336527L;
		String startDate = "2013-01-01";
		String endDate = "2013-31-12";
		given().when().get("specific_failure_per_period/" + startDate + "/" + endDate + "/" + testIMSI).then()
				.statusCode(200);
	}

	// USER STORY #6
	@Test
	public void validFailureEventsPerIMSIAndCauseCode() {
		long testIMSI = 6384L;
		given().when().get("event_cause/by_imsi/" + testIMSI).then().statusCode(200);
	}

	// USER STORY #7
	@Test
	public void validIMSIPerPeriod() {
		String startDate = "2013-01-01";
		String endDate = "2013-31-12";
		given().when().get("imsi_per_period/" + startDate + "/" + endDate).then().statusCode(200);
	}

	// User Story #8
	@Test
	public void validFailureCountPerModel() {
		String startDate = "2013-01-01";
		String endDate = "2013-31-12";
		String phoneModel = "VEA3";
		given().when().get("count_per_phone_model/" + startDate + "/" + endDate + "/" + phoneModel).then()
				.statusCode(200);
	}

	// User Story #9
	@Test
	public void validCallDataPerPeriod() {
		String startDate = "2013-01-01";
		String endDate = "2013-31-12";
		given().when().get("call_data_per_period/" + startDate + "/" + endDate).then().statusCode(200);
	}

	// User Story #10
	@Test
	public void validFailureEventAndCauseCodeByUEType() {
		String ueType = "VEA3";
		given().when().get("event_cause/by_ue_type/" + ueType).then().statusCode(200);
	}

	// User Story #11
	@Test
	public void validTopTenCallFailurePerPeriod() {
		String startDate = "2013-01-01";
		String endDate = "2013-31-12";
		given().when().get("top_ten_per_period/" + startDate + "/" + endDate).then().statusCode(200);
	}

	// User Story #14
	@Test
	public void validIMSIPerFailureClass() {
		Integer failureClass = 2;
		given().when().get("failure_class/get_imsis/" + failureClass).then().statusCode(200);
	}

}
