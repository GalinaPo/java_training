package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by gpodmorina on 23.06.2017.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomepage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Galina", "Podmorina", "+79315555555", "shine19@bk.ru"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
