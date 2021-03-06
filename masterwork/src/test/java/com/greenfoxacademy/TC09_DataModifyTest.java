package com.greenfoxacademy;

import static org.assertj.core.api.Assertions.*;

import com.greenfoxacademy.pages.EditPage;
import com.greenfoxacademy.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class TC09_DataModifyTest extends BaseTest {
  HomePage homePage;
  EditPage editPage;

  @BeforeEach
  public void setup() {
    editPage = PageFactory.initElements(driver, EditPage.class);
    homePage = PageFactory.initElements(driver, HomePage.class);
    homePage.open();
    homePage.getLoginDropDown().click();
    homePage.getLoginUsernameField().sendKeys(userName);
    homePage.getLoginPasswordField().sendKeys(password);
    homePage.getLoginButton().click();
  }

  @Test
  @DisplayName("TC_09-DataModify")
  @Feature("Data Modify")
  @Description("Modify the previously created Wiki Page with specified content")
  public void shouldModifyWikiPageContent() {
    String content = "I modified the content.";
    homePage.getQuickEditField().sendKeys(wikiPageName);
    homePage.getQuickEditCreateButton().click();
    editPage.getEditField().clear();
    editPage.getEditField().sendKeys(content);
    editPage.getSaveButton().click();
    String actualBackgroundColor = editPage
        .getSuccessMessage().getCssValue("background-color");
    String expectedBackgroundColor = "rgba(212, 237, 218, 1)";
    assertThat(actualBackgroundColor).isEqualTo(expectedBackgroundColor);
    assertThat(editPage.getSuccessMessageText().getText()).contains("To review the changes");
    homePage.logout();
  }
}