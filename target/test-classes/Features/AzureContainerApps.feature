Feature: Login page for the E-commerce website Azure App

  Scenario: validate that the user is able to login/logout of Azure App
    Given user login using "store@admin.com" as username and "P@ssw0rd" as password
    When user redirected to the dashboard
    And user get the title of the home page
    And user clicks on "account side menu" button
    And user clicks on "log out" button
    Then user can see the signed out snack bar
    And user can not see the dashboard
    And user can see the login page
