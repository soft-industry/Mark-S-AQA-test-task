package api.steps;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;


public class ProductSteps {
    private final static String BASE_URI = "https://waarkoop-server.herokuapp.com/api/v1/search/test/";

    @Step("user cals for endpoint")
    public void getEndpointForProduct(String product) {
        SerenityRest.given().baseUri(BASE_URI).get(product);
    }

    @Step("user gets product title")
    public void getProductTitle(String product) {
        RestAssured.baseURI = BASE_URI;
        RequestSpecification request = given();
        Response response = request.get(product);
        String jsonString = response.asString();
        ArrayList<String> products = JsonPath.from(jsonString).get("title");
        products.stream()
                .filter(x -> x.contains(product))
                .collect(Collectors.toList());
        Assert.assertTrue(products.stream().anyMatch(x -> x.contains(product)));
    }

}
