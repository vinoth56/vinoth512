Feature: Verify OMR Branch Book Hotel Details

  Scenario Outline: Book hotel including GST-card(debitcard-VISA)-with special request
    Given User is on the OMR Branch Book hotel page
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

    Examples: 
      | username                | password       | SelectState | SelectCity | SelectRoomType | CheckIn    | CheckOut   | NoofRooms | NoofAdults | SelectSalutation | FirstName | LastName | MobileNo   | Email                   | EnterRegistrationNo | EnterCompanyName       | EnterCompanyAddress | SpecialRequest | cardType   |
      | sathish180699@gmail.com | Sathissurya18@ | Tamil Nadu  | Chennai    | Deluxe         | 2023-09-27 | 2023-09-30 | 1-One     | 2-Two      | Mr.              | Sathish   | S        | 9159611528 | sathish180699@gmail.com |          9043592058 | Greens Tech OMR Branch | Thoraipakkam        | LargeBed       | debit_card |

  Scenario Outline: Book hotel including GST-card(CreditCard-VISA)-with special request
    Given User is on the OMR Branch Book hotel page
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
      | visa       | 5555555555552223 | Mani     | March | 2024 | 123 |
      | MasterCard | 5555555555554444 | Mani     | March | 2024 | 123 |
      | Amex       | 5555555555550000 | Mani     | March | 2024 | 123 |
      | Discover   | 5555555555556666 | Mani     | March | 2024 | 123 |
    Then User should verify success message after booking hotel "Booking is Confirmed" and save the orderid

    Examples: 
      | username                | password       | SelectState | SelectCity | SelectRoomType | CheckIn    | CheckOut   | NoofRooms | NoofAdults | SelectSalutation | FirstName | LastName | MobileNo   | Email                   | EnterRegistrationNo | EnterCompanyName       | EnterCompanyAddress | SpecialRequest | cardType    |
      | sathish180699@gmail.com | Sathissurya18@ | Tamil Nadu  | Chennai    | Deluxe         | 2023-09-27 | 2023-09-30 | 1-One     | 2-Two      | Mr.              | Sathish   | S        | 9159611528 | sathish180699@gmail.com |          9043592058 | Greens Tech OMR Branch | Thoraipakkam        | LargeBed       | credit_card |

  Scenario Outline: Book hotel including GST-card(debitcard-VISA)-without special request
    Given User is on the OMR Branch Book hotel page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When User Search Hotel "<SelectState>","<SelectCity>","<SelectRoomType>","<CheckIn>","<CheckOut>","<NoofRooms>" and "<NoofAdults>"
    Then User should verify success message after search hotel "Select Hotel"
    When User should select first hotel name and save the hotel name and price
    And User should accept the hotel book alert
    Then User should verify success message after select hotel "Book Hotel"
    When User add the guest details click Myself radio button and Enter "<SelectSalutation>","<FirstName>","<LastName>","<MobileNo>" and "<Email>"
    And User add GST details "<EnterRegistrationNo>","<EnterCompanyName>" and "<EnterCompanyAddress>"
    And User click next without add special request
    And User Enter payment Details,proceed with card type "<cardType>"
      | SelectCard | CardNo           | CardName | Month | Year | Cvv |
      | visa       | 5555555555552222 | Mani     | March | 2024 | 123 |
      | MasterCard | 5555555555554444 | Mani     | March | 2024 | 123 |
      | Amex       | 5555555555550000 | Mani     | March | 2024 | 123 |
      | Discover   | 5555555555556666 | Mani     | March | 2024 | 123 |
    Then User should verify success message after booking hotel "Booking is Confirmed" and save the orderid

    Examples: 
      | username                | password       | SelectState | SelectCity | SelectRoomType | CheckIn    | CheckOut   | NoofRooms | NoofAdults | SelectSalutation | FirstName | LastName | MobileNo   | Email                   | EnterRegistrationNo | EnterCompanyName       | EnterCompanyAddress | cardType   |
      | sathish180699@gmail.com | Sathissurya18@ | Tamil Nadu  | Chennai    | Deluxe         | 2023-09-27 | 2023-09-30 | 1-One     | 2-Two      | Mr.              | Sathish   | S        | 9159611528 | sathish180699@gmail.com |          9043592058 | Greens Tech OMR Branch | Thoraipakkam        | debit_card |

  Scenario Outline: Book hotel including GST-card(CreditCard-VISA)-without special request
    Given User is on the OMR Branch Book hotel page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When User Search Hotel "<SelectState>","<SelectCity>","<SelectRoomType>","<CheckIn>","<CheckOut>","<NoofRooms>" and "<NoofAdults>"
    Then User should verify success message after search hotel "Select Hotel"
    When User should select first hotel name and save the hotel name and price
    And User should accept the hotel book alert
    Then User should verify success message after select hotel "Book Hotel"
    When User add the guest details click Myself radio button and Enter "<SelectSalutation>","<FirstName>","<LastName>","<MobileNo>" and "<Email>"
    And User add GST details "<EnterRegistrationNo>","<EnterCompanyName>" and "<EnterCompanyAddress>"
    And User click next without add special request
    And User Enter payment Details,proceed with card type "<cardType>"
      | SelectCard | CardNo           | CardName | Month | Year | Cvv |
      | visa       | 5555555555552223 | Mani     | March | 2024 | 123 |
      | MasterCard | 5555555555554444 | Mani     | March | 2024 | 123 |
      | Amex       | 5555555555550000 | Mani     | March | 2024 | 123 |
      | Discover   | 5555555555556666 | Mani     | March | 2024 | 123 |
    Then User should verify success message after booking hotel "Booking is Confirmed" and save the orderid

    Examples: 
      | username                | password       | SelectState | SelectCity | SelectRoomType | CheckIn    | CheckOut   | NoofRooms | NoofAdults | SelectSalutation | FirstName | LastName | MobileNo   | Email                   | EnterRegistrationNo | EnterCompanyName       | EnterCompanyAddress | cardType    |
      | sathish180699@gmail.com | Sathissurya18@ | Tamil Nadu  | Chennai    | Deluxe         | 2023-09-27 | 2023-09-30 | 1-One     | 2-Two      | Mr.              | Sathish   | S        | 9159611528 | sathish180699@gmail.com |          9043592058 | Greens Tech OMR Branch | Thoraipakkam        | credit_card |

  Scenario Outline: Book hotel without GST-card(debitcard-VISA)-with special request
    Given User is on the OMR Branch Book hotel page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When User Search Hotel "<SelectState>","<SelectCity>","<SelectRoomType>","<CheckIn>","<CheckOut>","<NoofRooms>" and "<NoofAdults>"
    Then User should verify success message after search hotel "Select Hotel"
    When User should select first hotel name and save the hotel name and price
    And User should accept the hotel book alert
    Then User should verify success message after select hotel "Book Hotel"
    When User add the guest details click Myself radio button and Enter "<SelectSalutation>","<FirstName>","<LastName>","<MobileNo>" and "<Email>" click next
    And User add the special request "<SpecialRequest>"
    And User Enter payment Details,proceed with card type "<cardType>"
      | SelectCard | CardNo           | CardName | Month | Year | Cvv |
      | visa       | 5555555555552222 | Mani     | March | 2024 | 123 |
      | MasterCard | 5555555555554444 | Mani     | March | 2024 | 123 |
      | Amex       | 5555555555550000 | Mani     | March | 2024 | 123 |
      | Discover   | 5555555555556666 | Mani     | March | 2024 | 123 |
    Then User should verify success message after booking hotel "Booking is Confirmed" and save the orderid

    Examples: 
      | username                | password       | SelectState | SelectCity | SelectRoomType | CheckIn    | CheckOut   | NoofRooms | NoofAdults | SelectSalutation | FirstName | LastName | MobileNo   | Email                   | SpecialRequest | cardType   |
      | sathish180699@gmail.com | Sathissurya18@ | Tamil Nadu  | Chennai    | Deluxe         | 2023-09-27 | 2023-09-30 | 1-One     | 2-Two      | Mr.              | Sathish   | S        | 9159611528 | sathish180699@gmail.com | LargeBed       | debit_card |

  Scenario Outline: Book hotel without GST-card(CreditCard-VISA)-without special request
    Given User is on the OMR Branch Book hotel page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When User Search Hotel "<SelectState>","<SelectCity>","<SelectRoomType>","<CheckIn>","<CheckOut>","<NoofRooms>" and "<NoofAdults>"
    Then User should verify success message after search hotel "Select Hotel"
    When User should select first hotel name and save the hotel name and price
    And User should accept the hotel book alert
    Then User should verify success message after select hotel "Book Hotel"
    When User add the guest details click Myself radio button and Enter "<SelectSalutation>","<FirstName>","<LastName>","<MobileNo>" and "<Email>" click next
    And User click next without add special request
    And User Enter payment Details,proceed with card type "<cardType>"
      | SelectCard | CardNo           | CardName | Month | Year | Cvv |
      | visa       | 5555555555552223 | Mani     | March | 2024 | 123 |
      | MasterCard | 5555555555554444 | Mani     | March | 2024 | 123 |
      | Amex       | 5555555555550000 | Mani     | March | 2024 | 123 |
      | Discover   | 5555555555556666 | Mani     | March | 2024 | 123 |
    Then User should verify success message after booking hotel "Booking is Confirmed" and save the orderid

    Examples: 
      | username                | password       | SelectState | SelectCity | SelectRoomType | CheckIn    | CheckOut   | NoofRooms | NoofAdults | SelectSalutation | FirstName | LastName | MobileNo   | Email                   | cardType    |
      | sathish180699@gmail.com | Sathissurya18@ | Tamil Nadu  | Chennai    | Deluxe         | 2023-09-27 | 2023-09-30 | 1-One     | 2-Two      | Mr.              | Sathish   | S        | 9159611528 | sathish180699@gmail.com | credit_card |

  @Book
  Scenario Outline: Without entering any field book hotel and verify error message in payment
    Given User is on the OMR Branch Book hotel page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"
    When User Search Hotel "<SelectState>","<SelectCity>","<SelectRoomType>","<CheckIn>","<CheckOut>","<NoofRooms>" and "<NoofAdults>"
    Then User should verify success message after search hotel "Select Hotel"
    When User should select first hotel name and save the hotel name and price
    And User should accept the hotel book alert
    Then User should verify success message after select hotel "Book Hotel"
    When User add the guest details click Myself radio button and Enter "<SelectSalutation>","<FirstName>","<LastName>","<MobileNo>" and "<Email>" click next
    And User click next without add special request
    And User click submit without enter any field
    Then User should verify all error messages "Please select your card type","Please select your card","Please provide your card number","Please provide name on your card","Please provide your Card Expiry Date" and "Please provide your Card's security code" at payment

    Examples: 
      | username                | password       | SelectState | SelectCity | SelectRoomType | CheckIn    | CheckOut   | NoofRooms | NoofAdults | SelectSalutation | FirstName | LastName | MobileNo   | Email                   |
      | sathish180699@gmail.com | Sathissurya18@ | Tamil Nadu  | Chennai    | Deluxe         | 2023-09-27 | 2023-09-30 | 1-One     | 2-Two      | Mr.              | Sathish   | S        | 9159611528 | sathish180699@gmail.com |
