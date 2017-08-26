package new_topic;

import domen.MessageClass;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LogInPage;
import pages.conclusion.ConclusionPage;
import pages.dashboard.DashboardPage;
import pages.group.GroupPage;
import pages.message.SendMessagePage;
import setup.SetUp;

/**
 *
 * @author Dejan
 */

public class NewTopic {
    
    private static WebDriver driver;
    private static Logger log = null;
    private static LogInPage logInPage;
    private static HomePage homePage;
    
    private GroupPage groupPage;
    private SendMessagePage sendMessage;
    private ConclusionPage conclusion;
    private MessageClass msgSent;
    private MessageClass msgWeb;
    
    @BeforeClass
    public static void setUpClass() {
        driver = SetUp.initializeDriver(driver, log);
        logInPage = SetUp.openLogInPage(driver, log);
        homePage = logInPage.clickOnLogin(driver, log);
        
        log = Logger.getLogger(NewTopic.class);
        PropertyConfigurator.configure("log4j.properties");
        
        log.info("Home Page has opened");
    }
    
    @AfterClass
    public static void tearDownClass() {
        homePage.logOut(driver, log);
        driver.quit();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testNewTopic() {
        
        log = Logger.getLogger(NewTopic.class);
        PropertyConfigurator.configure("log4j.properties");
        
        groupPage = homePage.createGroup(driver, log);
        
        sendMessage = groupPage.createNewTopic(driver, log);
        
        msgSent = sendMessage.sendMessage(driver, log);

        conclusion = SendMessagePage.createNewConclusion(driver, log);
        
        conclusion.createConclusion(driver, log);
        
        msgWeb = DashboardPage.getMessageFromWeb(driver, log);
        
        Assert.assertEquals(msgSent.getMessage(), msgWeb.getMessage());
        
        log.info("Assertion has finished");
        
    }
}
