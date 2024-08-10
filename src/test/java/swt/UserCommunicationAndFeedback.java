package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.FeedBack;
import sweetsys.MessagingClass;
import sweetsys.SweetProject;
import static org.junit.Assert.*;

public class UserCommunicationAndFeedback {

SweetProject s;

    public UserCommunicationAndFeedback( ) {
        s=new SweetProject();
    }

    @Test
    @Given("User navigates to the Messaging section")
    public void userNavigatesToTheMessagingSection() {
        MessagingClass messege=new MessagingClass();
        assertFalse(messege.in);
    }



    @Test
    @Then("User can send messages to store owners or suppliers")
    public void userCanSendMessagesToStoreOwnersOrSuppliers() {
MessagingClass m=new MessagingClass();
assertFalse(m.messageDone);
    }







    @Test
    @Given("User navigates to the Feedback section")
    public void userNavigatesToTheFeedbackSection() {
        FeedBack feed=new FeedBack();
        assertFalse(feed.in);
    }






    @Test
    @Then("User submits feedback")
    public void userSubmitsFeedback() {
        FeedBack feed=new FeedBack();
        assertFalse(feed.Done);
    }



}
