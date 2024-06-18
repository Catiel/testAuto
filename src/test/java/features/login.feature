Feature: El usuario se puede logear en la aplicacion

  Scenario: El usuario ingresa un titulo con exito
    Given Ingresar a la pagina "https://abmodelis.github.io/#/teachers/courses"
    When Hacer click en el boton "Editar"
    And Hacer click en el boton titulo "Editar Titulo"
    And Ingresar titulo
    And Hacer click en el boton guardar "Guardar"
    Then El titulo es igual a  "Ejemplo de texto para editar titulo"