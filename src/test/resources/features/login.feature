Feature: Decathlon Login Page

  @login
  Scenario Outline: Login using Mobile Number and OTP
    Given User is on the Decathlon login page
    When User selects login with Mobile and OTP
    And User enters valid mobile number "<mobile>"
    And User clicks on the Send OTP button
    Then User should receive OTP and login should be successful

    Examples: 
      | mobile     |
      | 8305174541 |

  @login
  Scenario Outline: Login using Email and OTP
    Given User is on the Decathlon login page
    When User selects login with Email and OTP
    And User enters valid email address "<email>"
    And User clicks on the Send OTP button
    Then User should receive OTP and login should be successful

    Examples: 
      | email                     |
      | sanjaypalaiya98@gmail.com |
