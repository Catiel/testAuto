package appHooks;

import base.WebDriverClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;
    private WebDriverClass myWebdriver;


    @Before(order = 10)
    public void launchBrowser() {
        String browser = "chrome"; //prop.getProperty("browser");
        myWebdriver = new WebDriverClass();
        try {
            driver = myWebdriver.getWebDriver(browser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @After(order = 10)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 20)
    public void myTearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screanshot:

            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }
}
