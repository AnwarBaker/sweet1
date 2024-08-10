package sweetsys;

import java.util.ArrayList;
import java.util.Scanner;

public class FeedBack {

    public boolean in;
    public boolean Done;
    private String FeedbackMessage;
private String senderName;
private String productName;



static public ArrayList<FeedBack> feedBacklist =new ArrayList<FeedBack>();


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFeedbackMessage() {
        return FeedbackMessage;
    }

    public void setFeedbackMessage(String feedbackMessage) {
        FeedbackMessage = feedbackMessage;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public static ArrayList<FeedBack> getFeedBacklist() {
        return feedBacklist;
    }

    public static void setFeedBacklist(ArrayList<FeedBack> feedBacklist) {
        FeedBack.feedBacklist = feedBacklist;
    }

    public FeedBack(String feedbackMessage, String senderName) {
        FeedbackMessage = feedbackMessage;
        this.senderName = senderName;
    }

    public FeedBack(String feedbackMessage) {
        FeedbackMessage = feedbackMessage;
    }

    public FeedBack() {
    }

    public FeedBack(String feedbackMessage, String senderName, String productName) {
        FeedbackMessage = feedbackMessage;
        this.senderName = senderName;
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "{" +
                "FeedbackMessage='" + FeedbackMessage + '\'' +
                ", senderName='" + senderName + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }

    public void UserFeedBack(User user){
        SweetProject s=new SweetProject();
        FeedBack f=new FeedBack();
        String name=user.getUsername();
        Scanner cin=new Scanner(System.in);
        try{
        System.out.println("this is all our products name you can choose any of this to Enter Your FeedBack: \n");

        for(ProductManegmwntSystem prod :s.getProducts()){

            System.out.println(prod.getUniq()+"\t"+prod.getProductName()+"\t"+prod.getProductDescription()+"\n");

        }
        System.out.println("Enter the Number of Products you want \n");

        int num= cin.nextInt();
        String proname="";
        for(ProductManegmwntSystem p :s.getProducts()){
            if(num==p.getUniq()){
              proname=p.getProductName();
            }
        }
            System.out.println("Enter Your feedback about "+proname+" pls");
        Scanner c =new Scanner(System.in);
        String feedbacke=c.nextLine();
        f.setFeedbackMessage(feedbacke);
        FeedBack feed =new FeedBack(feedbacke,name,proname);
        f.feedBacklist.add(feed);
        f.setFeedBacklist(feedBacklist);
            System.out.println(f.getFeedBacklist());

    }catch(Exception e) {}


}








    public static void main(String[] args) {

SweetProject s =new SweetProject();
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

    }

}
