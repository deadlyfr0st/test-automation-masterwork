package com.greenfoxacademy;

import static org.assertj.core.api.Assertions.*;

import com.greenfoxacademy.pages.CommunityPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class TC05_DataListTest extends BaseTest {
  CommunityPage communityPage;

  @BeforeEach
  public void setup() {
    communityPage = PageFactory.initElements(driver, CommunityPage.class);
    communityPage.open();
  }

  @Test
  @DisplayName("TC_05-List")
  @Feature("Data Listing")
  @Description("Compare By the numbers list elements with the created list")
  public void byTheNumbersListElementsShouldEqualWithManuallyCreatedList() {
    communityPage.getAboutMenuLink().click();
    communityPage.getAboutMenuCommunityItemLink().click();
    List<String> expectedList = new ArrayList<>();
    expectedList.add("10+ years old");
    expectedList.add("40+ languages");
    expectedList.add("250+ code contributors (via CVS/SVN)");
    expectedList.add("1,500+ built-in features and preferences");
    expectedList.add("1,000+ wiki pages of documentation");
    expectedList.add("1,000,000+ downloads");
    expectedList.add("1,000,000+ lines of code, with a code commit every two hours (on average)");
    assertThat(communityPage.byTheNumbersRows()).isEqualTo(expectedList);
  }
}