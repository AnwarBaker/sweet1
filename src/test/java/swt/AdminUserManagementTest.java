package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.AdminerManagementClass;
import sweetsys.SweetProject;
import sweetsys.User;
import sweetsys.Signup;

import static org.junit.Assert.*;

public class AdminUserManagementTest {


    SweetProject s;


    public AdminUserManagementTest() {
        s = new SweetProject();
    }


@Test
    @Given("Admin log in to the system")
    public void adminLogInToTheSystem() {
    assertFalse(s.isExist());
    }

    @Test
    @When("Admin navigate to the User Management section")
    public void admin_navigate_to_the_user_management_section() {

    assertFalse(AdminerManagementClass.isIsExist());
    }


    @Test
    @When("Admin can view a list of users \\(store owners, raw material suppliers)")
    public void adminCanViewAListOfUsersStoreOwnersRawMaterialSuppliers() {
        SweetProject.getUsers().clear();
        SweetProject.getUsers().add(new User("anwar", "123", 1));
        SweetProject.getUsers().add(new User("ahmad", "1234", 2));
        SweetProject.getUsers().add(new User("yasmine", "12345", 1));
        SweetProject.getUsers().add(new User("tarneem", "123456", 3));
        SweetProject.setUsers(SweetProject.getUsers());

        SweetProject.setUsers(SweetProject.getUsers());



        s.showeachTypeofusers();
int adminexpectsize= SweetProject.getAdminArraylist().size();
        assertEquals(adminexpectsize, SweetProject.getAdminArraylist().size());
        assertTrue(SweetProject.getAdminArraylist().stream().anyMatch(u -> u.getUsername().equals("anwar")));
        assertTrue(SweetProject.getAdminArraylist().stream().anyMatch(u -> u.getUsername().equals("yasmine")));

int storesizeexpected=SweetProject.getStoreOwnerarraylist().size();
        assertEquals(storesizeexpected, SweetProject.getStoreOwnerarraylist().size());
        assertTrue(SweetProject.getStoreOwnerarraylist().stream().anyMatch(u -> u.getUsername().equals("ahmad")));

int userizeexpected=SweetProject.getUsersArraylist().size();
        assertEquals(userizeexpected, SweetProject.getUsersArraylist().size());
        assertTrue(SweetProject.getUsersArraylist().stream().anyMatch(u -> u.getUsername().equals("tarneem")));



        SweetProject.setAdminArraylist(SweetProject.getAdminArraylist());
        SweetProject.getAdminArraylist();

        SweetProject.setUsersArraylist(SweetProject.getUsersArraylist());
        SweetProject.getUsersArraylist();

        SweetProject.setStoreOwnerarraylist(SweetProject.getStoreOwnerarraylist());
        SweetProject.getStoreOwnerarraylist();

        SweetProject.setNablusbestselling(SweetProject.getNablusbestselling());
        SweetProject.getNablusbestselling();

        SweetProject.setJeninbestselling(SweetProject.getJeninbestselling());
        SweetProject.getJeninbestselling();

        SweetProject.setJeninUsers(SweetProject.getJeninUsers());
        SweetProject.getJeninUsers();

        SweetProject.setNablususers(SweetProject.getNablususers());
        SweetProject.getNablususers();

        SweetProject.setJeninprodcuts(SweetProject.getJeninprodcuts());
        SweetProject.getJeninprodcuts();

        SweetProject.setNablusProdcuts(SweetProject.getNablusProdcuts());
        SweetProject.getNablusProdcuts();

    }


    @Test
    @When("Admin can add new user by filling in the required details")
    public void adminCanAddNewUserByFillingInTheRequiredDetails() {
        String name = "fadi";
        String pass = "1234563";
        int userLevel = 3;
        User user = new User(name, pass, userLevel);

s.login(user);

        SweetProject.getUsers().clear();

        SweetProject.getUsers().add(new User("anwar", "123", 1, "anwar123@gmail.com", "Jenin"));
        SweetProject.getUsers().add(new User("ahmad", "1234", 3, "ahmad1234@gmail.com", "Nablus"));
        SweetProject.getUsers().add(new User("yasmine", "12345", 1, "yasmine12345@gmail.com", "Nablus"));
        SweetProject.getUsers().add(new User("tarneem", "123456", 3, "tarneem123456@gmail.com", "Jenin"));
        SweetProject.setUsers(SweetProject.getUsers());



        Signup sign = new Signup();
        sign.addnewuser(user);



        assertTrue("New user should be in UsersArrayList",s.isValidUser(SweetProject.getUsers(),name,pass));



    }




    @Test
    @When("Admin can update existing user details")
    public void adminCanUpdateExistingUserDetails() {
        SweetProject.getUsers().clear();
        SweetProject.getUsers().add(new User("anwar", "123", 1,"anwar123@gmail.com","Jenin"));
        SweetProject.getUsers().add(new User("ahmad", "1234", 3,"ahmad1234@gmail.com","Nablus"));
        SweetProject.getUsers().add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com","nablus"));
        SweetProject.getUsers().add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com","Jenin"));
        SweetProject.setUsers(SweetProject.getUsers());
        User  updatedUser= new User("anwar", "225", 1, "anwar225@gmail.com", "Nablus");

        s.update(updatedUser);

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
        s.update(nonExistentUser);
        boolean userExists = false;
        for (User user : SweetProject.getUsers()) {
            if (user.getUsername().equalsIgnoreCase("nonexistent")) {
                userExists = true;
                break;
            }
        }
        assertFalse(userExists);



    }





    @Test
    @Then("Admin can delete a user account")
    public void adminCanDeleteAUserAccount() {

        SweetProject.getUsers().clear();
        SweetProject.getUsers().add(new User("anwar", "123", 1, "anwar123@gmail.com", "Jenin"));
        SweetProject.getUsers().add(new User("ahmad", "1234", 3, "ahmad1234@gmail.com", "Nablus"));
        SweetProject.getUsers().add(new User("yasmine", "12345", 1, "yasmine12345@gmail.com", "Nablus"));
        SweetProject.getUsers().add(new User("tarneem", "123456", 2, "tarneem123456@gmail.com", "Jenin"));
        SweetProject.setUsers(SweetProject.getUsers());

        User userToDelete = new User("ahmad", "1234", 3, "ahmad1234@gmail.com", "Nablus");


        s.delete(userToDelete);

        boolean userDeleted = SweetProject.getUsers().stream()
                .noneMatch(u -> u.getUsername().equalsIgnoreCase(userToDelete.getUsername())
                        && u.getPass().equals(userToDelete.getPass()));


        assertTrue("The user should be deleted from the list", userDeleted);

    }
}
