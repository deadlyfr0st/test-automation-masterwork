package com.greenfoxacademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPage extends BasePage {

  public EditPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "editwiki")
  WebElement editField;

  @FindBy(name = "save")
  WebElement saveButton;

  @FindBy(className = "alert-success")
  WebElement successMessage;

  @FindBy(className = "linktodiff")
  WebElement successMessageText;

  @FindBy(id = "page-data")
  WebElement wikiPageContentText;

  public WebElement getEditField() {
    return editField;
  }

  public WebElement getSaveButton() {
    return saveButton;
  }

  public WebElement getSuccessMessage() {
    return successMessage;
  }

  public WebElement getSuccessMessageText() {
    return successMessageText;
  }

  public WebElement getWikiPageContentText() {
    return wikiPageContentText;
  }
}