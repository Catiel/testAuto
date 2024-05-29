Feature: Registro de instructor

  Scenario: Intento de registro con un correo electrónico ya registrado
    Given Ingresar a la pagina "https://abmodelis.github.io/"
    When El usuario llena el formulario con los siguientes detalles:
      | campo                     | valor                |
      | nombre                    | Juan                 |
      | apellidos                 | Perez                |
      | correo electronico        | ejemplo@gmail.com    |
      | contraseña                | Pruebaautomatizacion |
      | confirmación de contraseña| Pruebaautomatizacion |
    And El usuario hace clic en "Registrarme"
    Then Aparece un mensaje que dice "El correo ya estaba registrado"