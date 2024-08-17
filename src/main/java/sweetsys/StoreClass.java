package sweetsys;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

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





    public void buyproducts(){
SweetProject s=new SweetProject();
    StoreClass ss=new StoreClass();
    AdminReports a=new AdminReports();
    a.SeperateEachCity();

        System.out.println("Enter your city name : Nablus OR jenin");
        Scanner v=new Scanner(System.in);
                String city = v.nextLine();

                if(city.equalsIgnoreCase("nablus")){

                    System.out.println("here you can see all nablus store products and its description : \n");
                    System.out.println("Num\t Name \t\t\tDescription ");

                    for (ProductManegmwntSystem pro :s.getNablusprodcuts()){
                        System.out.println(pro.getUniq()+"\t"+pro.getProductName()+"\t"+pro.getProductDescription());

                    }

                    ArrayList<Integer> selectedProducts = new ArrayList<>();
                    String input;
                    System.out.println("Enter the numbers of your orders (comma separated, e.g., 1,2,3):");


                    Scanner cin=new Scanner(System.in);
                    input = cin.nextLine();


                    String[] productIds = input.split(",");

                    try {
                        for (String id : productIds) {
                            selectedProducts.add(Integer.parseInt(id.trim()));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter valid product numbers.");
                        return;
                    }


                    System.out.println("You have selected the following products:");

                    for (ProductManegmwntSystem pro : s.getProducts()) {
                        if (selectedProducts.contains(pro.getUniq())) {
                            String status="Processing";
                            OrderManegmentClass o=new OrderManegmentClass(pro.getProductName(),pro.getPrice(),pro.getDiscount(),pro.getUniq(),status);
                            o.orderlist.add(o);
                            o.setOrderlist(o.orderlist);
                            System.out.println(pro.getUniq() + "\t" + pro.getProductName() + "\t" + pro.getProductDescription());
                            pro.setNumOfsales(pro.getNumOfsales()+1);
                        }
                    }


                    System.out.println("Processing your order...");


                    System.out.println("Thank you for your purchase!");


                }



                else if(city.equalsIgnoreCase("jenin")){


                    System.out.println("here you can see all products and its description : \n");
                    System.out.println("Num\t Name \t\t\tDescription ");

                    for (ProductManegmwntSystem pro :s.getJeninprodcuts()){
                        System.out.println(pro.getUniq()+"\t"+pro.getProductName()+"\t"+pro.getProductDescription());

                    }

                    ArrayList<Integer> selectedProducts = new ArrayList<>();
                    String input;
                    System.out.println("Enter the numbers of your orders (comma separated, e.g., 1,2,3):");


                    Scanner cin=new Scanner(System.in);
                    input = cin.nextLine();


                    String[] productIds = input.split(",");


                    try {
                        for (String id : productIds) {
                            selectedProducts.add(Integer.parseInt(id.trim()));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter valid product numbers.");
                        return;
                    }


                    System.out.println("You have selected the following products:");

                    for (ProductManegmwntSystem pro : s.getProducts()) {
                        if (selectedProducts.contains(pro.getUniq())) {
                            String status="Processing";
                            OrderManegmentClass o=new OrderManegmentClass(pro.getProductName(),pro.getPrice(),pro.getDiscount(),pro.getUniq(),status);
                            o.orderlist.add(o);
                            o.setOrderlist(o.orderlist);
                            System.out.println(pro.getUniq() + "\t" + pro.getProductName() + "\t" + pro.getProductDescription());
                            pro.setNumOfsales(pro.getNumOfsales()+1);
                        }
                    }


                    System.out.println("Processing your order...");


                    System.out.println("Thank you for your purchase!");

                }
                else{
                    System.out.println("invalid input try again");
                    exit(0);
                }


    }



    /*public static void main(String[] args) {
        SweetProject s = new SweetProject();
        s.products.add(new ProductManegmwntSystem(1,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"not finished",5));
        s.products.add(new ProductManegmwntSystem(2,"Cheesecake","Jenin","Creamy cheesecake with a graham cracker crust",5.0,30.0,"not finished",10));
        s.products.add(new ProductManegmwntSystem(3,"Cupcake","Nablus","Vanilla cupcake with buttercream frosting",3.0,20.0,"not finished",12));
        s.products.add(new ProductManegmwntSystem(4,"Lemon Tart","jenin","Tangy lemon curd in a buttery shortcrust pastry",4.0,25.0,"not finished",7));
        s.products.add(new ProductManegmwntSystem(5,"Apple Pie","Jenin","Traditional apple pie with a flaky crust and cinnamon-spiced filling",3.5,24.0,"not finished",30));
        s.products.add(new ProductManegmwntSystem(6,"Creme Brulee ","Nablus","Rich custard topped with a layer of hard caramel",1.5,15.0,"not finished",35));

        s.products.add(new ProductManegmwntSystem(1,"Brownies","Nablus","Fudgy chocolate brownies with a crackly top",8.0,35.0,"not finished",6));
        s.products.add(new ProductManegmwntSystem(2,"Panna Cotta","Jenin","Italian dessert made with sweetened cream and set with gelatin",12.0,55.0,"not finished",50));
        s.products.add(new ProductManegmwntSystem(3,"Macarons","jenin","Delicate almond meringue cookies filled with flavored buttercream",2.0,10.0,"not finished",40));
        s.setProducts(s.products);
        OrderManegmentClass o=new OrderManegmentClass();
o.orderlist.clear();
        StoreClass u = new StoreClass();
        u.buyproducts();
        System.out.println("\n\n");



    }*/


    
}
