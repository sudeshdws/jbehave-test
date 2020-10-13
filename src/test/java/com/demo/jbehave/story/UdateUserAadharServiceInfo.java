package com.demo.jbehave.story;

import com.demo.jbehave.config.Utility;
import com.demo.jbehave.model.User;
import com.demo.jbehave.model.UserInfo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.IOException;


public class UdateUserAadharServiceInfo extends Steps {

    private User user  = new User();
    private Response response ;
    private Utility util = Utility.getInstance();

    @Given("given user information to update $record")
    public void givenUserInformation(UserInfo record) {
        user.setId(record.getId());
        user.setFirstName(record.getFirstName());
        user.setContactNumber(record.getContactNumber());
        user.setDateOfBirth(record.getDateOfBirth());
        user.setLastName(record.getLastName());
        user.setAddress(record.getAddress());
        user.setCity(record.getCity());
    }

    @When("call update aadhar service to update user information")
    public void callAdharServiceToUpdateUserinfo() throws IOException {

        RestAssured.baseURI = util.getUrl("update.aadhar.information.url");
        RequestSpecification request = RestAssured.given();
        JSONObject requestParam = new JSONObject();

        requestParam.put(Utility.getId(),user.getId());
        requestParam.put(Utility.getFirstName(),user.getFirstName());
        requestParam.put(Utility.getLastName(),user.getLastName());
        requestParam.put(Utility.getCity(),user.getCity());
        requestParam.put(Utility.getDateOfBirth(),user.getDateOfBirth());
        requestParam.put(Utility.getContactNumber(),user.getContactNumber());
        requestParam.put(Utility.getAddress(),user.getAddress());
        request.header(Utility.getContentType(),Utility.getApplicationJson());
        request.body(requestParam.toString());

        response = request.put();
    }

    @Then("user inforamation is succesfully updated with status code $code")
    public void recordGetUpdated(int code){
        Assert.assertEquals(code,response.getStatusCode());
    }


}
