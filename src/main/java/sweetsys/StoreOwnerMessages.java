package sweetsys;

import java.util.ArrayList;
import java.util.List;


import static java.lang.System.exit;

public class StoreOwnerMessages {
    public static final boolean IN=false;
  private String storownerename;
  private String username;
  private String message;
  private int messagenum;


  protected static List<StoreOwnerMessages> messegaesList =new ArrayList<>();


    public StoreOwnerMessages(String storownereName, String username, String message, int messagenum) {
        this.storownerename = storownereName;
        this.username = username;
        this.message = message;
        this.messagenum = messagenum;
    }


    public String getStorownerename() {
        return storownerename;
    }

    public void setStorownerename(String storownerename) {
        this.storownerename = storownerename;
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

    public static List<StoreOwnerMessages> getMessegaesList() {
        return messegaesList;
    }

    public static void setMessegaesList(List<StoreOwnerMessages> messegaesList) {
        StoreOwnerMessages.messegaesList = messegaesList;
    }

    public StoreOwnerMessages() {
    }


    @Override
    public String toString() {
        return "{" +
                "storename='" + storownerename + '\'' +
                ", message='" + message + '\'' +
                ", username='" + username + '\'' +
                ", messagenum=" + messagenum +
                '}'+"\n";
    }


public void storeOwnersendmesseges(User user, String messagee, String usernamee) {
    String name = user.getUsername();
    boolean found = false;

    int last = getMessegaesList().size();

    for (User us : SweetProject.getUsers()) {
        if (us.getUserlevel() == 3 && us.getUsername().equals(usernamee)) {
            found = true;
            StoreOwnerMessages m = new StoreOwnerMessages(name, usernamee, messagee, last + 1);
            messegaesList.add(m);
            setMessegaesList(messegaesList);
            break;
        }
    }
    if(!found){
        exit(0);
    }


}

    public void storeResponsemessege(User user,String usernamee,String res) {

boolean find=false;
        String name = user.getUsername();
        int last = getMessegaesList().size();
        for (MessagingClass mmm : MessagingClass.getMessages()) {

            if (mmm.getSendername().equals(usernamee)) {
                username = mmm.getSendername();
                StoreOwnerMessages st = new StoreOwnerMessages(name, usernamee, res, last + 1);
                messegaesList.add(st);
                find=true;
                setMessegaesList(messegaesList);
                break;
            }
        }
        if(!find){exit(0);}
    }

}
