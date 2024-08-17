package swt;

import io.cucumber.java.en.*;
import org.junit.*;
import sweetsys.SweetProject;
import sweetsys.Sys;
import sweetsys.User;

import static org.junit.Assert.*;

public class LoginTest {


     SweetProject s;


    public LoginTest() {
        s = new SweetProject();
    }

@Test
    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
      assertFalse(s.isIs_login());

    }

    @Test
    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {


        User u = new User("yasmine", "12345");
        s.login(u);
        SweetProject.users.add(new User("anwar", "123", 1,"anwar123@gmail.com","Jenin"));
        SweetProject.users.add(new User("ahmad", "1234", 3,"ahmad1234@gmail.com","Nablus"));
        SweetProject.users.add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com","nablus"));
        SweetProject.users.add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com","Jenin"));
        SweetProject.setUsers(SweetProject.users);


        boolean isValid = s.isValidUser(SweetProject.getUsers(), u.getUsername(), u.getPass());

        if (isValid) {
            System.out.println("you are welcome " + u.getUsername());
        }

        assertTrue("you are welcome " + u.getUsername(), isValid);



    }



    @Test
    @When("the user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {

        SweetProject.users.add(new User("anwar", "123", 1,"anwar123@gmail.com","Jenin"));
        SweetProject.users.add(new User("ahmad", "1234", 3,"ahmad1234@gmail.com","Nablus"));
        SweetProject.users.add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com","nablus"));
        SweetProject.users.add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com","Jenin"));
        SweetProject.setUsers(SweetProject.users);


        boolean isValidInvalidUser = s.isValidUser(SweetProject.getUsers(), "invalidUser", "12345");
        assertFalse("The user should be invalid due to incorrect username", isValidInvalidUser);


        boolean isValidInvalidPass = s.isValidUser(SweetProject.getUsers(), "yasmine", "wrongPass");
        assertFalse("The user should be invalid due to incorrect password", isValidInvalidPass);



    }





    @Test
    @Then("the user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard() {

assertFalse(Sys.isB());

    }


    @Test
    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        User u = new User("fadi", "123548");
        s.login(u);
        SweetProject.users.add(new User("anwar", "123", 1,"anwar123@gmail.com","Jenin"));
        SweetProject.users.add(new User("ahmad", "1234", 3,"ahmad1234@gmail.com","Nablus"));
        SweetProject.users.add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com","nablus"));
        SweetProject.users.add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com","Jenin"));
        SweetProject.setUsers(SweetProject.users);


        boolean isValid = s.isValidUser(SweetProject.getUsers(), u.getUsername(), u.getPass());


        assertFalse("Invalid email or password",isValid);
        String expectedErrorMessage = "Invalid email or password";
        String actualErrorMessage = s.getErrorMessage();

        assertEquals("The error message should be displayed", expectedErrorMessage, actualErrorMessage);



}
}
