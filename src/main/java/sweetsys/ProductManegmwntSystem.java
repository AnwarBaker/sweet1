package sweetsys;

public class ProductManegmwntSystem {
    private boolean inside;
    public int uniq;
    private String productName;
    private String city;
    private String productDescription;
    private double price;
    private double earning;
    private String condition;
    private int numOfsales;
    private double discount;


    public boolean isInside() {
        return inside;
    }

    public ProductManegmwntSystem(int uniq, String productName, String city, String productDescription, double price) {
        this.uniq = uniq;
        this.productName = productName;
        this.city = city;
        this.productDescription = productDescription;
        this.price = price;
    }

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

    public int getNumOfsales() {
        return numOfsales;
    }

    public void setNumOfsales(int numOfsales) {
        this.numOfsales = numOfsales;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getUniq() {
        return uniq;
    }

    public void setUniq(int uniq) {
        this.uniq = uniq;
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

    public ProductManegmwntSystem(int uniq, String productName, String city, String productDescription, double price, String condition, double earning, int numOfsales, double discount) {
        this.uniq = uniq;
        this.productName = productName;
        this.city = city;
        this.productDescription = productDescription;
        this.price = price;
        this.condition = condition;
        this.earning = earning;
        this.numOfsales = numOfsales;
        this.discount = discount;
    }

    public ProductManegmwntSystem(int uniq, double discount) {
        this.uniq = uniq;
        this.discount = discount;
    }

    public ProductManegmwntSystem(String productName, String productDescription, Double price , Double earning, int numOfsales, String condition, int uniq){
        this.productName=productName;
        this.productDescription=productDescription;
        this.price=price;
        this.earning=earning;
        this.uniq=uniq;
        this.condition=condition;
        this.numOfsales=numOfsales;
}


    public ProductManegmwntSystem(int uniq, String productName, String city, String productDescription, double earning, double price, String condition, int numOfsales) {
        this.uniq = uniq;
        this.productName = productName;
        this.city = city;
        this.productDescription = productDescription;
        this.earning = earning;
        this.price = price;
        this.condition = condition;
        this.numOfsales = numOfsales;
    }

    public ProductManegmwntSystem(String productName,String productDescription,int numOfsales,String condition,int uniq){
        this.productName=productName;
        this.productDescription=productDescription;
        this.uniq=uniq;
        this.condition=condition;
        this.numOfsales=numOfsales;

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
                ", Num_Of_Sales=" + numOfsales +
                ", discount=" + discount +
                '}';
    }

}
