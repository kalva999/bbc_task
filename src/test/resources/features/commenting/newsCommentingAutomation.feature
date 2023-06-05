Feature: As a logged in BBC news reader, comment section should be in editable mode.
@automation
  Scenario Outline: Verify if comment section is editable for a logged in user
  	Given I am on the BBC page URL <BBC Sports URL>
    And I accept the cookie
    Then I click on sign in button and wait for sign in page
    When I enter username as <username>
    And I enter password as <password>
    And I click on login button
    And I accept the cookie
    When I Click on a article with comment button from homePage
    And I Click on the view Comment button of the article
    Then I Verify the commenting is enabled
  Examples:
    | BBC Sports URL              | username               | password      |
    | https://www.bbc.co.uk/sport | kalva.qa999@gmail.com  | 07429186166Kk |
