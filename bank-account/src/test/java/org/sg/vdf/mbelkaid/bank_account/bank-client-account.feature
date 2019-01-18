Feature: Features of bank client account

Scenario: US1
Given a bank client
 When I want to make a deposit in my account
 Then save money

Scenario: US2
Given I am a bank client
 When I want to make a withdrawal from my account
 Then retrieve some or all of my savings

Scenario: US3
Given The same bank client
 When I check my operations
 Then I see the history