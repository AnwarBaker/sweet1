package sweetsys;

public class ProductManegmwntSystem {
    public boolean inside;
    public int uniq;
    public String productName;
    public String city;
    public String productDescription;
    public double price;
    public double earning;
    public String condition;
    public int Num_Of_Sales;
    public double discount;
    public boolean added;
    public boolean updated;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getNum_Of_Sales() {
        return Num_Of_Sales;
    }

    public void setNum_Of_Sales(int num_Of_Sales) {
        Num_Of_Sales = num_Of_Sales;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }

    public int getUniq() {
        return uniq;
    }

    public void setUniq(int uniq) {
        this.uniq = uniq;
    }

    public boolean isAdded() {
        return added;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public double getEarning() {
        return earning;
    }

    public void setEarning(double earning) {
        this.earning = earning;
    }

    public ProductManegmwntSystem(String productName, String productDescription, double price) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
    }

    public ProductManegmwntSystem(int uniq, String productName, String city, String productDescription, double price, String condition, double earning, int num_Of_Sales, double discount) {
        this.uniq = uniq;
        this.productName = productName;
        this.city = city;
        this.productDescription = productDescription;
        this.price = price;
        this.condition = condition;
        this.earning = earning;
        Num_Of_Sales = num_Of_Sales;
        this.discount = discount;
    }


    public ProductManegmwntSystem(String productName, String productDescription, Double price , Double earning, int Num_Of_Sales, String condition, int uniq){
        this.productName=productName;
        this.productDescription=productDescription;
        this.price=price;
        this.earning=earning;
        this.uniq=uniq;
        this.condition=condition;
        this.Num_Of_Sales=Num_Of_Sales;
}

    public ProductManegmwntSystem(String productName,String productDescription,Double price ,Double earning,int Num_Of_Sales,String condition,Double discount,int uniq ){
        this.productName=productName;
        this.productDescription=productDescription;
        this.price=price;
        this.earning=earning;
        this.uniq=uniq;
        this.condition=condition;
        this.Num_Of_Sales=Num_Of_Sales;
        this.discount=discount;
    }

    public ProductManegmwntSystem(int uniq, String productName, String city, String productDescription, double earning, double price, String condition, int num_Of_Sales) {
        this.uniq = uniq;
        this.productName = productName;
        this.city = city;
        this.productDescription = productDescription;
        this.earning = earning;
        this.price = price;
        this.condition = condition;
        Num_Of_Sales = num_Of_Sales;
    }

    public ProductManegmwntSystem(String productName, String productDescription, Double price, int Num_Of_Sales, String condition, int uniq){
        this.productName=productName;
        this.productDescription=productDescription;
        this.price=price;
        this.uniq=uniq;
        this.condition=condition;
        this.Num_Of_Sales=Num_Of_Sales;
    }

    public ProductManegmwntSystem(String productName,String productDescription,int Num_Of_Sales,String condition,int uniq){
        this.productName=productName;
        this.productDescription=productDescription;
        this.uniq=uniq;
        this.condition=condition;
        this.Num_Of_Sales=Num_Of_Sales;

    }
    public ProductManegmwntSystem(int uniq){
        this.uniq=uniq;
    }

    public ProductManegmwntSystem(){}


    @Override
    public String toString() {
        return "{" +
                "uniqnum=" + uniq +
                ", productName='" + productName + '\'' +
                ", city='" + city + '\'' +
                ", price=" + price +
                ", productDescription='" + productDescription + '\'' +
                ", earning=" + earning +
                ", condition='" + condition + '\'' +
                ", Num_Of_Sales=" + Num_Of_Sales +
                ", discount=" + discount +
                '}';
    }

    public static void main(String[] args) {
        ProductManegmwntSystem prod=new ProductManegmwntSystem(1,"mkdjfs","Nablus","sldkfjsdvhfh",10.0,60.0,"finished",5);
    }
}
