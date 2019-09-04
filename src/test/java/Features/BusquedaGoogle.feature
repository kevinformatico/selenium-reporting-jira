@busquedaGoogle
Feature: Busqueda

  Scenario Outline: busqueda en Google
    Given Estoy en la pagina "http://www.google.cl"
    When busco la palabra "<buscar>"
    Then aparecen enlaces relacionados con "<buscar>"
    And hacer click en el enlace

    Examples:
      | buscar    |
      | Autos     |