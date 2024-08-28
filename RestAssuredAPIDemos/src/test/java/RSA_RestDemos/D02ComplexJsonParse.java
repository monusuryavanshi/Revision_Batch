package RSA_RestDemos;

import io.restassured.path.json.JsonPath;
import files.payLoad;
import org.testng.Assert;

public class D02ComplexJsonParse {
    public static void main(String[] args) {

        JsonPath js = new JsonPath(payLoad.CoursePrice());

        //1. Print No of courses returned by API
        int count = js.getInt("courses.size()");
        System.out.println(count);

        //2.Print Purchase Amount
        int pAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(pAmount);

        //3. Print Title of the first course
        System.out.println(js.get("courses[0].title").toString()); // get() method by default string
        //String cFTitle;
        //System.out.println(cFTitle);

        //4. Print All course titles and their respective Prices
        for (int i = 0 ; i < count ; i++)
        {
            String s = js.get("courses["+i+"].title");
            int p = js.getInt("courses["+i+"].price");
            System.out.println(s +" : "+ p);
        }

        //5. Print no of copies sold by RPA Course
        for (int i = 0 ; i < count ; i ++)
        {
            String sTitle = js.get("courses["+i+"].title");
            if (sTitle.equalsIgnoreCase("RPA"))
            {
                int ccopies = js.getInt("courses["+i+"].copies");
                System.out.println("Number of copies of RPA = "+ccopies);
                break;
            }
        }

        //6. Verify if Sum of all Course prices matches with Purchase Amount
        System.out.println(pAmount);
        int sumP = 0;
        for (int i = 0 ; i < count ; i++)
        {
            int p = js.getInt("courses["+i+"].price");
            int c = js.getInt("courses["+i+"].copies");
            int amount = p * c ;
            System.out.println(amount);
            sumP = sumP + amount;
        }
        System.out.println(sumP);
        Assert.assertEquals(sumP,pAmount);
    }
}
