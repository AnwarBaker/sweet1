package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.MessagingClass;
import sweetsys.StoreOwnerMessages;
import sweetsys.SweetProject;
import sweetsys.User;

import java.util.List;

import static org.junit.Assert.*;

public class StoreOwnerCommunicationTest {

    SweetProject s;

    public StoreOwnerCommunicationTest( ) {
        s = new SweetProject();
    }


    @Test
    @When("Store owner navigates to the Messaging section")
    public void storeOwnerNavigatesToTheMessagingSection() {
        StoreOwnerMessages store =new StoreOwnerMessages();
        assertFalse(store.in);
    }


    @Test
    @When("Store owner can send messages to users or suppliers")
    public void storeOwnerCanSendMessagesToUsersOrSuppliers() {

        SweetProject.users.clear();
        MessagingClass mmmm = new MessagingClass();
        mmmm.getMessages().clear();
        StoreOwnerMessages sto = new StoreOwnerMessages();
        sto.getMessegaesList().clear();

        SweetProject.users.add(new User("anwar", "123", 1, "anwar123@gmail.com", "Jenin"));
        SweetProject.users.add(new User("ahmad", "1234", 3, "ahmad1234@gmail.com", "Nablus"));
        SweetProject.users.add(new User("yasmine", "12345", 1, "yasmine12345@gmail.com", "nablus"));
        SweetProject.users.add(new User("tarneem", "123456", 3, "tarneem123456@gmail.com", "Jenin"));
        SweetProject.users.add(new User("rama", "145", 3, "rama145@gmail.com", "nablus"));
        SweetProject.users.add(new User("tala", "1", 3, "tala1@gmail.com", "Jenin"));
        User user = new User("talal", "12", 2, "talal12@gmail.com", "Jenin");
        s.login(user);
        SweetProject.setUsers(SweetProject.users);

        User uu = new User("talaall", "1234666", 2, "talaall1234666@gmail.com", "Jenin");
        StoreOwnerMessages stor = new StoreOwnerMessages();
        stor.storeOwnersendmesseges(uu, "this is my response", "rama");

        assertEquals(1, StoreOwnerMessages.getMessegaesList().size());
        StoreOwnerMessages sentMessage = StoreOwnerMessages.getMessegaesList().get(0);
        assertEquals("talaall", sentMessage.getStorownerename());
        assertEquals("rama", sentMessage.getUsername());
        assertEquals("this is my response", sentMessage.getMessage());
        assertEquals(1, sentMessage.getMessagenum());
        StoreOwnerMessages storeowner = new StoreOwnerMessages();
        storeowner.setMessage("kldf");
        storeowner.setStorownerename("kjsnhf");
        storeowner.setMessagenum(2);
        storeowner.setUsername("skld");
        storeowner.getMessage();
        storeowner.getStorownerename();
        storeowner.getMessagenum();
        storeowner.getUsername();
        StoreOwnerMessages.setMessegaesList(StoreOwnerMessages.getMessegaesList());
        StoreOwnerMessages.getMessegaesList();
        StoreOwnerMessages storeownerr = new StoreOwnerMessages(storeowner.getStorownerename(),storeowner.getUsername(),storeowner.getMessage(),storeowner.getMessagenum());


    }


    @Test
    @Then("Store owner can receive messages and respond to them")
    public void storeOwnerCanReceiveMessagesAndRespondToThem() {


SweetProject.users.clear();

        SweetProject.users.add(new User("anwar", "123", 1, "anwar123@gmail.com", "Jenin"));
        SweetProject.users.add(new User("ahmad", "1234", 3, "ahmad1234@gmail.com", "Nablus"));
        SweetProject.users.add(new User("yasmine", "12345", 1, "yasmine12345@gmail.com", "nablus"));
        SweetProject.users.add(new User("tarneem", "123456", 3, "tarneem123456@gmail.com", "Jenin"));
        SweetProject.users.add(new User("rama", "145", 3, "rama145@gmail.com", "nablus"));
        SweetProject.users.add(new User("tala", "1", 3, "tala1@gmail.com", "Jenin"));
        User user = new User("talal", "12", 2, "talal12@gmail.com", "Jenin");
        s.login(user);
        SweetProject.setUsers(SweetProject.users);

        User u = new User("talaa", "12346", 3, "talaa12346@gmail.com", "Jenin");
        s.login(u);
        MessagingClass mmm = new MessagingClass();
        mmm.getMessages().clear();

        mmm.usersendMessages(u, "hi im user talaa");

        User uu = new User("talaall", "1234666", 2, "talaall1234666@gmail.com", "Jenin");
        StoreOwnerMessages sto = new StoreOwnerMessages();
        sto.getMessegaesList().clear();
        sto.storeResponsemessege(uu, "talaa", "this is my response");

        List<StoreOwnerMessages> messagesList = sto.getMessegaesList();
        assertNotNull(messagesList);
        assertFalse(messagesList.isEmpty());

        StoreOwnerMessages lastMessage = messagesList.get(messagesList.size() - 1);

        assertEquals("talaall", lastMessage.getStorownerename());
        assertEquals("talaa", lastMessage.getUsername());
        assertEquals("this is my response", lastMessage.getMessage());
        assertEquals(messagesList.size(), lastMessage.getMessagenum());

        boolean messageFound = false;
        for (StoreOwnerMessages message : messagesList) {
            if (message.getStorownerename().equals("talaall") && message.getUsername().equals("talaa") && message.getMessage().equals("this is my response")) {
                messageFound = true;
                break;
            }
        }
        assertTrue(messageFound);


    }



}

