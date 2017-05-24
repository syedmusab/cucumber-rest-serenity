Feature: Get list of built dates of car types
  In order to select the built dates of manufactured car
  A request to built dates API with valid end point always return response in wkda

  Scenario: A api call for built dates with valid end point and parameters returns valid manufacturer response
    Given get endpoint of built-dates manufacturer
    When a request is sent to autoOne with wa_key and locale and manufacturer and main types
    Then api returns car built dates details when valid parameters were passed