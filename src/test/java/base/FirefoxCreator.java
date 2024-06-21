package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxCreator extends WebDriverCreator{
    @Override
    public WebDriver createWebDriver() {
        System.setProperty("webdriver.gecko.driver", "src/resources/geckodriver.exe");

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("layout.css.devPixelsPerPx", "0.95");

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        return new FirefoxDriver(options);
    }
}