Feature: Test Login functionality


Scenario: Valid login
Given user should be on login page
When user enters userid and password and click on login button
Then user should be landed on home page
And close browser


Scenario: E2E lead creation scenario
Given user should be on login page
When user enters userid and password and click on login button
Then user should be landed on home page
When user click on create lead link
Then user navigates on create lead page
When user enter last name and company 
And click on save button
Then lead should be saved successfully
And click on logout link
And close browser


@run
Scenario Outline: InValid login
Given user should be on login page
When user enters invalid "<Userid>" and "<Password>" click on login button
#Then user should be landed on home page
And close browser
Examples:
|Userid | Password |
|admin1 | admin1   |
|admin2 | admin2   |
|admin3 | admin3   |





