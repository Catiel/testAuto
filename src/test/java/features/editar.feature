Feature: Verificación de campos obligatorios en la edición de cursos

  Scenario: Verificar que se muestra error si el título del curso está vacío al guardar cambios
    Given El usuario ha ingresado a la pagina "https://abmodelis.github.io/#/teachers/courses"
    And El usuario tiene al menos un curso creado
    When El usuario hace abre el curso
    And El usuario hace click en el boton editar
    And El usuario borra el contenido del campo titulo
    And El usuario hace click en el boton guardar
    Then El sistema muestra un mensaje de error "Este campo es requerido"

  Scenario: Verificar que se muestra error si el título del curso está vacío al guardar cambios
    Given El usuario ha ingresado a la pagina "https://abmodelis.github.io/#/teachers/courses"
    And El usuario tiene al menos un curso creado
    When El usuario hace abre el curso
    And El usuario hace click en el boton editar
    And El usuario borra el contenido del campo titulo
    And El usuario hace click en el boton guardar
    Then El sistema muestra un mensaje de error "Este campo no puede estar vacio"

  Scenario: Verificar que se muestra error si la descripcion del curso está vacío al guardar cambios
    Given El usuario ha ingresado a la pagina "https://abmodelis.github.io/#/teachers/courses"
    And El usuario tiene al menos un curso creado
    When El usuario hace abre el curso
    And El usuario hace click en el boton editar
    And El usuario borra el contenido del campo descripcion
    And El usuario hace click en el boton guardar
    Then El sistema muestra un mensaje de error "Este campo es requerido"
