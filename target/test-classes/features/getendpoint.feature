Feature: API Test
  API Test for Get Endpoint

  @Get
  Scenario: Ensure GET Endpoint works as expected
    Given Call GET Endpoint for "/users"
    And I should see first name "Ashok"