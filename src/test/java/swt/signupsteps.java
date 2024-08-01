package swt;

import io.cucumber.java.en.*;
import sweetsys.SweetProject;
import sweetsys.signup;

import static org.junit.Assert.assertFalse;

public class signupsteps {

SweetProject s;

    public signupsteps(SweetProject s) {
        this.s = s;
    }

    @Given("I am on the sign-up page")
    public void iAmOnTheSignUpPage() {
        signup sign=new signup();
        assertFalse(sign.in);

    }

    @When("I enter a valid username")
    public void iEnterAValidUsername() {


    }

    @When("I enter a valid password")
    public void iEnterAValidPassword() {

    }

    @When("I enter a user level")
    public void iEnterAUserLevel() {

    }

    @Then("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {

    }



}
