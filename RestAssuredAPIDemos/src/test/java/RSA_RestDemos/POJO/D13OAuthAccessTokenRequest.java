package RSA_RestDemos.POJO;

import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

public class D13OAuthAccessTokenRequest {
    public static void main(String[] args) {

        String response = given()
                .formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .formParams("grant_type","client_credentials")
                .formParams("scope","trust")
                .when().log().all()
                .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
                .asString();

        System.out.println(response);

        JsonPath js = new JsonPath(response);
        String aToken = js.getString("access_token");
        System.out.println(aToken);


        // make get request using above access token and get all details

        D08GetCourse detailsResponse = given()
                .queryParams("access_token",aToken)
                .when().log().all()
                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
                        .as(D08GetCourse.class);

        System.out.println(detailsResponse.getLinkedIn());
        System.out.println(detailsResponse.getInstructor());



    }
}
