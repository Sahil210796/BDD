Feature: OrangeHRM Login Feature

Scenario Outline: OrangeHrm Login Test Scenario

Given user is already on Login Page
When title of login page is login
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then user is on Dashboard
Then Close the browser


Examples:
	| username | password  | login |
	| Admin    | admin123 | Login |
		