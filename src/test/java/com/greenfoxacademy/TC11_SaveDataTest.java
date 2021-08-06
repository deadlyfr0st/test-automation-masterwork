package com.greenfoxacademy;

import static org.assertj.core.api.Assertions.assertThat;

import com.greenfoxacademy.pages.CommunityPage;
import com.greenfoxacademy.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class TC11_SaveDataTest extends BaseTest {
  HomePage homePage;
  CommunityPage communityPage;

  @BeforeEach
  public void setup() {
    communityPage = PageFactory.initElements(driver, CommunityPage.class);
    homePage = PageFactory.initElements(driver, HomePage.class);
    homePage.open();
    homePage.getLoginDropDown().click();
    homePage.getLoginUsernameField().sendKeys("FinalUser0");
    homePage.getLoginPasswordField().sendKeys("Jelszo01");
    homePage.getLoginButton().click();
  }

  @Test
  @DisplayName("TC_11-SaveDataToFile")
  @Feature("Data Save")
  @Description("Save By the numbers list elements to By-The-Numbers.txt")
  public void shouldSaveByTheNumbersListElementsToTxt() {
    communityPage.getAboutMenuLink().click();
    communityPage.getAboutMenuCommunityItemLink().click();
    communityPage.saveListElementsToTxt();
    homePage.logout();
    assertThat(driver.getCurrentUrl())
        .isEqualTo("http://test-automation-wiki2.greenfox.academy/tiki-index.php");
  }
}