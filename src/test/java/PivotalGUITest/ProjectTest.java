package PivotalGUITest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ProjectTest {
    private WebDriver driver;
    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.pivotaltracker.com/");
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("credentials_username")).sendKeys("mirkofer.122020@gmail.com");
        driver.findElement(By.name("action")).click();
        driver.findElement(By.id("credentials_password")).sendKeys("622Mirko###");
        driver.findElement(By.name("action")).click();
    }
    @AfterEach
    public void tearDown() {
        driver.get("https://www.pivotaltracker.com/projects");
        String ProjectName = driver.findElement(By.xpath("//div[@class='projects column'][1]/a")).getText();
        if("ProjectTest".equals(ProjectName)) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.findElement(By.linkText("Settings")).click();
            WebElement element = driver.findElement(By.id("delete_link"));
            js.executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            driver.findElement(By.id("confirm_delete")).click();
        }
        driver.quit();
    }
    @Test
    public void createProject() throws InterruptedException {
        driver.findElement(By.id("create-project-button")).click();
        driver.findElement(By.name("project_name")).click();
        driver.findElement(By.name("project_name")).sendKeys("ProjectTest");
        {
            WebElement element = driver.findElement(By.cssSelector(".tc-account-selector__header"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".tc-account-selector__list-header-owner"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.cssSelector(".tc-account-selector")).click();
        driver.findElement(By.cssSelector(".tc-account-selector__option-account:nth-child(1) .tc-account-selector__option-account-name")).click();
        driver.findElement(By.cssSelector(".tc-project-type-chooser__label:nth-child(3) > .tc-project-type-chooser__label-name")).click();
        driver.findElement(By.cssSelector(".pvXpn__Button--positive")).click();
        Thread.sleep(5000);
        driver.get("https://www.pivotaltracker.com/projects");
        String ProjectName = driver.findElement(By.xpath("//div[@class='projects column'][1]/a")).getText();
        assertEquals("ProjectTest", ProjectName);
    }
}
