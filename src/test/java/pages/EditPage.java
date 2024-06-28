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
    private String editarCurso = "//body/main/div/main/div[1]/button";
    private String inptTitulo = "css-1x5jdmq";
    private String btnGuardar = "css-5zrdtn";
    private String error = "css-v7esy";
    private String inptDescripcion = "css-u36398";

    public void open(String url) {
        driver.get(url);
    }

    public void abrirCurso() {
        driver.findElement(By.xpath(curso)).click();
    }

    public void editarCurso() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editarCurso)));
        driver.findElement(By.xpath(editarCurso)).click();
    }

    public void borrarTitulo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(inptTitulo)));
        driver.findElement(By.className(inptTitulo)).clear();
    }

    public void borrarDescripcion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(inptDescripcion)));
        driver.findElement(By.className(inptDescripcion)).clear();
    }

    public void clickGuardar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.className(btnGuardar)));
        driver.findElement(By.className(btnGuardar)).click();
    }

    public String getErrorMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(error)));
            return driver.findElement(By.className(error)).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void isNoCoursesMessageVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(curso)));
    }
}
