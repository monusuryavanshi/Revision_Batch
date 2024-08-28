package RSA_RestDemos;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.File;

import static io.restassured.RestAssured.*;

public class D05BugTestJira {
    public static void main(String[] args) {
        RestAssured.baseURI="https://monuu315.atlassian.net/";
        String createIssueResponse =
        given()
                .header("Content-Type","application/json")
                .header("Authorization","Basic bW9udXUzMS41QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjA4QV9PS2hXNGR5Y1ZEb05sbGowOU5iT0p0MjR5U285ZnFfZnVfaHRkSWpUSkt5bXFlTV9WMnF6ZEJyRnpyUjJhdnhuMmRaZEFzZFVqd2M3bzFUWXR0eDR1djBleXY5NS02d2tfN3FiMEJQSWxPbjVfMVo4S2ZXSUdNdmxUbV85WjY3ZkRRd1BvM0FLb2NhUm1PTlRidXBlS2JTU0VLSTByaTJzM0Q3QklCSTg9MkYzOEJDMDU=")
                .body("{\n" +
                        "    \"fields\": {\n" +
                        "       \"project\":\n" +
                        "       {\n" +
                        "          \"key\": \"SCRUM\"\n" +
                        "       },\n" +
                        "       \"summary\": \"Tags are not working - REST Assured API Automation\",\n" +
                        "       \"issuetype\": {\n" +
                        "          \"name\": \"Bug\"\n" +
                        "       }\n" +
                        "   }\n" +
                        "}")
                .log().all()
                .post("rest/api/3/issue")
                .then().log().all()
                .assertThat().statusCode(201)
                .extract().response().asString();

        JsonPath js = new JsonPath(createIssueResponse);
        String issueId = js.get("id");
        System.out.println(issueId);

        // add attachment
        String attachment =
        given()
                .pathParam("key",issueId)
                .header("X-Atlassian-Token","no-check")
                .header("Authorization","Basic bW9udXUzMS41QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjA4QV9PS2hXNGR5Y1ZEb05sbGowOU5iT0p0MjR5U285ZnFfZnVfaHRkSWpUSkt5bXFlTV9WMnF6ZEJyRnpyUjJhdnhuMmRaZEFzZFVqd2M3bzFUWXR0eDR1djBleXY5NS02d2tfN3FiMEJQSWxPbjVfMVo4S2ZXSUdNdmxUbV85WjY3ZkRRd1BvM0FLb2NhUm1PTlRidXBlS2JTU0VLSTByaTJzM0Q3QklCSTg9MkYzOEJDMDU=")
                .multiPart("file",new File("C:\\Users\\HP\\Desktop\\Screenshot131040.png")).log().all()
                .multiPart("file", new File("C:\\Users\\HP\\Desktop\\Novels.txt"))

                .post("rest/api/3/issue/{key}/attachments")
                .then().log().all()

                .assertThat().statusCode(200)
                .extract().response().asString();

        /*JsonPath js1 = new JsonPath(attachment);
        String attachedFileName = js1.getString("filename");
        System.out.println(attachedFileName);*/
    }
}
