package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by gpodmorina on 04.08.2017.
 */
public class ChangePasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangePassword() throws IOException, MessagingException {
    app.goTo().MyAccountPage();
    app.goTo().ManageUsersPage();
    Users before = app.db().users();
    String modifiedUserName = null;
    String modifiedUserEmail = null;
    for (UserData u: before) {
      if (u.getUsername() != "administrator") {
        modifiedUserName = u.getUsername();
        modifiedUserEmail = u.getEmail();

      }
    }
    app.selectUser(modifiedUserName);
    app.resetPassword();
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, modifiedUserEmail);
    app.registration().finish(confirmationLink, "passwordnew");
    assertTrue(app.newSession().login(modifiedUserName, "passwordnew"));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }


  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
