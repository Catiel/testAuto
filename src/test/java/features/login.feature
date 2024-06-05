Feature: El usuario se puede logear en la aplicacion

  Scenario: El usuario se logea con credenciales validas
    Given Ingresar a la pagina "https://the-internet.herokuapp.com/login"
    When Introducir el usuario "tomsmith" en username
    And Introducir la "SuperSecretPassword!" en password
    And Hacer click en el boton "Login"
    Then Se despliega el mensaje "Cambia la Contraseña"

  Scenario: Login Form invalido
    Given Ingresar a la pagina "https://the-internet.herokuapp.com/loginkddñlknf"
    When Introducir el usuario "tomsmith" en username
    And Introducir la "SuperSecretPassword!" en password
    And Hacer click en el boton "Login"
    Then Se despliega el mensaje "Cambia la Contraseña"

  Scenario: Login Form invalido 3
    Given Ingresar a la pagina "https://the-internet.herokuapp.com/login"
    When Introducir el usuario "tomhhsmith" en username
    And Introducir la "SuperSecrenntPassword!" en password
    And Hacer click en el boton "Login"
    Then Se despliega el mensaje "Cambia la Contraseña"