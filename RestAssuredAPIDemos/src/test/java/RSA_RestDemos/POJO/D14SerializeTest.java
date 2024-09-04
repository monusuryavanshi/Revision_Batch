package RSA_RestDemos.POJO;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class D14SerializeTest {

    public static void main(String[] args) {

       RestAssured.baseURI = "https://rahulshettyacademy.com";

       // create object of pojo class addplace
        D15AddPlaces p = new D15AddPlaces();

        p.setAccuracy(50);
        p.setAddress("29, side layout, cohen 09");
        p.setLanguage("French-IN");
        p.setName("Frontline house");
        p.setPhone_number("(+91) 983 893 3937");
        p.setWebsite("http://google.com");

        //setting data through list
        List<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");
        p.setTypes(myList);

        // setting data through class's object
        D16Locations l = new D16Locations();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);

        Response res =
        given().log().all()
                .queryParam("key", "qaclick123")
               .body(p) // passing object of pojo class to pass json body
               .when()
               .post("maps/api/place/add/json")
               .then().assertThat().statusCode(200).extract().response();

        String responseString = res.asString();
        System.out.println(responseString);
    }
}
