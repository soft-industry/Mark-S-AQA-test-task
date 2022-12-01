# Sample Serenity Cucumber REST Project

## Prerequisites

1. Java 8
2. Maven 3

## Running tests on local environment

1. Make sure that you have JDK 1.8 or greater and Maven 3 installed.
3. Run tests with `mvn clean verify`

## Adding new tests

In order to add new tests and actions, follow this structure:

* __steps__ package should have steps covered in stepdefinitions package;
* __stepdefinitions__ package should have Cucumber steps definitions;

Feature files should be placed into `resources/features` folder.

## What was refactored

### Added new scenario and extended existing one by adding new steps in get_product.feature
### Added .gitlab-ci.yml file to run in GitLab pipeline and generate html report file
### Refactored ProductStepDefinitions.class:

1. Fixed errors which affected tests
2. Added new checks to complete test verifications

### Added ProductStep.class to hide steps logic and make test code more readable
