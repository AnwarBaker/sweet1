package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.OrderManegmentClass;
import sweetsys.ProductManegmwntSystem;
import sweetsys.SalesReport;
import sweetsys.SweetProject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class StoreOwnerOrderManegSteps {

    SweetProject s;

    public StoreOwnerOrderManegSteps( ) {
        s =new SweetProject();
    }


    @Test
    @Given("Store owner navigates to the Order Management section.")
    public void storeOwnerNavigatesToTheOrderManagementSection() {
        OrderManegmentClass Order =new OrderManegmentClass();
   assertFalse(Order.in);
    }

    @Test
    @When("Store owner can view a list of orders")
    public void storeOwnerCanViewAListOfOrders() {
        OrderManegmentClass order =new OrderManegmentClass();


        s.products.add(new ProductManegmwntSystem(1,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",5));
        s.products.add(new ProductManegmwntSystem(2,"Nutella cake","Jenin","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",10));
        s.products.add(new ProductManegmwntSystem(3,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",12));

        s.setProducts(s.products);
        order.ShowOrders();
        assertFalse(order.isted);
    }

    @Test
    @Then("Store owner can update the status of each order")
    public void storeOwnerCanUpdateTheStatusOfEachOrder() {
        OrderManegmentClass order =new OrderManegmentClass();

        assertFalse(order.isUpdated);
    }


}
