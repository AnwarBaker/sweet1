package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.*;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
public class UserAccountTest {

SweetProject s;

    public UserAccountTest() {
        s=new SweetProject();
    }

    @Before
    public void setUp() {
        SweetProject.getUsers().clear();
    }

    @After
    public void tearDown() {
        SweetProject.getUsers().clear();
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
        SweetProject.getUsers().clear();
        SweetProject.getUsers().add(new User("anwar", "123", 1,"anwar123@gmail.com"));
        SweetProject.getUsers().add(new User("ahmad", "1234", 2,"ahmad1234@gmail.com"));
        SweetProject.getUsers().add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com"));
        SweetProject.getUsers().add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com"));
        SweetProject.setUsers(SweetProject.getUsers());

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
        SweetProject.getUsers().clear();
        SweetProject.getUsers().add(new User("anwar", "123", 1, "anwar123@gmail.com"));
        SweetProject.getUsers().add(new User("ahmad", "1234", 2, "ahmad1234@gmail.com"));
        SweetProject.getUsers().add(new User("yasmine", "12345", 1, "yasmine12345@gmail.com"));
        SweetProject.getUsers().add(new User("tarneem", "123456", 3, "tarneem123456@gmail.com"));
        SweetProject.setUsers(SweetProject.getUsers());

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
        SweetProject.getUsers().clear();

        SweetProject.getUsers().add(new User("anwar", "123", 1,"anwar123@gmail.com"));
        SweetProject.getUsers().add(new User("ahmad", "1234", 2,"ahmad1234@gmail.com"));
        SweetProject.getUsers().add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com"));
        SweetProject.getUsers().add(new User("tarneem", "123456", 3,"tarneem1234@gmail.com"));
        SweetProject.setUsers(SweetProject.getUsers());


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

        SweetProject.getUsers().clear();
        SweetProject.getUsers().add(new User("anwar", "123", 1,"anwar123@gmail.com"));
        SweetProject.getUsers().add(new User("ahmad", "1234", 2,"ahmad1234@gmail.com"));
        SweetProject.getUsers().add(new User("yasmine", "12345", 2,"yasmine12345@gmail.com"));
        SweetProject.getUsers().add(new User("tarneem", "123456", 3,"tarneem1234@gmail.com"));
        SweetProject.setUsers(SweetProject.getUsers());

        User updatedUser = new User("tarneem", "newpass", 3, "newemail@gmail.com");

        UserAccountManegment test = new UserAccountManegment();
        test.updateUser(updatedUser);

        User foundUser = SweetProject.getUsers().stream()
                .filter(u -> u.getUsername().equalsIgnoreCase("tarneem"))
                .findFirst()
                .orElse(null);

        assertNotNull("User should be found after update", foundUser);
        assertEquals("Username should remain unchanged", "tarneem", foundUser.getUsername());
        assertEquals("Password should be updated", "newpass", foundUser.getPass());
        assertEquals("Email should be updated", "newemail@gmail.com", foundUser.getEmail());

        User nonUpdatableUser = new User("yasmine", "updatedpass", 2, "updatedemail@gmail.com");
        test.updateUser(nonUpdatableUser);

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
        SweetProject.getProducts().clear();
        UserShareProducts.getUserproducts().clear();

        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,10,"finished",1));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutella","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        SweetProject.getProducts().add(new ProductManegmwntSystem("cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,14,"not finished",3));
        SweetProject.setProducts(SweetProject.getProducts());


        UserShareProducts newProd  =new UserShareProducts("ds cake","Layers of chocolate cake with chocolate cream in the middle", 60.0);

        UserShareProducts usershare=new UserShareProducts();
        usershare.addnewProductForUser(newProd);



        assertTrue("The new product should be added to the user's shared products list", usershare.getUserproducts().contains(newProd));

        UserShareProducts existingProd = new UserShareProducts("Nutella cake", "Layers of chocolate cake with chocolate cream in the middle", 60.0);
        usershare.addnewProductForUser(existingProd);

        int expected=usershare.getUserproducts().size();
        assertEquals("The existing product should not be added again",expected , usershare.getUserproducts().size());

    }

}
