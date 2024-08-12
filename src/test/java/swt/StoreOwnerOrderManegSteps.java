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



        OrderManegmentClass o=new OrderManegmentClass("cake",10,1.0,1,"done");
        OrderManegmentClass oo=new OrderManegmentClass();
        oo.orderlist.add(o);
        oo.setOrderlist(oo.orderlist);
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
