Feature: Authentication

  @testcase1
  Scenario: Register User
    Given I access to automation exercise system
    Then The 'Home' page should be displayed
    And The 'Home' menu's option should be focused
    When I click 'Signup / Login' menu's option
    Then The 'Signup / Login' page should be displayed
    And The 'Signup / Login' menu's option should be focused
    And The 'New User Signup!' should be visible
    When I enter data below into 'Name' and 'Email Address' fields of Signup
      | name       | email                 |
      | automation | automation@katalon.vn |
    And I click 'Signup' button
    Then The 'ENTER ACCOUNT INFORMATION' text should be displayed
    When I fill details data below
      | Title         | Mr.                      |
      | Name          | Pham Thanh Nam           |
      | Email         | nam.phamthanh@katalon.vn |
      | Password      | AutomationKatalon@2024   |
      | Date of Birth | September 1, 2001        |
    And I select 'Sign up for our newsletter!' checkbox
    And I select 'Receive special offers from our partners!' checkbox
    And I fill details data below
      | First name    | Test First Name   |
      | Last name     | Test Last Name    |
      | Company       | FPT Software      |
      | Address       | Ha Noi City       |
      | Address 2     | Nam Dinh Province |
      | Country       | Singapore         |
      | State         | Singapore State   |
      | City          | Singapore City    |
      | Zipcode       | 10000             |
      | Mobile Number | (+84) 958940985   |
    And I click 'Create Account' button
    Then The 'ACCOUNT CREATED!' text should be displayed
    When I click 'Continue' button
    Then Menu's option should be included in options below
      | Home            |
      | Products        |
      | Cart            |
      | Logout          |
      | Delete Account  |
      | Test Cases      |
      | API Testing     |
      | Video Tutorials |
      | Contact us      |
    When I click 'Delete Account' menu's option
    Then The 'ACCOUNT DELETED!' text should be displayed
    When I click 'Continue' button
    Then Menu's option should be included in options below
      | Home            |
      | Products        |
      | Cart            |
      | Signup / Login  |
      | Test Cases      |
      | API Testing     |
      | Video Tutorials |
      | Contact us      |
