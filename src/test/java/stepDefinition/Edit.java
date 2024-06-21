package stepDefinition;


import base.WebDriverClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.EditPage;

public class Edit {
    private EditPage editPage = new EditPage(WebDriverClass.getDriver());

    @Given("El usuario ha ingresado a la pagina {string}")
    public void elUsuarioHaIngresadoALaPagina(String arg0) {
        editPage.open(arg0);
    }

    @And("El usuario tiene al menos un curso creado")
    public void elUsuarioTieneAlMenosUnCursoCreado() {
        editPage.isNoCoursesMessageVisible();
    }

    @When("El usuario hace abre el curso")
    public void elUsuarioHaceAbreElCurso() {
        editPage.abrirCurso();
    }

    @And("El usuario hace click en el boton editar")
    public void elUsuarioHaceClickEnElBotonEditar() {
        editPage.editarCurso();
    }

    @And("El usuario borra el contenido del campo titulo")
    public void elUsuarioBorraElContenidoDelCampoTitulo() {
        editPage.borrarTitulo();
    }

    @And("El usuario hace click en el boton guardar")
    public void elUsuarioHaceClickEnElBotonGuardar() {
        editPage.clickGuardar();
    }

    @Then("El sistema muestra un mensaje de error {string}")
    public void elSistemaMuestraUnMensajeDeError(String mensajeEsperado) {
        String mensajeActual = editPage.getErrorMessage();
        Assert.assertEquals("El mensaje de error no es el esperado", mensajeEsperado, mensajeActual);
    }

    @And("El usuario borra el contenido del campo descripcion")
    public void elUsuarioBorraElContenidoDelCampoDescripcion() {
        editPage.borrarDescripcion();
    }
}
