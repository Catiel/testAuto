package pages;

import org.openqa.selenium.*;
import base.Base;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditPage extends Base {
    private WebDriver driver;

    public EditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //localizacion de elementos
    private String curso = "//body/main/div/main/div[2]/div[1]/div/div[3]/button";
    private String vacio = "css-68nmpm";
    private String editarCurso = "//body/main/div/main/div[1]/button";
    private String inptTitulo = "css-1x5jdmq";
    private String btnGuardar = "css-5zrdtn";
    private String error = "css-v7esy";

    public void open(String url) {
        driver.get(url);
    }

    public void abrirCurso() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // espera hasta 10 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(curso))); // espera hasta que el elemento esté visible
        driver.findElement(By.xpath(curso)).click();
    }

    public void editarCurso() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // espera hasta 10 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editarCurso))); // espera hasta que el elemento esté visible
        driver.findElement(By.xpath(editarCurso)).click();
    }

    public void borrarTitulo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // espera hasta 10 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(inptTitulo))); // espera hasta que el elemento esté visible
        driver.findElement(By.className(inptTitulo)).clear();
    }

    public void clickGuardar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // espera hasta 10 segundos
        wait.until(ExpectedConditions.elementToBeClickable(By.className(btnGuardar))); // espera hasta que el botón sea clickeable
        driver.findElement(By.className(btnGuardar)).click();
    }

    public String getErrorMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // espera hasta 10 segundos
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(error))); // espera hasta que el mensaje de error sea visible
            return driver.findElement(By.className(error)).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public boolean isNoCoursesMessageVisible() {
        try {
            return driver.findElement(By.className(vacio)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
