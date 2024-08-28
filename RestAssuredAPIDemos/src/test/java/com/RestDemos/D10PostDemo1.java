package com.RestDemos;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class D10PostDemo1 {
    @Test
    public void postMethodTest()
    {
        Map<String, Object> payLoad = new HashMap<>();
        payLoad.put("name", "mira1");
        payLoad.put("job", "leader");

        System.out.println("Map format data = " +payLoad);
        // need to convert map data to Json as post method we are using json data

        JSONObject data = new JSONObject(payLoad); // always uses map to pass as parameters

        System.out.println("JSON format data = " + data);

        given()
                .body(data.toJSONString()) // pass json formated data to body
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .assertThat()
                .statusCode(201)
                .log().all();

    }
}
