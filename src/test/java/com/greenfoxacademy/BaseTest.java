package com.greenfoxacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
  protected WebDriver driver;
  protected WebDriverWait wait;
  private Properties properties;

  @BeforeAll
  void setupDriver() throws IOException {
    properties = new Properties();
    InputStream resourceAsStream = this.getClass().getResourceAsStream("/test.properties");
    properties.load(resourceAsStream);
    String browser = properties.getProperty("browser");

    if (browser.equals("chrome")) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    } else if (browser.equals("firefox")) {
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
    } else {
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
    }

    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, 5);
  }

  @AfterAll
  public void tearDown() {
    driver.quit();
  }
}