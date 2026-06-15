Feature: IKEA Denmark Homepage

  Scenario: User can open IKEA DK homepage
    Given user opens the IKEA Denmark website
    Then the page title contains "IKEA"
    And the cookie consent banner is visible


  Scenario: User can search for a product
    Given user opens the IKEA Denmark website
    When user types "BILLY" in the search box
    Then search results contain "BILLY"