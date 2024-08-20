package sweetsys;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminFeedback {
    public boolean Done;
    private String username;
    private String AdminName;
    private String Response;
    private int responseNumber;


    static public ArrayList<AdminFeedback> adminresponse = new ArrayList<>();


    public AdminFeedback(String adminName, int responseNumber, String response, String username) {
        AdminName = adminName;
        this.responseNumber = responseNumber;
        Response = response;
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

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    public static ArrayList<AdminFeedback> getAdminresponse() {
        return adminresponse;
    }

    public static void setAdminresponse(ArrayList<AdminFeedback> adminresponse) {
        AdminFeedback.adminresponse = adminresponse;
    }

    public AdminFeedback() {
    }

    @Override
    public String toString() {
        return "AdminFeedback{" +
                "username='" + username + '\'' +
                ", AdminName='" + AdminName + '\'' +
                ", Response='" + Response + '\'' +
                '}';
    }


    public void AdminResponseMessege(User user) {
        FeedBack f = new FeedBack();
        String name = user.getUsername();
        try {
            for (FeedBack feed : f.getFeedBacklist()) {
                System.out.println(feed);
            }
            System.out.println("Enter num of feedback you want to response");
            Scanner cin = new Scanner(System.in);
            int i = cin.nextInt();
            String usernamee="";
            int resnum=0;
            for (FeedBack feed : f.getFeedBacklist()) {
                if (feed.getFeednumber() == i) {
                  usernamee=feed.getSenderName();
                  resnum=i;
                }
            }
            System.out.println("Enter Your Response on "+username+" feedback:");
            Scanner c=new Scanner(System.in);
            String res=c.nextLine();
            AdminFeedback a=new AdminFeedback(name,resnum,res,username);
            AdminFeedback aa=new AdminFeedback();
            aa.adminresponse.add(a);
            aa.setAdminresponse(adminresponse);
            System.out.println(aa.getAdminresponse());

        } catch (Exception e) {}

    }


    /*public static void main(String[] args) {
        SweetProject s=new SweetProject();
        s.users.add(new User("rama", "123455", 2,"rama123455@gmail.com","nablus"));
        s.users.add(new User("tala", "12345566", 2,"tala12345566@gmail.com","Jenin"));
        s.setUsers(s.users);
        User u=new User("talaa", "12346", 3,"talaa12346@gmail.com","Jenin");
        s.login(u);
        s.products.add(new ProductManegmwntSystem(1,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",5));
        s.products.add(new ProductManegmwntSystem(2,"Nutella cake","Jenin","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",10));
        s.products.add(new ProductManegmwntSystem(3,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",12));
        FeedBack fe=new FeedBack();
        fe.UserFeedBack(u);
        User uuu=new User("eeee", "1", 1,"eeee1@gmail.com","Jenin");
        s.login(uuu);
        AdminFeedback aa=new AdminFeedback();
        aa.AdminResponseMessege(uuu);
    }*/

}