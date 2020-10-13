package com.demo.jbehave.story;

import com.demo.jbehave.config.Utility;
import com.demo.jbehave.model.User;
import com.demo.jbehave.model.UserInfo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.json.JSONObject;
import org.junit.Assert;

public class EnrollAndRetrieveUserAadharInfo extends Steps {

    private String adharId = ""  ;
    private String getAdharURL = "";
    private String enrollAdharURL = "";
    private Response response;
    private JsonPath jp;
    private Utility util = Utility.getInstance();
    private User user  = new User();

    @Given("Given user information $userInfo")
    public void givenUserInformation(UserInfo userInfo){
        getAdharURL = util.getUrl("get.aadhar.information.url");
        enrollAdharURL = util.getUrl("enroll.aadhar.information.url");
        user.setFirstName(userInfo.getFirstName());
        user.setContactNumber(userInfo.getContactNumber());
        user.setDateOfBirth(userInfo.getDateOfBirth());
        user.setLastName(userInfo.getLastName());
        user.setAddress(userInfo.getAddress());
        user.setCity(userInfo.getCity());
    }

    @When("Call enroll service to register user and generate aadhar Id")
    public void enrollServiceToRegisterUser(){
        RestAssured.baseURI = enrollAdharURL;
        RequestSpecification request = RestAssured.given();
        JSONObject requestParam = new JSONObject();
        requestParam.put(Utility.getFirstName(),user.getFirstName());
        requestParam.put(Utility.getLastName(),user.getLastName());
        requestParam.put(Utility.getCity(),user.getCity());
        requestParam.put(Utility.getDateOfBirth(),user.getDateOfBirth());
        requestParam.put(Utility.getContactNumber(),user.getContactNumber());
        requestParam.put(Utility.getAddress(),user.getAddress());
        request.header(Utility.getContentType(),Utility.getApplicationJson());
        request.body(requestParam.toString());

        response = request.post();
        jp = new JsonPath(response.asString());
    }

    @Then("Aadhar id is generated with status code $code")
    public void checkAadharIdIsGenerated(int code){
        Assert.assertEquals(code,response.getStatusCode());
        Assert.assertEquals("John",jp.getString(Utility.getFirstName()));

    }


    @Given("Use the generated aadhar Id to search user")
    public void useGeneratedAdharId(){
        adharId =  jp.getString("id");
    }

    @When("Call the get service api and search the user")
    public void callGetServiceToSearchUserAdharInfo(){
        RestAssured.baseURI = getAdharURL.concat(adharId);
        RequestSpecification request = RestAssured.given();
        request.header(Utility.getContentType(),Utility.getApplicationJson());
        response = request.get();

    }


    @Then("User information should be retrieve with status code 200")
    public void getUsetInformationFromAadharId(int code ){
        Assert.assertEquals(code,response.getStatusCode());
    }



}
