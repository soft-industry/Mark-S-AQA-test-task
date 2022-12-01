package api.stepdefinitions;

import api.steps.ProductSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ProductStepDefinitions {

    @Steps
    public ProductSteps productSteps;

    @When("user calls endpoint for {string} product")
    public void userCallsEndpoint(String product) {
        productSteps.getEndpointForProduct(product);
    }

    @Then("user sees the results displayed for {string}")
    public void userSeesTheResultsDisplayedForProduct(String product) {
        restAssuredThat(response -> response.statusCode(200));
        productSteps.getProductTitle(product);
    }

    @Then("user sees error message {string}")
    public void userSeesErrorMessage(String message) {
        restAssuredThat(response -> response.body("detail.message", equalTo(message)));
    }
}
