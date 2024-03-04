Feature: Verify OMR Branch Hotel Login Automation

  Scenario Outline: Verifying Login with valid credentials
    Given User is on the OMR Branch hotel page
    When User Login "<username>" and "<password>"
    Then User should verify success message after Login "Welcome Sathis"

    Examples: 
      | username                | password       |
      | sathish180699@gmail.com | Sathissurya18@ |

  Scenario Outline: Verifying Login with valid credentials using ENTER Key
    Given User is on the OMR Branch hotel page
    When User Login "<username>" and "<password>" with ENTER key
    Then User should verify success message after Login "Welcome Sathis"

    Examples: 
      | username                | password       |
      | sathish180699@gmail.com | Sathissurya18@ |

  Scenario Outline: Verifying Login with invalid credentials
    Given User is on the OMR Branch hotel page
    When User Login "<username>" and "<password>"
    Then User should verify error message after Login "Invalid Login details or Your Password might have expired."

    Examples: 
      | username                | password    |
      | sathish180699@gmail.com | Sathish007s |
