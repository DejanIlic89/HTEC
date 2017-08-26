package pages.conclusion;

import data.FillData;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Page;

/**
 *
 * @author Dejan
 */

public class ConclusionPage extends Page {
    
    @FindBy(how = How.ID, using = "mceu_23")
    private WebElement parent;
    
    @FindBy(how = How.CLASS_NAME, using = "options-panel__options")
    private WebElement group;
	
	@FindBy(how = How.CLASS_NAME, using = "ladda-label")
    private WebElement propose;
    
    public void createConclusion(WebDriver driver, Logger log) {
        
        log = Logger.getLogger(ConclusionPage.class);
        PropertyConfigurator.configure("log4j.properties");
        
        WebElement paren = waitForVisibilityOfElement(driver, parent);
        WebElement frame = paren.findElement(By.id("ui-tinymce-1_ifr"));
    
        WebElement targetElement = driver.switchTo().frame(frame).findElement(By.tagName("body"));
        log.info("Driver has switched to iframe");
        targetElement.clear();
        targetElement.sendKeys(FillData.getRandomText());
        driver.switchTo().defaultContent();
        log.info("Driver is get backed to default content");
        
        WebElement groupParent = waitForVisibilityOfElement(driver, group);
        List<WebElement> list = groupParent.findElements(By.className("voting-duration"));
        list.get(1).click(); 
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(ConclusionPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByClassName(\"md-select-menu-container\")[2].getElementsByClassName(\"md-text\")[0].click()");
                
        log.info("Voting type has selected");
        
        WebElement propConclusion = waitForElement(driver, propose);
        propConclusion.click();
        
        log.info("The conclusion has made");
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(ConclusionPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
