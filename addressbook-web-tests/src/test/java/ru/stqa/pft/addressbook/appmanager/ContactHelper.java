package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by gpodmorina on 22.06.2017.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("mobile"), contactData.getMobilephone());
    type(By.name("email"), contactData.getEmail());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void closeDeleteAlert() {
      wd.switchTo().alert().accept();
  }

  public void deleteSelectedContacts() {
      click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContact() {
      click(By.name("selected[]"));
  }
}
