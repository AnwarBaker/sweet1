package sweetsys;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class OrderManegmentClass {

    private String name;
    private double price;
    private double discount;
    private int ordernum;
    private String orderstatus;

    protected static List<OrderManegmentClass> orderlist=new ArrayList<>();

      public static final boolean IN=false;

    public OrderManegmentClass(){}

    public void setDiscount(double discount) {
        this.discount = discount;
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


    public static List<OrderManegmentClass> getOrderlist() {
        return orderlist;
    }

    public static void setOrderlist(List<OrderManegmentClass> orderlist) {
        OrderManegmentClass.orderlist = orderlist;
    }

    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
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
        this.ordernum = orderNUM;
        this.orderstatus = orderstatus;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", OrderNUM=" + ordernum +
                ", discount=" + discount +
                ", orderstatus='" + orderstatus + '\'' +
                '}';
    }




public void showOrders(){
        for(OrderManegmentClass o :getOrderlist()){
            System.out.println(o);
        }
}

  public void orderUpdate(OrderManegmentClass order){


            if (order == null||orderlist == null) {
                System.out.println("Order cannot be null. OR rder list is not initialized ");
                return;
            }


            IntStream.range(0, orderlist.size()).filter(i -> orderlist.get(i).getOrdernum() == order.getOrdernum()).findFirst().ifPresent(i -> orderlist.get(i).setOrderstatus(order.getOrderstatus()));
            setOrderlist(orderlist);

    }
}
