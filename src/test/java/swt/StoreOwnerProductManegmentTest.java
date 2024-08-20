package swt;

import org.junit.Test;
import sweetsys.ProductManegmwntSystem;
import sweetsys.SalesReport;
import sweetsys.SweetProject;
import io.cucumber.java.en.*;
import sweetsys.Sys;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

public class StoreOwnerProductManegmentTest {

    SweetProject s;


    public StoreOwnerProductManegmentTest() {
        s = new SweetProject();
    }


@Test
    @Given("Store owner logs in to the system")
    public void storeOwnerLogsInToTheSystem() {


    assertFalse(Sys.isB());
    }


    @Test
    @When("Store owner navigates to the Product Management section")
    public void storeOwnerNavigatesToTheProductManagementSection() {
        ProductManegmwntSystem manegproduct=new ProductManegmwntSystem();
       assertFalse(manegproduct.isInside());
    }



    @Test
    @When("Store owner can add a new product by providing necessary details")
    public void storeOwnerCanAddANewProductByProvidingNecessaryDetails() {
        SweetProject.products.clear();
    ProductManegmwntSystem prod=new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",1);
    SweetProject.products.add(new ProductManegmwntSystem("Nutella","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        SweetProject.products.add(new ProductManegmwntSystem("Nutla","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",3));

        s.productlogin(prod);
    SweetProject.setProducts(SweetProject.products);
        int expected=SweetProject.getProducts().size();

    s.addnewProduct(prod);

        List<ProductManegmwntSystem> products = SweetProject.getProducts();


        boolean productExists = products.stream()
                .anyMatch(p -> p.getProductName().equals("Nutella cake") && p.getProductDescription().equals("Layers of chocolate cake with chocolate cream in the middle"));


        assertTrue("Product should be added to the product list", productExists);


        ProductManegmwntSystem addedProduct = products.stream()
                .filter(p -> p.getProductName().equals("Nutella cake"))
               .findFirst()
               .orElse(null);



for(ProductManegmwntSystem pp :SweetProject.getProducts()){
    System.out.println(pp);
}
        assertNotNull("Product should be added", addedProduct);
        assertEquals("Unique ID should be set correctly", expected, addedProduct.getUniq());

    }



    @Test
    @When("Store owner can update existing product information")
    public void storeOwnerCanUpdateExistingProductInformation() {

SweetProject.products.clear();
        SweetProject.products.add(new ProductManegmwntSystem(1,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",5));
        SweetProject.products.add(new ProductManegmwntSystem(2,"cake","Jenin","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",10));
        SweetProject.products.add(new ProductManegmwntSystem(3,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",12));
        SweetProject.setProducts(SweetProject.products);


        ProductManegmwntSystem updatedProd = new ProductManegmwntSystem(2, "Nutella cake", "Jenin", "Updated description of Nutella cake", 15.0, 65.0, "updated", 15);

        s.ProductUpdate(updatedProd);


        ProductManegmwntSystem updatedProductInList = SweetProject.getProducts().stream()
                .filter(p -> p.getUniq() == 2)
                .findFirst()
                .orElse(null);
for (ProductManegmwntSystem pro :SweetProject.getProducts()){
    System.out.println(pro);
}

        assertNotNull("Updated product should be present in the list", updatedProductInList);
        assertEquals("Product description should be updated", "Updated description of Nutella cake", updatedProductInList.getProductDescription());
        assertEquals("Product price should be updated", 65, updatedProductInList.getPrice(), 0.01);
        assertEquals("Product stock quantity should be updated", 15.0, updatedProductInList.getEarning(), 0.01);
        assertEquals("Product status should be updated", "updated", updatedProductInList.getCondition());
        assertEquals("Product other detail should be updated", 15, updatedProductInList.getNumOfsales());


    }





    @Test
    @Then("Store owner can remove a product from the list")
    public void storeOwnerCanRemoveAProductFromTheList() {
SweetProject.products.clear();
        SweetProject.products.add(new ProductManegmwntSystem(1,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",5));
        SweetProject.products.add(new ProductManegmwntSystem(2,"cake","Jenin","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",10));
        SweetProject.products.add(new ProductManegmwntSystem(3,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",12));
        SweetProject.setProducts(SweetProject.products);

        ProductManegmwntSystem productToDelete = new ProductManegmwntSystem();
        productToDelete.setUniq(2);


        s.DeleteProduct(productToDelete);

        boolean productExists = SweetProject.getProducts().stream()
                .anyMatch(p -> p.getUniq() == 2);

        assertFalse("Product with unique ID 2 should be removed from the list", productExists);
        assertEquals("The product list should have 2 products remaining", 2, SweetProject.getProducts().size());

    }



    @Test
    @When("Store owner navigates to the Sales Reports section")
    public void storeOwnerNavigatesToTheSalesReportsSection() {
        SalesReport sale=new SalesReport();

        assertFalse(sale.isUserIn());
    }



    @Test
    @Then("System displays sales and profit reports")
    public void systemDisplaysSalesAndProfitReports() {
        SweetProject.products.clear();

        SweetProject.products.add(new ProductManegmwntSystem(1,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",5));
        SweetProject.products.add(new ProductManegmwntSystem(2,"Nutella cake","Jenin","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",10));
        SweetProject.products.add(new ProductManegmwntSystem(3,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",12));


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {

            SalesReport sales = new SalesReport();
            sales.ShoewSalesReport();
            String output = outputStream.toString();
            String expectedHeader = "Product Name:\tDescrption:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPrice\tEwarning:\tCondition:\tNum_OF_Sales:\tUniq Num:\n";
            assertTrue("Sales report header should be displayed correctly", output.contains(expectedHeader));

        } finally {
            System.setOut(originalOut);
        }


    }






    @Test
    @Then("System displays the best-selling products")
    public void systemDisplaysTheBestSellingProducts() {
SweetProject.products.clear();
SweetProject.bestselling.clear();

        SweetProject.products.add(new ProductManegmwntSystem(1,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",5));
        SweetProject.products.add(new ProductManegmwntSystem(2,"Nutella cake","Jenin","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",10));
        SweetProject.products.add(new ProductManegmwntSystem(3,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",12));

        SalesReport sales=new SalesReport();
        sales.ShowBestProduct();

      int expectednum= SweetProject.getBestselling().get(0).getNumOfsales();
      assertEquals(12,expectednum);


    }







    @Test
    @Then("Store owner can set dynamic discounts for products")
    public void storeOwnerCanSetDynamicDiscountsForProducts() {


        SweetProject.products.clear();
        SweetProject.products.add(new ProductManegmwntSystem(1, "Nutella cake", "Nablus", "Layers of chocolate cake with chocolate cream in the middle", 10.0, 60.0, "finished", 5));
        SweetProject.products.add(new ProductManegmwntSystem(2, "Nutella cake", "Jenin", "Layers of chocolate cake with chocolate cream in the middle", 10.0, 60.0, "finished", 10));
        SweetProject.products.add(new ProductManegmwntSystem(3, "Nutella cake", "Nablus", "Layers of chocolate cake with chocolate cream in the middle", 10.0, 60.0, "finished", 12));

        ProductManegmwntSystem prodWithDiscount = new ProductManegmwntSystem();
        prodWithDiscount.setUniq(2);
        prodWithDiscount.setDiscount(20.0);


        SalesReport sales = new SalesReport();
        sales.addDiscount(prodWithDiscount);

        ProductManegmwntSystem updatedProduct = SweetProject.getProducts().stream()
                .filter(prod -> prod.getUniq() == 2)
                .findFirst()
                .orElse(null);

        assertNotNull("Product should exist in the list", updatedProduct);
        assertEquals("Discount should be updated to 20.0%", 20.0, updatedProduct.getDiscount(), 0.0);
    }


}
