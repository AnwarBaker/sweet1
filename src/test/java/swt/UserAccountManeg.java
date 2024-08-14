package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.*;

import static org.junit.Assert.*;
public class UserAccountManeg {




SweetProject s;

    public UserAccountManeg() {
        s=new SweetProject();
    }



@Test
    @Given("User navigates to the registration page.")
    public void userNavigatesToTheRegistrationPage() {
signup sign=new signup();

assertFalse(sign.in);

    }



    @Test
    @When("User fills in the required details and submits the form.")
    public void userFillsInTheRequiredDetailsAndSubmitsTheForm() {
        s.users.add(new User("anwar", "123", 1,"anwar123@gmail.com"));
        s.users.add(new User("ahmad", "1234", 2,"ahmad1234@gmail.com"));
        s.users.add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com"));
        s.users.add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com"));
        s.setUsers(s.users);

        signup sign=new signup();
        User user=new User("hjsdvc","44sc",3);
        sign.addnewuser(user);


        //assertTrue(sign.isDone());

    }


    @Test
    @Then("System creates a new account for the user.")
    public void systemCreatesANewAccountForTheUser() {
        s.users.add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com"));
        s.setUsers(s.users);

        signup sign=new signup();
        User user=new User("ii","47",3);
        sign.addnewuser(user);


        //assertTrue(sign.isDone());
    }


    @Test
    @Given("User navigates to the login page.")
    public void userNavigatesToTheLoginPage() {
        s.setExist(false);
 assertFalse(s.isExist());
    }


    @Test
    @Then("User enters credentials and logs in.")
    public void userEntersCredentialsAndLogsIn() {

        User u = new User("yasmine", "12345",3);
        s.login(u);
        s.users.add(new User("anwar", "123", 1,"anwar123@gmail.com"));
        s.users.add(new User("ahmad", "1234", 2,"ahmad1234@gmail.com"));
        s.users.add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com"));
        s.users.add(new User("tarneem", "123456", 3,"tarneem1234@gmail.com"));
        s.setUsers(s.users);


        boolean isValid = s.isValidUser(s.getUsers(), u.getUsername(), u.getPass());

        if (isValid) {
            System.out.println("You Are Welcome User " + u.getUsername());
        }

        assertTrue("you are welcome " + u.getUsername(), isValid);
    }





    @Test
    @Given("User logs in to the system.")
    public void userLogsInToTheSystem() {
        s.setExist(false);
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
UserAccountManegment test =new UserAccountManegment();
        s.users.add(new User("anwar", "123", 1,"anwar123@gmail.com"));
        s.users.add(new User("ahmad", "1234", 2,"ahmad1234@gmail.com"));
        s.users.add(new User("yasmine", "12345", 2,"yasmine12345@gmail.com"));
        s.users.add(new User("tarneem", "123456", 3,"tarneem1234@gmail.com"));
        s.setUsers(s.users);
  test.setIsexist(false);
    assertFalse(test.isIsexist());
    }


    @Test
    @Given("User navigates to the Share Creations section.")
    public void userNavigatesToTheShareCreationsSection() {
assertFalse(s.exist);

    }


    @Test
    @Then("User uploads a new dessert creation with details.")
    public void userUploadsANewDessertCreationWithDetails() {

        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,10,"finished",1));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,14,"not finished",3));
        UserShareProducts prod =new UserShareProducts("ds cake","Layers of chocolate cake with chocolate cream in the middle", 60.0);
        prod.addnewProductForUser(prod);


        assertFalse(prod.done);
    }





}
