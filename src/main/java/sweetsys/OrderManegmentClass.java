package sweetsys;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class OrderManegmentClass {

    private String name;
    private double price;
    private double discount;
    private int OrderNUM;
    private String orderstatus;

    static public ArrayList<OrderManegmentClass> orderlist=new ArrayList<>();

      public static boolean in;

    public OrderManegmentClass(){}



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



    public int getOrderNUM() {
        return OrderNUM;
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

    public boolean isIn() {
        return in;
    }


public void ShowOrders(){
        for(OrderManegmentClass o :getOrderlist()){
            System.out.println(o);
        }
}


    public void OrderUpdate(OrderManegmentClass order){


            if (order == null) {
                System.out.println("Order cannot be null.");
                return;
            }

            if (orderlist == null) {
                System.out.println("Order list is not initialized.");
                return;
            }

            IntStream.range(0, orderlist.size()).filter(i -> orderlist.get(i).getOrderNUM() == order.getOrderNUM()).findFirst().ifPresent(i -> orderlist.get(i).setOrderstatus(order.getOrderstatus()));
            setOrderlist(orderlist);

    }


}
