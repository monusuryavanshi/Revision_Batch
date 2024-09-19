package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apiguardian.api.API;
import pojo.D15AddPlaces;
import pojo.D16Locations;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class stepDefs extends Utils {
    ResponseSpecification resspec;
    RequestSpecification res;
    Response response1;
    TestDataBuild p = new TestDataBuild();
    static String place_id;


    @Given("Add Place Payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        res = given().spec(requestSpecification())
                .body(p.addPlacePayload(name,language,address));
    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        // Write code here that turns the phrase above into concrete actions
        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());

        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        if(method.equalsIgnoreCase("POST"))
        response1 = res.when().post(resourceAPI.getResource());
        else if(method.equalsIgnoreCase("GET"))
        response1 = res.when().get(resourceAPI.getResource());
    }

    @Then("the API call got success with status code {int}")
    public void theAPICallGotSuccessWithStatusCode(int arg0) {
        assertEquals(response1.getStatusCode(), 200);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
        // Write code here that turns the phrase above into concrete actions
       assertEquals(getJSonPath(response1,keyValue), expectedValue);
    }

    @Then("verify place_Id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
       // request Specification
        place_id = getJSonPath(response1,"place_id");
        res = given().spec(requestSpecification()).queryParam("place_id",place_id);
        user_calls_with_http_request(resource,"GET"); //used when step def function to call get request
        String actualName = getJSonPath(response1,"name"); // to fetch name from got response
        assertEquals(actualName,expectedName);
    }

    @Given("DeletePlace Payload")
    public void delete_place_payload() throws IOException {
        // Write code here that will delete place
        res = given().spec(requestSpecification()).body(p.deletePlacePayload(place_id));

    }

}


