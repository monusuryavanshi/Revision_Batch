package com.RestDemos;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D02GetListUsers {
    @Test
    public void getListOfUsers()
    {
        Response res = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Status Code = " + res.getStatusCode());
        System.out.println("Session Id = " + res.getSessionId());
        System.out.println("Status Line = " + res.getStatusLine());
        System.out.println("Time in ms = " + res.getTime());
        System.out.println("Body = " + res.getBody().asPrettyString());

        Assert.assertEquals(res.getStatusCode(),200);
    }
}
