package sweetsys;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import static java.lang.System.exit;

public class SweetProject {
    private String errorMessage;
    private String existdataMessage;

    public boolean isIs_login() {
        return is_login;
    }


private boolean exist;


    public boolean is_login;
  

    static public ArrayList<User> users =new ArrayList<User>();
    static public ArrayList<User> Nablususers =new ArrayList<User>();
    static public ArrayList<User> JeninUsers =new ArrayList<User>();




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


    public boolean found;

    public void login(User u) {
// empty beacuse well fill later
    }
ProductManegmwntSystem prod;
    public void productlogin(ProductManegmwntSystem prod) {

        this.prod=prod;

    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        SweetProject.users = users;
    }

    public String getExistdataMessage() {
        return existdataMessage;
    }

    public  boolean isValidUser(ArrayList<User> users, String name, String pass) {
        for (User search : users) {
            if (search.getUsername().equals(name) && search.getPass().equals(pass)) {
               this.existdataMessage="User Exists";
                return true;

            }
        }
        this.errorMessage = "Invalid email or password";
        return false;
    }






    public String getErrorMessage() {
        return this.errorMessage;
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


            }
            else if(u.getUserlevel()==2)  {
               User user=new User(u.getUsername(),u.getPass(),u.getUserlevel(),u.getEmail(),u.getCity());
                SweetProject.StoreOwnerArrayList.add(user);
                SweetProject.setStoreOwnerArrayList(StoreOwnerArrayList);

            }

            else if(u.getUserlevel()==3)  {
               User user=new User(u.getUsername(),u.getPass(),u.getUserlevel(),u.getEmail(),u.getCity());

                SweetProject.UsersArrayList.add(user);
                SweetProject.setUsersArrayList(UsersArrayList);


            }
        }


        System.out.println("All System employees :\n");
        System.out.println("Admins: \n" + SweetProject.getAdminArrayList());
        System.out.println("Store Owners: \n" + SweetProject.getStoreOwnerArrayList());
        System.out.println("Users: \n" + SweetProject.getUsersArrayList());
    }







    public void Update(User user){
        try{
       for(int i = 0 ;i <SweetProject.users.size();i++){
           if(SweetProject.users.get(i).getUsername().equalsIgnoreCase(user.getUsername())){
               SweetProject.users.set(i,user);
               break;
           }
        }
    }catch (Exception e){
            e.printStackTrace();
        }
    }




    public void Delete(User user){
        try{

            for(int i = 0 ;i <SweetProject.users.size();i++){
                if(SweetProject.users.get(i).getUsername().equalsIgnoreCase(user.getUsername())&&SweetProject.users.get(i).getPass().equals(user.getPass())){

                    SweetProject.users.remove(i);
                    break;
                }
            }
            SweetProject.setUsers(SweetProject.users);

        }catch (Exception e){e.printStackTrace();}
    }




    public void ProductUpdate( ProductManegmwntSystem prod){
        try{
            for(int i = 0 ;i <SweetProject.products.size();i++){
                if(SweetProject.products.get(i).getUniq()==prod.getUniq()){
                    SweetProject.products.set(i,prod);
                    break;
                }
            }
            SweetProject.setProducts(SweetProject.products);
        }catch (Exception e){
            e.printStackTrace();
        }
    }





    public void addnewProduct(ProductManegmwntSystem prod) {
        SweetProject s=new SweetProject();
        boolean exist=false;

        try{
            for(int i=0 ;i<SweetProject.getProducts().size();i++){
                if(SweetProject.products.get(i).getUniq()==prod.getUniq()){
                    exist =true;
                    break;
                }
            }

  if(!exist){
      int last=SweetProject.getProducts().size();
      prod.setUniq(last);
      SweetProject.products.add(prod);
  }
  SweetProject.setProducts(SweetProject.products);

    }catch(Exception e){e.printStackTrace();}
    }






    public void DeleteProduct(ProductManegmwntSystem prod){
        try{

            for(int i = 0 ;i <SweetProject.products.size();i++){
                if(SweetProject.products.get(i).getUniq()==prod.getUniq()){

                    SweetProject.products.remove(i);
                    break;
                }
            }
            SweetProject.setProducts(SweetProject.products);

        }catch (Exception e){e.printStackTrace();}
    }


}

