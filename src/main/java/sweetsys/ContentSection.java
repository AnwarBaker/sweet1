package sweetsys;
import static java.lang.System.exit;

public class ContentSection {
    public boolean in;



    public void updateUserrecipes(UserShareProducts pro){
boolean found=false;
        for(int i=0 ;i<UserShareProducts.getUserproducts().size();i++){
            if(UserShareProducts.getUserproducts().get(i).getProductName().equalsIgnoreCase(pro.getProductName())){
                UserShareProducts.getUserproducts().set(i,pro);
                found=true;
                break;
            }
        }
        UserShareProducts.setUserproducts(UserShareProducts.getUserproducts());

        if(!found){
            System.out.println("you entered wrong details try again");
            exit(0);
        }

    }


    public void deleteUserrecipes(UserShareProducts pro ){

        boolean found=false;

        for(int i = 0; i < UserShareProducts.getUserproducts().size(); i++){
            if(UserShareProducts.getUserproducts().get(i).getProductName().equalsIgnoreCase(pro.getProductName())){

                UserShareProducts.getUserproducts().remove(i);
                found=true;
                break;
            }
        }
        UserShareProducts.setUserproducts(UserShareProducts.getUserproducts());
if(!found){
    System.out.println("non exist");
    exit(0);
}

    }

}
