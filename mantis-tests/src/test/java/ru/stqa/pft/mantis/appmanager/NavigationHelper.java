package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by gpodmorina on 04.08.2017.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void MyAccountPage() {
    wd.get(app.getProperty("web.baseUrl"));
    type(By.name("username"), "administrator");
    click(By.cssSelector("input[value='Войти']"));
    type(By.name("password"), "root");
    click(By.cssSelector("input[value='Войти']"));
  }

  public void ManageUsersPage() {
    wd.findElement(By.linkText("управление")).click();
    wd.findElement(By.linkText("Управление пользователями")).click();
  }
}
