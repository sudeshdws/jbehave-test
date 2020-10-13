 Meta: User Aadhar Service
       Addhar service provides the user to enroll into aadhar service and get aadhar id . With aadhar id user can perform
       update,search and modify user information

 Narrative:
        As a user
        I want to search user information using aadhar-id using retrieve aadhar service api

Scenario: Get user aadhar information
Given Use the generated aadhar Id to search user
When Call the get service api and search the user
Then User information should be retrieve with status code 200