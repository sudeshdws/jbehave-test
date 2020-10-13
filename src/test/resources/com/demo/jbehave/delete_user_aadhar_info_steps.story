 Meta: User Aadhar Service
       Addhar service provides the user to enroll into aadhar service and get aadhar id . With aadhar id user can update ,
       search and modify user information

 Narrative:
        As a user
        I want to delte user aadhar information  using aadhar-id service api
        So that the user information can delete information into system


Scenario: Delete user aadhar information
Given Given user aadhar Id 410549274260
When Call the delete service api
Then User information should be delete from system and should return status code 204

