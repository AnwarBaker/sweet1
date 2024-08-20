package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.*;

import static org.junit.Assert.*;

public class AdminContentManegment {

SweetProject s;

    public AdminContentManegment( ) {
        s =new SweetProject();
    }


    @Test
    @When("Admin navigates to the Content Management section")
    public void adminNavigatesToTheContentManagementSection() {
ContentSection i =new ContentSection();

assertFalse(i.in);

    }



    @Test

    @Then("Admin can add, update, or delete recipes and posts shared by users")
    public void adminCanAddUpdateOrDeleteRecipesAndPostsSharedByUsers() {
        ContentSection c=new ContentSection();

assertFalse(c.in);
    }



    @Test

    @When("Admin navigates to the Feedback Management section")
    public void adminNavigatesToTheFeedbackManagementSection() {
ContentSection c=new ContentSection();
        assertFalse(c.in);
    }



    @Test

    @When("Admin can view all feedback from users")
    public void adminCanViewAllFeedbackFromUsers() {
        FeedBack feed=new FeedBack();
        //assertFalse(feed.Done);
    }



    @Test

    @Then("Admin can respond to or moderate feedback")
    public void adminCanRespondToOrModerateFeedback() {
        AdminFeedback aa=new AdminFeedback();
//assertFalse(aa.Done);
    }


}
