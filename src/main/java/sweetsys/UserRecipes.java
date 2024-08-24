package sweetsys;

import java.util.ArrayList;


public class UserRecipes {


    public static final boolean IN=false;

    public void recipesSearch(ProductManegmwntSystem prod){

        for(ProductManegmwntSystem p : SweetProject.getProducts()){
            if(prod.getUniq()==p.getUniq()){
                System.out.println("Product Recipe :"+p.getProductDescription());
                break;
            }
        }

    }

    public void filterRecipes(String name){


        ArrayList<Integer> n =new ArrayList<>();
        for(ProductManegmwntSystem prod : SweetProject.getProducts()){
            if(prod.getProductName().contains(name)||prod.getProductDescription().contains(name)){
                n.add(prod.getUniq());
            }
        }
        System.out.println("These products do not cause you allergies:");

            for(ProductManegmwntSystem pro : SweetProject.getProducts()){
                if (!n.contains(pro.getUniq())){
                System.out.println(pro.getUniq()+"\t"+pro.getProductName()+"\t"+pro.getProductDescription()+"\t"+pro.getPrice());
            }

        }
    }

}
