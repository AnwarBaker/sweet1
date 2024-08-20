package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.StoreOwnerMessages;
import sweetsys.SweetProject;
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
StoreOwnerMessages store =new StoreOwnerMessages();
assertFalse(store.in);
    }


    @Test
    @Then("Store owner can receive messages and respond to them")
    public void storeOwnerCanReceiveMessagesAndRespondToThem() {
        StoreOwnerMessages store =new StoreOwnerMessages();
        assertFalse(store.in);
    }



}
