package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by gpodmorina on 22.06.2017.
 */
public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver wd) {
    super (wd);
  }

  public void groupPage() {
    click(By.linkText("groups"));
  }

  public void Homepage() {
    click(By.linkText("home"));
  }
}
