package org.fundacionjala.pivotal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ProjectTest {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    
    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.pivotaltracker.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, 40, 500);
        webDriver.findElement(By.linkText("Log in")).click();
        webDriver.findElement(By.id("credentials_username")).sendKeys("mirkofer.122020@gmail.com");
        webDriver.findElement(By.name("action")).click();
        webDriver.findElement(By.id("credentials_password")).sendKeys("622Mirko###");
        webDriver.findElement(By.name("action")).click();
    }
    @AfterEach
    public void tearDown() {
        webDriver.get("https://www.pivotaltracker.com/projects");
        String ProjectName = webDriver.findElement(By.xpath("//div[@class='projects column'][1]/a")).getText();
        if("ProjectTest".equals(ProjectName)) {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            webDriver.findElement(By.linkText("Settings")).click();
            WebElement element = webDriver.findElement(By.id("delete_link"));
            js.executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            webDriver.findElement(By.id("confirm_delete")).click();
        }
        webDriver.quit();
    }
    @Test
    public void createProject() throws InterruptedException {
        webDriver.findElement(By.id("create-project-button")).click();
        webDriver.findElement(By.name("project_name")).click();
        webDriver.findElement(By.name("project_name")).sendKeys("ProjectTest");
        {
            WebElement element = webDriver.findElement(By.cssSelector(".tc-account-selector__header"));
            Actions builder = new Actions(webDriver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = webDriver.findElement(By.cssSelector(".tc-account-selector__list-header-owner"));
            Actions builder = new Actions(webDriver);
            builder.moveToElement(element).release().perform();
        }
        webDriver.findElement(By.cssSelector(".tc-account-selector")).click();
        webDriver.findElement(By.cssSelector(".tc-account-selector__option-account:nth-child(1) .tc-account-selector__option-account-name")).click();
        webDriver.findElement(By.cssSelector(".tc-project-type-chooser__label:nth-child(3) > .tc-project-type-chooser__label-name")).click();
        webDriver.findElement(By.cssSelector(".pvXpn__Button--positive")).click();
        Thread.sleep(5000);
        webDriver.get("https://www.pivotaltracker.com/projects");
        String ProjectName = webDriver.findElement(By.xpath("//div[@class='projects column'][1]/a")).getText();
        assertEquals("ProjectTest", ProjectName);
    }
}
