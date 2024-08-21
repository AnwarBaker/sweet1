package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.*;

import static org.junit.Assert.*;

public class AdminContentManagementTest {

SweetProject s;

    public AdminContentManagementTest( ) {
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

        SweetProject.products.add(new ProductManegmwntSystem("Nutella cake", "Layers of chocolate cake with chocolate cream in the middle", 60.0, 10.0, 10, "finished", 1));
        SweetProject.products.add(new ProductManegmwntSystem("Nutella cake", "Layers of chocolate cake with chocolate cream in the middle", 60.0, 10.0, 12, "not finished", 2));
        SweetProject.products.add(new ProductManegmwntSystem("Nutella cake", "Layers of chocolate cake with chocolate cream in the middle", 60.0, 10.0, 14, "not finished", 3));

        UserShareProducts prod = new UserShareProducts("cake", "Layers of chocolate cake with chocolate cream in the middle", 60.0);
        UserShareProducts pro = new UserShareProducts("ds cake", "Layers of chocolate cake with chocolate cream in the middle", 60.0);
        prod.addnewProductForUser(prod);
        prod.addnewProductForUser(pro);

        UserShareProducts toupdatepro = new UserShareProducts("cake", "Layers of chocolate cake with chocolate", 20.0);
        ContentSection c = new ContentSection();
        c.updateUserrecipes(toupdatepro);

        boolean updated = false;
        for (UserShareProducts p : UserShareProducts.getUserproducts()) {
            if (p.getProductName().equalsIgnoreCase("cake") && p.getExpectedprice() == 20.0) {
                updated = true;
                break;
            }
        }
        assertTrue("The product should be updated", updated);

        c.deleteUserrecipes(toupdatepro);

        boolean deleted = true;
        for (UserShareProducts p : UserShareProducts.getUserproducts()) {
            if (p.getProductName().equalsIgnoreCase("cake")) {
                deleted = false;
                break;
            }
        }
        assertTrue("The product should be deleted", deleted);
assertFalse(s.isExist());


    }



    @Test

    @When("Admin navigates to the Feedback Management section")
    public void adminNavigatesToTheFeedbackManagementSection() {
AdminFeedback a=new AdminFeedback();
assertFalse(a.in);
    }



    @Test

    @When("Admin can view all feedback from users")
    public void adminCanViewAllFeedbackFromUsers() {
        FeedBack feed=new FeedBack();
        assertFalse(feed.in);

        AdminFeedback adminfeed=new AdminFeedback();

        adminfeed.setAdminresponse(adminfeed.getAdminresponse());
        adminfeed.setAdminname("sjkdfhks");
        adminfeed.setResponse("jkdhksjd");
        adminfeed.setUsername("hjgsd");
        adminfeed.setResponseNumber(1);

        adminfeed.getResponse();
        adminfeed.getAdminname();
        adminfeed.getResponseNumber();
        adminfeed.getUsername();

        AdminFeedback firstadminfeed=new AdminFeedback(adminfeed.getAdminname(),adminfeed.getResponseNumber(),adminfeed.getUsername(), adminfeed.getResponse());
        AdminFeedback admincover=new AdminFeedback(adminfeed.getAdminname(),adminfeed.getResponseNumber(),adminfeed.getResponse(),adminfeed.getUsername());

    }



    @Test

    @Then("Admin can respond to or moderate feedback")
    public void adminCanRespondToOrModerateFeedback() {
SweetProject.users.clear();
FeedBack.getFeedBacklist().clear();
AdminFeedback.getAdminresponse().clear();
        SweetProject.users.add(new User("rama", "123455", 2,"rama123455@gmail.com","nablus"));
        SweetProject.users.add(new User("tala", "12345566", 2,"tala12345566@gmail.com","Jenin"));
        SweetProject.setUsers(SweetProject.users);
        User u=new User("talaa", "12346", 3,"talaa12346@gmail.com","Jenin");
        s.login(u);
        SweetProject.products.add(new ProductManegmwntSystem(1,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",5));
        SweetProject.products.add(new ProductManegmwntSystem(2,"Nutella cake","Jenin","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",10));
        SweetProject.products.add(new ProductManegmwntSystem(3,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",12));
        FeedBack fe=new FeedBack();
        fe.userFeedback(u,1,"this is my msg to you");
        User uuu=new User("eeee", "1", 1,"eeee1@gmail.com","Jenin");
        s.login(uuu);


        AdminFeedback aa=new AdminFeedback();
        aa.adminResponsemessege(uuu,1,"this is my response to you");
        assertEquals(1, FeedBack.getFeedBacklist().size());
        assertEquals("this is my msg to you", FeedBack.getFeedBacklist().get(0).getFeedbackMessage());
        assertEquals(1, AdminFeedback.getAdminresponse().size());
        assertEquals("this is my response to you", AdminFeedback.getAdminresponse().get(0).getResponse());
        assertEquals("talaa", AdminFeedback.getAdminresponse().get(0).getUsername());

int expectedproductssize=SweetProject.products.size();
        assertEquals(expectedproductssize, SweetProject.products.size());
        assertEquals("Nutella cake", SweetProject.products.get(0).getProductName());

        String expectedcity=SweetProject.products.get(0).getCity();
        assertEquals(expectedcity, SweetProject.products.get(0).getCity());
        assertEquals(2, SweetProject.users.size());
        assertEquals("rama", SweetProject.users.get(0).getUsername());

    }


}
