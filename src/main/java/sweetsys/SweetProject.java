package sweetsys;



import java.util.ArrayList;
import java.util.Scanner;

public class SweetProject {


    public boolean is_login;
    public boolean a;

    static public ArrayList<User> users =new ArrayList<User>();

User u=new User();

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


    public static void main(String[] args) {



        SweetProject t=new SweetProject();

        t.setUsers(users);
        t.getUsers();
        for(User h :users){
            System.out.println(h);
        }


    }


}
