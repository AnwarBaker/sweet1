package sweetsys;

import java.util.Iterator;
import java.util.Scanner;

import static java.lang.System.exit;

public class ContentSection {
    public boolean in;



    public ContentSection(){}


    public void UpdateUserRecipes(){

        SweetProject s=new SweetProject();
        UserShareProducts u=new UserShareProducts();

for(UserShareProducts pro :u.getUserproducts()){
    System.out.println(pro);
}

boolean found=false;

        System.out.println("\n\nenter Name of product you want to update pls :\n");
        Scanner cin =new Scanner(System.in);
        String  name=cin.nextLine();



        for(UserShareProducts uu:u.getUserproducts()){
            if(uu.getProductName().equalsIgnoreCase(name)){
                found = true;

            }
        }
        if(!found){
            System.out.println("you entered wrong details try again");
            exit(0);
        }
        Scanner c =new Scanner(System.in);
        System.out.println("\n \nenter the new Name of product you want to update pls :\n");
        String newname=c.nextLine();
        System.out.println("enter the new Description of product you want to update pls :\n");
        String newDis=c.nextLine();
        System.out.println("enter the new Expected Price of employee you want to update pls :a\n");
        double newprice=cin.nextInt();

        for(UserShareProducts uu:u.getUserproducts()){
            if(uu.getProductName().equalsIgnoreCase(name)){

                uu.setProductName(newname);
                uu.setProductDescription(newDis);
                uu.setExpectedprice(newprice);

            }

        }
        u.setUserproducts(u.userproducts);
        for(UserShareProducts uu:u.getUserproducts()){
            System.out.println(uu);
        }
    }








    public void DeleteUserRecipes( ) {
        Scanner cin = new Scanner(System.in);
UserShareProducts userss =new UserShareProducts();
        // Display the current user-shared products
        for (UserShareProducts pro : userss.getUserproducts()) {
            System.out.println(pro);
        }

        System.out.println("\n\nEnter the name of the product you want to delete, please:\n");
        String name = cin.nextLine();

        boolean found = false;
        Iterator<UserShareProducts> iterator = userss.getUserproducts().iterator();

        while (iterator.hasNext()) {
            UserShareProducts uu = iterator.next();
            if (uu.getProductName() != null && uu.getProductName().equalsIgnoreCase(name)) {
                iterator.remove();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("You entered wrong details. Try again.");
        } else {
            System.out.println("Product deleted successfully.");
        }

        // Display the updated list of user-shared products
        for (UserShareProducts pro : userss.getUserproducts()) {
            System.out.println(pro);
        }
    }



  /*  public static void main(String[] args) {
        SweetProject s=new SweetProject();
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,10,"finished",1));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        s.products.add(new ProductManegmwntSystem("Nutella cake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,14,"not finished",3));

        UserShareProducts prod =new UserShareProducts("cake","Layers of chocolate cake with chocolate cream in the middle", 60.0);
        UserShareProducts pro =new UserShareProducts("ds cake","Layers of chocolate cake with chocolate cream in the middle", 60.0);
        prod.addnewProductForUser(prod);
        prod.addnewProductForUser(pro);

        ContentSection c=new ContentSection();
        c.UpdateUserRecipes();
        c.DeleteUserRecipes();
    }*/

}
