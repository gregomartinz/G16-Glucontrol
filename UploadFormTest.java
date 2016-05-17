package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UploadFormTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://1-dot-glucosa-g16.appspot.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUploadForm() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("Subida")).click();
    driver.findElement(By.id("glucosa")).clear();
    driver.findElement(By.id("glucosa")).sendKeys("150");
    driver.findElement(By.name("glucosaComida")).clear();
    driver.findElement(By.name("glucosaComida")).sendKeys("150");
    driver.findElement(By.name("glucosaCena")).clear();
    driver.findElement(By.name("glucosaCena")).sendKeys("150");
    driver.findElement(By.id("fecha_dia")).clear();
    driver.findElement(By.id("fecha_dia")).sendKeys("17");
    new Select(driver.findElement(By.id("fecha_mes"))).selectByVisibleText("Mayo");
    driver.findElement(By.id("fecha_ano")).clear();
    driver.findElement(By.id("fecha_ano")).sendKeys("2016");
    driver.findElement(By.cssSelector("input.submit-button")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
