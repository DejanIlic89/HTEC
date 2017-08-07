package user_profile;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LogInPage;
import pages.profile.ProfilePage;
import setup.SetUp;

/**
 *
 * @author Dejan
 */

public class UserProfile {
    
    private static WebDriver driver;
    private static Logger log = null;
    private static LogInPage logInPage;
    private static HomePage homePage;
    
    private ProfilePage profilePage;
    
    @BeforeClass
    public static void setUpClass() {
        driver = SetUp.initializeDriver(driver, log);
        logInPage = SetUp.openLogInPage(driver, log);
        homePage = logInPage.clickOnLogin(driver, log);
        
        log = Logger.getLogger(UserProfile.class);
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
        profilePage = homePage.openUserProfile(driver, log);
        log.info("Profile Page has opened");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSetUpProfile() {
        
        profilePage.setPicture(driver, log);
        
        profilePage.setBirthDate(driver, log);

    }
}
