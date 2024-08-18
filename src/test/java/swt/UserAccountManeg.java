package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.*;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
public class UserAccountManeg {




SweetProject s;

    public UserAccountManeg() {
        s=new SweetProject();
    }

    @Before
    public void setUp() {
        SweetProject.users.clear();
    }

    @After
    public void tearDown() {
        SweetProject.users.clear();
    }


@Test
    @Given("User navigates to the registration page.")
    public void userNavigatesToTheRegistrationPage() {
Signup sign=new Signup();

assertFalse(sign.in);

    }



    @Test
    @When("User fills in the required details and submits the form.")
    public void userFillsInTheRequiredDetailsAndSubmitsTheForm() {
        SweetProject.users.clear();
        SweetProject.users.add(new User("anwar", "123", 1,"anwar123@gmail.com"));
        SweetProject.users.add(new User("ahmad", "1234", 2,"ahmad1234@gmail.com"));
        SweetProject.users.add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com"));
        SweetProject.users.add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com"));
        SweetProject.setUsers(SweetProject.users);

        Signup sign = new Signup();
        User newUser = new User("newuser", "password", 1);
        sign.addnewuserforuseronly(newUser);

        boolean userAdded = SweetProject.getUsers().stream()
                .anyMatch(u -> u.getUsername().equals("newuser") && u.getPass().equals("password") && u.getUserlevel() == 1);
        assertTrue(userAdded);

        User differentLevelUser = new User("differentlevel", "password", 3);
        sign.addnewuserforuseronly(differentLevelUser);

        boolean userNotAdded = SweetProject.getUsers().stream()
                .noneMatch(u -> u.getUsername().equals("differentlevel"));
        assertTrue(userNotAdded);

        User existingUser = new User("anwar", "123", 1);
        sign.addnewuserforuseronly(existingUser);

        int expectedSize = 5;
        assertEquals(expectedSize, SweetProject.getUsers().size());

    }



    @Test
    @Then("System creates a new account for the user.")
    public void systemCreatesANewAccountForTheUser() {
        SweetProject.users.clear();
        SweetProject.users.add(new User("anwar", "123", 1, "anwar123@gmail.com"));
        SweetProject.users.add(new User("ahmad", "1234", 2, "ahmad1234@gmail.com"));
        SweetProject.users.add(new User("yasmine", "12345", 1, "yasmine12345@gmail.com"));
        SweetProject.users.add(new User("tarneem", "123456", 3, "tarneem123456@gmail.com"));
        SweetProject.setUsers(SweetProject.users);

        Signup sign = new Signup();
        User newUser = new User("newuser", "password", 1);
        sign.addnewuserforuseronly(newUser);

        boolean userAdded = SweetProject.getUsers().stream()
                .anyMatch(u -> u.getUsername().equals("newuser") && u.getPass().equals("password") && u.getUserlevel() == 1);

        assertTrue("New user account should be created", userAdded);

        User existingUser = new User("anwar", "123", 1);
        sign.addnewuserforuseronly(existingUser);

        int expectedSize = 5;
        assertEquals("User list size should remain unchanged if user already exists", expectedSize, SweetProject.getUsers().size());

        User differentLevelUser = new User("anotheruser", "password", 3);
        sign.addnewuserforuseronly(differentLevelUser);

        boolean userNotAdded = SweetProject.getUsers().stream()
                .noneMatch(u -> u.getUsername().equals("anotheruser"));

        assertTrue("User should not be added if user level is not 1", userNotAdded);

    }


    @Test
    @Given("User navigates to the login page.")
    public void userNavigatesToTheLoginPage() {
 assertFalse(s.isExist());
    }


    @Test
    @Then("User enters credentials and logs in.")
    public void userEntersCredentialsAndLogsIn() {
        SweetProject.users.clear();

        SweetProject.users.add(new User("anwar", "123", 1,"anwar123@gmail.com"));
        SweetProject.users.add(new User("ahmad", "1234", 2,"ahmad1234@gmail.com"));
        SweetProject.users.add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com"));
        SweetProject.users.add(new User("tarneem", "123456", 3,"tarneem1234@gmail.com"));
        SweetProject.setUsers(SweetProject.users);


        User validUser = new User("yasmine", "12345", 1);
        s.login(validUser);
        boolean isValid = s.isValidUser(SweetProject.getUsers(), validUser.getUsername(), validUser.getPass());

        assertTrue("User should be able to log in with correct credentials", isValid);
        assertEquals("User Exists", s.getExistdataMessage());

        User invalidUser = new User("yasmine", "wrongpass", 1);
        boolean isInvalid = s.isValidUser(SweetProject.getUsers(), invalidUser.getUsername(), invalidUser.getPass());

        assertFalse("User should not be able to log in with incorrect credentials", isInvalid);
        assertEquals("Invalid email or password", s.getErrorMessage());
    }





    @Test
    @Given("User logs in to the system.")
    public void userLogsInToTheSystem() {

assertFalse(s.isExist());
    }


    @Test
    @When("User navigates to the Account Management section.")
    public void userNavigatesToTheAccountManagementSection() {
        UserAccountManegment in=new UserAccountManegment();
        assertFalse(in.exist);
    }


    @Test
    @Then("User can update personal information and account settings.")
    public void userCanUpdatePersonalInformationAndAccountSettings() {

        SweetProject.users.clear();
        SweetProject.users.add(new User("anwar", "123", 1,"anwar123@gmail.com"));
        SweetProject.users.add(new User("ahmad", "1234", 2,"ahmad1234@gmail.com"));
        SweetProject.users.add(new User("yasmine", "12345", 2,"yasmine12345@gmail.com"));
        SweetProject.users.add(new User("tarneem", "123456", 3,"tarneem1234@gmail.com"));
        SweetProject.setUsers(SweetProject.users);

        User updatedUser = new User("tarneem", "newpass", 3, "newemail@gmail.com");

        UserAccountManegment test = new UserAccountManegment();
        test.UpdateUser(updatedUser);

        User foundUser = SweetProject.getUsers().stream()
                .filter(u -> u.getUsername().equalsIgnoreCase("tarneem"))
                .findFirst()
                .orElse(null);

        assertNotNull("User should be found after update", foundUser);
        assertEquals("Username should remain unchanged", "tarneem", foundUser.getUsername());
        assertEquals("Password should be updated", "newpass", foundUser.getPass());
        assertEquals("Email should be updated", "newemail@gmail.com", foundUser.getEmail());

        User nonUpdatableUser = new User("yasmine", "updatedpass", 2, "updatedemail@gmail.com");
        test.UpdateUser(nonUpdatableUser);

        User unchangedUser = SweetProject.getUsers().stream()
                .filter(u -> u.getUsername().equalsIgnoreCase("yasmine"))
                .findFirst()
                .orElse(null);

        assertNotNull("User should be found after attempted update", unchangedUser);
        assertEquals("Password should remain unchanged", "12345", unchangedUser.getPass());
        assertEquals("Email should remain unchanged", "yasmine12345@gmail.com", unchangedUser.getEmail());


    }


    @Test
    @Given("User navigates to the Share Creations section.")
    public void userNavigatesToTheShareCreationsSection() {
assertFalse(s.isExist());

    }


    @Test
    @Then("User uploads a new dessert creation with details.")
    public void userUploadsANewDessertCreationWithDetails() {
        SweetProject.products.clear();
        SweetProject.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,10,"finished",1));
        SweetProject.products.add(new ProductManegmwntSystem("Nutella","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        SweetProject.products.add(new ProductManegmwntSystem("cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,14,"not finished",3));
        SweetProject.setProducts(SweetProject.products);


        UserShareProducts newProd  =new UserShareProducts("ds cake","Layers of chocolate cake with chocolate cream in the middle", 60.0);

        UserShareProducts usershare=new UserShareProducts();
        usershare.addnewProductForUser(newProd);



        assertTrue("The new product should be added to the user's shared products list", usershare.userproducts.contains(newProd));

        UserShareProducts existingProd = new UserShareProducts("Nutella cake", "Layers of chocolate cake with chocolate cream in the middle", 60.0);
        usershare.addnewProductForUser(existingProd);

        assertEquals("The existing product should not be added again", 1, usershare.userproducts.size());

    }

}
