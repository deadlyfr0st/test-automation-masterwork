package com.greenfoxacademy;

import static org.assertj.core.api.Assertions.assertThat;

import com.greenfoxacademy.pages.EditPage;
import com.greenfoxacademy.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class TC10_DataDeleteTest extends BaseTest {
  HomePage homePage;
  EditPage editPage;

  @BeforeEach
  public void setup() {
    editPage = PageFactory.initElements(driver, EditPage.class);
    homePage = PageFactory.initElements(driver, HomePage.class);
    homePage.open();
    homePage.getLoginDropDown().click();
    homePage.getLoginUsernameField().sendKeys("WikiTest");
    homePage.getLoginPasswordField().sendKeys("Jelszo01");
    homePage.getLoginButton().click();
  }

  @Test
  @DisplayName("TC_10-DataDelete")
  @Feature("Data Delete")
  @Description("Delete the previously modified Wiki Page content")
  public void shouldModifyWikiPageContent() {
    String wikiPageName = "WikiTest-page";
    homePage.getQuickEditField().sendKeys(wikiPageName);
    homePage.getQuickEditCreateButton().click();
    editPage.getEditField().clear();
    editPage.getSaveButton().click();
    String actualBackgroundColor = editPage
        .getSuccessMessage().getCssValue("background-color");
    String expectedBackgroundColor = "rgba(212, 237, 218, 1)";
    assertThat(actualBackgroundColor).isEqualTo(expectedBackgroundColor);
    assertThat(editPage.getSuccessMessageText().getText()).contains("To review the changes");
    assertThat(editPage.getWikiPageContentText().getText()).isEqualTo("");
    homePage.logout();
  }
}