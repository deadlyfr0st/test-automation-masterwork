package com.greenfoxacademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

  public HomePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@id=\"mod-login_boxtop2\"]/div/button")
  WebElement loginDropDown;

  @FindBy(id = "login-user_1")
  WebElement loginUsernameField;

  @FindBy(id = "login-pass_1")
  WebElement loginPasswordField;

  @FindBy(xpath = "//*[@id=\"loginbox-1\"]/div[3]/button")
  WebElement loginButton;

  @FindBy(linkText = "Register")
  WebElement registerLink;

  @FindBy(xpath = "//*[@id=\"rbox_1\"]/div[2]")
  WebElement loginErrorMessage;

  public WebElement getLoginDropDown() {
    return loginDropDown;
  }

  public WebElement getLoginUsernameField() {
    return loginUsernameField;
  }

  public WebElement getLoginPasswordField() {
    return loginPasswordField;
  }

  public WebElement getLoginButton() {
    return loginButton;
  }

  public WebElement getRegisterLink() {
    return registerLink;
  }

  public WebElement getLoginErrorMessage() {
    return loginErrorMessage;
  }

  public void open() {
    driver.get(baseURL);
  }
}