package sweetsys;

public class AdminReports {


    public boolean printed;
    public boolean in;

    public void SeperateEachCity() {

try{
        for (ProductManegmwntSystem pro : SweetProject.getProducts()) {
            String city = pro.getCity();
            if (city != null) {
                if (city.equalsIgnoreCase("nablus")) {
                SweetProject.Nablusprodcuts.add(pro);
            } else if (pro.getCity().equalsIgnoreCase("jenin")) {
                SweetProject.Jeninprodcuts.add(pro);
            }
        }
        }

        SweetProject.setNablusprodcuts(SweetProject.Nablusprodcuts);
        SweetProject.setJeninprodcuts(SweetProject.Jeninprodcuts);

    }catch (Exception e){}
    }


    public void ShowBestSellinForNablus(){

        AdminReports a=new AdminReports();

        int flag= SweetProject.Nablusprodcuts.get(0).getNumOfsales();

        for(ProductManegmwntSystem prod : SweetProject.getNablusprodcuts()){
            if (prod.getNumOfsales() > flag) {
                flag = prod.getNumOfsales();
            }
        }
        for(ProductManegmwntSystem last : SweetProject.getProducts()){
            if (last.getNumOfsales()==flag) {
                SweetProject.Nablusbestselling.add(last);
                SweetProject.setNablusbestselling(SweetProject.Nablusbestselling);
                System.out.println(last);
                break;
            }
        }



    }



    public void ShowBestSellinForJenin(){

        AdminReports a=new AdminReports();
        a.SeperateEachCity();

        int flag= SweetProject.Jeninprodcuts.get(0).getNumOfsales();

        for(ProductManegmwntSystem prod : SweetProject.getJeninprodcuts()){
            if (prod.getNumOfsales() > flag) {
                flag = prod.getNumOfsales();
            }
        }
        for(ProductManegmwntSystem last : SweetProject.getJeninprodcuts()){
            if (last.getNumOfsales()==flag) {
                SweetProject.Jeninbestselling.add(last);
                SweetProject.setJeninbestselling(SweetProject.Jeninbestselling);
                System.out.println(last);
                break;
            }
        }

    }




    public  void SeperateEachUserToCities(){
        SweetProject s=new SweetProject();
        try{
            for (User u : SweetProject.getUsers()) {
                String city = u.getCity();
                if (city != null) {
                    if (city.equalsIgnoreCase("nablus")) {
                        SweetProject.Nablususers.add(u);
                    } else if (u.getCity().equalsIgnoreCase("jenin")) {
                        SweetProject.JeninUsers.add(u);
                    }
                }
            }

            SweetProject.setNablususers(SweetProject.Nablususers);
            SweetProject.setJeninUsers(SweetProject.JeninUsers);

            System.out.println("Nablus Users: ");
            for (User user : SweetProject.Nablususers) {
                System.out.println(user);
            }
            System.out.println("Jenin Users: ");
            for (User user : SweetProject.JeninUsers) {
                System.out.println(user);
            }

    }catch (Exception e){}

    }




}
