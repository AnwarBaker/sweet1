package sweetsys;
import java.util.ArrayList;
public class SweetProject {
    private String errorMessage;
    private String existdataMessage;



private boolean exist;

    public boolean isExist() {
        return exist;
    }


  

    static public    ArrayList<User> users =new ArrayList<>();
    static protected   ArrayList<User> Nablususers =new ArrayList<>();
    static protected ArrayList<User> JeninUsers =new ArrayList<>();




    static public ArrayList<ProductManegmwntSystem> products =new ArrayList<>();
    static public ArrayList<ProductManegmwntSystem> bestselling =new ArrayList<>();

    static protected ArrayList<ProductManegmwntSystem> nablusProdcuts =new ArrayList<>();
    static protected ArrayList<ProductManegmwntSystem> Jeninprodcuts =new ArrayList<>();
    static protected ArrayList<ProductManegmwntSystem> Jeninbestselling =new ArrayList<>();
    static protected ArrayList<ProductManegmwntSystem> Nablusbestselling =new ArrayList<>();


    public static ArrayList<ProductManegmwntSystem> getNablusProdcuts() {
        return nablusProdcuts;
    }

    public static void setNablusProdcuts(ArrayList<ProductManegmwntSystem> nablusProdcuts) {
        SweetProject.nablusProdcuts = nablusProdcuts;
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




    public static ArrayList<ProductManegmwntSystem> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<ProductManegmwntSystem> products) {
        SweetProject.products = products;
    }



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






    static protected ArrayList<User> AdminArrayList = new ArrayList<User>();

    static protected ArrayList<User> StoreOwnerArrayList = new ArrayList<User>();

    static protected ArrayList<User> usersArraylist = new ArrayList<User>();

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


    public static ArrayList<User> getUsersArraylist() {
        return usersArraylist;
    }

    public static void setUsersArraylist(ArrayList<User> usersArraylist) {
        SweetProject.usersArraylist = usersArraylist;
    }

    public void showeachTypeofusers(){

        for(User u: getUsers()){
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

                SweetProject.usersArraylist.add(user);
                SweetProject.setUsersArraylist(usersArraylist);


            }
        }
    }







    public void update(User user){


       for(int i = 0; i < users.size(); i++){
           if(SweetProject.users.get(i).getUsername().equalsIgnoreCase(user.getUsername())){
               SweetProject.users.set(i,user);
               break;
           }
        }

    }




    public void delete(User user){


            for(int i = 0; i < users.size(); i++){
                if(SweetProject.users.get(i).getUsername().equalsIgnoreCase(user.getUsername())&&SweetProject.users.get(i).getPass().equals(user.getPass())){

                    SweetProject.users.remove(i);
                    break;
                }
            }
            SweetProject.setUsers(SweetProject.users);


    }




    public void productUpdate( ProductManegmwntSystem prod){

            for(int i = 0; i < products.size(); i++){
                if(SweetProject.products.get(i).getUniq()==prod.getUniq()){
                    SweetProject.products.set(i,prod);
                    break;
                }
            }
            SweetProject.setProducts(SweetProject.products);

    }





    public void addnewProduct(ProductManegmwntSystem prod) {
        boolean tesTxist=false;


            for(int i=0 ;i<SweetProject.getProducts().size();i++){
                if(products.get(i).getUniq()==prod.getUniq()){
                    tesTxist =true;
                    break;
                }
            }

  if(!tesTxist){
      int last=SweetProject.getProducts().size();
      prod.setUniq(last);
      products.add(prod);
  }
  setProducts(products);


    }






    public void deleteProduct(ProductManegmwntSystem prod){


            for(int i = 0; i < products.size(); i++){
                if(products.get(i).getUniq()==prod.getUniq()){

                    SweetProject.products.remove(i);
                    break;
                }
            }
            setProducts(SweetProject.products);

    }


}

