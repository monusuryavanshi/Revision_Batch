package RSA_RestDemos.POJO;

import io.restassured.RestAssured;

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

        String response =
        given().queryParam("key", "qaclick123")
               .body()
               .when()
               .post("maps/api/place/add/json")
               .then().assertThat().statusCode(200).extract().response();
    }
}
