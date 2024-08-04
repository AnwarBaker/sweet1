package sweetsys;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import static java.lang.System.exit;

public class SweetProject {


    public boolean is_login;
    public boolean a;

    static public ArrayList<User> users =new ArrayList<User>();
    public boolean founddd;
    public boolean deleted;


    User u=new User();
    public static boolean print;
    public boolean found;

    public void login(User u) {

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
            return "Invalid email or password";
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







    public void ShowEachTypeOfUsers(ArrayList<User> users){

        for(User u:users){
            if(u.getUserlevel()==1)  {
                User user=new User(u.getUsername(),u.getPass(),u.getUserlevel());

                SweetProject.AdminArrayList.add(user);
                SweetProject.setAdminArrayList(AdminArrayList);
                SweetProject.print=true;

            }
            else if(u.getUserlevel()==2)  {
               User user=new User(u.getUsername(),u.getPass(),u.getUserlevel());
                SweetProject.StoreOwnerArrayList.add(user);
                SweetProject.setStoreOwnerArrayList(StoreOwnerArrayList);
                SweetProject.print=true;
            }

            else if(u.getUserlevel()==3)  {
               User user=new User(u.getUsername(),u.getPass(),u.getUserlevel());

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
        s.ShowEachTypeOfUsers(s.getUsers());
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

        for(User u:s.getUsers()){
            if(u.getUsername().equals(user.getUsername())&&u.getPass().equals(user.getPass())&&u.getUserlevel()==user.getUserlevel()){

                u.setUsername(newname);
                u.setPass(newpass);
                u.setUserlevel(newuserlevel);

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

        for(User u:s.getUsers()){
            System.out.println(u);
        }
    }

    public static void main(String[] args) {



        /*SweetProject t=new SweetProject();



        t.users.add(new User("anwar", "123", 1));
        t.users.add(new User("ahmad", "1234", 2));
        t.users.add(new User("yasmine", "12345", 1));
        t.users.add(new User("tarneem", "123456", 3));
        t.setUsers(t.users);
        t.setUsers(SweetProject.users);
        t.ShowEachTypeOfUsers(SweetProject.users);*/

        SweetProject t=new SweetProject();



        t.users.add(new User("anwar", "123", 1));
        t.users.add(new User("ahmad", "1234", 2));
        t.users.add(new User("yasmine", "12345", 1));
        t.users.add(new User("tarneem", "123456", 3));
        t.setUsers(t.users);

        t.setUsers(SweetProject.users);
boolean s;
        s=t.isValidUser(t.users,"fadi","1234");
        System.out.println(s);


    }


}
