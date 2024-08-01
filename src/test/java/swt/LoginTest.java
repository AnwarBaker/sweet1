package swt;

import io.cucumber.java.en.*;
import sweetsys.SweetProject;

public class LoginTest {



     SweetProject s;

    public LoginTest(SweetProject s) {
        this.s = s;
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {

    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {

    }


    @When("the user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {

    }



    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {

    }




    @Then("the user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard() {

    }


    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {

    }


}
