 Meta: User Aadhar Service
       Addhar service provides the user to enroll into aadhar service and get aadhar id . With aadhar id user can update ,
       delete ,search and modify user information

 Narrative:
        As a user
        I want to enroll user into aadhar system and gerate the aadhar Id
        After I want to delete user based on aadhar Id
        So that user inforamtion can be deleted from aadhar system


Scenario: Enroll user to aadhar system and generate aadhar Id
Given Given user information
|firstName |lastName  |dateOfBirth|contactNumber|address                          |city      |
|Johny      |Doey     |2012-07-11 |23222326     |34 Windsore shore ,South Carlonia|Blythewoodh|
When Call enroll service to register user and generate aadhar Id
Then Aadhar id is generated with status code 201



Scenario: Delete user aadhar information
Given Use the generated aadhar Id to delete user
When Call the delete service api and delete the user
Then User information should be delete from system and should return status code 204
