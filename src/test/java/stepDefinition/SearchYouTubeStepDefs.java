package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class SearchYouTubeStepDefs {
    private WebDriver driver;

    @Given("I am on the YouTube homepage")
    public void i_am_on_the_youtube_homepage() {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe"); // replace with your actual path
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.youtube.com");
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys(query);
        searchBox.submit();
    }


    @Then("I should see videos related to {string}")
    public void i_should_see_videos_related_to(String query) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstVideoTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#video-title")));
        assertTrue(firstVideoTitle.getText().contains(query));
        driver.quit();
    }
}