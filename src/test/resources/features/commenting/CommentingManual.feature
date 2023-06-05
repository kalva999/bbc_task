@manualTestCases
Feature: Commenting and Related Features
Background:
  Given I am on the BBC page URL <BBC Sports URL>
  Then I click on sign in button and wait for sign in page
  When I enter username as <username>
  And I enter password as <password>
  And I click on login button

  Scenario: Verify if user can submit their Comment
    Given I am on the article page on the BBC website
    And I am in the comment section
    When I enter a valid comment in the comment input field
    And I click on the "Submit" button
    Then the comment should be successfully submitted and displayed in the comment section

  Scenario: Verify if user can see error message on empty comment entry
    Given I am on the article page on the BBC website
    And I am in the comment section
    When I enter an empty comment in the comment input field
    And I click on the "Submit" button
    Then an error message should be displayed, indicating that the comment cannot be empty

  Scenario: Verify if user can delete their comment
    Given I am on the article page on the BBC website
    And I am in the comment section
    And I have previously posted a comment
    When I click on the "Delete" button of the comment
    And I click on ok button from confirm the deletion popup
    Then the comment should no longer be displayed in the comment section

  Scenario: Verify if user can edit their comment
    Given I am on the article page on the BBC website
    And I am in the comment section
    And I have previously posted a comment
    When I click on the "Edit" button of the comment
    And I make changes to the comment content
    And I click on the "Save" button
    Then the edited comment should be displayed with the updated content in the comment section

  Scenario: Verify if user can reply on a Comment
    Given I am on the article page on the BBC website
    And I am in the comment section
    When I click on the "Reply" button of the comment I want to reply to
    And I enter a valid reply in the reply input field
    And I click on the "Submit" button
    Then the reply should be successfully submitted and displayed

  Scenario: Verify if user can Sort the comments by using show filter
    Given I am on the article page on the BBC website
    And I am in the comment section where multiple comments displayed
    When I click on the "Latest" sorting option from Show dropdown
    Then the comments should be rearranged according to the selected sorting option

  Scenario: Verify if user can report a comment
    Given I am on the article page on the BBC website
    And I am in the comment section
    And there is a comment that violates the community guidelines or contains inappropriate content
    When I click on the three dot menu button and clicked on "Report" button
    And I fill in the necessary information to report the comment
    And I submit the report
    Then a confirmation message should be displayed