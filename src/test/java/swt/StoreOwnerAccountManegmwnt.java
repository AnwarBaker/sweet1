package swt;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Test;
import sweetsys.StoreOwnerAccountManegment;
import sweetsys.SweetProject;
import static org.junit.Assert.*;

public class StoreOwnerAccountManegmwnt {


    SweetProject s;

    public StoreOwnerAccountManegmwnt() {
        s=new SweetProject();
    }

    @Test
    @When("Store owner navigates to the Account Management section")
    public void storeOwnerNavigatesToTheAccountManagementSection() {
        StoreOwnerAccountManegment store =new StoreOwnerAccountManegment();
        assertFalse(store.isCome());
    }


    @Test
    @Then("Store owner can update account details")
    public void storeOwnerCanUpdateAccountDetails() {
     StoreOwnerAccountManegment store =new StoreOwnerAccountManegment();
     assertFalse(store.updated);

    }
}
