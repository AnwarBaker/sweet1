package sweetsys;

import java.util.Scanner;

import static java.lang.System.exit;


public class StoreOwnerAccountManegment {

    public boolean found;
public boolean come;
public boolean updated;
    public boolean isCome() {
        return come;
    }

    public void setCome(boolean come) {
        this.come = come;
    }

    public StoreOwnerAccountManegment(){}

    SweetProject b;

    public StoreOwnerAccountManegment(SweetProject b) {
        this.b = b;
    }



    public void ShowStoreOwners(){
        SweetProject s =new SweetProject();

        boolean isexist=false;


           for(User u : s.getUsers()) {
               if (u.getUserlevel() == 2)
               {
                   s.StoreOwnerArrayList.add(u);
                   s.setStoreOwnerArrayList(s.StoreOwnerArrayList);
                   System.out.println(u);
                   isexist=true;

               }
           }
           if(!isexist){
               System.out.println("there is no Store Owner in the System");
           }

    }


       public void UpdateStoreOwnerAccount(){

        SweetProject s =new SweetProject();

            User user;
     StoreOwnerAccountManegment store=new StoreOwnerAccountManegment();
store.ShowStoreOwners();
            String name;
            System.out.println("\n\nEnter UserName of employee you want to update pls :\n");
            Scanner cin =new Scanner(System.in);
            name=cin.nextLine();
            System.out.println("Enter Pass of "+name+" to update pls :\n");
            String pass=cin.nextLine();
          int userlevel=2;

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

           store.ShowStoreOwners();


    }


   /* public static void main(String[] args) {
        SweetProject s=new SweetProject();
        User u = new User("yasmine", "12345",2);
        s.login(u);
        s.users.add(new User("anwar", "123", 1,"anwar123@gmail.com"));
        s.users.add(new User("ahmad", "1234", 2,"ahmad1234@gmail.com"));
        s.users.add(new User("yasmine", "12345", 2,"yasmine12345@gmail.com"));
        s.users.add(new User("tarneem", "123456", 3,"tarneem1234@gmail.com"));
        StoreOwnerAccountManegment test=new StoreOwnerAccountManegment();

        test.UpdateStoreOwnerAccount();
    }*/

}
