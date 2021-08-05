package com.greenfoxacademy.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommunityPage extends BasePage {

  public CommunityPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(linkText = "Home")
  WebElement homeMenuLink;

  @FindBy(linkText = "About")
  WebElement aboutMenuLink;

  @FindBy(linkText = "Section")
  WebElement sectionsMenuLink;

  @FindBy(linkText = "Community")
  WebElement aboutMenuCommunityItemLink;

  @FindBy(linkText = "Forums")
  WebElement sectionsMenuForumsItemLink;

  @FindBy(xpath = "//*[@id=\"page-data\"]/ul[1]/li")
  WebElement byTheNumbersUl;

  public WebElement getHomeMenuLink() {
    return homeMenuLink;
  }

  public WebElement getAboutMenuLink() {
    return aboutMenuLink;
  }

  public WebElement getSectionsMenuLink() {
    return sectionsMenuLink;
  }

  public WebElement getAboutMenuCommunityItemLink() {
    return aboutMenuCommunityItemLink;
  }

  public WebElement getSectionsMenuForumsItemLink() {
    return sectionsMenuForumsItemLink;
  }

  public WebElement getByTheNumbersUl() {
    return byTheNumbersUl;
  }

  public List<String> byTheNumbersRows() {
    List<WebElement> ulItems = driver.findElements(By.xpath("//*[@id=\"page-data\"]/ul[1]/li"));
    List<String> liItems = new ArrayList<>();
    for (WebElement ulItem : ulItems) {
      liItems.add(ulItem.getText());
    }
    return liItems;
  }

  public void open() {
    driver.get(baseURL + "tiki-index.php?page=HomePage");
  }
}