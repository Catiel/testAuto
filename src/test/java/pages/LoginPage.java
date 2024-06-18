package pages;

import org.openqa.selenium.By;
import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Base {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //localizacion de elementos
    private String editar = "/html/body/main/div/main/div[2]/div[1]/div/div[3]/button";
    private String editarTitulo = "/html/body/main/div/main/div[2]/div[2]/div/div[1]/div/div/div[1]/div[1]/h6/div/button[1]";
    private String inptTitulo = "//*[@id=\":r7:\"]";
    private String btnGuardar = "/html/body/div[3]/div[3]/form/div[2]/div[2]/button";
    private String Exito = "/html/body/main/div/main/div[2]/div[2]/div/div[1]/div/div/div[1]/div[1]/h6";

    public void open(String url) {
        driver.get(url);
    }

    public void clickEditar() {
        driver.findElement(By.xpath(editar)).click();
    }

    public void clickEditarTitulo() {
        driver.findElement(By.xpath(editarTitulo)).click();
    }

    public void setTitulo() {
        driver.findElement(By.xpath(inptTitulo)).clear();
        driver.findElement(By.xpath(inptTitulo)).sendKeys("Ejemplo de texto para editar titulo Ejemplo de texto para editar titulo Ejemplo de texto para editar titulo Ejemplo de texto para editar titulo Ejemplo de texto para editar titulo");
    }

    public void clickGuardar() {
        driver.findElement(By.xpath(btnGuardar)).click();
    }

    public String getExito() {
        return driver.findElement(By.xpath(Exito)).getText();
    }
}
