Feature: HealthCheck
  As a user,
  I want to request an endpoint
  So that I can check the application is up

  Scenario: simple healthcheck endpoint
    Given the application context is "http://localhost:8181"
    When the user requests the endpoint "/health-check"
    Then the user should see the text "All is ok with the test bean"