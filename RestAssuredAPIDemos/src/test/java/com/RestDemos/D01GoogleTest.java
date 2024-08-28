package com.RestDemos;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D01GoogleTest {

    @Test
    public void googleRequest()
    {
        Response res = RestAssured.get("https://www.google.com");

        int sCode = res.getStatusCode();
        System.out.println("Status is = " + sCode);

        Assert.assertEquals(sCode,200,"Status Code is not matching!!");
        System.out.println("Status Code is Matching!!");

    }


}
