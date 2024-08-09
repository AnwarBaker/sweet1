package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.*;

import static org.junit.Assert.*;

public class AdminMonitoringAndReporting {

SweetProject s;

    public AdminMonitoringAndReporting( ) {
        s = new SweetProject();
    }


    @Test
    @Given("Admin logs in to the system")
    public void adminLogsInToTheSystem() {
assertFalse(s.is_login);
    }


    @Test
    @When("Admin navigates to the Reports section")
    public void adminNavigatesToTheReportsSection() {

    }


    @Test
    @When("Admin selects the desired report type \\(e.g., monthly profits)")
    public void adminSelectsTheDesiredReportTypeEGMonthlyProfits() {
        SalesReport sales=new SalesReport();
        assertFalse(sales.user_in);
    }


    @Test
    @Then("System generates and displays the financial report")
    public void systemGeneratesAndDisplaysTheFinancialReport() {
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,10,"finished",1));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,14,"not finished",3));
        SalesReport sales=new SalesReport();
        sales.ShoewSalesReport();
        assertFalse(sales.isPrinted());
    }


    @Test
    @When("Admin navigates to the Best-Selling Products section")
    public void adminNavigatesToTheBestSellingProductsSection() {
        SalesReport sales=new SalesReport();
        assertFalse(sales.user_in);
    }



    @Test
    @Then("System displays a list of best-selling products for each store")
    public void systemDisplaysAListOfBestSellingProductsForEachStore() {
        s.products.add(new ProductManegmwntSystem(1,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",5));
        s.products.add(new ProductManegmwntSystem(2,"Nutella ","Jenin","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",10));
        s.products.add(new ProductManegmwntSystem(3,"pop cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",12));
        s.products.add(new ProductManegmwntSystem(4,"marcemillo cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",13));
        s.products.add(new ProductManegmwntSystem(5,"lotos cake","Jenin","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",30));
        s.products.add(new ProductManegmwntSystem(6,"juice ","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",35));
        AdminReports a=new AdminReports();
        a.SeperateEachCity();
        a.ShowBestSellinForNablus();
        a.ShowBestSellinForJenin();
        assertFalse(a.printed);
    }


    @Test
    @When("Admin navigates to the User Statistics section")
    public void adminNavigatesToTheUserStatisticsSection() {
AdminReports a=new AdminReports();
assertFalse(a.in);
    }


    @Test
    @Then("System displays user statistics categorized by city \\(e.g., Nablus, Jenin)")
    public void systemDisplaysUserStatisticsCategorizedByCityEGNablusJenin() {
        s.users.add(new User("anwar", "123", 1,"anwar123@gmail.com","Jenin"));
        s.users.add(new User("ahmad", "1234", 3,"ahmad1234@gmail.com","Nablus"));
        s.users.add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com","nablus"));
        s.users.add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com","Jenin"));
        AdminReports a=new AdminReports();

        a.SeperateEachUserToCities();
        assertFalse(a.printed);
    }


}
