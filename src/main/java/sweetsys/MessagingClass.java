package sweetsys;

import java.util.ArrayList;


public class MessagingClass {

    private String sendername;
     private String recivername;
     private String meessage;

     static protected ArrayList<MessagingClass> messages =new ArrayList<>();

    public MessagingClass(String senderName, String reciverName, String message) {
        sendername = senderName;
        recivername = reciverName;
        meessage = message;
    }

    public String getRecivername() {
        return recivername;
    }

    public void setRecivername(String recivername) {
        this.recivername = recivername;
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername;
    }

    public String getMeessage() {
        return meessage;
    }

    public void setMeessage(String meessage) {
        this.meessage = meessage;
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
                "Message='" + meessage + '\'' +
                ", ReciverName='" + recivername + '\'' +
                ", SenderName='" + sendername + '\'' +
                '}'+"\n";
    }

    public MessagingClass(){}

    public void usersendMessages(User user, String message) {
        String name = user.getUsername();
        String city = user.getCity();

        if (city == null) {
            city = "";
        }

        for (User u : SweetProject.getUsers()) {
            if (u.getUsername().equals(name) && u.getUserlevel() == 3) {
                city = u.getCity();
                if (city == null) {
                    city = "";
                }
                break;
            }
        }

        String recive = "";
        for (User uss : SweetProject.getUsers()) {
            if (uss.getUserlevel() == 2) {
                String ussCity = uss.getCity();
                if (city.equalsIgnoreCase(ussCity)) {
                    recive = uss.getUsername();
                    break;
                }
            }
        }

        MessagingClass m = new MessagingClass(name, recive, message);
        messages.add(m);
        setMessages(messages);
    }

}








