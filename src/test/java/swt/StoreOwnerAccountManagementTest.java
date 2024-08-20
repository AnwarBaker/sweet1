package swt;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Test;
import sweetsys.StoreOwnerAccountManegment;
import sweetsys.SweetProject;
import sweetsys.User;

import static org.junit.Assert.*;

public class StoreOwnerAccountManagementTest {


    SweetProject s;

    public StoreOwnerAccountManagementTest() {
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

        SweetProject.users.clear();
        SweetProject.users.add(new User("anwar", "123", 1,"anwar123@gmail.com","Jenin"));
        SweetProject.users.add(new User("ahmad", "1234", 3,"ahmad1234@gmail.com","Nablus"));
        SweetProject.users.add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com","nablus"));
        SweetProject.users.add(new User("tarneem", "123456", 2,"tarneem123456@gmail.com","Jenin"));
        SweetProject.setUsers(SweetProject.users);
        User  updatedUser= new User("tarneem", "225511", 2, "tarneem225511@gmail.com", "Nablus");

        StoreOwnerAccountManegment store =new StoreOwnerAccountManegment();
        store.UpdateStoreOwnerAccount(updatedUser);

        User retrievedUser = SweetProject.getUsers().stream()
                .filter(u -> u.getUsername().equalsIgnoreCase("tarneem"))
                .findFirst()
                .orElse(null);

        assertNotNull("The user should still exist in the system", retrievedUser);
        assertEquals("The password should be updated", "225511", retrievedUser.getPass());
        assertEquals("The email should be updated", "tarneem225511@gmail.com", retrievedUser.getEmail());
        assertEquals("The city should be updated", "Nablus", retrievedUser.getCity());



    }
}
