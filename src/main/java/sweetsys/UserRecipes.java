package sweetsys;

import java.util.ArrayList;
import java.util.Scanner;

public class UserRecipes {

    public boolean search;
    public boolean in;
    public boolean found;

    public void UserRecipes(){}





    public void RecipesSearch(){
        SweetProject s=new SweetProject();
System.out.println("this is all our products name you cac choose any of this to see our Recipes: \n");

for(ProductManegmwntSystem prod :s.getProducts()){

    System.out.println(prod.getUniq()+"\t"+prod.getProductName()+"\n");

}
        System.out.println("Enter the Number of Products you want recipe\n");

        Scanner cin =new Scanner(System.in);
        int num= cin.nextInt();
        for(ProductManegmwntSystem p :s.getProducts()){
            if(num==p.getUniq()){
                System.out.println("Product Recipe :"+p.getProductDescription());
                search=false;
            }
        }

    }



    public void filterRecipes(){

        System.out.println("Enter the name of the food to which you are allergic\n");
SweetProject s=new SweetProject();

        ArrayList<Integer> n =new ArrayList<Integer>();
        Scanner cin=new Scanner(System.in);
        String name=cin.nextLine();
        for(ProductManegmwntSystem prod :s.getProducts()){

            if(prod.getProductName().contains(name)||prod.getProductDescription().contains(name)){
found=false;
                n.add(prod.getUniq());
            }
        }
        try{
        int t=0;
            System.out.println("These products do not cause you allergies\n");
            for(ProductManegmwntSystem pro :s.getProducts()){
                if (!n.contains(pro.getUniq())){
                System.out.println(pro);
            }
            ++t;
        }




}catch (Exception e){

}



    }

  /*  public static void main(String[] args) {
        SweetProject s=new SweetProject();
        s.products.add(new ProductManegmwntSystem("Nutel cake","Layers of chocolate cake with chocolate cream in the top", 60.0,10.0,10,"finished",1));
        s.products.add(new ProductManegmwntSystem("Nulla popcake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        s.products.add(new ProductManegmwntSystem("Nutela juice","Layers of chocolate cake with chocolate cream in the front", 60.0,10.0,14,"not finished",3));
        UserRecipes u=new UserRecipes();
        u.filterRecipes();
    }*/

}
