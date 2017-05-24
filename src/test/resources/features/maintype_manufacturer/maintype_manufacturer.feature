Feature: Get list of manufacturer main types
  In order to select the type of manufactured car I want to sell
  A request to maintype manufacturer API with valid end point always return response in wkda

  Scenario: A api call for maintype with valid end point and parameters returns valid manufacturer response
    Given get endpoint of main-types manufacturer
    When a request is sent to autoOne with wa_key and locale and manufacturer
    Then autoOne api returns car manufacturer details when valid parameters were passed