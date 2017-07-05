package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomepage();
        if (! app.getContactHelper().isThereAContact()) {
          app.getContactHelper().createContact(new ContactData("Galina", "Podmorina", "+79315555555", "shine19@bk.ru"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().closeDeleteAlert();
        app.getContactHelper().returnToHomePage();
    }

}
