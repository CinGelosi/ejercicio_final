@pet
Feature: Swagger - Pet
  Add a new pet, find, update or delete pets

  @addPet
  Scenario Outline: Add a new pet
    Given a pet with name "<name>" and status "<status>"
    When it is decided to add in the system
    Then the status code is 200
    Examples:
      | name           | status       |
      | Dominic        | available    |

  @findPet
  Scenario Outline: Find pet
    Given a status "<status>"
    When i try to find a pet
    Then the status code is 200
    Examples:
      | status       |
      | available    |
      | pending      |
      | sold         |

  @updatePet
  Scenario Outline: Update pet
    Given an id "<id>" and a new name "<name>"
    When i try update the pet
    Then the status code is 200
    Examples:
      |id                 | name           |
      |9223372036854334490| Dominic        |

  @findPetById
  Scenario Outline: Find pet by id
    Given an id "<id>"
    When i try to find a pet by id "<id>"
    Then the status code is 200
    Examples:
      | id                     |
      | 9223372036854334490    |

  @deletePet
  Scenario Outline: Delete pet
    Given an id "<id>"
    When i try to delete a pet by "<id>"
    Then the status code is 200
    Examples:
      | id                     |
      | 9223372036854334490    |