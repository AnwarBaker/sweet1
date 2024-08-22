package sweetsys;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserShareProducts {

    private static final Logger logger = Logger.getLogger(UserShareProducts.class.getName());

    public String productName;
    public String productDescription;
    public double expectedprice;

    protected static List<UserShareProducts> userproducts = new ArrayList<>();

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public static List<UserShareProducts> getUserproducts() {
        return userproducts;
    }

    public static void setUserproducts(List<UserShareProducts> userproducts) {
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

    public UserShareProducts() {}

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

    public void addnewProductForUser(UserShareProducts prod) {

        boolean founded = false;
        for (ProductManegmwntSystem products : SweetProject.getProducts()) {
            if (products.getProductName().equalsIgnoreCase(prod.getProductName()) &&
                    products.getProductDescription().equalsIgnoreCase(prod.getProductDescription())) {
                logger.log(Level.WARNING, "This product already exists");
                founded = true;
            }
        }
        if (!founded) {
            userproducts.add(prod);
            setUserproducts(userproducts);
        }
    }
}

