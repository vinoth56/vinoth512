Feature: Verify OMR Branch Change Booking Details
 @Edit
  Scenario Outline: Verify change booking Module by changing checkInDate for created order id
    Given User is on the OMR Branch My Booking page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When User Search Hotel "<SelectState>","<SelectCity>","<SelectRoomType>","<CheckIn>","<CheckOut>","<NoofRooms>" and "<NoofAdults>"
    Then User should verify success message after search hotel "Select Hotel"
    When User should select first hotel name and save the hotel name and price
    And User should accept the hotel book alert
    Then User should verify success message after select hotel "Book Hotel"
    When User add the guest details click Myself radio button and Enter "<SelectSalutation>","<FirstName>","<LastName>","<MobileNo>" and "<Email>"
    And User add GST details "<EnterRegistrationNo>","<EnterCompanyName>" and "<EnterCompanyAddress>"
    And User add the special request "<SpecialRequest>"
    And User Enter payment Details,proceed with card type "<cardType>"
      | SelectCard | CardNo           | CardName | Month | Year | Cvv |
      | visa       | 5555555555552222 | Mani     | March | 2024 | 123 |
      | MasterCard | 5555555555554444 | Mani     | March | 2024 | 123 |
      | Amex       | 5555555555550000 | Mani     | March | 2024 | 123 |
      | Discover   | 5555555555556666 | Mani     | March | 2024 | 123 |
    Then User should verify success message after booking hotel "Booking is Confirmed" and save the orderid
    And User should verify same hotel name is booked
    When user navigate to my booking page
    Then User should verify the success message "Bookings" after navigate to booking page
    When User search the orderId with saved orderId
    Then User should verify the same orderId is present successfully
    And User should verify the same hotel name is present successfully
    And User should verify the same hotel price is present successfully
    When User edit the booking by changing the checkInDate "<CheckIn>"
    Then User should verify after editing the checkindate success message "Booking updated successfully"

    Examples: 
      | username                | password       | SelectState | SelectCity | SelectRoomType | CheckIn    | CheckOut   | NoofRooms | NoofAdults | SelectSalutation | FirstName | LastName | MobileNo   | Email                   | EnterRegistrationNo | EnterCompanyName       | EnterCompanyAddress | SpecialRequest | cardType   | CheckIn    |
      | sathish180699@gmail.com | Sathissurya18@ | Tamil Nadu  | Chennai    | Deluxe         | 2023-09-27 | 2023-09-30 | 1-One     | 2-Two      | Mr.              | Sathish   | S        | 9159611528 | sathish180699@gmail.com |          9043592058 | Greens Tech OMR Branch | Thoraipakkam        | LargeBed       | debit_card | 2023-09-29 |

 
  Scenario Outline: Verify change booking Module by changing checkInDate for first order id
    Given User is on the OMR Branch My Booking page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When user navigate to my booking page after login
    Then User should verify the success message "Bookings" after navigate to booking page
    When User should modify the first order id
    And User edit the booking by changing the checkInDate "<CheckIn>"
    Then User should verify after editing the checkindate success message "Booking updated successfully"

    Examples: 
      | username                | password       | CheckIn    |
      | sathish180699@gmail.com | Sathissurya18@ | 2023-09-27 |

  Scenario Outline: Verify change booking Module by changing checkInDate for existing order id
    Given User is on the OMR Branch My Booking page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When user navigate to my booking page after login
    Then User should verify the success message "Bookings" after navigate to booking page
    When User should modify the existing order id
    And User edit the booking by changing the checkInDate "<CheckIn>"
    Then User should verify after editing the checkindate success message "Booking updated successfully"

    Examples: 
      | username                | password       | CheckIn    |
      | sathish180699@gmail.com | Sathissurya18@ | 2023-09-28 |
