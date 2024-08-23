package sweetsys;

public class AdminReports {



    public boolean in;

    public void separateEachCity() {



        for (ProductManegmwntSystem pro : SweetProject.getProducts()) {
            String city = pro.getCity();
            if (city != null) {
                if (city.equalsIgnoreCase("nablus")) {
                SweetProject.getNablusProdcuts().add(pro);
            } else if (pro.getCity().equalsIgnoreCase("jenin")) {
                SweetProject.getJeninprodcuts().add(pro);
            }
        }
        }

        SweetProject.setNablusProdcuts(SweetProject.getNablusProdcuts());
        SweetProject.setJeninprodcuts(SweetProject.getJeninprodcuts());



    }


    public void showBestSellingForNablus(){



        int flag= SweetProject.nablusProdcuts.get(0).getNumOfsales();

        for(ProductManegmwntSystem prod : SweetProject.getNablusProdcuts()){
            if (prod.getNumOfsales() > flag) {
                flag = prod.getNumOfsales();
            }
        }
        for(ProductManegmwntSystem last : SweetProject.getProducts()) {
            if (last.getNumOfsales() == flag) {
                SweetProject.nablusbestselling.add(last);
                SweetProject.setNablusbestselling(SweetProject.nablusbestselling);
                System.out.println(last);
                break;
            }
        }
    }

    public void showBestSellingForJenin(){

        AdminReports a=new AdminReports();
        a.separateEachCity();

        int flag= SweetProject.jeninprodcuts.get(0).getNumOfsales();

        for(ProductManegmwntSystem prod : SweetProject.getJeninprodcuts()){
            if (prod.getNumOfsales() > flag) {
                flag = prod.getNumOfsales();
            }
        }
        for(ProductManegmwntSystem last : SweetProject.getJeninprodcuts()){
            if (last.getNumOfsales()==flag) {
                SweetProject.jeninbestselling.add(last);
                SweetProject.setJeninbestselling(SweetProject.jeninbestselling);
                System.out.println(last);
                break;
            }
        }

    }

    public  void separateUsersByCity(){


            for (User u : SweetProject.getUsers()) {
                String city = u.getCity();
                if (city != null) {
                    if (city.equalsIgnoreCase("nablus")) {
                        SweetProject.nablususers.add(u);
                    } else if (u.getCity().equalsIgnoreCase("jenin")) {
                        SweetProject.jeninUsers.add(u);
                    }
                }
            }

            SweetProject.setNablususers(SweetProject.nablususers);
            SweetProject.setJeninUsers(SweetProject.jeninUsers);

            System.out.println("Nablus Users: ");
            for (User user : SweetProject.nablususers) {
                System.out.println(user);
            }
            System.out.println("Jenin Users: ");
            for (User user : SweetProject.jeninUsers) {
                System.out.println(user);
            }

    }

}
