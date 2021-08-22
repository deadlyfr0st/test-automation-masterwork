package com.greenfoxacademy.pages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

  @FindBy(linkText = "About")
  WebElement aboutMenuLink;

  @FindBy(linkText = "Community")
  WebElement aboutMenuCommunityItemLink;

  public WebElement getAboutMenuLink() {
    return aboutMenuLink;
  }

  public WebElement getAboutMenuCommunityItemLink() {
    return aboutMenuCommunityItemLink;
  }

  public List<String> byTheNumbersRows() {
    List<WebElement> ulItems = driver.findElements(By.xpath("//*[@id=\"page-data\"]/ul[1]/li"));
    List<String> liItems = new ArrayList<>();
    for (WebElement ulItem : ulItems) {
      liItems.add(ulItem.getText());
    }
    return liItems;
  }

  public static String targetPathString() {
    String fullPath = "src/test/resources/com/greenfoxacademy";
    String[] fullPathArray = fullPath.split("/");
    StringBuilder stringBuilder = new StringBuilder();
    for (String pathPiece : fullPathArray) {
      stringBuilder.append(pathPiece)
          .append(File.separator);
    }
    return stringBuilder.toString();
  }

  public void saveListElementsToTxt() {
    Path targetPath = Paths.get(targetPathString() + "By-The-Numbers.txt");
    try {
      Files.write(targetPath, byTheNumbersRows());
    } catch (IOException e) {
      System.err.println("Writing to file failed! File name: By-The-Numbers.txt");
    }
  }

  public void open() {
    driver.get(baseURL);
  }
}