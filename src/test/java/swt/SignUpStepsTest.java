package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.SweetProject;
import sweetsys.User;
import sweetsys.Signup;

import static org.junit.Assert.*;

public class SignUpStepsTest {

SweetProject s;

    public SignUpStepsTest() {
        s = new SweetProject();
    }
@Test
    @Given("I am on the sign-up page")
    public void iAmOnTheSignUpPage() {
        Signup sign=new Signup();

    assertFalse(sign.isIn());

    }


    @Test
  @When("the user enters a valid signup data like")
  public void theUserEntersAValidSignupDataLike() {
       String name="check";
       String pass="1233";
       int userLevel=3;
      User user=new User(name,pass,userLevel);
      s.login(user);
        SweetProject.users.add(new User("anwar", "123", 1,"anwar123@gmail.com","Jenin"));
        SweetProject.users.add(new User("ahmad", "1234", 3,"ahmad1234@gmail.com","Nablus"));
        SweetProject.users.add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com","nablus"));
        SweetProject.users.add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com","Jenin"));
      SweetProject.setUsers(SweetProject.users);
      boolean test=s.isValidUser(SweetProject.getUsers(),user.getUsername(),user.getPass());
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
        int userLevel=3;
        User user=new User(name,pass,userLevel);
        s.login(user);
        SweetProject.users.add(new User("anwar", "123", 1,"anwar123@gmail.com","Jenin"));
        SweetProject.users.add(new User("ahmad", "1234", 3,"ahmad1234@gmail.com","Nablus"));
        SweetProject.users.add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com","nablus"));
        SweetProject.users.add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com","Jenin"));
        SweetProject.setUsers(SweetProject.users);

        Signup sign=new Signup();
        sign.addnewuser(user);

        boolean userAdded = s.isValidUser(SweetProject.getUsers(), user.getUsername(), user.getPass());
        assertTrue("The user should be added successfully", userAdded);

    }


    @Test
   @When("the user enters signup data of exist data like")
   public void theUserEntersSignupDataOfExistDataLike() {
        String name="anwar";
        String pass="123";
        int userLevel=1;
        User user=new User(name,pass,userLevel);
        s.login(user);
        SweetProject.users.add(new User("anwar", "123", 1,"anwar123@gmail.com","Jenin"));
        SweetProject.users.add(new User("ahmad", "1234", 3,"ahmad1234@gmail.com","Nablus"));
        SweetProject.users.add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com","nablus"));
        SweetProject.users.add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com","Jenin"));
        SweetProject.setUsers(SweetProject.users);
        boolean test=s.isValidUser(SweetProject.getUsers(),user.getUsername(),user.getPass());

        assertTrue(user.getUsername()+"\talready exists",test);
   }




    @Test
    @Then("the user should see a exist data message")
    public void theUserShouldSeeAExistDataMessage() {
        String name="anwar";
        String pass="123";
        int userLevel=1;
        User user=new User(name,pass,userLevel);
        s.login(user);
        SweetProject.users.add(new User("anwar", "123", 1,"anwar123@gmail.com","Jenin"));
        SweetProject.users.add(new User("ahmad", "1234", 3,"ahmad1234@gmail.com","Nablus"));
        SweetProject.users.add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com","nablus"));
        SweetProject.users.add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com","Jenin"));
        SweetProject.setUsers(SweetProject.users);
        boolean test=s.isValidUser(SweetProject.getUsers(),user.getUsername(),user.getPass());
       String expectedMessage="User Exists";
        assertTrue("Invalid email or password",test);
        String actualExistMessage = s.getExistdataMessage();
        assertEquals("the user should see a exist data message", expectedMessage, actualExistMessage);
    }


}
