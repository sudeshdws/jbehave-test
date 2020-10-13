 Meta: User Aadhar Service
       Addhar service provides the user to enroll into aadhar service and get aadhar id . With aadhar id user can update ,
       delete ,search and modify user information

 Narrative:
        As a user
        I want to enroll user into aadhar system and gerate the aadhar Id
        After I want to search user using aadhar Id
        So that I can get the user information

Scenario: Enroll user to aadhar system and generate aadhar Id
Given Given user information
|firstName |lastName  |dateOfBirth|contactNumber|address                          |city      |
|John      |Doe       |2012-07-11 |23222323     |34 Windsore shore ,South Carlonia|Blythewood|
When Call enroll service to register user and generate aadhar Id
Then Aadhar id is generated with status code 201

Scenario: Get user aadhar information
Given Use the generated aadhar Id to search user
When Call the get service api and search the user
Then User information should be retrieve with status code 200
