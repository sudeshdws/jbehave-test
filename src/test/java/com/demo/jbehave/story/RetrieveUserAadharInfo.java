package com.demo.jbehave.story;

import com.demo.jbehave.config.Utility;
import io.restassured.response.Response;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

public class RetrieveUserAadharInfo extends Steps {

    private String url = "";
    private Utility util = Utility.getInstance();
    private Response response;

    @Given("Use the generated aadhar Id to search user")
    public void getTheUserIdAndUrl() {
//        url = util.getUrl("get.aadhar.information.url").
//                concat(util.getAadharId("test.aadhar-id"));

    }

    @When("Call the get service api and search the user")
    public void callTheGetUserAddharApi(int code) {
//        RestAssured.baseURI = util.getUrl("get.aadhar.information.url").
//                concat(util.getAadharId("test.aadhar-id"));
//        RequestSpecification request = RestAssured.given();
//        request.header(Utility.getContentType(), Utility.getApplicationJson());
//        response = request.get();
    }

    @Then("User information should be retrieve with status code 200")
    public void thencheckResponse(int code) {
//        Assert.assertEquals(code, response.getStatusCode());
    }

}
