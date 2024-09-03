package RSA_RestDemos.POJO;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class D13OAuthAccessTokenRequest {
    public static void main(String[] args) {

        String[] courseTitles = {"Selenium Webdriver Java", "Cypress", "Protractor"};

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

        // Query to print api course title and its price
        System.out.println("Course Title =  "+ detailsResponse.getCourses().getApi().get(1).getCourseTitle());

        // create variable of datatype as list of api class and store all api data to it
        List<D11NestedCoursesAPI> apiCourses = detailsResponse.getCourses().getApi();

        for (int i=0 ; i < apiCourses.size() ; i++)
        {
            if (apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
            {
                System.out.println("Price = " + apiCourses.get(i).getPrice());
            }

        }

        // Query to print all Web Automation course titles
        //System.out.println(detailsResponse.getCourses().getWebAutomation().get(1).getCourseTitle());

        ArrayList<String> a = new ArrayList<String>();
        List<D10NestedCoursesWebAutomation> webAutoCourses = detailsResponse.getCourses().getWebAutomation();
        for (int j = 0 ; j < webAutoCourses.size(); j++)
        {
            a.add(webAutoCourses.get(j).getCourseTitle());
            //System.out.println("Web Automation Course title =  "+ webAutoCourses.get(j).getCourseTitle());
        }
        // converted array to list type to compare data
        List<String> expectedList = Arrays.asList(courseTitles);
        Assert.assertTrue(a.equals(expectedList));


    }
}
