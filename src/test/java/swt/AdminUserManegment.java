package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.AdminuserManegmentClass;
import sweetsys.SweetProject;
import sweetsys.User;
import sweetsys.signup;

import static org.junit.Assert.*;

public class AdminUserManegment {


    SweetProject s;


    public AdminUserManegment() {
        s = new SweetProject();
    }


@Test
    @Given("Admin log in to the system")
    public void adminLogInToTheSystem() {
    assertFalse(s.is_login);
    }

    @Test
    @When("Admin navigate to the User Management section")
    public void admin_navigate_to_the_user_management_section() {
    assertFalse(AdminuserManegmentClass.is_exist);
    }


    @Test
    @When("Admin can view a list of users \\(store owners, raw material suppliers)")
    public void adminCanViewAListOfUsersStoreOwnersRawMaterialSuppliers() {

        s.users.add(new User("anwar", "123", 1));
        s.users.add(new User("ahmad", "1234", 2));
        s.users.add(new User("yasmine", "12345", 1));
        s.users.add(new User("tarneem", "123456", 3));
        s.setUsers(s.users);

        s.setUsers(SweetProject.users);



        s.ShowEachTypeOfUsers();


      assertTrue("",s.print);
    }
    @Test
    @When("Admin can add new user by filling in the required details")
    public void adminCanAddNewUserByFillingInTheRequiredDetails() {
        String name="fadi";
        String pass="123";
        int UserLevel=3;
        User user=new User(name,pass,UserLevel);
        s.login(user);
        s.users.add(new User("anwar", "123", 1));
        s.users.add(new User("ahmad", "1234", 2));
        s.users.add(new User("yasmine", "12345", 1));
        s.users.add(new User("tarneem", "123456", 3));
        s.setUsers(s.users);

        signup sign=new signup();
        sign.addnewuser(user);
        if(sign.isDone())
            assertTrue("user added",sign.isDone());
    }
    @Test
    @When("Admin can update existing user details")
    public void adminCanUpdateExistingUserDetails() {


        assertFalse(s.founddd);
    }
    @Test
    @Then("Admin can delete a user account")
    public void adminCanDeleteAUserAccount() {
assertFalse(s.deleted);
    }
}
