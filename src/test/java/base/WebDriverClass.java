package base;

import org.openqa.selenium.WebDriver;

public class WebDriverClass {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getWebDriver(String browser) throws Exception {
        if (browser.equals("chrome")) {
            ChromeCreator chromeCreator = new ChromeCreator();
            driver.set((WebDriver) chromeCreator.createWebDriver());
        } else if (browser.equals("firefox")) {
            FirefoxCreator firefoxCreator = new FirefoxCreator();
            driver.set((WebDriver) firefoxCreator.createWebDriver());
        } else {
            ChromeCreator chromeCreator = new ChromeCreator();
            driver.set((WebDriver) chromeCreator.createWebDriver());
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}