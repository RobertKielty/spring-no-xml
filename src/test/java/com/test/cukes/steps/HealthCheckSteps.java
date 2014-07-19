package com.test.cukes.steps;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class HealthCheckSteps {

    private RequestSpecification requestSpecification;
    private Response response;

    @Before
    public void setUp() throws Exception {
        requestSpecification = null;
        response = null;
    }

    @Given("^the application context is \"(.*?)\"$")
    public void getApplicationContext(String host) {
        requestSpecification = given().baseUri(host);
    }

    @When("^the user requests the endpoint \"(.*?)\"$")
    public void requestEndpoint(String endpoint) {
        response = requestSpecification.when().get(endpoint);
    }

    @Then("^the user should see the text \"(.*?)\"$")
    public void assertResult(String expectedResult) {
        response.then().statusCode(200).and().body(containsString(expectedResult));
    }
}
