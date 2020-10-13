package com.demo.jbehave.story;

import com.demo.jbehave.config.Utility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;

public class DeleteUserAadharInfo extends Steps {


    private String id = "";
    private Response response;
    private Utility util = Utility.getInstance();


    @Given("Given user aadhar Id $aadharId")
    public void givenAadharId(String aadharId) {

        id = aadharId;
    }

    @When("Call the delete service api")
    public void callTheDeleteServiceURL() {
        RestAssured.baseURI = util.getUrl("delete.aadhar.information.url").concat(id).trim();
        RequestSpecification request = RestAssured.given();
        request.header(Utility.getContentType(), Utility.getApplicationJson());
        response = request.delete();

    }

    @Then("User information should be delete from system and should return status code $code")
    public void validateDeleteCode(int code) {
        Assert.assertEquals(code, response.getStatusCode());
    }


}