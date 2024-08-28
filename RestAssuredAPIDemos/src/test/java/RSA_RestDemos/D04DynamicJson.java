package RSA_RestDemos;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import files.ReusableMethods;
import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class D04DynamicJson {
    @Test (dataProvider = "BooksData" , enabled = false) // provide data provider name to use created data set
    public void addBook(String isbn1, String aisle1) // pass arguments of array elements to pass value through data provider
    {
       RestAssured.baseURI = "http://216.10.245.166";
       String response = given()
               .log().all()
               .header("Content-Type","application/json")
               .body(payLoad.addBook(isbn1,aisle1)) // passing arguments here
               .when().post("/Library/Addbook.php")
               .then()
               .assertThat().statusCode(200)
               .extract().response().asString();
       JsonPath js = ReusableMethods.rawToJson(response);
       System.out.println(response);
       String id = js.get("ID");
       System.out.println(id);
    }

    @Test (priority = 0)
    public void deleteBook()
    {
        // Delete Book
        RestAssured.baseURI = "http://216.10.245.166";
        String responseD = given()
                .log().all()
                .header("Content-Type","application/json")
                .body(payLoad.addBook("efghi","22")) // passing arguments here
                .when().delete("/Library/DeleteBook.php")
                .then()
                .assertThat().statusCode(200)
                //.body("msg", equalTo("book is successfully deleted"))
                .extract().response().asString();
        System.out.println(responseD);
    }

    @DataProvider (name="BooksData") // designing data set to pass as parameter to above test function, using Data Provider
    public Object[][] getData()
    {
        //return new Object[][] {{"bbbb","1133"},{"cccc","1144"},{"dddd","1155"}};
        return new Object[][] {{"eeee","1166"},{"ffff","1177"}};
    }
}
