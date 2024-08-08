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

        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,10,"finished",1));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,14,"not finished",3));
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
