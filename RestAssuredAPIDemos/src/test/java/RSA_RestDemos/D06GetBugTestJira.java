package RSA_RestDemos;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class D06GetBugTestJira {
    public static void main(String[] args) {
        RestAssured.baseURI ="https://monuu315.atlassian.net/";
        given()
                .header("Authorization","Basic bW9udXUzMS41QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjA4QV9PS2hXNGR5Y1ZEb05sbGowOU5iT0p0MjR5U285ZnFfZnVfaHRkSWpUSkt5bXFlTV9WMnF6ZEJyRnpyUjJhdnhuMmRaZEFzZFVqd2M3bzFUWXR0eDR1djBleXY5NS02d2tfN3FiMEJQSWxPbjVfMVo4S2ZXSUdNdmxUbV85WjY3ZkRRd1BvM0FLb2NhUm1PTlRidXBlS2JTU0VLSTByaTJzM0Q3QklCSTg9MkYzOEJDMDU=")
                .pathParam("key","10005")
                .when()
                .get("rest/api/3/issue/{key}")
                .then().assertThat().log().all().statusCode(200)
                .extract().response().asString();
    }
}
