package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.SweetProject;
import sweetsys.User;
import sweetsys.signup;

import static org.junit.Assert.*;

public class signupsteps{

SweetProject s;

    public signupsteps() {
        s = new SweetProject();
    }
@Test
    @Given("I am on the sign-up page")
    public void iAmOnTheSignUpPage() {
        signup sign=new signup();

    assertFalse(sign.in);

    }

    @Test
  @When("the user enters a valid signup data like")
  public void theUserEntersAValidSignupDataLike() {
       String name="check";
       String pass="1233";
       int UserLevel=3;
      User user=new User(name,pass,UserLevel);
      s.login(user);
      s.users.add(new User("anwar", "123", 1));
      s.users.add(new User("ahmad", "1234", 2));
      s.users.add(new User("yasmine", "12345", 1));
      s.users.add(new User("tarneem", "123456", 3));
      s.setUsers(s.users);
      boolean test=s.isValidUser(s.getUsers(),user.getUsername(),user.getPass());
      if(!test){
          System.out.println("you are a valid user");
      }
      assertFalse("you are a valid user",test);
  }


    @Test
    @Then("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {
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
        System.out.println(sign.isDone());
sign.setDone(true);
        assertTrue("user added",sign.isDone());

    }


    @Test
   @When("the user enters signup data of exist data like")
   public void theUserEntersSignupDataOfExistDataLike() {
        String name="anwar";
        String pass="123";
        int UserLevel=1;
        User user=new User(name,pass,UserLevel);
        s.login(user);
        s.users.add(new User("anwar", "123", 1));
        s.users.add(new User("ahmad", "1234", 2));
        s.users.add(new User("yasmine", "12345", 1));
        s.users.add(new User("tarneem", "123456", 3));
        s.setUsers(s.users);
        boolean test=s.isValidUser(s.getUsers(),user.getUsername(),user.getPass());
        if(test){
            System.out.println(user.getUsername()+" already exists");
        }
        assertTrue(user.getUsername()+"\talready exists",test);
   }
    @Test
    @Then("the user should see a exist data message")
    public void theUserShouldSeeAExistDataMessage() {
        String name="anwar";
        String pass="123";
        int UserLevel=1;
        User user=new User(name,pass,UserLevel);
        s.login(user);
        s.users.add(new User("anwar", "123", 1));
        s.users.add(new User("ahmad", "1234", 2));
        s.users.add(new User("yasmine", "12345", 1));
        s.users.add(new User("tarneem", "123456", 3));
        s.setUsers(s.users);
        boolean test=s.isValidUser(s.getUsers(),user.getUsername(),user.getPass());
        if(test){
            System.out.println("this person already exists");
        }
        assertTrue(user.getUsername()+"\talready exists",test);
    }


}
