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
    private String vacio = "//body/main/div/main/p";
    private String editarCurso = "//body/main/div/main/div[1]/button";
    private String inptTitulo = ":rd:";
    private String btnGuardar = "//body/div[2]/div[3]/div/div/div/form/div[5]/div[2]/button";
    private String error = "//*[@id=\":rd:-helper-text\"]";

    public void open(String url) {
        driver.get(url);
    }

    public void abrirCurso() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // espera hasta 10 segundos
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inptTitulo))); // espera hasta que el elemento esté visible
        driver.findElement(By.id(inptTitulo)).clear();
    }

    public void clickGuardar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // espera hasta 10 segundos
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnGuardar))); // espera hasta que el botón sea clickeable
        driver.findElement(By.xpath(btnGuardar)).click();
    }

    public String getErrorMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // espera hasta 10 segundos
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(error))); // espera hasta que el mensaje de error sea visible
            return driver.findElement(By.xpath(error)).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public boolean isNoCoursesMessageVisible() {
        try {
            return driver.findElement(By.xpath(vacio)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
