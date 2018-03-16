Feature: Search

  Scenario: search for not-existent info
    When typed random text to search box
    Then should show no results

  Scenario: press Enter in empty search box
    When typed "" to search box
    Then should show no results

  Scenario Outline: search for article titles
    When typed "<text>" to search box
    Then "<title>" should be first in search results

    Examples:
      | text      | title     |
      | pets      | Pets      |
      | inventory | Inventory |

  Scenario Outline: search existent info
    When typed "<text>" to search box
    Then "<result>" should be in search results

    Examples:
      | text         | result      |
      | texture      | Value Types |
      | requirements | Items       |
