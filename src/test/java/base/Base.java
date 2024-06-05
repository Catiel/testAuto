package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Base {

    private WebDriver driver;
    private String url = "";

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public Boolean launchWebPage(String url, String title){
        try{
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.get(url);

            return (driver.getTitle() == title) ? true: false;
        }
        catch (Exception e){
            System.out.println("the page does not found " + title);
            return false;
        }
    }
    public By getLocatorType(String locatorType, String locator){
        switch (locatorType){
            case "id":
                return By.id(locator);
            case "name":
                return By.name(locator);
            case "class":
                return By.className(locator);
            case "xpath":
                return By.xpath(locator);
            case "css":
                return By.cssSelector(locator);
            case "tag":
                return By.tagName(locator);
            case "link":
                return By.linkText(locator);
            case "plink":
                return By.partialLinkText(locator);
            default:
                System.out.println("The locator type is not valid " + locatorType);
                return null;
        }

    }
}
