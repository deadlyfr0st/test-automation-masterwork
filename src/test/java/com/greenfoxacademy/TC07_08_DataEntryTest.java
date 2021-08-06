package com.greenfoxacademy;

import static org.assertj.core.api.Assertions.assertThat;

import com.greenfoxacademy.pages.EditPage;
import com.greenfoxacademy.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.PageFactory;

public class TC07_08_DataEntryTest extends BaseTest {
  HomePage homePage;
  EditPage editPage;

  @BeforeEach
  public void setup() {
    editPage = PageFactory.initElements(driver, EditPage.class);
    homePage = PageFactory.initElements(driver, HomePage.class);
    homePage.open();
    homePage.getLoginDropDown().click();
    homePage.getLoginUsernameField().sendKeys("FinalUser0");
    homePage.getLoginPasswordField().sendKeys("Jelszo01");
    homePage.getLoginButton().click();
  }

  @Test
  @DisplayName("TC_07-NewDataEntry")
  @Feature("Data Entry")
  @Description("Create a new Wiki Page with some content after login")
  public void shouldCreateNewWikiPage() {
    String wikiPageName = "FinalUser0-page";
    String content = "This is my first page on this site.";
    homePage.getQuickEditField().sendKeys(wikiPageName);
    homePage.getQuickEditCreateButton().click();
    editPage.getEditField().sendKeys(content);
    editPage.getSaveButton().click();
    String actualBackgroundColor = editPage
        .getSuccessMessage().getCssValue("background-color");
    String expectedBackgroundColor = "rgba(212, 237, 218, 1)";
    assertThat(actualBackgroundColor).isEqualTo(expectedBackgroundColor);
    homePage.logout();
  }

  @ParameterizedTest
  @DisplayName("TC_08-RepetitiveDataEntry")
  @CsvFileSource(resources = "wikiPages.csv", numLinesToSkip = 1)
  @Feature("Data Entry")
  @Description("After login, create new Wiki Pages with some content from wikiPages.csv file. " +
      "Log out after every new page.")
  public void shouldCreateThreeNewWikiPage(String pageName, String content) {
    homePage.getQuickEditField().sendKeys(pageName);
    homePage.getQuickEditCreateButton().click();
    editPage.getEditField().sendKeys(content);
    editPage.getSaveButton().click();
    String actualBackgroundColor = editPage
        .getSuccessMessage().getCssValue("background-color");
    String expectedBackgroundColor = "rgba(212, 237, 218, 1)";
    assertThat(actualBackgroundColor).isEqualTo(expectedBackgroundColor);
    homePage.logout();
  }
}