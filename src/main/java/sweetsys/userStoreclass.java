package sweetsys;
import java.util.ArrayList;
import static java.lang.System.exit;
public class userStoreclass {
    public boolean in;

    public userStoreclass(){
        //dd
    }
    public void buyproducts(String input){

        AdminReports a=new AdminReports();
        a.SeperateEachCity();

        ArrayList<Integer> selectedProducts = new ArrayList<>();

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

        for (ProductManegmwntSystem pro : SweetProject.getProducts()) {
            if (selectedProducts.contains(pro.getUniq())) {
                String status="Processing";
                OrderManegmentClass o=new OrderManegmentClass(pro.getProductName(),pro.getPrice(),pro.getDiscount(),pro.getUniq(),status);
                OrderManegmentClass.orderlist.add(o);
                OrderManegmentClass.setOrderlist(OrderManegmentClass.orderlist);
                System.out.println(pro.getUniq() + "\t" + pro.getProductName() + "\t" + pro.getProductDescription());
                pro.setNumOfsales(pro.getNumOfsales()+1);
            }
        }
        if(input==null){
            exit(0);
        }

    }

}
