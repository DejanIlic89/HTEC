package pages.group;

import domen.HelpClass;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Page;
import pages.message.SendMessagePage;

/**
 *
 * @author Dejan
 */

public class GroupPage extends Page {
    
    @FindBy(how = How.NAME, using = "groupName")
    private WebElement setMainTopic;
    
    @FindBy(how = How.TAG_NAME, using = "textarea")
    private WebElement addDescription;
    
    @FindBy(how = How.CLASS_NAME, using = "ladda-label")
    private WebElement create;
    
    @FindBy(how = How.CLASS_NAME, using = "icon-chat-main")
    private WebElement openMainTopic;
    
    HelpClass hc = new HelpClass();
    
    public SendMessagePage createNewTopic(WebDriver driver, Logger log) {
        
        log = Logger.getLogger(GroupPage.class);
        PropertyConfigurator.configure("log4j.properties");
        
        String topicName = sendText(driver, setMainTopic);
        hc.setTopicTitle(topicName);
        log.info("Topic title has set");
        
        sendText(driver, addDescription);
        log.info("Description has set");
        
        WebElement createBtn = waitForElement(driver, create);
        createBtn.click();
        log.info("Topic has created");
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(GroupPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.className("icon-chat-main")));
                
        WebElement openTopic = waitForVisibilityOfElement(driver, openMainTopic);
        openTopic.click();
        log.info("Enter the topic");
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(GroupPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return PageFactory.initElements(driver, SendMessagePage.class);
    
    }
    
}
