package sweetsys;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SalesReport {

    private boolean userIn;
    private static final Logger logger = Logger.getLogger(MainSweetSystem.class.getName());

    public boolean isUserIn() {
        return userIn;
    }

    public SalesReport(){
        //not now
    }
    public void shoewSalesreport(){

        System.out.println("Product Name:\tDescrption:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPrice\tEwarning:\tCondition:\tNum_OF_Sales:\tUniq Num:\n");
        for(ProductManegmwntSystem prod : SweetProject.getProducts()){
System.out.println(prod.getProductName()+"\t"+prod.getProductDescription()+"\t\t\t"+prod.getPrice()+"\t"+prod.getEarning()+"\t\t"+prod.getCondition()+"\t"+prod.getNumOfsales()+"\t\t\t\t"+prod.getUniq()+"\n");
        }

    }

    public void showBestproduct(){

        logger.log(Level.WARNING,"Best Product :\n");
        try{
        int flag=SweetProject.products.get(0).getNumOfsales();

        System.out.println("Product Name:\tDescrption:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPrice\tEwarning:\tCondition:\tNum_OF_Sales:\tUniq Num:\n");
        for(ProductManegmwntSystem prod :SweetProject.getProducts()){
            if (prod.getNumOfsales() > flag) {
                flag = prod.getNumOfsales();
            }
        }

        for(ProductManegmwntSystem last :SweetProject.getProducts()){
            if (last.getNumOfsales()==flag) {
              SweetProject.bestselling.add(last);
              SweetProject.setBestselling(SweetProject.bestselling);
                System.out.println(last);
                break;
            }
        }}catch (Exception e){e.printStackTrace();}

    }


    public void addDiscount( ProductManegmwntSystem prod){

          double discount=prod.getDiscount();

            for(ProductManegmwntSystem pro :SweetProject.getProducts()){
                if(pro.getUniq()==prod.getUniq()){
                    pro.setDiscount(discount);
                    break;
                }
            }
            SweetProject.setProducts(SweetProject.products);



    }
}
