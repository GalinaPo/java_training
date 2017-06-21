package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    initContactCreation();
    fillContactForm(new ContactData("Galina", "Podmorina", "+79315555555", "shine19@bk.ru"));
    submitContactCreation();
    returnToHomePage();
  }

}
