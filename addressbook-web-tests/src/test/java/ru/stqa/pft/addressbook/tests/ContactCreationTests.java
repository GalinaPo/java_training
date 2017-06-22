package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.initContactCreation();
    app.fillContactForm(new ContactData("Galina", "Podmorina", "+79315555555", "shine19@bk.ru"));
    app.submitContactCreation();
    app.returnToHomePage();
  }

}
