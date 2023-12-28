Feature: Elegir Productos Opencart

  Scenario: Login Opencart
    Given User I navigate to opencart
    And he I select a products
      |products|
      |MacBook|
      |iPhone|
      |Apple Cinema 30"|
      |Canon EOS 5D|
    And he usuario ingresa las credenciales
      |Usuario                |Password|
      |pruebadata@hotmail.com |prueba123|
    And he eliminar productos outstcock




   # Given User I navigate to demoblaze compra
    #Then he Valido el campo "Juan Perez"
    #Then he Valido ingreso country "Ecuador Sudamerica"
    #Then he Valido ingreso city "Quito"
    #Then he valido ingreso tarjeta "9876-5432-1098-7654"
    #Then he Ingreso Mes
    #Then he Valido anio 2023
    #Then he Finalizar Compra
    #Then he navigate demoblaze back

