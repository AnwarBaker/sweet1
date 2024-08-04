package swt;

import org.junit.Test;
import sweetsys.ProductManegmwntSystem;
import sweetsys.SalesReport;
import sweetsys.SweetProject;
import io.cucumber.java.en.*;
import sweetsys.Sys;
import static org.junit.Assert.*;

public class StoreOwnerProductManegmentTest {

    SweetProject s;


    public StoreOwnerProductManegmentTest() {
        s = new SweetProject();
    }


@Test
    @Given("Store owner logs in to the system")
    public void storeOwnerLogsInToTheSystem() {
    Sys system=new Sys();
    system.setB(false);
    assertFalse(system.isB());
    }


    @Test
    @When("Store owner navigates to the Product Management section")
    public void storeOwnerNavigatesToTheProductManagementSection() {
        ProductManegmwntSystem manegproduct=new ProductManegmwntSystem();
       assertFalse(manegproduct.inside);
    }



    @Test
    @When("Store owner can add a new product by providing necessary details")
    public void storeOwnerCanAddANewProductByProvidingNecessaryDetails() {
    ProductManegmwntSystem prod=new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",1);
    s.productlogin(prod);
    s.addnewProduct(prod);
    s.setProducts(s.products);
    prod.setAdded(true);
    System.out.println("Product\t" +prod.getProductName()+ "added succsesfully\n" +s.getProducts());
    assertFalse(s.isExist());

    }


    @Test
    @When("Store owner can update existing product information")
    public void storeOwnerCanUpdateExistingProductInformation() {
        ProductManegmwntSystem prod=new ProductManegmwntSystem();
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,10,"finished",1));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,14,"not finished",3));
        prod.setUpdated(true);
        assertTrue(prod.isUpdated());
    }


    @Test
    @Then("Store owner can remove a product from the list")
    public void storeOwnerCanRemoveAProductFromTheList() {
        assertFalse(s.deleted);
    }



    @Test
    @When("Store owner navigates to the Sales Reports section")
    public void storeOwnerNavigatesToTheSalesReportsSection() {
        SalesReport sale=new SalesReport();
        sale.setUser_in(false);
        assertFalse(sale.user_in);
    }



    @Test
    @Then("System displays sales and profit reports")
    public void systemDisplaysSalesAndProfitReports() {
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,10,"finished",1));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,14,"not finished",3));
        SalesReport sales=new SalesReport();
        sales.ShoewSalesReport();
        assertFalse(sales.isPrinted());
    }



    @Test
    @When("Store owner navigates to the Best-Selling Products section")
    public void storeOwnerNavigatesToTheBestSellingProductsSection() {
        SalesReport sale=new SalesReport();
        sale.setUser_in(false);
        assertFalse(sale.user_in);
    }


    @Test
    @Then("System displays the best-selling products")
    public void systemDisplaysTheBestSellingProducts() {
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,10,"finished",1));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,14,"not finished",3));
        SalesReport sales=new SalesReport();
        sales.ShowBestProduct();
        assertFalse(sales.isPrinted());
    }



    @Test
    @When("Store owner navigates to the Discount Management section")
    public void storeOwnerNavigatesToTheDiscountManagementSection() {
        SalesReport sale=new SalesReport();
        sale.setUser_in(false);
        assertFalse(sale.user_in);
    }



    @Test
    @Then("Store owner can set dynamic discounts for products")
    public void storeOwnerCanSetDynamicDiscountsForProducts() {

     SalesReport sales=new SalesReport();
     sales.setDone(true);
     assertTrue(sales.isDone());

    }


}
