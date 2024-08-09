package sweetsys;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreClass {

    public boolean in;
    public boolean done;
    private String storecity;
    
    
    public  StoreClass(){}

    public StoreClass(String storecity) {
        this.storecity = storecity;
    }

    public String getStorecity() {
        return storecity;
    }

    public void setStorecity(String storecity) {
        this.storecity = storecity;
    }
    

    public void buyproducts(){
SweetProject s=new SweetProject();

        System.out.println("here you can see all products and its description : \n");
        System.out.println("Num\t Name \t\t\tDescription ");

        for (ProductManegmwntSystem pro :s.getProducts()){
            System.out.println(pro.getUniq()+"\t"+pro.getProductName()+"\t"+pro.getProductDescription());

        }

        ArrayList<Integer> selectedProducts = new ArrayList<>();
        String input;
        System.out.println("Enter the numbers of your orders (comma separated, e.g., 1,2,3):");

        // Read the user input
        Scanner cin=new Scanner(System.in);
        input = cin.nextLine();

        // Split the input into individual product IDs
        String[] productIds = input.split(",");

        // Convert product IDs to integers and add to the list
        try {
            for (String id : productIds) {
                selectedProducts.add(Integer.parseInt(id.trim()));
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid product numbers.");
            return;
        }

        // Display selected products
        System.out.println("You have selected the following products:");

        for (ProductManegmwntSystem pro : s.getProducts()) {
            if (selectedProducts.contains(pro.getUniq())) {
                System.out.println(pro.getUniq() + "\t" + pro.getProductName() + "\t" + pro.getProductDescription());
                pro.setNum_Of_Sales(pro.getNum_Of_Sales()+1);
            }
        }


        System.out.println("Processing your order...");


        System.out.println("Thank you for your purchase!");

    }


    public static void main(String[] args) {
        SweetProject s = new SweetProject();
        s.products.add(new ProductManegmwntSystem("Nutel cake", "Layers of chocolate cake with chocolate cream on the top", 60.0, 10.0, 10, "finished", 1));
        s.products.add(new ProductManegmwntSystem("Nulla popcake", "Layers of chocolate cake with chocolate cream in the middle", 60.0, 10.0, 12, "not finished", 2));
        s.products.add(new ProductManegmwntSystem("Nutela juice", "Layers of chocolate cake with chocolate cream in the front", 60.0, 10.0, 14, "not finished", 3));
        StoreClass u = new StoreClass();
        u.buyproducts();
    }


    
}
