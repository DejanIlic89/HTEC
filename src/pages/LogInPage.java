package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Dejan
 */

public class LogInPage {
    
    @FindBy(how = How.NAME, using = "email")
    private WebElement email;
    
    @FindBy(how = How.NAME, using = "password")
    private WebElement password;
    
    @FindBy(how = How.NAME, using = "login")
    private WebElement logIn;
    
    public HomePage clickOnLogin(WebDriver driver, Logger log) {
        
        log = Logger.getLogger(LogInPage.class);
        PropertyConfigurator.configure("log4j.properties");
        
        email.sendKeys("dejan.ilic@mailinator.com");
        log.info("Email has entered");
        
        password.sendKeys("123123");
        log.info("Password has entered");
        
        logIn.click();
        log.info("LogIn has performed");
        
        return PageFactory.initElements(driver, HomePage.class);
        
    }
    
}
