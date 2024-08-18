package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.AdminerManagementClass;
import sweetsys.SweetProject;
import sweetsys.User;
import sweetsys.Signup;

import static org.junit.Assert.*;

public class AdminUserManegment {


    SweetProject s;


    public AdminUserManegment() {
        s = new SweetProject();
    }


@Test
    @Given("Admin log in to the system")
    public void adminLogInToTheSystem() {
    assertFalse(s.isIs_login());
    }

    @Test
    @When("Admin navigate to the User Management section")
    public void admin_navigate_to_the_user_management_section() {

    assertFalse(AdminerManagementClass.isIs_exist());
    }


    @Test
    @When("Admin can view a list of users \\(store owners, raw material suppliers)")
    public void adminCanViewAListOfUsersStoreOwnersRawMaterialSuppliers() {
        SweetProject.users.clear();
        SweetProject.users.add(new User("anwar", "123", 1));
        SweetProject.users.add(new User("ahmad", "1234", 2));
        SweetProject.users.add(new User("yasmine", "12345", 1));
        SweetProject.users.add(new User("tarneem", "123456", 3));
        SweetProject.setUsers(SweetProject.users);

        SweetProject.setUsers(SweetProject.users);



        s.ShowEachTypeOfUsers();

        assertEquals(2, SweetProject.getAdminArrayList().size());
        assertTrue(SweetProject.getAdminArrayList().stream().anyMatch(u -> u.getUsername().equals("anwar")));
        assertTrue(SweetProject.getAdminArrayList().stream().anyMatch(u -> u.getUsername().equals("yasmine")));


        assertEquals(1, SweetProject.getStoreOwnerArrayList().size());
        assertTrue(SweetProject.getStoreOwnerArrayList().stream().anyMatch(u -> u.getUsername().equals("ahmad")));


        assertEquals(1, SweetProject.getUsersArrayList().size());
        assertTrue(SweetProject.getUsersArrayList().stream().anyMatch(u -> u.getUsername().equals("tarneem")));


    }


    @Test
    @When("Admin can add new user by filling in the required details")
    public void adminCanAddNewUserByFillingInTheRequiredDetails() {
        String name = "fadi";
        String pass = "1234563";
        int userLevel = 3;
        User user = new User(name, pass, userLevel);

s.login(user);

        SweetProject.users.clear();

        SweetProject.users.add(new User("anwar", "123", 1, "anwar123@gmail.com", "Jenin"));
        SweetProject.users.add(new User("ahmad", "1234", 3, "ahmad1234@gmail.com", "Nablus"));
        SweetProject.users.add(new User("yasmine", "12345", 1, "yasmine12345@gmail.com", "Nablus"));
        SweetProject.users.add(new User("tarneem", "123456", 3, "tarneem123456@gmail.com", "Jenin"));
        SweetProject.setUsers(SweetProject.users);



        Signup sign = new Signup();
        sign.addnewuser(user);



        assertTrue("New user should be in UsersArrayList",s.isValidUser(SweetProject.getUsers(),name,pass));



    }




    @Test
    @When("Admin can update existing user details")
    public void adminCanUpdateExistingUserDetails() {
        SweetProject.users.clear();
        SweetProject.users.add(new User("anwar", "123", 1,"anwar123@gmail.com","Jenin"));
        SweetProject.users.add(new User("ahmad", "1234", 3,"ahmad1234@gmail.com","Nablus"));
        SweetProject.users.add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com","nablus"));
        SweetProject.users.add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com","Jenin"));
        SweetProject.setUsers(SweetProject.users);
        User  updatedUser= new User("anwar", "225", 1, "anwar225@gmail.com", "Nablus");

        s.Update(updatedUser);

        User retrievedUser = SweetProject.getUsers().stream()
                .filter(u -> u.getUsername().equalsIgnoreCase("anwar"))
                .findFirst()
                .orElse(null);


        System.out.println("Current:");
        SweetProject.getUsers().forEach(u -> System.out.println(u.getUsername() + " - " + u.getPass()));


        assertNotNull("The user should still exist in the system", retrievedUser);
        assertEquals("The password should be updated", "225", retrievedUser.getPass());
        assertEquals("The email should be updated", "anwar225@gmail.com", retrievedUser.getEmail());
        assertEquals("The city should be updated", "Nablus", retrievedUser.getCity());





        for (User user : SweetProject.getUsers()) {
            if (user.getUsername().equalsIgnoreCase("anwar")) {
                assertEquals("225", user.getPass());
                assertEquals("anwar225@gmail.com", user.getEmail());
                assertEquals("Nablus", user.getCity());
                break;
            }
        }


        User nonExistentUser = new User("nonexistent", "000", 0, "nonexistent@gmail.com", "Unknown");
        s.Update(nonExistentUser);
        boolean userExists = false;
        for (User user : SweetProject.users) {
            if (user.getUsername().equalsIgnoreCase("nonexistent")) {
                userExists = true;
                break;
            }
        }
        assertFalse(userExists);

        try {

        } catch (Exception e) {
        }

    }





    @Test
    @Then("Admin can delete a user account")
    public void adminCanDeleteAUserAccount() {

        SweetProject.users.clear();
        SweetProject.users.add(new User("anwar", "123", 1, "anwar123@gmail.com", "Jenin"));
        SweetProject.users.add(new User("ahmad", "1234", 3, "ahmad1234@gmail.com", "Nablus"));
        SweetProject.users.add(new User("yasmine", "12345", 1, "yasmine12345@gmail.com", "Nablus"));
        SweetProject.users.add(new User("tarneem", "123456", 2, "tarneem123456@gmail.com", "Jenin"));
        SweetProject.setUsers(SweetProject.users);

        User userToDelete = new User("ahmad", "1234", 3, "ahmad1234@gmail.com", "Nablus");


        s.Delete(userToDelete);

        boolean userDeleted = SweetProject.getUsers().stream()
                .noneMatch(u -> u.getUsername().equalsIgnoreCase(userToDelete.getUsername())
                        && u.getPass().equals(userToDelete.getPass()));


        assertTrue("The user should be deleted from the list", userDeleted);

    }
}
