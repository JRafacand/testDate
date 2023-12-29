Feature: Elegir Productos Opencart

  Scenario: register
    Given User I navigate to opencart
    And he I Register user
        |firstname|lastname|email                |telephone |password |confirm|
        |Pedro    |Test   |PedroTest@hotmail.com|0987654321|prueba123|prueba123|
  Scenario: Login Opencart
    Given User I navigate to opencart
    And he I select a products
      |products|
      |MacBook|
      |iPhone|
      |Apple Cinema 30"|
      |Canon EOS 5D|
    And he usuario ingresa las credenciales
      |Usuario              |Password|
      |PedroTest@hotmail.com|prueba123|
    And he eliminar productos outstcock
    And he checkout
    Then he Valido el campo nombre "Pedro"
    Then he Valido el campo apellido "Test"
    Then he ingreso company "RuakTravel"
    Then he ingreso address 1 "Cumbaya" address 2 "Bellavista"
    Then he Valido ingreso city "Ecuador Sudamerica"
    Then he Valido ingreso codigo postal 170184
    Then he Ingreso country y state
    Then he delivery details
    Then he confirm order

