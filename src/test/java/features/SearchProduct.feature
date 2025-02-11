Feature: Search and place the order for Products
Scenario: Search Experience for product search in both home and offers page
Given User is on the GreenCart Landing Page of GreenKart Website.
When User searched with shortname "Tom" and extracted actual name of product.
Then User Searched for same shortname in offers page to check if product exist
And Validate product name in offers page matches with Landing Page.

Scenario: Search Experience for product search in both home and offers page
Given User is on the GreenCart Landing Page of GreenKart Website.
When User searched with shortname "Tom" and extracted actual name of product.
Then User Searched for same shortname in offers page to check if product exist
And Validate product name in offers page matches with Landing Page.
