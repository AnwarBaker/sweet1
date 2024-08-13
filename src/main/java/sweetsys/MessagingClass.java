package sweetsys;

import java.util.ArrayList;
import java.util.Scanner;

public class MessagingClass {

    public boolean messageDone;
    private String SenderName;
     private String ReciverName;
     private String Meessage;

     static public ArrayList<MessagingClass> messages =new ArrayList<MessagingClass>();

    public MessagingClass(String senderName, String reciverName, String message) {
        SenderName = senderName;
        ReciverName = reciverName;
        Meessage = message;
    }

    public MessagingClass(String senderName, String reciverName) {
        SenderName = senderName;
        ReciverName = reciverName;
    }

    public String getReciverName() {
        return ReciverName;
    }

    public void setReciverName(String reciverName) {
        ReciverName = reciverName;
    }

    public String getSenderName() {
        return SenderName;
    }

    public void setSenderName(String senderName) {
        SenderName = senderName;
    }

    public String getMeessage() {
        return Meessage;
    }

    public void setMeessage(String meessage) {
        Meessage = meessage;
    }


    public static ArrayList<MessagingClass> getMessages() {
        return messages;
    }

    public static void setMessages(ArrayList<MessagingClass> messages) {
        MessagingClass.messages = messages;
    }

    public boolean in;

    @Override
    public String toString() {
        return "{" +
                "Message='" + Meessage + '\'' +
                ", ReciverName='" + ReciverName + '\'' +
                ", SenderName='" + SenderName + '\'' +
                '}'+"\n";
    }

    public MessagingClass(){}







    public void UserSendMesseges(User user){


SweetProject s=new SweetProject();
String name =user.getUsername();
String city= user.getCity();

try {
    for (User u : s.getUsers()) {
        if (u.getUsername().equals(name)&&u.getUserlevel()==3) {
            city = u.getCity();
        }
    }
    String recive="";
    for (User uss : s.getUsers()) {
        if (uss.getUserlevel() == 2 && uss.getCity().equalsIgnoreCase(city)) {
            recive = uss.getUsername();
        }

    }
    System.out.println("Enter your message for "+recive+" "+city+" Store Owner");
    Scanner cin =new Scanner(System.in);
    String message =cin.nextLine();

    MessagingClass m=new MessagingClass(name,recive,message);
    m.messages.add(m);
    m.setMessages(messages);
    System.out.println(m.getMessages());

}catch (Exception e){}

    }








   /* public static void main(String[] args) {
        SweetProject s=new SweetProject();
        s.users.add(new User("anwar", "123", 1,"anwar123@gmail.com","Jenin"));
        s.users.add(new User("ahmad", "1234", 3,"ahmad1234@gmail.com","Nablus"));
        s.users.add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com","nablus"));
        s.users.add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com","Jenin"));
        s.users.add(new User("rama", "123455", 2,"rama123455@gmail.com","nablus"));
        s.users.add(new User("tala", "12345566", 2,"tala12345566@gmail.com","Jenin"));
        s.setUsers(s.users);
        User u=new User("talaa", "12346", 3,"talaa12346@gmail.com","Jenin");
        s.login(u);
        MessagingClass m=new MessagingClass();
        m.UserSendMesseges(u);

    }*/





}


