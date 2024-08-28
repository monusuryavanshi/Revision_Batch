package com.RestDemos;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class D07DirectAssertion2 {
    @Test
    public void getAll()
    {
        given()
                .get("https://reqres.in/api/users?page=2")
                .then().assertThat().statusCode(200)
                .assertThat().body("data.id[2]",equalTo(9))
                //.log().ifError();
                .log().all();
    }
}
