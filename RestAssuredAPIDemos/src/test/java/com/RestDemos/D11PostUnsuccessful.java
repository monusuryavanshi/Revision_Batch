package com.RestDemos;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class D11PostUnsuccessful {
    @Test
    public void postUnsucessful()
    {
        Map<String, String> payLoad = new HashMap<>();
        payLoad.put("email", "monu@gmail.com");

        JSONObject data = new JSONObject(payLoad);

        System.out.println(data);

        given()
                .body(data.toJSONString())
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .assertThat().statusCode(400)
                .assertThat().body("error", equalTo("Missing email or username"))
                .log().all();

    }
}
