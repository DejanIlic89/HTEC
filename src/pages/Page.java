package pages;

import data.FillData;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Dejan
 */

public class Page {
    
    public static WebElement waitForElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        return targetElement;
    }
    
    public WebElement waitForElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }
    
    public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOf(element));
        return targetElement;
    }
    
    public void clickOnElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        targetElement.click();
    }
    
    public void chooseFile(WebDriver driver, WebElement element, String filePath) {
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        WebElement upload = waitForElement(driver, element);
        upload.click();
        
            try {
                Robot robot = new Robot();
                robot.setAutoDelay(2000);
                
                StringSelection ss = new StringSelection(filePath);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
                
                robot.setAutoDelay(1000);
                
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_V);
                
                robot.setAutoDelay(1000);
                
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            } catch (AWTException ex) {
                Logger.getLogger(Page.class.getName()).log(Level.SEVERE, null, ex);
            }
    }   
        
    public String sendText(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOf(element));
        targetElement.clear();
        String text = FillData.getRandomText();
        targetElement.sendKeys(text);
        return text;
    }
    
    public void sendPredefinedText(WebDriver driver, WebElement element, String string) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOf(element));
        targetElement.clear();
        String text = string;
        targetElement.sendKeys(text);
    }
    
}
