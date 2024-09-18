package RSA_RestDemos.Ecom;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

// End to End flow for Login > Create Product > Create Order > View Order > Delete Product > Delete Order of RahulShettyAcademy.com ecom site

public class D18ECommerceTestAPI {
    public static void main(String[] args) {

        // *** login
        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .setContentType(ContentType.JSON).build();
        LoginRequest_POJOClass loginReq = new LoginRequest_POJOClass();
        loginReq.setUserEmail("postman@gmail.com");
        loginReq.setUserPassword("Hello123@");
        RequestSpecification reqLogin =  given().log().all().spec(req).body(loginReq);
        LoginResponse_POJO loginResponse =  reqLogin.when().post("/api/ecom/auth/login")
                .then().log().all().extract().response().as(LoginResponse_POJO.class);
        System.out.println(loginResponse.getToken());
        String token = loginResponse.getToken();
        System.out.println(loginResponse.getUserId());
        String userId = loginResponse.getUserId();


        // *** Add product
        RequestSpecification addProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("authorization",token)
                .build();
        RequestSpecification reqAddProduct =  given().log().all().spec(addProductBaseReq)
                .param("productName","Laptop")
                .param("productAddedBy",userId)
                .param("productCategory","fashion")
                .param("productSubCategory","shirts")
                .param("productPrice","11500")
                .param("productDescription","Addias Originals")
                .param("productFor","women")
                .multiPart("productImage", new File("C://Users//HP/Desktop//Pin3.jpg"));
        String addProductResponse =  reqAddProduct.when().post("/api/ecom/product/add-product")
                .then().log().all().extract().response().asString();
        JsonPath js = new JsonPath(addProductResponse);
        String productId = js.get("productId");


        // *** Create Order for added product
        RequestSpecification createOrderBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("authorization",token)
                .setContentType(ContentType.JSON) // as we are sending json payload for order creation
                .build();
        //use Pojo class objects of orders and details
        OrderDetails_POJO orderDetails = new OrderDetails_POJO();
        orderDetails.setCountry("India");
        orderDetails.setProductOrderedId(productId);
        //create list of orderdetails object
        List<OrderDetails_POJO> orderDetailsList = new ArrayList<OrderDetails_POJO>();
        orderDetailsList.add(orderDetails);
        //pass order details list to orders setter method as it accepts only list
        Order_POJO orders = new Order_POJO();
        orders.setOrders(orderDetailsList);
        RequestSpecification createOrderReq = given().log().all().spec(createOrderBaseReq).body(orders); // passing orders object
        /*String responseAddedOrder = createOrderReq.when().post("/api/ecom/order/create-order")
                .then().log().all().extract().response().asString();
        System.out.println(responseAddedOrder);*/
        Ordered_Details_POJO responseAddedOrder = createOrderReq.when().post("/api/ecom/order/create-order")
                .then().log().all().extract().response().as(Ordered_Details_POJO.class);
        System.out.println(responseAddedOrder);
        System.out.println(responseAddedOrder.getOrders().get(0));


        // *** Get Ordered Details
        RequestSpecification req1 = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("authorization",token)
                .build();
        RequestSpecification getQueryReq = given().log().all().spec(req1).queryParam("id", responseAddedOrder.getOrders().get(0));
        getQueryReq.when().get("/api/ecom/order/get-orders-details")
                .then().assertThat().log().all().statusCode(200)
                .extract().response().asString();


        // *** Delete Product
        RequestSpecification req2 = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("authorization",token)
                .setContentType(ContentType.JSON)
                .build();
        RequestSpecification deleteQueryReq = given().log().all().spec(req2).pathParam("productId", productId);
        String delProd = deleteQueryReq.when().delete("/api/ecom/product/delete-product/{productId}")
                .then().log().all().extract().response().asString();
        JsonPath js1 = new JsonPath(delProd);
        Assert.assertEquals("Product Deleted Successfully",js1.getString("message"));


        // *** Delete Order
        RequestSpecification req3 =  new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("authorization",token)
                .setContentType(ContentType.JSON)
                .build();
        RequestSpecification deleteOrderQueryReq = given().log().all().spec(req3).pathParam("id",responseAddedOrder.getOrders().get(0));
        String delOrder = deleteOrderQueryReq.when().delete("/api/ecom/order/delete-order/{id}")
                .then().log().all().extract().response().asString();
        JsonPath js2 = new JsonPath(delOrder);
        Assert.assertEquals("Orders Deleted Successfully",js2.getString("message"));

    }
}
