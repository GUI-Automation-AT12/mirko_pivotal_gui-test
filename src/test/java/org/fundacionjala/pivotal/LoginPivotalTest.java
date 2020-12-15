package org.fundacionjala.pivotal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPivotalTest {

  private WebDriver driver;

  @BeforeEach
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
    driver = new FirefoxDriver();
  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void loginPivotal() {
    driver.get("https://www.pivotaltracker.com/");
    /*WebElement element = driver.findElement(By.cssSelector(".header__link-signin"));
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOf(element));
    element.click();
    a.header__link:nth-child(4)
    */
    driver.findElement(By.linkText("Log in")).click();
    driver.findElement(By.id("credentials_username")).sendKeys("mirkofer.122020@gmail.com");
    driver.findElement(By.name("action")).click();
    driver.findElement(By.id("credentials_password")).sendKeys("622Mirko###");
    driver.findElement(By.name("action")).click();
    driver.findElement(By.cssSelector(".tc_pull_right:nth-child(3) .zWDds__Button")).click();
    driver.findElement(By.xpath("//div[@class='Dropdown__options Dropdown__options--small']/div/div/a[1]")).click();
  //driver.findElement(By.xpath("/html/body/div[4]/header/div[1]/div/div/header/ul/li[3]/div/div/div[2]/div/div/a[1]")).click();
    String actual = driver.findElement(By.cssSelector("#general.card ul.rows.read li div")).getText();
    assertEquals(actual, "mirkofer122020");
    /*html.with_footer body.dashboards_page.Page--dashboard.js-focus-visible.scrimVisible div#main header#header_wrapper.header_wrapper_fixed div#shared_header.clearfix div.tc_tracker_header div header.tc_page_header.tc_page_header_version-ia ul li.tc_pull_right.tc_extra_wide div.Dropdown div.Dropdown__content.Dropdown--open div.Dropdown__options.Dropdown__options--small div div a.Dropdown__option.Dropdown__option--link
    html.with_footer body.dashboards_page.Page--dashboard.js-focus-visible.scrimVisible div#main header#header_wrapper.header_wrapper_fixed div#shared_header.clearfix div.tc_tracker_header div header.tc_page_header.tc_page_header_version-ia ul li.tc_pull_right.tc_extra_wide div.Dropdown div.Dropdown__content.Dropdown--open div.Dropdown__options.Dropdown__options--small div div a.Dropdown__option.Dropdown__option--link
            /html/body/div[4]/header/div[1]/div/div/header/ul/li[3]/div/div/div[2]/div/div/a[1]
            /html/body/div[4]/header/div[1]/div/div/header/ul/li[3]/div/div/div[2]/div/div/a[2]*/
  }

}
