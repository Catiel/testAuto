package stepDefinition;


import base.WebDriverClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class Login {
    private LoginPage loginPage = new LoginPage(WebDriverClass.getDriver());


    @Given("Ingresar a la pagina {string}")
    public void ingresar_a_la_pagina(String string) {
        loginPage.open(string);
        try {
            Thread.sleep(20000); // Espera de 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("Hacer click en el boton {string}")
    public void hacer_click_en_el_boton(String string) {
        loginPage.clickEditar();
        try {
            Thread.sleep(10000); // Espera de 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("Hacer click en el boton titulo {string}")
    public void hacerClickEnElBotonTitulo(String arg0) {
        loginPage.clickEditarTitulo();
        try {
            Thread.sleep(10000); // Espera de 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("Ingresar titulo")
    public void ingresar_titulo() {
        loginPage.setTitulo();
        try {
            Thread.sleep(10000); // Espera de 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("Hacer click en el boton guardar {string}")
    public void hacerClickEnElBotonGuardar(String arg0) {
        loginPage.clickGuardar();
        try {
            Thread.sleep(10000); // Espera de 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("El titulo es igual a  {string}")
    public void elTituloEsIgualA(String arg0) {
        System.out.println(loginPage.getExito());
    }
}
