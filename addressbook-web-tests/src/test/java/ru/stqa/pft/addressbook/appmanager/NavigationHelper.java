package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by gpodmorina on 22.06.2017.
 */
public class NavigationHelper extends HelperBase{

  public NavigationHelper(FirefoxDriver wd) {
    super (wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void gotoHomepage() {
    click(By.linkText("home"));
  }
}
