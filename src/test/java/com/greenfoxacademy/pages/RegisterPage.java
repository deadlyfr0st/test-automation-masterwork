package com.greenfoxacademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

  public RegisterPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "name")
  WebElement usernameField;

  @FindBy(id = "email")
  WebElement emailField;

  @FindBy(id = "pass1")
  WebElement newPassword;

  @FindBy(id = "pass2")
  WebElement confirmPassword;

  @FindBy(className = "form-check-input")
  WebElement privacyCheckbox;

  @FindBy(linkText = "Privacy Policy")
  WebElement privacyLink;

  @FindBy(xpath = "//*[@id=\"editItemForm1\"]/div[3]/div/input")
  WebElement registerButton;

  @FindBy(className = "invalid-feedback")
  WebElement failMessage;

  @FindBy(tagName = "fieldset")
  WebElement successMessage;

  public WebElement getUsernameField() {
    return usernameField;
  }

  public WebElement getEmailField() {
    return emailField;
  }

  public WebElement getNewPassword() {
    return newPassword;
  }

  public WebElement getConfirmPassword() {
    return confirmPassword;
  }

  public WebElement getPrivacyCheckbox() {
    return privacyCheckbox;
  }

  public WebElement getPrivacyLink() {
    return privacyLink;
  }

  public WebElement getRegisterButton() {
    return registerButton;
  }

  public WebElement getFailMessage() {
    return failMessage;
  }

  public WebElement getSuccessMessage() {
    return successMessage;
  }

  public void open() {
    driver.get(baseURL + "tiki-register.php");
  }
}