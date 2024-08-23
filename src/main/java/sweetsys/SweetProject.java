package sweetsys;
import java.util.ArrayList;
import java.util.List;

public class SweetProject {
    private String errorMessage;
    private String existdataMessage;



private boolean exist;

    public boolean isExist() {
        return exist;
    }




    protected static List <User> users =new ArrayList<>();
    protected static List<User> nablususers =new ArrayList<>();
    protected static List<User> jeninUsers =new ArrayList<>();

    protected static List <ProductManegmwntSystem> products =new ArrayList<>();
    protected static List<ProductManegmwntSystem> bestselling =new ArrayList<>();

    protected static List<ProductManegmwntSystem> nablusProdcuts =new ArrayList<>();
    protected static List<ProductManegmwntSystem> jeninprodcuts =new ArrayList<>();
    protected static List<ProductManegmwntSystem> jeninbestselling =new ArrayList<>();
    protected static List<ProductManegmwntSystem> nablusbestselling =new ArrayList<>();


    public static List<ProductManegmwntSystem> getNablusProdcuts() {
        return nablusProdcuts;
    }

    public static void setNablusProdcuts(List<ProductManegmwntSystem> nablusProdcuts) {
        SweetProject.nablusProdcuts = nablusProdcuts;
    }

    public static List<ProductManegmwntSystem> getJeninprodcuts() {
        return jeninprodcuts;
    }

    public static void setJeninprodcuts(List<ProductManegmwntSystem> jeninprodcuts) {
        SweetProject.jeninprodcuts = jeninprodcuts;
    }

    public static List<ProductManegmwntSystem> getJeninbestselling() {
        return jeninbestselling;
    }

    public static void setJeninbestselling(List<ProductManegmwntSystem> jeninbestselling) {
        SweetProject.jeninbestselling = jeninbestselling;
    }

    public static List<ProductManegmwntSystem> getNablusbestselling() {
        return nablusbestselling;
    }

    public static void setNablusbestselling(List<ProductManegmwntSystem> nablusbestselling) {
        SweetProject.nablusbestselling = nablusbestselling;
    }


    public static List<User> getNablususers() {
        return nablususers;
    }

    public static void setNablususers(List<User> nablususers) {
        SweetProject.nablususers = nablususers;
    }

    public static List<User> getJeninUsers() {
        return jeninUsers;
    }

    public static void setJeninUsers(List<User> jeninUsers) {
        SweetProject.jeninUsers = jeninUsers;
    }


    public static List<ProductManegmwntSystem> getBestselling() {
        return bestselling;
    }

    public static void setBestselling(List<ProductManegmwntSystem> bestselling) {
        SweetProject.bestselling = bestselling;
    }


    public static List<ProductManegmwntSystem> getProducts() {
        return products;
    }

    public static void setProducts(List<ProductManegmwntSystem> products) {
        SweetProject.products = products;
    }

    public void login(User u) {
// empty beacuse well fill later
    }

ProductManegmwntSystem prod;

    public void productlogin(ProductManegmwntSystem prod) {

        this.prod=prod;

    }


    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        SweetProject.users = users;
    }

    public String getExistdataMessage() {
        return existdataMessage;
    }

    public  boolean isValidUser(List<User> users, String name, String pass) {
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


    protected static List<User> adminArraylist = new ArrayList<>();

    protected static List<User> storeOwnerarraylist = new ArrayList<>();

    protected static List<User> usersArraylist = new ArrayList<>();


    public static List<User> getAdminArraylist() {
        return adminArraylist;
    }

    public static void setAdminArraylist(List<User> adminArraylist) {
        SweetProject.adminArraylist = adminArraylist;
    }

    public static List<User> getStoreOwnerarraylist() {
        return storeOwnerarraylist;
    }

    public static void setStoreOwnerarraylist(List<User> storeOwnerarraylist) {
        SweetProject.storeOwnerarraylist = storeOwnerarraylist;
    }

    public static List<User> getUsersArraylist() {
        return usersArraylist;
    }

    public static void setUsersArraylist(List<User> usersArraylist) {
        SweetProject.usersArraylist = usersArraylist;
    }

    public void showeachTypeofusers(){

        for(User u: getUsers()){
            if(u.getUserlevel()==1)  {
                User user=new User(u.getUsername(),u.getPass(),u.getUserlevel(),u.getEmail(),u.getCity());

                SweetProject.adminArraylist.add(user);
                SweetProject.setAdminArraylist(adminArraylist);


            }
            else if(u.getUserlevel()==2)  {
               User user=new User(u.getUsername(),u.getPass(),u.getUserlevel(),u.getEmail(),u.getCity());
                SweetProject.storeOwnerarraylist.add(user);
                SweetProject.setStoreOwnerarraylist(storeOwnerarraylist);

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
      prod.setUniq(last+1);
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

