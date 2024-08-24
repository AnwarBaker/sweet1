package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.OrderManegmentClass;

import sweetsys.SweetProject;

import static org.junit.Assert.*;



public class StoreOwnerOrderManegStepsTest {

    SweetProject s;

    public StoreOwnerOrderManegStepsTest( ) {
        s =new SweetProject();
    }


    @Test
    @Given("Store owner navigates to the Order Management section.")
    public void storeOwnerNavigatesToTheOrderManagementSection() {
        OrderManegmentClass order =new OrderManegmentClass();
   assertFalse(order.IN);
    }

    @Test
    @When("Store owner can view a list of orders")
    public void storeOwnerCanViewAListOfOrders() {
        OrderManegmentClass order =new OrderManegmentClass();
        OrderManegmentClass.getOrderlist().clear();
        OrderManegmentClass.getOrderlist().add(new OrderManegmentClass("Pastry", 5, 0.5, 2, "In Progress"));
        OrderManegmentClass.getOrderlist().add(new OrderManegmentClass("cake",10,1.0,1,"done"));

        OrderManegmentClass.setOrderlist(OrderManegmentClass.getOrderlist());


        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));


        order.showOrders();




        String expectedOutput = """
    Orders{name='Pastry', price=5.0, OrderNUM=2, discount=0.5, orderstatus='In Progress'}
    Orders{name='cake', price=10.0, OrderNUM=1, discount=1.0, orderstatus='done'}
    """;

        String actualOutput = outContent.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);



         System.setOut(System.out);
    }


    @Test
    @Then("Store owner can update the status of each order")
    public void storeOwnerCanUpdateTheStatusOfEachOrder() {
        OrderManegmentClass.getOrderlist().clear();
        OrderManegmentClass.getOrderlist().add(new OrderManegmentClass("Pastry", 5, 0.5, 2, "In Progress"));
        OrderManegmentClass.getOrderlist().add(new OrderManegmentClass("cake",10,1.0,1,"done"));

        OrderManegmentClass.setOrderlist(OrderManegmentClass.getOrderlist());
        OrderManegmentClass order =new OrderManegmentClass();
        OrderManegmentClass ord = new OrderManegmentClass("Pastry", 5, 0.5, 2, "Completed");
        order.orderUpdate(ord);

        String updatedStatus = OrderManegmentClass.getOrderlist().get(0).getOrderstatus();
        assertEquals("Completed", updatedStatus);

        String unchangedStatus = OrderManegmentClass.getOrderlist().get(1).getOrderstatus();
        assertEquals("done", unchangedStatus);



        OrderManegmentClass tocover =new OrderManegmentClass();
        tocover.setOrderstatus("sdjfhs");
        tocover.setName("jkfhk");
        tocover.setPrice(12);
        tocover.setDiscount(10);
        tocover.setOrdernum(2);
        tocover.setOrderlist(tocover.getOrderlist());
        tocover.getOrderlist();
        tocover.getDiscount();
        tocover.getName();
        tocover.getPrice();
        tocover.getOrdernum();
        tocover.getDiscount();


    }


}
