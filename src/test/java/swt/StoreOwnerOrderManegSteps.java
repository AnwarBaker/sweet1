package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.OrderManegmentClass;

import sweetsys.SweetProject;

import static org.junit.Assert.*;



public class StoreOwnerOrderManegSteps {

    SweetProject s;

    public StoreOwnerOrderManegSteps( ) {
        s =new SweetProject();
    }


    @Test
    @Given("Store owner navigates to the Order Management section.")
    public void storeOwnerNavigatesToTheOrderManagementSection() {
        OrderManegmentClass order =new OrderManegmentClass();
   assertFalse(order.isIn());
    }

    @Test
    @When("Store owner can view a list of orders")
    public void storeOwnerCanViewAListOfOrders() {
        OrderManegmentClass order =new OrderManegmentClass();
        OrderManegmentClass.orderlist.clear();
        OrderManegmentClass.orderlist.add(new OrderManegmentClass("Pastry", 5, 0.5, 2, "In Progress"));
        OrderManegmentClass.orderlist.add(new OrderManegmentClass("cake",10,1.0,1,"done"));

        OrderManegmentClass.setOrderlist(OrderManegmentClass.orderlist);


        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));


        order.ShowOrders();



        String expectedOutput = "Orders{name='Pastry', price=5.0, OrderNUM=2, discount=0.5, orderstatus='In Progress'}\n" +
                "Orders{name='cake', price=10.0, OrderNUM=1, discount=1.0, orderstatus='done'}\n";

        String actualOutput = outContent.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);



         System.setOut(System.out);
    }


    @Test
    @Then("Store owner can update the status of each order")
    public void storeOwnerCanUpdateTheStatusOfEachOrder() {
        OrderManegmentClass.orderlist.clear();
        OrderManegmentClass.orderlist.add(new OrderManegmentClass("Pastry", 5, 0.5, 2, "In Progress"));
        OrderManegmentClass.orderlist.add(new OrderManegmentClass("cake",10,1.0,1,"done"));

        OrderManegmentClass.setOrderlist(OrderManegmentClass.orderlist);
        OrderManegmentClass order =new OrderManegmentClass();
        OrderManegmentClass ord = new OrderManegmentClass("Pastry", 5, 0.5, 2, "Completed");
        order.OrderUpdate(ord);

        String updatedStatus = OrderManegmentClass.orderlist.get(0).getOrderstatus();
        assertEquals("Completed", updatedStatus);

        String unchangedStatus = OrderManegmentClass.orderlist.get(1).getOrderstatus();
        assertEquals("done", unchangedStatus);
    }


}
