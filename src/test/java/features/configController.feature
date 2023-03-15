Feature: Configuration Controller ApiAutomation

  Scenario: Engagement Configuration Api controller

      #step1
    Given User calls "CreateConfig" with "POST" http request
     #step2
    Then the API call got success with status code 200
      #step3
    Then I Retrieve the ConfigId "Id"
#    And  User calls "getAllConfigs" using tenantID get all the configuration list
      #step3
#    And To get configuration used "tenantID" and "configId"
#      #step5
#    Then "<configId>" config is Updated for  existing configuration



