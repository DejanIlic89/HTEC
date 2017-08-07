package setup;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import pages.LogInPage;

/**
 *
 * @author Dejan
 */

public class SetUp {
    
     public static WebDriver initializeDriver(WebDriver driver, Logger log) {
        
        log = Logger.getLogger(SetUp.class);
        PropertyConfigurator.configure("log4j.properties");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("disable-infobars");
        
        driver = new ChromeDriver(options);
        
        log.info("Driver has initialized");
        driver.manage().window().maximize();
        log.info("Browser has maximized");
        return driver;
        
    }
    
    public static LogInPage openLogInPage(WebDriver driver, Logger log) {
        
        log = Logger.getLogger("SetUp");
        PropertyConfigurator.configure("log4j.properties");
        
        driver.get("https://tenant.staging-9mentors.com/#/login");
        
        log.info("Log In page has opened");
        return PageFactory.initElements(driver, LogInPage.class);
        
    }
    
}
