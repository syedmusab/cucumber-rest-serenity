Feature: Get list of manufacturer car types
  In order to select the type of car I want to sell
  A request to cartype manufacturer API with valid end point always return response in wkda

  Scenario: A api call with valid end point and parameters returns valid wkda response
    Given get endpoint of car-types manufacturer
    When a request is sent to autoOne with wa_key and locale
    Then autoOne api returns wkda response when valid parameters were passed