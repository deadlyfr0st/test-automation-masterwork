package com.greenfoxacademy;

import static org.assertj.core.api.Assertions.assertThat;

import com.greenfoxacademy.pages.HomePage;
import com.greenfoxacademy.pages.LastChangesPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC06_PaginationTest extends BaseTest {
  LastChangesPage lastChangesPage;

  @BeforeEach
  public void setup() {
    lastChangesPage = PageFactory.initElements(driver, LastChangesPage.class);
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    homePage.open();
    homePage.getLoginDropDown().click();
    homePage.getLoginUsernameField().sendKeys("TiborTest");
    homePage.getLoginPasswordField().sendKeys("Jelszo01");
    homePage.getLoginButton().click();
  }

  @Test
  @DisplayName("TC_06-Pagination")
  @Feature("Data Listing")
  @Description("List the last changes and navigate to the next page")
  public void shouldNavigateToNextPage() {
    lastChangesPage.getSystemModuleWikiDropdown().click();
    wait.until(ExpectedConditions.elementToBeClickable(lastChangesPage.getLastChangesLink()));
    lastChangesPage.getLastChangesLink().click();
    wait.until(ExpectedConditions.elementToBeClickable(lastChangesPage.getSecondPageLink()));
    lastChangesPage.getSecondPageLink().click();
    assertThat(lastChangesPage.getSecondPageLinkForAssert().getText()).isEqualTo("(current)");
  }
}