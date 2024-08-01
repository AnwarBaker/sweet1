package sweetsys;

import swt.LoginClass;

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


        users.add(new User("anwar","123",1));
        users.add(new User("ahmad","1234",2));
        users.add(new User("yasmine","12345",1));
        users.add(new User("tarneem","123456",3));
        Scanner cin=new Scanner(System.in);

       /*System.out.println("\nEnter Your Name Pls");
        String namee=cin.nextLine();

        User u=new User();

        u.setUsername(namee);

        System.out.println("\nEnter Your Password Pls");

        String passw=cin.nextLine();

        u.setPass(passw);
        SweetProject t=new SweetProject();
        t.isValidUser(users,u.getUsername(),u.getPass());*/
        SweetProject t=new SweetProject();

        t.setUsers(users);
        t.getUsers();
        for(User h :users){
            System.out.println(h);
        }


    }

}
