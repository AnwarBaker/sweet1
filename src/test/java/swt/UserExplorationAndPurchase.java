package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.StoreClass;
import sweetsys.SweetProject;
import sweetsys.UserRecipes;

import static org.junit.Assert.*;

public class UserExplorationAndPurchase {

SweetProject s;

    public UserExplorationAndPurchase( ) {
        s=new SweetProject();
    }

    @Test
    @Given("User logs in to the system")
    public void userLogsInToTheSystem() {
       assertFalse(s.is_login);
    }


    @Test

    @Then("User can browse and search for dessert recipes")
    public void userCanBrowseAndSearchForDessertRecipes() {
        UserRecipes u=new UserRecipes();
assertFalse(u.search);
    }


    @Test
    @Given("User navigates to the Recipes section")
    public void userNavigatesToTheRecipesSection() {
        UserRecipes u=new UserRecipes();
        assertFalse(u.in);
    }


    @Test
    @When("User applies filters based on dietary needs or allergies")
    public void userAppliesFiltersBasedOnDietaryNeedsOrAllergies() {
        UserRecipes u=new UserRecipes();
assertFalse(u.found);
    }


    @Test
    @Then("System displays filtered recipes")
    public void systemDisplaysFilteredRecipes() {
        UserRecipes u=new UserRecipes();
        assertFalse(u.found);
    }


    @Test

    @Given("User navigates to the Store section")
    public void userNavigatesToTheStoreSection() {
StoreClass store =new StoreClass();
assertFalse(store.in);
    }



    @Test
    @When("User selects a dessert to purchase")
    public void userSelectsADessertToPurchase() {
        StoreClass store =new StoreClass();
        assertFalse(store.done);
    }


    @Test
    @Then("User completes the purchase process")
    public void userCompletesThePurchaseProcess() {
        StoreClass store =new StoreClass();
        assertFalse(store.done);
    }




}
