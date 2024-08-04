package sweetsys;

import java.util.*;
public class signup {



    public boolean in;
    public boolean done;

public signup(){}


    SweetProject s=new SweetProject();
User user;


   public signup(User u){
       user=u;
   }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void addnewuser(User user){
       SweetProject s=new SweetProject();
       boolean exist;
       this.user=user;
       setDone(false);
if(user.getUserlevel()==1||user.getUserlevel()==2||user.getUserlevel()==3){
       exist= s.isValidUser(s.getUsers(),user.getUsername(),user.getPass());
       if(!exist){
           s.users.add(user);
           s.setUsers(s.users);
           setDone(true);
           System.out.println("user added successfully");


       }
       else{
           System.out.println("user already exists");
       }
}else{
    System.out.println("enter valid userlevel pls");
}

   }
    public static void main(String[] args) {
        SweetProject s=new SweetProject();
        s.users.add(new User("anwar", "123", 1));
        s.users.add(new User("ahmad", "1234", 2));
        s.users.add(new User("yasmine", "12345", 1));
        s.users.add(new User("tarneem", "123456", 3));
        s.setUsers(s.users);

        signup sign=new signup();

        Scanner cin=new Scanner(System.in);
        System.out.println("welcome to sign up page in sweet system\n");

        System.out.println("enter name of new employee pls: ");
        String name=cin.nextLine();
        System.out.println("enter password of new employee pls: ");
        String pass=cin.nextLine();
        System.out.println("enter UserLevel of new employee pls :\n for Admin enter '1'\n for store owner enter '2'\n for user enter '3'\n ");
        int userlevel=cin.nextInt();
        User new_user=new User(name,pass,userlevel);

        sign.addnewuser(new_user);

        for(User u :s.users){
            System.out.println(u);
        }
    }


}
