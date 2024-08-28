package RSA_RestDemos;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import files.payLoad; // importing for Payload body
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import files.ReusableMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class D01Basics {
    public static void main(String[] args) throws IOException {

        // validate if add place api is working correctly

        // given : all inputs
        // when : submit the API --> resource and http methods will be included here
        // then : validate the response
        // content of the file to String --> read content of file and convert into byte in java --> convert byte data to String

        // need to set base url first
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all().queryParam("key","qaclick123")
                .header("Content-Type", "application/json")
                .body(new String(Files.readAllBytes(Paths.get("E:\\StudyMaterial\\Udemy_APIAutomation\\addPlace.json")))) // called payLoad from external file ".json"

                //.body(payLoad.AddPlace()) // called payLoad class file from files package to add body here
                .when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200) //.log().all. is removed as need to store in variable and print it
                .body("scope", equalTo("APP")) //validation from body to scope option
                .header("Server","Apache/2.4.52 (Ubuntu)") // when use .header before when it is "input" and same after then() it is validation
                .extract().response().asString();//extract all response in string format and store it in a variable named "response"

        System.out.println(response);

        // to extract data in JSON format from output as a string we need to create object of JsonPath class
        JsonPath js = new JsonPath(response);// this class takes string and converts to json and parson as json
        String place_id = js.getString("place_id");
        System.out.println(place_id);
        System.out.println("");


        // update place now using different given()
        String newAddress = "29, side layout, Australia 29";
        System.out.println(newAddress);
        given().log().all()
                .queryParam("key","qaclick123")
                .queryParam("place_id", place_id)
                .header("Content-Type", "application/json")

                .body("{\n" +
                        "\"place_id\":\""+place_id+"\",\n" +
                        "\"address\":\""+newAddress+",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")

                .when().put("maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200);
                //.body("msg", equalTo("Address successfully updated"));
        System.out.println("");

        // verify using GET api
        String getPlaceResponse = given().log().all()
                .queryParam("key","qaclick123") // not need to specify to give but we need to give place_id here
                .queryParam("place_id", place_id)

                .when().get("/maps/api/place/get/json")

                .then().assertThat().log().all().statusCode(200)
                .extract().response().asString();


        JsonPath js1 = new JsonPath(getPlaceResponse);
        //JsonPath js1 = ReusableMethods.rawToJson(getPlaceResponse); // call reusable class's method passing string and returning jsonpath object
        String actualAddress = js1.getString("address");

        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress,newAddress);

        // update not working check it




    }

    //Add place -> update place with new address -> get place to validate if new address is present or not
    // add place use POST, update use PUT, use GET to validate added/updated new address
    // thus now after adding place id need to store it in some variable that can be used to retrieve in GET and also in PUT to update


}
