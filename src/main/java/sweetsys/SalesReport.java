package sweetsys;


import static java.lang.System.exit;

public class SalesReport {

    private boolean user_in;
    public boolean printed;

    public boolean done;







    public boolean isPrinted() {
        return printed;
    }



    public boolean isUser_in() {
        return user_in;
    }

    public SalesReport(){
        //not now

    }
    public void ShoewSalesReport(){

        System.out.println("Sales Reports");
        System.out.println("Product Name:\tDescrption:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPrice\tEwarning:\tCondition:\tNum_OF_Sales:\tUniq Num:\n");
        for(ProductManegmwntSystem prod : SweetProject.getProducts()){
System.out.println(prod.getProductName()+"\t"+prod.getProductDescription()+"\t\t\t"+prod.getPrice()+"\t"+prod.getEarning()+"\t\t"+prod.getCondition()+"\t"+prod.getNumOfsales()+"\t\t\t\t"+prod.getUniq()+"\n");
        }


    }



    public void ShowBestProduct(){

        System.out.println("Best Product :\n");

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
        }

    }


    public void addDiscount( ProductManegmwntSystem prod){
        try{
          double discount=prod.getDiscount();

            for(ProductManegmwntSystem pro :SweetProject.getProducts()){
                if(pro.getUniq()==prod.getUniq()){
                    pro.setDiscount(discount);
                    break;
                }
            }
            SweetProject.setProducts(SweetProject.products);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
