Feature: YouTube Search

  Scenario: Searching for a video on YouTube
    Given I am on the YouTube homepage
    When I search for "Cucumber automation"
    Then I should see videos related to "Cucumber"