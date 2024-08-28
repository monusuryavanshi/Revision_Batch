package com.RestDemos;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class D12PutDemo {
    @Test
    public void putRequest()
    {
        Map<String, String> payLoad = new HashMap<>();
        payLoad.put("name", "morpheus1");
        payLoad.put("job","zion resident");

        JSONObject data = new JSONObject(payLoad);
        given()
                .body(data.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("name", equalTo("morpheus1"))
                .log().all();
    }
}
