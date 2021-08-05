package com.greenfoxacademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LastChangesPage extends BasePage {

  public LastChangesPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@id=\"mod-menuleft1\"]/ul/li[3]/a")
  WebElement systemModuleWikiDropdown;

  @FindBy(xpath = "//*[@id=\"menu_option32\"]/li[2]/a")
  WebElement lastChangesLink;

  @FindBy(xpath = "//*[@id=\"col1\"]/ul/li[3]/a")
  WebElement secondPageLink;

  @FindBy(xpath = "//*[@id=\"col1\"]/ul/li[3]/span/span")
  WebElement secondPageLinkForAssert;

  public WebElement getSystemModuleWikiDropdown() {
    return systemModuleWikiDropdown;
  }

  public WebElement getLastChangesLink() {
    return lastChangesLink;
  }

  public WebElement getSecondPageLink() {
    return secondPageLink;
  }

  public WebElement getSecondPageLinkForAssert() {
    return secondPageLinkForAssert;
  }
}