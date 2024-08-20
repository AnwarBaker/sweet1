package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserCommunicationAndFeedbackTest {

SweetProject s;

    public UserCommunicationAndFeedbackTest( ) {
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

        SweetProject.users.add(new User("anwar", "123", 1, "anwar123@gmail.com", "Jenin"));
        SweetProject.users.add(new User("ahmad", "1234", 3, "ahmad1234@gmail.com", "Nablus"));
        SweetProject.users.add(new User("yasmine", "12345", 1, "yasmine12345@gmail.com", "nablus"));
        SweetProject.users.add(new User("tarneem", "123456", 3, "tarneem123456@gmail.com", "Jenin"));
        SweetProject.users.add(new User("rama", "123455", 2, "rama123455@gmail.com", "nablus"));
        SweetProject.users.add(new User("tala", "12345566", 2, "tala12345566@gmail.com", "Jenin"));
        SweetProject.setUsers(SweetProject.users);
        User u = new User("talaa", "12346", 3, "talaa12346@gmail.com", "Jenin");
        s.login(u);
        assertNotNull(u.getCity());
        MessagingClass m = new MessagingClass();
        m.usersendMessages(u, "hello store owner");
        assertEquals(1, MessagingClass.getMessages().size());
        MessagingClass sentMessage = MessagingClass.getMessages().get(0);
        assertEquals("talaa", sentMessage.getSendername());
        assertEquals("tala", sentMessage.getRecivername());
        assertEquals("hello store owner", sentMessage.getMeessage());

        String expectedString = "{Message='hello store owner', ReciverName='tala', SenderName='talaa'}\n";
        assertEquals(expectedString, sentMessage.toString());

        m.setSendername("talaa");
        m.getSendername();
        m.setRecivername("tala");
        m.getRecivername();
        m.setMeessage("ssdfk");
        m.getMeessage();
        MessagingClass.getMessages();

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
        SweetProject s =new SweetProject();
        SweetProject.users.add(new User("rama", "123455", 2,"rama123455@gmail.com","nablus"));
        SweetProject.users.add(new User("tala", "12345566", 2,"tala12345566@gmail.com","Jenin"));
        SweetProject.setUsers(SweetProject.users);
        User u=new User("talaa", "12346", 3,"talaa12346@gmail.com","Jenin");
        s.login(u);
        SweetProject.products.add(new ProductManegmwntSystem(1,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",5));
        SweetProject.products.add(new ProductManegmwntSystem(2,"Nutella cake","Jenin","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",10));
        SweetProject.products.add(new ProductManegmwntSystem(3,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",12));
        FeedBack fe=new FeedBack();
        fe.userFeedback(u,1,"hi this is my feedback");
        fe.showFeedback();


        FeedBack feedback = new FeedBack("Great product!", 1, "tala", "Nutella cake");
        feedback.setFeedbackMessage("Excellent product!");
        feedback.setFeednumber(2);
        feedback.setSenderName("talaa");
        feedback.setProductName("Nutella cake");

        assertEquals("Excellent product!", feedback.getFeedbackMessage());
        assertEquals(2, feedback.getFeednumber());
        assertEquals("talaa", feedback.getSenderName());
        assertEquals("Nutella cake", feedback.getProductName());

        ArrayList<FeedBack> feedbackList = new ArrayList<>();
        feedbackList.add(feedback);
        FeedBack.setFeedBacklist(feedbackList);

        assertEquals(feedbackList, FeedBack.getFeedBacklist());

        FeedBack defaultFeedback = new FeedBack();
        assertNotNull(defaultFeedback);

        FeedBack feedbackWithSender = new FeedBack("Good service", "tala");
        assertEquals("Good service", feedbackWithSender.getFeedbackMessage());
        assertEquals("tala", feedbackWithSender.getSenderName());

        FeedBack feedbackWithMessage = new FeedBack("Nice product");
        assertEquals("Nice product", feedbackWithMessage.getFeedbackMessage());

        FeedBack fullFeedback = new FeedBack("Amazing taste", "tala", "Nutella cake");
        assertEquals("Amazing taste", fullFeedback.getFeedbackMessage());
        assertEquals("tala", fullFeedback.getSenderName());
        assertEquals("Nutella cake", fullFeedback.getProductName());
    }



}
