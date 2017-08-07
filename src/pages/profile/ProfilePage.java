package pages.profile;

import java.io.File;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Page;

/**
 *
 * @author Dejan
 */

public class ProfilePage extends Page {
    
    @FindBy(how = How.ID, using = "step3")
    private WebElement editProfile;
    
    @FindBy(how = How.CLASS_NAME, using = "profile-image")
    private WebElement editPic;
    
    @FindBy(how = How.CLASS_NAME, using = "icon-photo-size")
    private WebElement selectPic;
    
    @FindBy(how = How.CLASS_NAME, using = "md-datepicker-button")
    private WebElement datePicker;
    
    @FindBy(how = How.XPATH, using = "//*[@id='profile-image-modal']/md-dialog-actions/button[2]")
    private WebElement upload;
    
    @FindBy(how = How.CLASS_NAME, using = "icon-confirm")
    private WebElement confirmEdit;
    
    public void setPicture(WebDriver driver, Logger log) {
        
        log = Logger.getLogger(ProfilePage.class);
        PropertyConfigurator.configure("log4j.properties");
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        clickOnElement(driver, editPic);
        log.info("Profile Image window has opened");
        
        File file = new File("pics\\Dejan.jpg");
        chooseFile(driver, selectPic, file.getAbsolutePath());
        
        clickOnElement(driver, upload);
        log.info("Picture has uploaded");
    
    }
    
    public void setBirthDate(WebDriver driver, Logger log) {
        
        log = Logger.getLogger(ProfilePage.class);
        PropertyConfigurator.configure("log4j.properties");
        
        new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(By.id("profile-image-modal")));
        clickOnElement(driver, editProfile);
        log.info("Edit profile button has clicked");
        
        clickOnElement(driver, datePicker);
        
        WebElement table = waitForElement(driver, By.className("md-calendar-scroll-mask"));
        WebElement today =  table.findElement(By.className("md-calendar-date-today"));
        today.click();
        log.info("Today date has chosen");
        
        new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(By.className("md-calendar-scroll-mask")));

        clickOnElement(driver, confirmEdit);
        log.info("Profile setup has performed");
    
    }
    
}
