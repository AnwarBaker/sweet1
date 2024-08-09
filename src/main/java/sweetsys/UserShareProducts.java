package sweetsys;

import java.util.ArrayList;

public class UserShareProducts {

    public String productName;
    public String productDescription;
    public double expectedprice;

static public ArrayList<UserShareProducts> userproducts=new ArrayList<UserShareProducts>();
    public boolean done;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public static ArrayList<UserShareProducts> getUserproducts() {
        return userproducts;
    }

    public static void setUserproducts(ArrayList<UserShareProducts> userproducts) {
        UserShareProducts.userproducts = userproducts;
    }

    public double getExpectedprice() {
        return expectedprice;
    }

    public void setExpectedprice(double expectedprice) {
        this.expectedprice = expectedprice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public UserShareProducts(){}

    public UserShareProducts(String productName) {
        this.productName = productName;
    }

    public UserShareProducts(String productName, String productDescription, double expectedprice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.expectedprice = expectedprice;
    }

    @Override
    public String toString() {
        return "User Products{" +
                "productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", expectedprice=" + expectedprice +
                '}';
    }

    public void addnewProductForUser(UserShareProducts prod){
        UserShareProducts newone =new UserShareProducts();
        boolean founded=false;
        SweetProject s=new SweetProject();
        for(ProductManegmwntSystem products :s.getProducts()){
            if(products.getProductName().equalsIgnoreCase(prod.getProductName())&&products.getProductDescription().equalsIgnoreCase(prod.getProductDescription())) {
                System.out.println("this product already exists");
                founded=true;

            }


        }

        if(!founded){
            newone.userproducts.add(prod);
            newone.setUserproducts(newone.userproducts);
        }


    }

 
}
