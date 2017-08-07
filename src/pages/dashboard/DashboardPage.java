package pages.dashboard;

import domen.MessageClass;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Page;

/**
 *
 * @author Dejan
 */

public class DashboardPage extends Page {
        
    public static MessageClass getMessageFromWeb(WebDriver driver, Logger log) {
        
        log = Logger.getLogger(DashboardPage.class);
        PropertyConfigurator.configure("log4j.properties");
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dash = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#/home']")));
        dash.click();
        log.info("Dash has clicked - Home");
        
        new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(By.className("quote-wrap")));
    
        MessageClass msgFromWeb = new MessageClass();
        log.info("msgFromWeb object of MessageClass class has instanced");
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        WebElement parent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[5]/div/div[1]/div/div[1]/div[2]")));
        
        List<WebElement> list = parent.findElements(By.className("dashboard-container__content"));
        WebElement container = list.get(0);
        
        List<WebElement> ng = container.findElements(By.className("message-text"));
        String text = ng.get(0).findElement(By.className("ng-binding")).getText();
        log.info("Message on Web is: " + text);
        
        msgFromWeb.setMessage(text);
        log.info("Message has taken from web");
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return msgFromWeb;
    
    }
    
}
