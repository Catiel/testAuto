package stepDefinition;


import base.WebDriverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class Login {
    private LoginPage loginPage = new LoginPage(WebDriverClass.getDriver());


    @Given("Ingresar a la pagina {string}")
    public void ingresar_a_la_pagina(String string) {
        loginPage.open(string);
    }

    @When("Introducir el usuario {string} en username")
    public void introducir_el_usuario_en_username(String string) {
        loginPage.setUsernameText(string);
    }

    @When("Introducir la {string} en password")
    public void introducir_la_en_password(String string) {
        loginPage.setPasswordText(string);
    }

    @When("Hacer click en el boton {string}")
    public void hacer_click_en_el_boton(String string) {
        loginPage.clickLogin();
    }

    @Then("Se despliega el mensaje {string}")
    public void se_despliega_el_mensaje(String string) {
        int a, b, c;
        a = 1;
    }
}
