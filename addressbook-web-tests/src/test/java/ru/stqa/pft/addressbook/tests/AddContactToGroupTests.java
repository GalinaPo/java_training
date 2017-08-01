package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by gpodmorina on 28.07.2017.
 */
public class AddContactToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().isEmpty()) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }


  @Test
  public void testAddContactToGroup() {
    app.goTo().Homepage();
    app.contact().create(new ContactData().withFirstname("Galina").withLastname("Podmorina"));
    Contacts before = app.db().contacts();

    int maxId = 0;
    ContactData modifiedcontact = null;
    for(ContactData cd: before) {
      if(cd.getId() > maxId) {
        maxId = cd.getId();
        modifiedcontact = cd;
      }
    }
    app.contact().addToGroupContact(modifiedcontact);
    Groups addedgroup = modifiedcontact.getGroups();
    boolean groupIsAdded = false;
    if (addedgroup != null) {
      groupIsAdded = true;
    }
    Assert.assertTrue(groupIsAdded);
  }
}
