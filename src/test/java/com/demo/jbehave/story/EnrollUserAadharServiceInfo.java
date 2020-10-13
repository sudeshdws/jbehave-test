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


public class EnrollUserAadharServiceInfo extends Steps {

    private User user = new User();
    private Response response;
    private Utility util = Utility.getInstance();

    @Given("given user information $user")
    public void userInformation(UserInfo userInfo) {
        user.setFirstName(userInfo.getFirstName());
        user.setContactNumber(userInfo.getContactNumber());
        user.setDateOfBirth(userInfo.getDateOfBirth());
        user.setLastName(userInfo.getLastName());
        user.setAddress(userInfo.getAddress());
        user.setCity(userInfo.getCity());
    }

    @When("call enroll service to generate aadhar id")
    public void callEnrollAadharService() {
        System.out.println("URL :"+util.getUrl("enroll.aadhar.information.url"));
        RestAssured.baseURI = util.getUrl("enroll.aadhar.information.url");
        RequestSpecification request = RestAssured.given();
        JSONObject requestParam = new JSONObject();
        requestParam.put(Utility.getFirstName(), user.getFirstName());
        requestParam.put(Utility.getLastName(), user.getLastName());
        requestParam.put(Utility.getCity(), user.getCity());
        requestParam.put(Utility.getDateOfBirth(), user.getDateOfBirth());
        requestParam.put(Utility.getContactNumber(), user.getContactNumber());
        requestParam.put(Utility.getAddress(), user.getAddress());
        request.header(Utility.getContentType(), Utility.getApplicationJson());
        request.body(requestParam.toString());
        response = request.post();
    }

    @Then("aadhar id is generated with status code $code")
    public void getAddharId(int code) {
        System.out.println(response.getBody().print());
        Assert.assertEquals(code, response.getStatusCode());
    }


}
