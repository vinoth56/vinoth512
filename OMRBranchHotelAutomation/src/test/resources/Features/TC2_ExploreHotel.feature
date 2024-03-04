Feature: Verify OMR Branch Explore Hotel Details

  Scenario Outline: Enter all fields and verify select hotel
    Given User is on the OMR Branch explore hotel page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When User Search Hotel "<SelectState>","<SelectCity>","<SelectRoomType>","<CheckIn>","<CheckOut>","<NoofRooms>","<NoofAdults>" and "<NoofChildren>"
    Then User should verify success message after search hotel "Select Hotel"

    Examples: 
      | username                | password       | SelectState | SelectCity | SelectRoomType | CheckIn    | CheckOut   | NoofRooms | NoofAdults | NoofChildren |
      | sathish180699@gmail.com | Sathissurya18@ | Tamil Nadu  | Chennai    | Deluxe         | 2023-09-27 | 2023-09-30 | 1-One     | 2-Two      |            1 |

  Scenario Outline: Enter Mandatory fields and verify select hotel
    Given User is on the OMR Branch explore hotel page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When User Search Hotel "<SelectState>","<SelectCity>","<CheckIn>","<CheckOut>","<NoofRooms>" and "<NoofAdults>"
    Then User should verify success message after search hotel "Select Hotel"

    Examples: 
      | username                | password       | SelectState | SelectCity | CheckIn    | CheckOut   | NoofRooms | NoofAdults |
      | sathish180699@gmail.com | Sathissurya18@ | Tamil Nadu  | Chennai    | 2023-09-27 | 2023-09-30 | 1-One     | 2-Two      |

  Scenario Outline: Without enter any field click search and verify all error message
    Given User is on the OMR Branch explore hotel page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When User should click search button without enter any field
    Then User should verify all error message "Please select state","Please select city","Please select Check-in date","Please select Check-out date","Please select no. of rooms" and "Please select no. of adults"

    Examples: 
      | username                | password       |
      | sathish180699@gmail.com | Sathissurya18@ |

  @Explore
  Scenario Outline: Enter multiple room type and verify header contain all the selected room type
    Given User is on the OMR Branch explore hotel page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When User Search Hotel "<SelectState>","<SelectCity>","<SelectRoomType>","<CheckIn>","<CheckOut>","<NoofRooms>" and "<NoofAdults>" with multiple room type
    Then User should verify success message after search hotel "Select Hotel"
    And User should verify the header contain all the selected room type "<SelectRoomType>"

    Examples: 
      | username                | password       | SelectState | SelectCity | SelectRoomType      | CheckIn    | CheckOut   | NoofRooms | NoofAdults |
      | sathish180699@gmail.com | Sathissurya18@ | Tamil Nadu  | Chennai    | Deluxe/Suite/Luxury | 2023-09-27 | 2023-09-30 | 1-One     | 2-Two      |
