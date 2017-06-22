package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomepage();
        app.selectContact();
        app.deleteSelectedContacts();
        app.closeDeleteAlert();
        app.returnToHomePage();
    }

}
