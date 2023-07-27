Feature: As a user, I want to create a automation to practice all my skills


  Scenario: Successful validate links
    Given Link page
    When Move in windows
    Then Validate link

  Scenario: Successful login using valid account
    Given Login form in login page
    When Submit information
    Then Success validate

  Scenario: Successful login using valid account
    Given Home page
    When Move the slider
    Then Validate number





#When Submit email using "your_email" and password using "your_password"