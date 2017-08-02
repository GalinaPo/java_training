package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.testng.Assert.assertEquals;

/**
 * Created by gpodmorina on 01.08.2017.
 */
public class DeleteContactFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().isEmpty()) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testDeleteContactFromGroup() {
    app.goTo().Homepage();
    Contacts before = app.db().contacts();
    Groups beforeG = app.db().groups();
    ContactData modContact = before.iterator().next();
    Groups addGroupsBefore = modContact.getGroups();
    if (addGroupsBefore.size() == 0){
      app.goTo().Homepage();
      app.contact().create(new ContactData().withFirstname("Galina").withLastname("Podmorina"));

      int maxId = 0;
      ContactData modifiedcontact = null;
      for(ContactData cd: before) {
        if(cd.getId() > maxId) {
          maxId = cd.getId();
          modifiedcontact = cd;
        }
      }
      app.contact().addToGroupContact(modifiedcontact);
    }
    Contacts after = app.db().contacts();
    ContactData delContact = null;
    for(ContactData c: after) {
      if(c.getGroups().size() > 0) {
        delContact = c;
      }
    }
    app.contact().deleteFromGroupContact(delContact);
    Groups groupfromdel = delContact.getGroups();
    boolean contactWasDeleted = false;
    if (groupfromdel == null) {
      contactWasDeleted = true;
    }
    Assert.assertTrue(contactWasDeleted);

  }
}
