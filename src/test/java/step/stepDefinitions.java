package step;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class stepDefinitions {

    private RequestSpecification request;
    private ValidatableResponse json;
    private Response response;

    @Before
    public void before() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Given("a pet with name {string} and status {string}")
    public void aNameAndStatus(String name, String status) {
        String petJson = String.format("{\"name\": \"%s\", \"status\": \"%s\"}", name, status);
        request = given()
                .header("Content-Type", "application/json")
                .body(petJson);
    }

    @When("it is decided to add in the system")
    public void itIsDecidedToAddInTheSystem() {
        response = request.post("/pet");
    }

    @Then("the status code is {int}")
    public void theStatusCodeIs(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Given("a status {string}")
    public void aStatus(String status) {
        request = given()
                .queryParam("status", status);
    }

    @When("i try to find a pet")
    public void iTryToFindApet() {
        response = request.get("/pet/findByStatus");
    }


    @Given("an id {string} and a new name {string}")
    public void anIdAndNewName(String id, String name) {
        String petJson = String.format("{\"id\": \"%s\", \"name\": \"%s\"}", id, name);
        request = given()
                .header("Content-Type", "application/json")
                .body(petJson);
    }

    @When("i try update the pet")
    public void iTryToUpdateAPet() {
        response = request.put("/pet");
    }

    @Given("an id {string}")
    public void anId(String id) {
        request = given();
    }

    @When("i try to find a pet by id {string}")
    public void iTryToFindAPetById(String id) {
        response = request.get("/pet/" + id);
    }

    @When("i try to delete a pet by {string}")
    public void iTryToDeleteAPetById(String id) {
        response = request.get("/pet/" + id);
    }


}
