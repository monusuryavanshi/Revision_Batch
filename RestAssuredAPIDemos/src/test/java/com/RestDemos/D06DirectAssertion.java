package com.RestDemos;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class D06DirectAssertion {
    @Test
    public void getList()
    {
        given()
                .get("https://reqres.in/api/users?page=2")
                .then().assertThat().statusCode(200)
                .log().all();
    }
}
