package sweetsys;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import static java.lang.System.exit;

public class SweetProject {


    public boolean is_login;
    public boolean a;

    static public ArrayList<User> users =new ArrayList<User>();
    static public ArrayList<User> Nablususers =new ArrayList<User>();
    static public ArrayList<User> JeninUsers =new ArrayList<User>();


    public boolean founddd;
    public boolean deleted;

    static public ArrayList<ProductManegmwntSystem> products =new ArrayList<ProductManegmwntSystem>();
    static public ArrayList<ProductManegmwntSystem> bestselling =new ArrayList<ProductManegmwntSystem>();

    static public ArrayList<ProductManegmwntSystem> Nablusprodcuts =new ArrayList<ProductManegmwntSystem>();
    static public ArrayList<ProductManegmwntSystem> Jeninprodcuts =new ArrayList<ProductManegmwntSystem>();
    static public ArrayList<ProductManegmwntSystem> Jeninbestselling =new ArrayList<ProductManegmwntSystem>();
    static public ArrayList<ProductManegmwntSystem> Nablusbestselling =new ArrayList<ProductManegmwntSystem>();


    public static ArrayList<ProductManegmwntSystem> getNablusprodcuts() {
        return Nablusprodcuts;
    }

    public static void setNablusprodcuts(ArrayList<ProductManegmwntSystem> nablusprodcuts) {
        Nablusprodcuts = nablusprodcuts;
    }

    public static ArrayList<ProductManegmwntSystem> getJeninprodcuts() {
        return Jeninprodcuts;
    }

    public static void setJeninprodcuts(ArrayList<ProductManegmwntSystem> jeninsprodcuts) {
        Jeninprodcuts = jeninsprodcuts;
    }

    public static ArrayList<ProductManegmwntSystem> getJeninbestselling() {
        return Jeninbestselling;
    }

    public static void setJeninbestselling(ArrayList<ProductManegmwntSystem> jeninbestselling) {
        Jeninbestselling = jeninbestselling;
    }

    public static ArrayList<ProductManegmwntSystem> getNablusbestselling() {
        return Nablusbestselling;
    }

    public static void setNablusbestselling(ArrayList<ProductManegmwntSystem> nablusbestselling) {
        Nablusbestselling = nablusbestselling;
    }

    public static ArrayList<User> getNablususers() {
        return Nablususers;
    }

    public static void setNablususers(ArrayList<User> nablususers) {
        Nablususers = nablususers;
    }

    public static ArrayList<User> getJeninUsers() {
        return JeninUsers;
    }

    public static void setJeninUsers(ArrayList<User> jeninUsers) {
        JeninUsers = jeninUsers;
    }

    public static ArrayList<ProductManegmwntSystem> getBestselling() {
        return bestselling;
    }

    public static void setBestselling(ArrayList<ProductManegmwntSystem> bestselling) {
        SweetProject.bestselling = bestselling;
    }

    public boolean exist;

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public static ArrayList<ProductManegmwntSystem> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<ProductManegmwntSystem> products) {
        SweetProject.products = products;
    }

    User u=new User();
    public static boolean print;
    public boolean found;

    public void login(User u) {

    }

    public void productlogin(ProductManegmwntSystem prod) {

    }
    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        SweetProject.users = users;
    }


    public  boolean isValidUser(ArrayList<User> users, String name, String pass) {
        for (User search : users) {
            if (search.getUsername().equals(name) && search.getPass().equals(pass)) {
                this.a=true;
                return true;
            }
        }
        this.a=false;
        return false;
    }

    public String getErrorMessage() {
        if (!a) {
            return "Invalid Email or password";
        }
        return "";
    }






    static public ArrayList<User> AdminArrayList = new ArrayList<User>();

    static public ArrayList<User> StoreOwnerArrayList = new ArrayList<User>();

    static public ArrayList<User> UsersArrayList = new ArrayList<User>();

    public static ArrayList<User> getAdminArrayList() {
        return AdminArrayList;
    }

    public static void setAdminArrayList(ArrayList<User> adminArrayList) {
        AdminArrayList = adminArrayList;
    }

    public static ArrayList<User> getStoreOwnerArrayList() {
        return StoreOwnerArrayList;
    }

    public static void setStoreOwnerArrayList(ArrayList<User> storeOwnerArrayList) {
        StoreOwnerArrayList = storeOwnerArrayList;
    }

    public static ArrayList<User> getUsersArrayList() {
        return UsersArrayList;
    }

    public static void setUsersArrayList(ArrayList<User> usersArrayList) {
        UsersArrayList = usersArrayList;
    }







    public void ShowEachTypeOfUsers(){
SweetProject s=new SweetProject();
        for(User u:s.getUsers()){
            if(u.getUserlevel()==1)  {
                User user=new User(u.getUsername(),u.getPass(),u.getUserlevel(),u.getEmail(),u.getCity());

                SweetProject.AdminArrayList.add(user);
                SweetProject.setAdminArrayList(AdminArrayList);
                SweetProject.print=true;

            }
            else if(u.getUserlevel()==2)  {
               User user=new User(u.getUsername(),u.getPass(),u.getUserlevel(),u.getEmail(),u.getCity());
                SweetProject.StoreOwnerArrayList.add(user);
                SweetProject.setStoreOwnerArrayList(StoreOwnerArrayList);
                SweetProject.print=true;
            }

            else if(u.getUserlevel()==3)  {
               User user=new User(u.getUsername(),u.getPass(),u.getUserlevel(),u.getEmail(),u.getCity());

                SweetProject.UsersArrayList.add(user);
                SweetProject.setUsersArrayList(UsersArrayList);
                SweetProject.print=true;

            }
        }
        System.out.println("All System employees :\n");
        System.out.println("Admins: \n" + SweetProject.getAdminArrayList());
        System.out.println("Store Owners: \n" + SweetProject.getStoreOwnerArrayList());
        System.out.println("Users: \n" + SweetProject.getUsersArrayList());
    }


    public void Update(){
        SweetProject s=new SweetProject();

User user;
        s.ShowEachTypeOfUsers();
        String name;
        System.out.println("\n\nenter UserName of employee you want to update pls :\n");
        Scanner cin =new Scanner(System.in);
        name=cin.nextLine();
        System.out.println("enter Pass of employee you want to update pls :\n");
        String pass=cin.nextLine();

        System.out.println("enter UserLevel of employee you want to update pls :\n");
        int userlevel=cin.nextInt();
        user=new User(name,pass,userlevel);
        s.login(user);
        for(User u:s.getUsers()){
            if(u.getUsername().equals(user.getUsername())&&u.getPass().equals(user.getPass())&&u.getUserlevel()==user.getUserlevel()){
                found = true;

            }
        }
        if(!found){
            System.out.println("you entered wrong details try again");
            exit(0);
        }
        Scanner c =new Scanner(System.in);
        System.out.println("\n \nenter the new UserName of employee you want to update pls :\n");
        String newname=c.nextLine();
        System.out.println("enter the new Pass of employee you want to update pls :\n");
        String newpass=c.nextLine();
        System.out.println("enter the new UserLevel of employee you want to update pls :a\n");
        int newuserlevel=cin.nextInt();
        String email=newname+newpass+"@gmail.com";

        for(User u:s.getUsers()){
            if(u.getUsername().equals(user.getUsername())&&u.getPass().equals(user.getPass())&&u.getUserlevel()==user.getUserlevel()){

                u.setUsername(newname);
                u.setPass(newpass);
                u.setUserlevel(newuserlevel);
                u.setEmail(email);

            }

        }
        for(User u:s.getUsers()){
            System.out.println(u);
        }
    }





    public void Delete(){
        SweetProject s=new SweetProject();

        User user;
        for(User u:s.getUsers()){
            System.out.println(u);
        }
        String name;
        System.out.println("\n\nenter UserName of employee you want to Delete pls :\n");
        Scanner cin =new Scanner(System.in);
        name=cin.nextLine();
        System.out.println("enter Pass of employee you want to Delete pls :\n");
        String pass=cin.nextLine();

        System.out.println("enter UserLevel of employee you want to Delete pls :\n");
        int userlevel=cin.nextInt();
        user=new User(name,pass,userlevel);
        s.login(user);
        found=false;
        Iterator<User> iterator = s.getUsers().iterator();
        while (iterator.hasNext()) {
            User u = iterator.next();
            if(u.getUsername().equals(user.getUsername())&&u.getPass().equals(user.getPass())&&u.getUserlevel()==user.getUserlevel()){

                iterator.remove();
                found = true;
                s.setUsers(s.users);
                break;

            }
        }
        if(!found){
            System.out.println("you entered wrong details try again");
            exit(0);
        }

       s.ShowEachTypeOfUsers();
    }







    public void ProductUpdate(){
        SweetProject s=new SweetProject();

        ProductManegmwntSystem prod;

        Scanner cin =new Scanner(System.in);
        for(ProductManegmwntSystem products:s.getProducts()){
            System.out.println(products);
        }


        System.out.println("enter UniqNumber of Product you want to update pls :\n");
        int uniqnum=cin.nextInt();
        prod=new ProductManegmwntSystem(uniqnum);
        s.productlogin(prod);



        for(ProductManegmwntSystem products :s.getProducts()){
            if(products.getUniq()==prod.getUniq()){
                found = true;
            }
        }

        if(!found){
            System.out.println("you entered wrong UniqNumber try again");
            exit(0);
        }
        Scanner c =new Scanner(System.in);

        System.out.println("\n \nenter the new Name of product you want to update pls :\n");
        String newname=c.nextLine();
        System.out.println("enter the new descripton of product you want to update pls :\n");
        String newDiscription=c.nextLine();
        System.out.println("enter the new price of product you want to update pls :a\n");
        int newPrice=cin.nextInt();
        System.out.println("enter the new earning num of product you want to update pls :a\n");
        int newearning =cin.nextInt();
        System.out.println("enter the new Num_of_Sales of product you want to update pls :a\n");
        int newNumOfSales=cin.nextInt();
        System.out.println("enter the new Status num of product you want to update pls :a\n");
        String newCondition =c.nextLine();

        for(ProductManegmwntSystem products:s.getProducts()){
            if(products.getUniq()==prod.getUniq()){

                products.setProductName(newname);
                products.setProductDescription(newDiscription);
                products.setPrice(newPrice);
                products.setEarning(newearning);
                products.setNum_Of_Sales(newNumOfSales);
                products.setCondition(newCondition);
            }

        }
        System.out.println("Updated Data\n");
        for(ProductManegmwntSystem products:s.getProducts()){
            System.out.println(products);
        }
    }




    public void addnewProduct(ProductManegmwntSystem prod){
        SweetProject s=new SweetProject();
        for(ProductManegmwntSystem products :s.getProducts()){
          if(products.getUniq()==prod.getUniq()) {
              System.out.println("this product already exists");
              s.setExist(true);
          }
          else if(products.getUniq()!=prod.getUniq()){
              s.setExist(false);
          }

        }
        if(!s.isExist()){
         s.products.add(prod);
        }


    }







    public void DeleteProduct(){
        SweetProject s=new SweetProject();

        ProductManegmwntSystem prod;
        for(ProductManegmwntSystem products:s.getProducts()){
            System.out.println(products);
        }

        Scanner cin=new Scanner(System.in);
        System.out.println("enter UniqNum of Product you want to Delete pls :\n");
        int uniq=cin.nextInt();
        prod=new ProductManegmwntSystem(uniq);
        s.productlogin(prod);
        found=false;
        Iterator<ProductManegmwntSystem> iterator = s.getProducts().iterator();
        while (iterator.hasNext()) {
            ProductManegmwntSystem product = iterator.next();
            if(product.getUniq()==prod.getUniq()){

                iterator.remove();
                found = true;
                s.setProducts(s.products);
                break;

            }
        }
        if(!found){
            System.out.println("you entered wrong details try again");
            exit(0);
        }

        for(ProductManegmwntSystem product : s.getProducts()){
            System.out.println(product);
        }
    }





    }

