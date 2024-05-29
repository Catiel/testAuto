package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class abmodel {

    private WebDriver driver;


    @Given("Ingresar a la pagina {string}")
    public void ingresar_a_la_pagina(String page) {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(page);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Enseña en UFC')]")));
    }

    @When("El usuario llena el formulario con los siguientes detalles:")
    public void el_usuario_llena_el_formulario_con_los_siguientes_detalles(io.cucumber.datatable.DataTable dataTable) {
        // Convertir la DataTable a una lista de mapas
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        Map<String, String> map = list.get(0); // Obtener la primera fila

        // Utilizar los valores de la tabla para llenar el formulario
        driver.findElement(By.id(":r9:")).sendKeys(map.get("nombre"));
        driver.findElement(By.id(":ra:")).sendKeys(map.get("apellidos"));
        driver.findElement(By.id(":rb:")).sendKeys(map.get("correo electronico"));
        driver.findElement(By.id("outlined-adornment-password")).sendKeys(map.get("contraseña"));
        driver.findElement(By.id("outlined-adornment-confirm-password")).sendKeys(map.get("confirmación de contraseña"));

        // Hacer clic en el campo para abrir la lista desplegable
        driver.findElement(By.id("demo-simple-select")).click();
    }

    @When("El usuario hace clic en {string}")
    public void el_usuario_hace_clic_en(String string) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//button[contains(text(), 'Registrarme')]")).click();
    }

    @Then("Aparece un mensaje que dice {string}")
    public void aparece_un_mensaje_que_dice(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}