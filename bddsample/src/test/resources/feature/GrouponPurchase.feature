Feature: Groupon purchase

  #Scenario: Login to Amazon site
  #	Given I navigate to amazon site 'http://groupon.com.au'
  #	When I set valid credentials
  #	Then I am logged in successfully
  Background: Login to Groupon site
    Given I navigate to groupon site 'http://groupon.com.au'
    When I set valid credentials
    Then I am logged in successfully

  Scenario: Search for an item
    Given I see search box on home page
    When I set search field as "car phone holder"
    Then I see list of items
