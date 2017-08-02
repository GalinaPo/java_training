package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by gpodmorina on 22.06.2017.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
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
    attach(By.name("photo"), contactData.getPhoto());
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactForm(contact);
    submitContactModification();
    returnToHomePage();
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

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initContactModification(int index) {
    wd.findElements(By.cssSelector("td.center img[title='Edit']")).get(index).click();
  }

  public void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact);
    submitContactCreation();
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    closeDeleteAlert();
    returnToHomePage();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> tdElements = element.findElements(By.tagName("td"));
      String lastname = tdElements.get(1).getText();
      String firstname = tdElements.get(2).getText();
      int id = Integer.parseInt(tdElements.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String address = tdElements.get(3).getText();
      String allEmails = tdElements.get(4).getText();
      String allPhones = tdElements.get(5).getText();
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAddress(address)
              .withAllPhones(allPhones).withAllEmails(allEmails));
    }
    return contacts;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomephone(home).withMobilephone(mobile).withWorkphone(work).withAddress(address)
            .withEmail(email).withEmail2(email2).withEmail3(email3);
  }

  public void addToGroupContact(ContactData contact) {
    selectContactById(contact.getId());
    addToGroupSelectedContacts();
    returnToHomePage();
  }

  public void addToGroupSelectedContacts() {
    click(By.name("add"));
  }

  public void openGroupForDelete(int groupToSelect_id){
    wd.findElement(By.cssSelector("form#right option[value='" + groupToSelect_id + "']")).click();
  }

  public void deleteFromGroupContact(ContactData contact) {
    int groupToSelect_id = Integer.parseInt(wd.findElement(By.name("to_group")).getAttribute("value"));
    openGroupForDelete(groupToSelect_id);
    selectContactById(contact.getId());
    deleteFromGroupSelectedContacts();
  }

  public void deleteFromGroupSelectedContacts() {
    click(By.name("remove"));
  }
}
