package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxCreator extends WebDriverCreator{
    @Override
    public WebDriver createWebDriver() {
        System.setProperty("webdriver.gecko.driver", "src/resources/geckodriver.exe");
        return new FirefoxDriver();
    }
}
