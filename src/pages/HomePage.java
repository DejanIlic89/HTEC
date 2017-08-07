package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.group.GroupPage;
import pages.profile.ProfilePage;

/**
 *
 * @author Dejan
 */

public class HomePage extends Page {
    
    @FindBy(how = How.CLASS_NAME, using = "icon-chevron-down")
    private WebElement arrowDown;
    
    @FindBy(how = How.CSS, using = "a[href='#/profile/705a9a25-4f47-4dd5-b478-ce4dd1cb5467']")
    private WebElement userProfile;
    
    @FindBy(how = How.CSS, using = "a[href='#/group-create']")
    private WebElement createGroupBtn;
    
    @FindBy(how = How.CSS, using = "a[href='#/logout']")
    private WebElement loggingOut;
    
    public ProfilePage openUserProfile(WebDriver driver, Logger log) {
        
        log = Logger.getLogger(HomePage.class);
        PropertyConfigurator.configure("log4j.properties");
    
        clickOnElement(driver, arrowDown);
        log.info("Arrow button has clicked");
        
        clickOnElement(driver, userProfile);
        log.info("User profile field has clicked");
        
        return PageFactory.initElements(driver, ProfilePage.class);
        
    }
    
    public GroupPage createGroup(WebDriver driver, Logger log) {
        
        log = Logger.getLogger(HomePage.class);
        PropertyConfigurator.configure("log4j.properties");
    
        clickOnElement(driver, createGroupBtn);
        log.info("Group Page has opened");
        return PageFactory.initElements(driver, GroupPage.class);
        
    }
    
    public void logOut(WebDriver driver, Logger log) {
        
        log = Logger.getLogger(HomePage.class);
        PropertyConfigurator.configure("log4j.properties");
        
        clickOnElement(driver, arrowDown);
        log.info("Arrow button has clicked");
    
        clickOnElement(driver, loggingOut);
        log.info("Log Out has performed");
    
    }
    
}
