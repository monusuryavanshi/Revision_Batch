package RSA_RestDemos.POJO;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class D17SpecBuilderTest {

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


     // using Response Spec Builder method
      ResponseSpecification resspec = new ResponseSpecBuilder()
              .expectStatusCode(200)
              .expectContentType(ContentType.JSON)
              .build();

     // using Request Spec Builder method
     RequestSpecification req = new RequestSpecBuilder()
               .setBaseUri("https://rahulshettyacademy.com")
               .addQueryParam("key","qaclick123")
               .setContentType(ContentType.JSON)
               .build();


     RequestSpecification res = given().spec(req).body(p);

     Response response1 = res.when().post("maps/api/place/add/json")
               .then().spec(resspec).extract().response();

     String responseString = response1.asString();
     System.out.println(responseString);
    }
}
