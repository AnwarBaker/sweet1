package sweetsys;

import java.util.ArrayList;
import java.util.List;

public class AdminFeedback {

    public static final boolean IN=false;
    private String username;
    private String adminname;
    private String response;
    private int responseNumber;


    protected static List<AdminFeedback> adminresponse = new ArrayList<>();


    public AdminFeedback(String adminName, int responseNumber, String response, String username) {
        this.adminname = adminName;
        this.responseNumber = responseNumber;
        this.response = response;
        this.username = username;
    }

    public int getResponseNumber() {
        return responseNumber;
    }

    public void setResponseNumber(int responseNumber) {
        this.responseNumber = responseNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public static List<AdminFeedback> getAdminresponse() {
        return adminresponse;
    }

    public static void setAdminresponse(List<AdminFeedback> adminresponse) {
        AdminFeedback.adminresponse = adminresponse;
    }

    public AdminFeedback() {
    }

    @Override
    public String toString() {
        return "AdminFeedback{" +
                "username='" + username + '\'' +
                ", adminname='" + adminname + '\'' +
                ", response='" + response + '\'' +
                ", responseNumber=" + responseNumber +
                '}';
    }

    public void adminResponsemessege(User user, int num, String resmsg) {


        String name = user.getUsername();

            String usernameee="";
            int resnum=0;
            for (FeedBack feed : FeedBack.getFeedBacklist()) {
                if (feed.getFeednumber() == num) {
                  usernameee = feed.getSenderName();
                  resnum=num;
                }
            }


            AdminFeedback a=new AdminFeedback(name,resnum,resmsg,usernameee);
            adminresponse.add(a);
            setAdminresponse(adminresponse);
            System.out.println(getAdminresponse());
    }
}