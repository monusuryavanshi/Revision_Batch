package com.RestDemos;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class D03ReadSingleUser {
    @Test
    public void readData()
    {
        given()
                .get("https://reqres.in/api/users/2")
                .then().statusCode(200); // expected status code
        Assert.assertEquals(200,200);
        System.out.println("Status code is matching.");
    }

    @Test
    public void readData2()
    {
        given()
                .get("https://reqres.in/api/users/2")
                .then().statusCode(200).log().all();
    }

}
