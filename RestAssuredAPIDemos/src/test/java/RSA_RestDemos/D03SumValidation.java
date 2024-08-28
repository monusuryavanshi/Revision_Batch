package RSA_RestDemos;

import files.payLoad;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D03SumValidation {

    @Test
    public void sumOfCourses()
    {
        //6. Verify if Sum of all Course prices matches with Purchase Amount
        int sum = 0 ;
        JsonPath js = new JsonPath(payLoad.CoursePrice());
        int count = js.getInt("courses.size()");
        for (int i = 0 ; i < count ; i ++)
        {
           int prices = js.getInt("courses["+i+"].price");
           int copies = js.getInt("courses["+i+"].copies");
           int amount = prices * copies ;
           sum = sum + amount ;
           System.out.println(amount);
        }
        System.out.println(sum);
        int pAmount = js.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(sum , pAmount);
    }
}
