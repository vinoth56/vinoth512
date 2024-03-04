@Select
Feature: Verify OMR Branch Select Hotel Details

  Scenario Outline: Select hotel and verify navigate to book hotel upon accepting the alert
    Given User is on the OMR Branch select hotel page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When User Search Hotel "<SelectState>","<SelectCity>","<SelectRoomType>","<CheckIn>","<CheckOut>","<NoofRooms>" and "<NoofAdults>"
    Then User should verify success message after search hotel "Select Hotel"
    When User should select first hotel name and save the hotel name and price
    And User should accept the hotel book alert
    Then User should verify success message after select hotel "Book Hotel"

    Examples: 
      | username                | password       | SelectState | SelectCity | SelectRoomType | CheckIn    | CheckOut   | NoofRooms | NoofAdults |
      | sathish180699@gmail.com | Sathissurya18@ | Tamil Nadu  | Chennai    | Deluxe         | 2023-09-27 | 2023-09-30 | 1-One     | 2-Two      |

  Scenario Outline: Select hotel and verify navigating in the same page upon dissmiss the alert
    Given User is on the OMR Branch select hotel page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When User Search Hotel "<SelectState>","<SelectCity>","<SelectRoomType>","<CheckIn>","<CheckOut>","<NoofRooms>" and "<NoofAdults>"
    Then User should verify success message after search hotel "Select Hotel"
    When User should select first hotel name and save the hotel name and price
    And User should dismiss the hotel book alert
    Then User should verify success message after dismiss select hotel "Select Hotel"

    Examples: 
      | username                | password       | SelectState | SelectCity | SelectRoomType | CheckIn    | CheckOut   | NoofRooms | NoofAdults |
      | sathish180699@gmail.com | Sathissurya18@ | Tamil Nadu  | Chennai    | Deluxe         | 2023-09-27 | 2023-09-30 | 1-One     | 2-Two      |

  Scenario Outline: Passing room type and verify filter is listed and verify hotel name ends with the same room type
    Given User is on the OMR Branch select hotel page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When User Search Hotel "<SelectState>","<SelectCity>","<SelectRoomType>","<CheckIn>","<CheckOut>","<NoofRooms>","<NoofAdults>" and "<NoofChildren>"
    Then User should verify success message after search hotel "Select Hotel"
    And User should verify same filters are checked in and verify each hotel name ends with the given room type "<SelectRoomType>"

    Examples: 
      | username                | password       | SelectState | SelectCity | SelectRoomType | CheckIn    | CheckOut   | NoofRooms | NoofAdults | NoofChildren |
      | sathish180699@gmail.com | Sathissurya18@ | Tamil Nadu  | Chennai    | Deluxe         | 2023-09-27 | 2023-09-30 | 1-One     | 2-Two      |            1 |

  Scenario Outline: Verify Hotel price listed in low to high
    Given User is on the OMR Branch select hotel page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When User Search Hotel "<SelectState>","<SelectCity>","<SelectRoomType>","<CheckIn>","<CheckOut>","<NoofRooms>" and "<NoofAdults>"
    Then User should verify success message after search hotel "Select Hotel"
    When User should click  radio button Price low to high
    Then User should verify the hotel price are listed in Ascending order

    Examples: 
      | username                | password       | SelectState | SelectCity | SelectRoomType | CheckIn    | CheckOut   | NoofRooms | NoofAdults |
      | sathish180699@gmail.com | Sathissurya18@ | Tamil Nadu  | Chennai    | Standard       | 2023-09-27 | 2023-09-30 | 1-One     | 2-Two      |

  Scenario Outline: Verify Hotel name listed in Descending order
    Given User is on the OMR Branch select hotel page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When User Search Hotel "<SelectState>","<SelectCity>","<SelectRoomType>","<CheckIn>","<CheckOut>","<NoofRooms>" and "<NoofAdults>"
    Then User should verify success message after search hotel "Select Hotel"
    When User should click radio button Name Descending
    Then User should verify the hotel name are listed in Descending order

    Examples: 
      | username                | password       | SelectState | SelectCity | SelectRoomType | CheckIn    | CheckOut   | NoofRooms | NoofAdults |
      | sathish180699@gmail.com | Sathissurya18@ | Tamil Nadu  | Chennai    | Deluxe         | 2023-09-27 | 2023-09-30 | 1-One     | 2-Two      |
