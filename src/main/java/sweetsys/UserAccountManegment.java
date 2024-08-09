package sweetsys;

import java.util.Scanner;

import static java.lang.System.exit;

public class UserAccountManegment {


    public boolean exist;
    private boolean found;
    private boolean isexist;

    public boolean isIsexist() {
        return isexist;
    }

    public void setIsexist(boolean isexist) {
        this.isexist = isexist;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public UserAccountManegment(){}


    public void ShowUsers(){
        SweetProject s =new SweetProject();
UserAccountManegment users =new UserAccountManegment();



        for(User u : s.getUsers()) {
            if (u.getUserlevel() == 3)
            {
                s.UsersArrayList.add(u);
                s.setUsersArrayList(s.UsersArrayList);
                System.out.println(u);
                users.setIsexist(true);

            }
        }
        if(!isexist){
            System.out.println("there is no User in the System");
        }

    }


    public void UpdateUser(){

        SweetProject s =new SweetProject();

        User user;

        UserAccountManegment userac =new UserAccountManegment();

        String name;
        System.out.println("\n\nEnter UserName of employee you want to update pls :\n");
        Scanner cin =new Scanner(System.in);
        name=cin.nextLine();
        System.out.println("Enter Pass of "+name+" to update pls :\n");
        String pass=cin.nextLine();
        int userlevel=3;

        user=new User(name,pass,userlevel);

        s.login(user);
        for(User u:s.getUsers()){
            if(u.getUsername().equals(user.getUsername())&&u.getPass().equals(user.getPass())&&u.getUserlevel()==user.getUserlevel()){

                userac.setFound(true);

            }
        }
        if(!userac.isFound()){
            System.out.println("you entered wrong details try again");
            exit(0);
        }

        Scanner c =new Scanner(System.in);
        System.out.println("\n \nEnter the new UserName of "+name+" to update pls :\n");
        String newname=c.nextLine();
        System.out.println("Enter the new Pass of "+name+" to update pls :\n");
        String newpass=c.nextLine();

        for(User u:s.getUsers()){
            if(u.getUsername().equals(user.getUsername())&&u.getPass().equals(user.getPass())&&u.getUserlevel()==user.getUserlevel()){

                u.setUsername(newname);
                u.setPass(newpass);
                String email=newname+newpass+"@gmail.com";
                u.setEmail(email);

            }

        }

        userac.ShowUsers();


    }


    public static void main(String[] args) {
        SweetProject s=new SweetProject();
        s.users.add(new User("anwar", "123", 1,"anwar123@gmail.com"));
        s.users.add(new User("ahmad", "1234", 2,"ahmad1234@gmail.com"));
        s.users.add(new User("yasmine", "12345", 2,"yasmine12345@gmail.com"));
        s.users.add(new User("tarneem", "123456", 3,"tarneem1234@gmail.com"));
        UserAccountManegment test=new UserAccountManegment();
        test.ShowUsers();
        test.UpdateUser();
    }

}
