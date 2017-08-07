package pages.message;

import domen.MessageClass;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.Page;
import pages.conclusion.ConclusionPage;

/**
 *
 * @author Dejan
 */

public class SendMessagePage extends Page {
    
    @FindBy(how = How.TAG_NAME, using = "textarea")
    private WebElement message;
    
    @FindBy(how = How.CLASS_NAME, using = "icon-send")
    private WebElement sendCommand;
    
    @FindBy(how = How.CLASS_NAME, using = "button--no-radius")
    private static WebElement createConBtn;

    public MessageClass sendMessage(WebDriver driver, Logger log) {
        
        log = Logger.getLogger(SendMessagePage.class);
        PropertyConfigurator.configure("log4j.properties");
        
        MessageClass m = new MessageClass();
        log.info("m object of MessageClass class has instanced");
        
        String msg = sendText(driver, message);
        m.setMessage(msg);
        log.info("Message for sending is: " + msg);
        
        clickOnElement(driver, sendCommand);
        log.info("Message has sent");
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(SendMessagePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
        return m;
        
    }
    
    public static ConclusionPage createNewConclusion(WebDriver driver, Logger log) {
        
        log = Logger.getLogger(SendMessagePage.class);
        PropertyConfigurator.configure("log4j.properties");
    
        WebElement elem = waitForElement(driver, createConBtn);
        elem.click();
        
        return PageFactory.initElements(driver, ConclusionPage.class);
    
    }
    
}
