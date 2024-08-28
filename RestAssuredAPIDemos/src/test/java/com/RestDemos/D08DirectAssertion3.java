package com.RestDemos;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class D08DirectAssertion3 {
    @Test
    public void getAll()
    {
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("data.id[2]",equalTo(9))
                .assertThat().body("data.first_name",hasItem("George"))
                //.log().ifError();
                .log().all();
    }
}
