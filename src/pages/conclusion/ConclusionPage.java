package pages.conclusion;

import data.FillData;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
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
        
        WebElement cont = driver.findElement(By.tagName("md-select-menu"));
        List<WebElement> items = cont.findElements(By.tagName("md-option"));
        WebElement major = items.get(0);
        
        //sledeca akcija se ne izvrsava iz meni nepoznatog razloga
        
        major.click();
        
        log.info("Voting type has chosen");
        
    }
    
}
