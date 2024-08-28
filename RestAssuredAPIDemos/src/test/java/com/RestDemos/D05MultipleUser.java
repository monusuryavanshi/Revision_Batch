package com.RestDemos;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class D05MultipleUser {

    @Test
    public void getAll()
    {
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .body("data.id[1]",equalTo(8))
                .body("data.first_name[1]",equalTo("Lindsay"))
                .log().all();
    }
}
