package com.RestDemos;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class D04CheckId {
    @Test
    public void checkForId()
    {
        given()
                .get("https://reqres.in/api/users/2")
                .then().body("data.id",equalTo(2)) // expected response
                .log().all();

        given()
                .get("https://reqres.in/api/users/2")
                .then().body("data.email",equalTo("janet.weaver@reqres.in"))
                .log().all();

        given()
                .get("https://reqres.in/api/users/2")
                .then().body("data.first_name",equalTo("Janet"))
                .log().all();

        given()
                .get("https://reqres.in/api/users/2")
                .then().body("data.last_name",equalTo("Weaver"))
                .log().all();

        given()
                .get("https://reqres.in/api/users/2")
                .then().body("support.url",equalTo("https://reqres.in/#support-heading"))
                .log().all();
    }
}
