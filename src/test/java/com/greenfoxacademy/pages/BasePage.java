package com.greenfoxacademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  String baseURL = "http://test-automation-wiki2.greenfox.academy/";
  WebDriver driver;
  WebDriverWait wait;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(this.driver, 5);
  }
}