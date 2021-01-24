Feature: API Test for PUT
  API Test for PUT Endpoint

 @put
  Scenario: Verify PUT operation after POST
    Given PUT operation for "/users/3"
       | id | first_name              | last_name         |
       | 3  | Sachin                  | Tendulkar |