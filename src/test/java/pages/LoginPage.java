package pages;

import org.openqa.selenium.By;
import base.Base;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base{
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //localizacion de elementos
    private String username = "username";
    private String txtPassword = "password";
    private String btnLogin = "//div[2]/div/div/form/button/i";

    public void open(String url) {
        driver.get(url);
    }
    public void setUsernameText(String text) {
        driver.findElement(By.id(username)).sendKeys(text);
    }
    public void setPasswordText(String text) {
        driver.findElement(By.id(txtPassword)).sendKeys(text);
    }
    public void clickLogin() {
        driver.findElement(By.xpath(btnLogin)).click();
    }
}
