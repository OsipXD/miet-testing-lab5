#Feature: Registration
#
#  Scenario Outline: Filling all fields with right data
#    When typed first name: <firstName>
#    And typed last name: <lastName>
#    And typed login: <login>
#    And typed password: <pass>
#    And typed password confirmation: <passConfirm>
#    And typed password phone: <phone>
#    Then all fields should be valid
#
#    Examples:
#      | firstName | lastName | login      | pass        | passConfirm | phone        |
#      | Ivan      | Ivanov   | iivanidzei | ilaASl299as | ilaASl299as | +79998765432 |
#
#  Scenario Outline: Filling all fields with errors
#    When typed first name: <firstName>
#    And typed last name: <lastName>
#    And typed login: <login>
#    And typed password: <pass>
#    And typed password confirmation: <passConfirm>
#    And typed password phone: <phone>
#    Then should have <n> invalid fields
#
#    Examples:
#      | firstName | lastName | login      | pass        | passConfirm | phone        | n |
#      |           | Ivanov   | iivanidzei | ilaASl299as | ilaASl299as | +79998765432 | 1 |
#      | Ivan      |          | iivanidzei | ilaASl299as | ilaASl299as | +79998765432 | 1 |
#      | Ivan      | Ivanov   | ivanidze   | ilaASl299as | ilaASl299as | +79998765432 | 1 |
#      | Ivan      | Ivanov   | iivanidzei | 12345678    | 12345678    | +79998765432 | 1 |
#      | Ivan      | Ivanov   | iivanidzei | ilaASl299as |             | +79998765432 | 1 |
#      | Ivan      | Ivanov   | iivanidzei | 123456789   | 12345678    | +79998765432 | 2 |
#      | Ivan      | Ivanov   | ivanidze   | 123456789   | 12345678    | +79998765432 | 3 |
#      | Ivan      |          | ivanidze   | 123456789   | 12345678    | +79998765432 | 4 |
#      |           |          | ivanidze   | 123456789   | 12345678    | +79998765432 | 5 |