package sweetsys;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreOwnerMessages {
    public boolean in;
  private String StorOwnereName;
  private String username;
  private String message;
  private int messagenum;


  static public ArrayList<StoreOwnerMessages> messegaesList =new ArrayList<StoreOwnerMessages>();


    public StoreOwnerMessages(String StorOwnereName, String username, String message, int messagenum) {
        this.StorOwnereName = StorOwnereName;
        this.username = username;
        this.message = message;
        this.messagenum = messagenum;
    }


    public String getStorOwnereName() {
        return StorOwnereName;
    }

    public void setStorOwnereName(String storOwnereName) {
        StorOwnereName = storOwnereName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMessagenum() {
        return messagenum;
    }

    public void setMessagenum(int messagenum) {
        this.messagenum = messagenum;
    }

    public static ArrayList<StoreOwnerMessages> getMessegaesList() {
        return messegaesList;
    }

    public static void setMessegaesList(ArrayList<StoreOwnerMessages> messegaesList) {
        StoreOwnerMessages.messegaesList = messegaesList;
    }

    public StoreOwnerMessages() {
    }


    @Override
    public String toString() {
        return "{" +
                "storename='" + StorOwnereName + '\'' +
                ", message='" + message + '\'' +
                ", username='" + username + '\'' +
                ", messagenum=" + messagenum +
                '}'+"\n";
    }



    public void StoreOwnerSendMesseges(User user){


        SweetProject s=new SweetProject();
        String name =user.getUsername();
        Scanner cin=new Scanner(System.in);
        boolean found = false;
        try {
            for (User u : s.getUsers()) {
                if(u.getUserlevel()==3){
                    System.out.println(u);
                }
            }
            String message="";
            System.out.println("Enter name of User YOU Wanna message :");
            String username=cin.nextLine();


            StoreOwnerMessages send=new StoreOwnerMessages();


            int last=send.getMessegaesList().size()-1;

            int mnum=send.getMessegaesList().get(last).getMessagenum();

            for (User us : s.getUsers()) {

                if (us.getUserlevel() == 3 && us.getUsername().equals(username)) {

                     found = true;
                     break;
                }

            }
            if(found){
                System.out.println("Enter your message for "+username);
                Scanner c =new Scanner(System.in);
                 message =c.nextLine();
            }

             StoreOwnerMessages mmm=new StoreOwnerMessages();

            StoreOwnerMessages m=new StoreOwnerMessages(name,username,message,mnum+1);
            m.messegaesList.add(m);
            m.setMessegaesList(messegaesList);
            System.out.println(m.getMessegaesList());

        }catch (Exception e){}

    }










    public void StoreResponseMessege(User user) {

        MessagingClass mm = new MessagingClass();
        boolean find=false;
        String name = user.getUsername();

        try {

            System.out.println("Enter Name of User you want to response");
            Scanner cin = new Scanner(System.in);
            String usernamee = cin.nextLine();

            StoreOwnerMessages storeresponse=new StoreOwnerMessages();
            int last=storeresponse.getMessegaesList().size()-1;

            int resnum=storeresponse.getMessegaesList().get(last).getMessagenum();


            for (MessagingClass mmm :  mm.getMessages()) {

                if (mmm.getSenderName().equals(usernamee)) {
                    username=mmm.getSenderName();

                    find=true;
                }
            }
            if(find){
                System.out.println("Enter Your Response on "+usernamee+" message:");
                Scanner c=new Scanner(System.in);
                String res=c.nextLine();
                StoreOwnerMessages st =new StoreOwnerMessages(name,usernamee,res,resnum+1);
                StoreOwnerMessages aa=new StoreOwnerMessages();
                aa.messegaesList.add(st);
                aa.setMessegaesList(messegaesList);

            }


        } catch (Exception e) {}

    }









    /*public static void main(String[] args) {
        SweetProject s=new SweetProject();
        s.users.add(new User("anwar", "123", 1,"anwar123@gmail.com","Jenin"));
        s.users.add(new User("ahmad", "1234", 3,"ahmad1234@gmail.com","Nablus"));
        s.users.add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com","nablus"));
        s.users.add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com","Jenin"));
        s.users.add(new User("rama", "145", 3,"rama145@gmail.com","nablus"));
        s.users.add(new User("tala", "1", 3,"tala1@gmail.com","Jenin"));
        User user =new User("talal", "12", 2,"talal12@gmail.com","Jenin");
        s.login(user);
        s.setUsers(s.users);


        User u=new User("talaa", "12346", 3,"talaa12346@gmail.com","Jenin");
        s.login(u);
        MessagingClass m=new MessagingClass();
        m.UserSendMesseges(u);

        User uu=new User("talaall", "1234666", 2,"talaall1234666@gmail.com","Jenin");


        StoreOwnerMessages sto=new StoreOwnerMessages();
        sto.StoreResponseMessege(uu);
    }*/

}
