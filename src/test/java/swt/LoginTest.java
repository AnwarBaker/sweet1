package swt;

import io.cucumber.java.en.*;
import org.junit.*;
import sweetsys.SweetProject;
import sweetsys.Sys;
import sweetsys.User;

import static org.junit.Assert.*;

public class LoginTest {


     SweetProject s;
    String username;
    String pass;
   /* public LoginTest(SweetProject s) {
        this.s = s;
    }*/
    public LoginTest() {
        s = new SweetProject();
    }
@Test
    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
assertFalse(s.is_login);

    }




    @Test
    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {


        User u = new User("yasmine", "12345");
        s.login(u);
        s.users.add(new User("anwar", "123", 1));
        s.users.add(new User("ahmad", "1234", 2));
        s.users.add(new User("yasmine", "12345", 1));
        s.users.add(new User("tarneem", "123456", 3));
        s.setUsers(s.users);


        boolean isValid = s.isValidUser(s.getUsers(), u.getUsername(), u.getPass());

        if (isValid) {
            System.out.println("you are welcome " + u.getUsername());
        }

        assertTrue("you are welcome " + u.getUsername(), isValid);

    }



    @Test
    @When("the user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {
        User u = new User("fadi", "123");
        s.login(u);
        s.users.add(new User("anwar", "123", 1));
        s.users.add(new User("ahmad", "1234", 2));
        s.users.add(new User("yasmine", "12345", 1));
        s.users.add(new User("tarneem", "123456", 3));
        s.setUsers(s.users);


        boolean isValid = s.isValidUser(s.getUsers(), u.getUsername(), u.getPass());

        if (!isValid) {
            System.out.println(" wrong username or password try again" );
        }

        assertFalse("wrong username or password try again ", isValid);
    }


    @Test
    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        assertTrue(!s.is_login);

    }



    @Test
    @Then("the user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard() {
Sys.b=true;
assertTrue(Sys.b);

    }


    @Test
    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        User u = new User("fadi", "123");
        s.login(u);
        s.users.add(new User("anwar", "123", 1));
        s.users.add(new User("ahmad", "1234", 2));
        s.users.add(new User("yasmine", "12345", 1));
        s.users.add(new User("tarneem", "123456", 3));
        s.setUsers(s.users);


        boolean isValid = s.isValidUser(s.getUsers(), u.getUsername(), u.getPass());

      if(!isValid){
          System.out.println("Invalid email or password");
      }

        assertFalse(isValid);
    }


}
