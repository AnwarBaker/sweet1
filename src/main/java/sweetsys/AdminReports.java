package sweetsys;

public class AdminReports {


    public boolean printed;
    public boolean in;

    public void SeperateEachCity() {
        SweetProject s = new SweetProject();

try{
        for (ProductManegmwntSystem pro : s.getProducts()) {
            String city = pro.getCity();
            if (city != null) {
                if (city.equalsIgnoreCase("nablus")) {
                s.Nablusprodcuts.add(pro);
            } else if (pro.getCity().equalsIgnoreCase("jenin")) {
                s.Jeninprodcuts.add(pro);
            }
        }
        }

        s.setNablusprodcuts(s.Nablusprodcuts);
        s.setJeninprodcuts(s.Jeninprodcuts);

    }catch (Exception e){}
    }


    public void ShowBestSellinForNablus(){
        SweetProject s=new SweetProject();
        System.out.println("Nablus Store Best Product :\n");
        AdminReports a=new AdminReports();
        a.SeperateEachCity();

        int flag=s.Nablusprodcuts.get(0).getNum_Of_Sales();

        System.out.println("Product Name:\tDescrption:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPrice\tEwarning:\tCondition:\tNum_OF_Sales:\tUniq Num:\n");
        for(ProductManegmwntSystem prod :s.getNablusprodcuts()){
            if (prod.getNum_Of_Sales() > flag) {
                flag = prod.getNum_Of_Sales();
            }
        }
        for(ProductManegmwntSystem last :s.getProducts()){
            if (last.getNum_Of_Sales()==flag) {
                s.Nablusbestselling.add(last);
                s.setNablusbestselling(s.Nablusbestselling);
                break;
            }
        }
        for(ProductManegmwntSystem store :s.getNablusbestselling()) {

            System.out.println(store.getProductName() + "\t" + store.getProductDescription() + "\t\t\t" + store.getPrice() + "\t" + store.getEarning() + "\t\t" + store.getCondition() + "\t" + store.getNum_Of_Sales() + "\t\t\t\t" + store.getUniq() + "\n");
        }


    }



    public void ShowBestSellinForJenin(){
        SweetProject s=new SweetProject();
        System.out.println("Jenin Store Best Product :\n");
        AdminReports a=new AdminReports();
        a.SeperateEachCity();

        int flag=s.Jeninprodcuts.get(0).getNum_Of_Sales();

        System.out.println("Product Name:\tDescrption:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPrice\tEwarning:\tCondition:\tNum_OF_Sales:\tUniq Num:\n");
        for(ProductManegmwntSystem prod :s.getJeninprodcuts()){
            if (prod.getNum_Of_Sales() > flag) {
                flag = prod.getNum_Of_Sales();
            }
        }
        for(ProductManegmwntSystem last :s.getJeninprodcuts()){
            if (last.getNum_Of_Sales()==flag) {
                s.Jeninbestselling.add(last);
                s.setJeninbestselling(s.Jeninbestselling);
                break;
            }
        }
        for(ProductManegmwntSystem store :s.getJeninbestselling()) {

            System.out.println(store.getProductName() + "\t" + store.getProductDescription() + "\t\t\t" + store.getPrice() + "\t" + store.getEarning() + "\t\t" + store.getCondition() + "\t" + store.getNum_Of_Sales() + "\t\t\t\t" + store.getUniq() + "\n");
        }


    }




    public  void SeperateEachUserToCities(){
        SweetProject s=new SweetProject();
        try{
            for (User u : s.getUsers()) {
                String city = u.getCity();
                if (city != null) {
                    if (city.equalsIgnoreCase("nablus")) {
                        s.Nablususers.add(u);
                    } else if (u.getCity().equalsIgnoreCase("jenin")) {
                        s.JeninUsers.add(u);
                    }
                }
            }

            s.setNablususers(s.Nablususers);
            s.setJeninUsers(s.JeninUsers);
            System.out.println("Nablus Users : \n");
            for (User uu :s.getNablususers()){
                System.out.println(uu);
            }
            System.out.println("Jenin Users : \n");

            for (User uuu :s.getJeninUsers()){
                System.out.println(uuu);
            }


    }catch (Exception e){}

    }




}
