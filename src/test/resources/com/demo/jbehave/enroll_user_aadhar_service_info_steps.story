Narrative:
In order to learn JBehave
As a tester
I want to define sample story for enroll user aadhar information

Scenario: User Enrollment To Aadhar
Given given user information
|firstName |lastName  |dateOfBirth|contactNumber|address                          |city      |
|Sudesh    |Maheshwari|2020-07-11 |23222323     |34 Windsore shore ,South Carlonia|Blythewood|
When call enroll service to generate aadhar id
Then aadhar id is generated with status code 201