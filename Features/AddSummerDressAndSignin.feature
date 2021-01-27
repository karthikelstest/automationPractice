Feature: Add Summer Dress to Shopping Cart and open Sign In Page

  @DemoTest
  Scenario: Add Summer Dress to Shopping Cart
    Given The website is launched URL "http://automationpractice.com/index.php"
    When Page Title is "My Store"
    Then Add Dress to Cart "Printed Summer Dress"
    And Open Sign In Page
    When Page Title is "Login - My Store"
    Then Close browser
