package sweetsys;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class OrderManegmentClass {

    public boolean isted;
    public boolean isUpdated;
    String name;
    double price;
    double discount;
    int OrderNUM;
    String orderstatus;

    static public ArrayList<OrderManegmentClass> orderlist=new ArrayList<OrderManegmentClass>();

    public boolean in;
    private boolean found;

    public OrderManegmentClass(){}

    ProductManegmwntSystem p;

    public OrderManegmentClass(ProductManegmwntSystem p) {
        this.p = p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public static ArrayList<OrderManegmentClass> getOrderlist() {
        return orderlist;
    }

    public static void setOrderlist(ArrayList<OrderManegmentClass> orderlist) {
        OrderManegmentClass.orderlist = orderlist;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getOrderNUM() {
        return OrderNUM;
    }

    public void setOrderNUM(int orderNUM) {
        OrderNUM = orderNUM;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public OrderManegmentClass(String name, double price, double discount, int orderNUM, String orderstatus) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.OrderNUM = orderNUM;
        this.orderstatus = orderstatus;
    }

    public OrderManegmentClass(String name, double price, double discount, int orderNUM) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.OrderNUM = orderNUM;
    }

    public OrderManegmentClass(int orderNUM) {
        OrderNUM = orderNUM;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", OrderNUM=" + OrderNUM +
                ", discount=" + discount +
                ", orderstatus='" + orderstatus + '\'' +
                '}';
    }

    public void ShowOrders(){
        SweetProject sweet =new SweetProject();
        OrderManegmentClass order =new OrderManegmentClass();
        int i=1;
        for(ProductManegmwntSystem prod :sweet.getProducts()){
            order.setName(prod.getProductName());
            order.setPrice(prod.getPrice());
            order.setDiscount(prod.getDiscount());
            order.setOrderNUM(i);
            order.setOrderstatus(prod.getCondition());
order.orderlist.add(new OrderManegmentClass(order.getName(),order.getPrice(),prod.getDiscount(),order.getOrderNUM(),order.getOrderstatus()));
            i++;

        }
order.setOrderlist(order.orderlist);
      for(OrderManegmentClass o :order.getOrderlist()){
          System.out.println(o);
      }
    }



    public void OrderUpdate(){
        SweetProject s=new SweetProject();

        OrderManegmentClass order =new OrderManegmentClass();

        Scanner cin =new Scanner(System.in);
       order.ShowOrders();


        System.out.println("enter Number of Order you want to update pls :\n");
        int ordernum=cin.nextInt();

        order=new OrderManegmentClass(ordernum);




        for(OrderManegmentClass orders :order.getOrderlist()){
            if(orders.getOrderNUM()==order.getOrderNUM()){
                found = true;
            }
        }


        if(!found){
            System.out.println("you entered wrong UniqNumber try again");
            exit(0);
        }

        Scanner c =new Scanner(System.in);

        System.out.println("\n \nenter the new Status of Order you want to update pls :\n");
        String newstatus=c.nextLine();


        for(OrderManegmentClass orders:order.getOrderlist()){
            if(orders.getOrderNUM()==order.getOrderNUM()){

                orders.setOrderstatus(newstatus);

            }

        }
        System.out.println("Updated Data\n");
        for(OrderManegmentClass orders:order.getOrderlist()){
            System.out.println(orders);
        }
    }







    public static void main(String[] args) {
        SweetProject s=new SweetProject();

        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,10,"finished",1));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,14,"not finished",3));
       s.setProducts(s.products);
       OrderManegmentClass order =new OrderManegmentClass();
    //   order.ShowOrders();
       order.OrderUpdate();
    }
}
