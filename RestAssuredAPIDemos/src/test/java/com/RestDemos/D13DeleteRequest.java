package com.RestDemos;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class D13DeleteRequest {
    @Test
    public void deleteRequest()
    {
        given()
                .delete("https://reqres.in/api/users/2")
                .then()
                .assertThat().statusCode(204)
                .log().all();
    }
}
