package sweetsys;

import java.util.ArrayList;

public class FeedBack {

    public boolean in;
    private String feedbackMessage;
    private int feednumber;
private String senderName;
private String productName;

    public FeedBack(String feedbackMessage, int feednumber, String senderName, String productName) {
        this.feedbackMessage = feedbackMessage;
        this.feednumber = feednumber;
        this.senderName = senderName;
        this.productName = productName;
    }

    static protected ArrayList<FeedBack> feedBacklist =new ArrayList<>();


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public void setFeedbackMessage(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
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
        this.feedbackMessage = feedbackMessage;
        this.senderName = senderName;
    }

    public FeedBack(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }

    public FeedBack() {
    }

    public FeedBack(String feedbackMessage, String senderName, String productName) {
        this.feedbackMessage = feedbackMessage;
        this.senderName = senderName;
        this.productName = productName;
    }

    public int getFeednumber() {
        return feednumber;
    }

    public void setFeednumber(int feednumber) {
        this.feednumber = feednumber;
    }

    @Override
    public String toString() {
        return "{" +
                "FeedbackMessage='" + feedbackMessage + '\'' +
                ", feednumber=" + feednumber +
                ", senderName='" + senderName + '\'' +
                ", productName='" + productName + '\'' +
                '}'+"\n";
    }
    public void userFeedback(User user,int num,String feedback){

        String name=user.getUsername();


        String proname="";
        for(ProductManegmwntSystem p : SweetProject.getProducts()){
            if(num==p.getUniq()){
              proname=p.getProductName();
              break;
            }
        }

      int last= getFeedBacklist().size();

        setFeedbackMessage(feedback);

            FeedBack feed =new FeedBack(feedback,last+1,name,proname);
        feedBacklist.add(feed);
        setFeedBacklist(feedBacklist);

}

public void showFeedback(){

        for(FeedBack f : getFeedBacklist()){
            System.out.println(f);
        }
}

}
