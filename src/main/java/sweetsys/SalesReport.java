package sweetsys;
import java.util.*;

import static java.lang.System.exit;

public class SalesReport {

    public boolean user_in;
    public boolean printed;
 SweetProject s;
    public boolean found;
    public boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public SalesReport(SweetProject s) {
    this.s=s;
}


    public boolean isPrinted() {
        return printed;
    }

    public void setPrinted(boolean printed) {
        this.printed = printed;
    }

    public boolean isUser_in() {
        return user_in;
    }

    public void setUser_in(boolean user_in) {
        this.user_in = user_in;
    }

    public SalesReport(){}

    public void ShoewSalesReport(){
        SweetProject s=new SweetProject();
        System.out.println("Product Name:\tDescrption:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPrice\tEwarning:\tCondition:\tNum_OF_Sales:\tUniq Num:\n");
        for(ProductManegmwntSystem prod :s.getProducts()){
System.out.println(prod.getProductName()+"\t"+prod.getProductDescription()+"\t\t\t"+prod.getPrice()+"\t"+prod.getEarning()+"\t\t"+prod.getCondition()+"\t"+prod.getNum_Of_Sales()+"\t\t\t\t"+prod.getUniq()+"\n");
        }
        SalesReport sales=new SalesReport();
        sales.setPrinted(true);
    }



    public void ShowBestProduct(){
        SweetProject s=new SweetProject();
        System.out.println("Best Product :\n");

        int flag=s.products.get(0).getNum_Of_Sales();

        System.out.println("Product Name:\tDescrption:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPrice\tEwarning:\tCondition:\tNum_OF_Sales:\tUniq Num:\n");
        for(ProductManegmwntSystem prod :s.getProducts()){
            if (prod.getNum_Of_Sales() > flag) {
                flag = prod.getNum_Of_Sales();
            }
        }
        for(ProductManegmwntSystem last :s.getProducts()){
            if (last.getNum_Of_Sales()==flag) {
              s.bestselling.add(last);
              s.setBestselling(s.bestselling);
                break;
            }
        }
        for(ProductManegmwntSystem store :s.getBestselling()) {

System.out.println(store.getProductName() + "\t" + store.getProductDescription() + "\t\t\t" + store.getPrice() + "\t" + store.getEarning() + "\t\t" + store.getCondition() + "\t" + store.getNum_Of_Sales() + "\t\t\t\t" + store.getUniq() + "\n");
        }

        SalesReport sales=new SalesReport();
        sales.setPrinted(true);
    }
 


public void addDiscount( ){
        SalesReport sale=new SalesReport();
    ProductManegmwntSystem prod=new ProductManegmwntSystem();
    for(ProductManegmwntSystem products:s.getProducts()){
        System.out.println(products);
    }
    double dis=prod.getDiscount();

        SweetProject s=new SweetProject();

        Scanner cin =new Scanner(System.in);


        System.out.println("enter UniqNumber of Product you want to add Discount for pls :\n");
        int uniqnum=cin.nextInt();
        prod=new ProductManegmwntSystem(uniqnum);
        s.productlogin(prod);


    for(ProductManegmwntSystem products :s.getProducts()){
            if(products.getUniq()==prod.getUniq()){
                found = true;
            }
        }

        if(!found){
            System.out.println("you entered wrong UniqNumber try again");
            exit(0);
        }
        Scanner c =new Scanner(System.in);


        System.out.println("enter the amount of Discount  of product you want to update pls :a\n");
        int DISCOUNT=cin.nextInt();
    double x = 0;
    int y = 0;
        for(ProductManegmwntSystem products:s.getProducts()){
            if(products.getUniq()==prod.getUniq()){


                products.setDiscount(DISCOUNT);
                 x=products.getPrice()-products.getDiscount();
                 y=products.getUniq();
                sale.done=true;
            }

        }
    System.out.println("The value of the new price on the product whose number:" +y+ "\tis :"+x);
        System.out.println("Updated Data\n");
        for(ProductManegmwntSystem products:s.getProducts()){
            System.out.println(products);
        }
    }







    /*public static void main(String[] args) {
        SweetProject s=new SweetProject();
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,10,"finished",1));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,14,"not finished",3));
        SalesReport sales =new SalesReport();
        //sales.ShoewSalesReport();
        //sales.ShowBestProduct();
        sales.addDiscount();

    }*/

}
