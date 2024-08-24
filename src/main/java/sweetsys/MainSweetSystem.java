package sweetsys;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MainSweetSystem {
    private static final Logger logger = Logger.getLogger(MainSweetSystem.class.getName());
    public static final String USER_DETAILS_LOG = "User details: {0}";
    public static final String PRODUCT_DETAILS_LOG = "Product details: {0}";
    public static final String ENTER_NAME_PROMPT = "Enter your Name pls :";
    public static final String CITY_NAME_JENIN = "Jenin";
    public static final String CITY_NAME_NABLUS = "nablus";

    public static final String YASMINEE = "yasmine";
    public static final String NOT_FINISH = "not finished";
    public static final String INVALID ="Invalid choice. Please try again.";
    public static final String EMAIL ="@gmail.com";
    public static void main(String[] args) {


        User us=new User();

        SweetProject s= new SweetProject();

        SweetProject.users.add(new User("anwar", "123", 1,"anwar123@gmail.com",CITY_NAME_JENIN));
        SweetProject.users.add(new User("ahmad", "1234", 3,"ahmad1234@gmail.com",CITY_NAME_NABLUS));
        SweetProject.users.add(new User(YASMINEE, "12345", 2,"yasmine12345@gmail.com",CITY_NAME_NABLUS));
        SweetProject.users.add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com",CITY_NAME_JENIN));

        SweetProject.users.add(new User("rama", "1", 3,"rama1@gmail.com",CITY_NAME_JENIN));
        SweetProject.users.add(new User("lana", "34", 3,"lana34@gmail.com",CITY_NAME_NABLUS));
        SweetProject.users.add(new User("haya", "12", 2,"haya12@gmail.com",CITY_NAME_JENIN));
        SweetProject.users.add(new User("loay", "56", 3,"loay56@gmail.com",CITY_NAME_JENIN));
        SweetProject.setUsers(SweetProject.users);




        SweetProject.products.add(new ProductManegmwntSystem(1,"Nutella cake",CITY_NAME_NABLUS,"Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,NOT_FINISH,5));
        SweetProject.products.add(new ProductManegmwntSystem(2,"Cheesecake",CITY_NAME_JENIN,"Creamy cheesecake with a graham cracker crust                 ",5.0,30.0,NOT_FINISH,10));
        SweetProject.products.add(new ProductManegmwntSystem(3,"Cupcake",CITY_NAME_NABLUS,"Vanilla cupcake with buttercream frosting                       ",3.0,20.0,NOT_FINISH,12));
        SweetProject.products.add(new ProductManegmwntSystem(4,"Lemon Tart",CITY_NAME_JENIN,"Tangy lemon curd in a buttery shortcrust pastry               ",4.0,25.0,NOT_FINISH,7));
        SweetProject.products.add(new ProductManegmwntSystem(5,"Apple Pie",CITY_NAME_JENIN,"Traditional apple pie with a cinnamon-spiced filling           ",3.5,24.0,NOT_FINISH,30));
        SweetProject.products.add(new ProductManegmwntSystem(6,"Creme Brulee ",CITY_NAME_NABLUS,"Rich custard topped with a layer of hard caramel          ",1.5,15.0,NOT_FINISH,35));

        SweetProject.products.add(new ProductManegmwntSystem(7,"Brownies",CITY_NAME_NABLUS,"Fudgy chocolate brownies with a crackly top                    ",8.0,35.0,NOT_FINISH,6));
        SweetProject.products.add(new ProductManegmwntSystem(8,"Panna Cotta",CITY_NAME_JENIN,"Italian dessert made with sweetened cream and with gelatin   ",12.0,55.0,NOT_FINISH,50));
        SweetProject.products.add(new ProductManegmwntSystem(9,"Macarons",CITY_NAME_JENIN,"Delicate almond meringue cookie filled with flavored buttercream",2.0,10.0,NOT_FINISH,40));
        SweetProject.setProducts(SweetProject.products);


        MessagingClass.messages.add(new MessagingClass("loay","haya","heelo mr haya can i send you amessage"));
        MessagingClass.messages.add(new MessagingClass("lana","haya","heelo mr haya can i send you amessage"));
        MessagingClass.messages.add(new MessagingClass("rama",YASMINEE,"heelo mr yasmine can i send you amessage"));



        StoreOwnerMessages.messegaesList.add(new StoreOwnerMessages("haya","loay","yes sure...",1));
        StoreOwnerMessages.messegaesList.add(new StoreOwnerMessages("haya","lana","yes sure.",2));
        StoreOwnerMessages.messegaesList.add(new StoreOwnerMessages(YASMINEE,"rama","yes sure..",3));

        StoreOwnerMessages.setMessegaesList(StoreOwnerMessages.messegaesList);







        FeedBack.feedBacklist.add(new FeedBack("the product is so tasty",1,"lana","Nutella cake"));
        FeedBack.feedBacklist.add(new FeedBack("perfect product",2,"tarneem","Cupcake"));
        FeedBack.feedBacklist.add(new FeedBack("prodcut need more chocolate",3,"loay","Brownies"));
        FeedBack.feedBacklist.add(new FeedBack("the product is so bad",4,"rama","Macarons"));
        FeedBack.setFeedBacklist(FeedBack.feedBacklist);


        UserShareProducts.userproducts.add(new UserShareProducts("new cake","Tangy lemon curd in a buttery shortcrust pastry",15.0));
        UserShareProducts.userproducts.add(new UserShareProducts("new Macarons","Delicate almond meringue cookies filled with flavored buttercream",25.0));
        UserShareProducts.userproducts.add(new UserShareProducts("Better Cheesecake","Creamy cheesecake",10.0));
        UserShareProducts.setUserproducts(UserShareProducts.userproducts);


        OrderManegmentClass.orderlist.add(new OrderManegmentClass("loay",25.0,2.5,1,"done"));
        OrderManegmentClass.orderlist.add(new OrderManegmentClass("lana",20.0,3.0,2,"done"));
        OrderManegmentClass.orderlist.add(new OrderManegmentClass("rama",15.0,1.0,3,"processing"));
        OrderManegmentClass.setOrderlist(OrderManegmentClass.orderlist);


        Scanner scanner = new Scanner(System.in);
        int choice;
        String adminname;
        String adminpass;
        String storename;
        String storepass;
        String username;
        String userpass;


        do{
            logger.log(Level.INFO, "Welcome to the Sweet Management System!");
            logger.log(Level.INFO, "Please choose an option:");
            logger.log(Level.INFO, "1. Admin");
            logger.log(Level.INFO, "2. Store Owner");
            logger.log(Level.INFO, "3. User");
            logger.log(Level.INFO, "4. SignUp for new User");
            logger.log(Level.INFO, "5. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Scanner c=new Scanner(System.in);
                    logger.log(Level.INFO, "Enter your Name pls.. :");
                    adminname=c.nextLine();
                    Scanner cin=new Scanner(System.in);

                    logger.log(Level.INFO, "Enter your pass pls.. :");
                    adminpass=cin.nextLine();
                    boolean f=false;

                    if( s.isValidUser(SweetProject.getUsers(),adminname,adminpass))
                    {
                        for(User u : SweetProject.getUsers()){
                            if(u.getUsername().equals(adminname)&&u.getPass().equals(adminpass)&&u.getUserlevel()==1){
                                f=true;
                                User testcons =new User(adminname,adminpass,1,u.getEmail(),u.getCity());
                                us.setUsername(adminname);
                                logger.log(Level.INFO, () -> "You are Welcome Admin " + us.getUsername());
                                us.setPass(adminpass);
                                s.login(testcons);

                                adminMenu(scanner,s,us);}}}

                    if(!f) {
                        logger.log(Level.WARNING, "You are not valid try again");
                    }
                    break;



                case 2:

                    Scanner v=new Scanner(System.in);
                    logger.log(Level.WARNING,"Enter your Name pls... :");
                    storename=v.nextLine();
                    Scanner ci=new Scanner(System.in);

                    logger.log(Level.WARNING,"Enter your pass pls... :");
                    storepass=ci.nextLine();
                    boolean ss=false;
                    if( s.isValidUser(SweetProject.getUsers(),storename,storepass))
                    {
                        for(User u : SweetProject.getUsers()){
                            if(u.getUsername().equals(storename)&&u.getPass().equals(storepass)&&u.getUserlevel()==2){
                                ss=true;
                                us.setUsername(storename);
                                logger.log(Level.WARNING, () -> "You are Welcome Store Owner " + us.getUsername());
                                us.setPass(storepass);
                                storeOwnerMenu(scanner,s,us);
                            }}}
                    if(!ss) {  logger.log(Level.WARNING,"you are not valid try again");}
                    break;


                case 3:



                    logger.log(Level.WARNING,"Logging into the system...");

                    Scanner vv=new Scanner(System.in);
                    logger.log(Level.WARNING,ENTER_NAME_PROMPT);
                    username=vv.nextLine();
                    Scanner ciii=new Scanner(System.in);

                    logger.log(Level.WARNING,ENTER_NAME_PROMPT);
                    userpass=ciii.nextLine();
                    boolean sss=false;
                    if( s.isValidUser(SweetProject.getUsers(),username,userpass))
                    {
                        for(User u : SweetProject.getUsers()){
                            if(u.getUsername().equals(username)&&u.getPass().equals(userpass)&&u.getUserlevel()==3){
                                sss=true;
                                us.setUsername(username);
                                logger.log(Level.WARNING, () -> "You are Welcome User " + us.getUsername());
                                us.setPass(userpass);
                                beneficiaryUserMenu(scanner,s,us);
                            }}}

                    if(!sss){
                        logger.log(Level.WARNING,"you are not valid try again");}


                    break;

                case 4:
                    logger.log(Level.WARNING,"Signing up a new user...");
                    Signup sig=new Signup();
                    Scanner vvv=new Scanner(System.in);

                    logger.log(Level.WARNING,ENTER_NAME_PROMPT);
                    String usernamee=vvv.nextLine();
                    Scanner cii=new Scanner(System.in);

                    logger.log(Level.WARNING,ENTER_NAME_PROMPT);
                    String userpasss=cii.nextLine();

                    logger.log(Level.WARNING,"Enter your city pls 'Nablus OR jenin' :");
                    String cityy =vvv.nextLine();
                    us.setCity(cityy);
                    us.setUsername(usernamee);
                    us.setPass(userpasss);
                    int userlevel=3;
                    String email=usernamee+userpasss+EMAIL;
                    User usersign=new User(usernamee,userpasss,userlevel,email,cityy);
                    sig.addnewuserforuseronly(usersign);

                    for(User uuu: SweetProject.getUsers()){
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, uuu.toString());
                        }
                    }
                    break;



                case 5:
                    logger.log(Level.INFO,"5. Exit The System");

                    break;

                default:
                    logger.log(Level.INFO,"Invalid choice. Please try again..");
            }
        } while (choice != 5);

        scanner.close();
    }

    public static void adminMenu(Scanner scanner,SweetProject s,User us) {
        int choice;

        do {
            logger.log(Level.INFO, "Admin Menu:");
            logger.log(Level.INFO, "1. User Management");
            logger.log(Level.INFO, "2. Monitoring and Reporting");
            logger.log(Level.INFO, "3. Content Management");
            logger.log(Level.INFO, "4. Back to Main Menu");


            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    logger.log(Level.INFO,"Managing user accounts...");
                    userManagementMenu(scanner, s,us);

                    break;
                case 2:
                    logger.log(Level.INFO,"Monitoring profits and generating reports...");
                    monitoringAndReportingMenu(scanner, s,us);


                    break;
                case 3:
                    logger.log(Level.INFO,"Managing content...");

                    contentManagementMenu(scanner,s,us);
                    break;
                case 4:
                    break;
                default:
                    logger.log(Level.INFO,INVALID);
            }
        } while (choice != 4);
    }







    public static void userManagementMenu(Scanner scanner, SweetProject s,User us) {
        int choice;
        us.getPass();
        do {
            String newname;
            String newpass;
            String email;
            String city;
            int usellevel;

            logger.log(Level.INFO,"1. Add New Account");
            logger.log(Level.INFO,"2. Update User Account");
            logger.log(Level.INFO,"3. Delete User Account");
            logger.log(Level.INFO,"4. Back to Admin Menu");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    logger.log(Level.INFO,"Enter new account name ");
                    Scanner cin=new Scanner(System.in);
                    newname=cin.nextLine();
                    logger.log(Level.INFO,"Enter new account pass ");
                    newpass=cin.nextLine();
                    logger.log(Level.INFO,"Enter new account Uselevel :\n '1' for admin \n '2' for store owner \n '3' for User ");
                    usellevel=cin.nextInt();
                    logger.log(Level.INFO,"Enter new account city 'Nablus' OR 'Jenin' ");
                    Scanner scan=new Scanner(System.in);
                    city=scan.nextLine();
                    email=newname+newpass+EMAIL;
                    User user=new User(newname,newpass,usellevel,email,city);
                    Signup sign =new Signup();
                    sign.addnewuser(user);
                    s.showeachTypeofusers();
                    logger.log(Level.INFO,"Admins.:\n");
                    logger.log(Level.INFO, "Admins:");
                    for (User showusers : SweetProject.getAdminArraylist()) {
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, showusers.toString());
                        }
                    }

                    logger.log(Level.INFO, "StoreOwners:");
                    for (User showusers : SweetProject.getStoreOwnerarraylist()) {
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, showusers.toString());
                        }
                    }

                    logger.log(Level.INFO, "Users.:");
                    for (User showusers : SweetProject.getUsersArraylist()) {
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, showusers.toString());
                        }
                    }


                    break;
                case 2:

                    s.showeachTypeofusers();
                    logger.log(Level.INFO, "Admins..:");
                    for (User showusers : SweetProject.getAdminArraylist()) {
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, showusers.toString());
                        }
                    }

                    logger.log(Level.INFO, "Store Owners:");
                    for (User showusers : SweetProject.getStoreOwnerarraylist()) {
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, showusers.toString());
                        }
                    }

                    logger.log(Level.INFO, "Users:");
                    for (User showusers : SweetProject.getUsersArraylist()) {
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, showusers.toString());
                        }
                    }

                    Scanner updated = new Scanner(System.in);
                    logger.log(Level.INFO, "Enter name of employee to Update:");
                    String empname = updated.nextLine();

                    logger.log(Level.INFO, "Enter new pass of employee to Update:");
                    String newpasss = updated.nextLine();

                    logger.log(Level.INFO, "Enter new City of employee to Update (Nablus or Jenin):");
                    String newcity = updated.nextLine();

                    logger.log(Level.INFO, "Enter new UserLevel of employee to Update (1 for Admin, 2 for Store Owner, 3 for User):");
                    int newuserlevel = updated.nextInt();

                    email = empname + newpasss + EMAIL;
                    User updateduser = new User(empname, newpasss, newuserlevel, email, newcity);
                    s.update(updateduser);

                    logger.log(Level.INFO, "Updated Users:");
                    for (User ui : SweetProject.getUsers()) {
                        if (ui.getUserlevel() == newuserlevel&&logger.isLoggable(Level.INFO)) {

                                logger.log(Level.INFO, "User info: {0}", ui);

                        }
                    }


                    break;
                case 3:
                    s.showeachTypeofusers();


                    logger.log(Level.INFO, "Admins:");
                    for (User showusers : SweetProject.getAdminArraylist()) {
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, USER_DETAILS_LOG, showusers);
                        }
                    }

                    logger.log(Level.INFO, "Store Owners:");
                    for (User showusers : SweetProject.getStoreOwnerarraylist()) {
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, USER_DETAILS_LOG, showusers);
                        }
                    }

                    logger.log(Level.INFO, "Users:");
                    for (User showusers : SweetProject.getUsersArraylist()) {
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, USER_DETAILS_LOG, showusers);
                        }
                    }


                    Scanner deleted = new Scanner(System.in);

                    logger.log(Level.INFO, "Enter name of employee to Delete:");
                    String empnamee = deleted.nextLine();

                    logger.log(Level.INFO, "Enter pass of employee to Delete:");
                    String emppassdelete = deleted.nextLine();

                    User todeleteuser = new User(empnamee, emppassdelete);
                    s.delete(todeleteuser);

                    logger.log(Level.INFO, "Remaining Users after deletion:");
                    for (User del : SweetProject.getUsers()) {
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, "Deleted item details: {0}", del);
                        }
                    }

                    break;

                case 4:
                    break;
                default:
                    logger.log(Level.INFO,INVALID);
            }
        } while (choice != 4);
    }


    public static void monitoringAndReportingMenu(Scanner scanner, SweetProject s,User us) {
       int choice;
       s.isExist();
       us.getPass();
        do {
            logger.log(Level.INFO, "1. Generate Financial Reports");
            logger.log(Level.INFO, "2. Identify Best-Selling Products in Each Store");
            logger.log(Level.INFO, "3. Gather and Display User Statistics by City");
            logger.log(Level.INFO, "4. Back to Admin Menu");

            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    logger.log(Level.INFO,"Generating financial reports...");
                    SalesReport sales=new SalesReport();
                    sales.shoewSalesreport();
                    break;

                case 2:
                    logger.log(Level.INFO, "Identifying best-selling products in each store...");
                    AdminReports a = new AdminReports();
                    a.separateEachCity();
                    logger.log(Level.INFO, "Nablus Best Product:");
                    a.showBestSellingForNablus();
                    logger.log(Level.INFO,"\nJenin Best Product:");
                    a.showBestSellingForJenin();


                    break;

                case 3:
                    logger.log(Level.INFO,"Gathering and displaying user statistics by city...\n");
                    AdminReports aa=new AdminReports();

                    aa.separateUsersByCity();

                    break;

                case 4:
                    break;

                default:
                    logger.log(Level.INFO,INVALID);
            }
        } while (choice != 4);
    }






    public static void contentManagementMenu(Scanner scanner,SweetProject s,User us) {
        int choice;
        s.isExist();
        do {
            logger.log(Level.INFO, "Content Management Menu:");
            logger.log(Level.INFO, "1. Update Recipes");
            logger.log(Level.INFO, "2. Delete Recipes");
            logger.log(Level.INFO, "3. Show Feedback");
            logger.log(Level.INFO, "4. Respond to Feedback");
            logger.log(Level.INFO, "5. Back to Admin Menu");


            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    logger.log(Level.INFO, "Updating recipe...");
                    ContentSection c = new ContentSection();

                    logger.log(Level.INFO, "Current User Products:");
                    for (UserShareProducts updatedpro : UserShareProducts.getUserproducts()) {
                        if (updatedpro != null&&logger.isLoggable(Level.INFO)) {

                                logger.log(Level.INFO, "Updated product details: {0}", updatedpro);

                        }
                    }

                    Scanner updated = new Scanner(System.in);

                    logger.log(Level.INFO, "Enter name of UserProduct to Update:");
                    String userproname = updated.nextLine();

                    logger.log(Level.INFO, "Enter new Description of UserProduct to Update:");
                    String newdescription = updated.nextLine();

                    logger.log(Level.INFO, "Enter new Expected Price of UserProduct to Update:");
                    int newpriceforuserproduct = updated.nextInt();

                    UserShareProducts updateduserproduct = new UserShareProducts(userproname, newdescription, newpriceforuserproduct);

                    c.updateUserrecipes(updateduserproduct);

                    logger.log(Level.INFO, "Updated User Products:");
                    for (UserShareProducts updatedpro : UserShareProducts.getUserproducts()) {
                        if (updatedpro != null) {
                            logger.log(Level.INFO, PRODUCT_DETAILS_LOG, updatedpro);
                        }
                    }

                    break;
                case 2:
                    logger.log(Level.INFO, "Deleting recipe...");
                    ContentSection cc = new ContentSection();

                    logger.log(Level.INFO, "Current User Products:");
                    for (UserShareProducts updatedpro : UserShareProducts.getUserproducts()) {
                        if(updatedpro!= null&&logger.isLoggable(Level.INFO)){

                                logger.log(Level.INFO, updatedpro.toString());
                            }
                    }

                    Scanner deleted = new Scanner(System.in);

                    logger.log(Level.INFO, "Enter name of UserProduct to Delete:");
                    String userpronametodelete = deleted.nextLine();

                    UserShareProducts deleteduserproduct = new UserShareProducts(userpronametodelete);

                    cc.deleteUserrecipes(deleteduserproduct);

                    logger.log(Level.INFO, "Updated User Products:");
                    for (UserShareProducts updatedpro : UserShareProducts.getUserproducts()) {
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, "Updated product details: {0}", updatedpro);
                        }
                    }


                    break;
                case 3:

                    logger.log(Level.INFO,"Showing feedback...");
                    FeedBack f=new FeedBack();
                    f.showFeedback();

                    break;
                case 4:

                    logger.log(Level.INFO, "Responding to feedback...");
                    for (FeedBack feeds : FeedBack.getFeedBacklist()) {
                        if (feeds != null) {
                            logger.log(Level.INFO, "Feedback details: {0}", feeds);
                        }
                    }

                    Scanner feed = new Scanner(System.in);

                    logger.log(Level.INFO, "Enter number of Feedback you want to respond to:");
                    int feednum = feed.nextInt();
                    Scanner feedmsgg = new Scanner(System.in);

                    logger.log(Level.INFO, "Enter your response message for this feedback:");
                    String feedmsg = feedmsgg.nextLine();

                    AdminFeedback adminfeed = new AdminFeedback();
                    User uuu = new User(us.getUsername(), us.getPass(), 1, us.getEmail(), us.getCity());
                    adminfeed.adminResponsemessege(uuu, feednum, feedmsg);

                    break;
                case 5:

                    logger.log(Level.INFO,"Returning to Admin Menu...");

                    break;

                default:
                    logger.log(Level.INFO,INVALID);
            }
        } while (choice != 5);
    }









    public static void storeOwnerMenu(Scanner scanner,SweetProject s,User us) {
        int choice;
        do {
            logger.log(Level.INFO, "Store Owner Menu:");
            logger.log(Level.INFO, "1. Product Management");
            logger.log(Level.INFO, "2. Communication and Notifications");
            logger.log(Level.INFO, "3. Account Management");
            logger.log(Level.INFO, "4. Order Management");
            logger.log(Level.INFO, "5. Back to Main Menu");


            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    logger.log(Level.INFO,"Managing products...");
                    productManagementMenu(scanner ,s,us);
                    break;
                case 2:

                    logger.log(Level.INFO,"Communication and Notifications...");
                    communicationAndNotificationsMenu(scanner, s,us);

                    break;

                case 3:
                    logger.log(Level.INFO,"Account Management...");
                    accountManagementMenu(scanner, s,us);

                    break;
                case 4:
                    logger.log(Level.INFO,"Managing orders...");
                    orderManagementMenu(scanner, s,us);
                    break;
                case 5:
                    break;
                default:
                    logger.log(Level.INFO,INVALID);
            }
        } while (choice != 5);
    }







    public static void productManagementMenu(Scanner scanner, SweetProject s,User us) {
        int choice;
        us.getPass();
        do {
            logger.log(Level.INFO, "Product Management Menu:");
            logger.log(Level.INFO, "1. Add New Product");
            logger.log(Level.INFO, "2. Update Product");
            logger.log(Level.INFO, "3. Delete Product");
            logger.log(Level.INFO, "4. Show Sales Report");
            logger.log(Level.INFO, "5. Show Best Selling Products");
            logger.log(Level.INFO, "6. Implement Dynamic Discount");
            logger.log(Level.INFO, "7. Back to Store Owner Menu");


            choice = scanner.nextInt();
            scanner.nextLine();

            String proname;
            String prodisc;
            double price;
            String procity;
            switch (choice) {
                case 1:
                    logger.log(Level.INFO,"Adding new product...\n");


                    logger.log(Level.INFO,"Enter Product Name : \n");
                    proname=scanner.nextLine();
                    logger.log(Level.INFO,"Enter Product Discription : \n");
                    prodisc=scanner.nextLine();
                    logger.log(Level.INFO,"Enter Product Price  : \n");
                    price=scanner.nextInt();
                    Scanner cityscan =new Scanner(System.in);
                    logger.log(Level.INFO,"Enter Product Store City 'Nablus' or 'Jenin' : \n");
                    procity=cityscan.nextLine();

                    ProductManegmwntSystem pro=new ProductManegmwntSystem(10,proname,procity,prodisc,price);
                    s.addnewProduct(pro);
                    for (ProductManegmwntSystem p : SweetProject.getProducts()){
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, PRODUCT_DETAILS_LOG, p);
                        }
                    }

                    break;
                case 2:
                    logger.log(Level.INFO,"Updating product...");
                    for (ProductManegmwntSystem p : SweetProject.getProducts()){
                        logger.log(Level.INFO, "{0}", p);
                    }
                    logger.log(Level.INFO,"Enter Product num to Update : \n");
                    int pronum =scanner.nextInt();
                    Scanner prnametoupdate =new Scanner(System.in);

                    logger.log(Level.INFO,"Enter new Product Name : \n");
                    proname=prnametoupdate.nextLine();
                    logger.log(Level.INFO,"Enter new Product Discription : \n");
                    prodisc=prnametoupdate.nextLine();
                    logger.log(Level.INFO,"Enter new Product Price  : \n");
                    price=scanner.nextInt();
                    Scanner citytoupdate =new Scanner(System.in);
                    logger.log(Level.INFO,"Enter new Product Store City 'Nablus' or 'Jenin' : \n");
                    procity=citytoupdate.nextLine();

                    ProductManegmwntSystem protoupdate=new ProductManegmwntSystem(pronum,proname,procity,prodisc,price);

                    s.productUpdate(protoupdate);
                    for (ProductManegmwntSystem p : SweetProject.getProducts()){
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, PRODUCT_DETAILS_LOG, p);
                        }
                    }
                    break;
                case 3:
                    logger.log(Level.INFO, "Deleting product...");
                    logger.log(Level.INFO, "Current Products List:");
                    for (ProductManegmwntSystem p : SweetProject.getProducts()) {
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, PRODUCT_DETAILS_LOG, p);
                        }
                    }

                    logger.log(Level.INFO, "Enter Product number to Delete:");
                    int pronumtodelete = scanner.nextInt();
                    scanner.nextLine();

                    ProductManegmwntSystem protodelete = new ProductManegmwntSystem(pronumtodelete);
                    s.deleteProduct(protodelete);

                    logger.log(Level.INFO, "Updated Products List after Deletion:");
                    for (ProductManegmwntSystem p : SweetProject.getProducts()) {
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, PRODUCT_DETAILS_LOG, p);
                        }
                    }

                    break;
                case 4:
                    logger.log(Level.INFO,"Showing sales report...");
                    SalesReport saless =new SalesReport();
                    saless.shoewSalesreport();
                    break;
                case 5:
                    logger.log(Level.INFO,"Showing best selling products...");
                    AdminReports aaa=new AdminReports();
                    aaa.separateEachCity();
                    logger.log(Level.INFO,"Jenin Best Product :\n");
                    aaa.showBestSellingForJenin();
                    logger.log(Level.INFO,"\nNablus Best Product :\n");
                    aaa.showBestSellingForNablus();
                    break;

                case 6:
                    logger.log(Level.INFO, "Implementing dynamic discount...");
                    SalesReport sal = new SalesReport();

                    logger.log(Level.INFO, "Current Products List:");
                    for (ProductManegmwntSystem p : SweetProject.getProducts()) {
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, PRODUCT_DETAILS_LOG, p);
                        }
                    }

                    logger.log(Level.INFO, "Enter Product number to add discount:");
                    int pronumtodis = scanner.nextInt();
                    logger.log(Level.INFO, "Enter amount of discount to add:");
                    int discamount = scanner.nextInt();

                    ProductManegmwntSystem prodiscount = new ProductManegmwntSystem(pronumtodis, discamount);
                    sal.addDiscount(prodiscount);

                    logger.log(Level.INFO, "Updated Products List after Discount:");
                    for (ProductManegmwntSystem prodtocal : SweetProject.getProducts()) {
                        if (prodtocal.getUniq() == pronumtodis) {
                            if (logger.isLoggable(Level.INFO)) {
                                logger.log(Level.INFO, PRODUCT_DETAILS_LOG, prodtocal);
                            }
                            logger.log(Level.INFO, () -> "New price of " + prodtocal.getProductName() + " is: " + (prodtocal.getPrice() - prodtocal.getDiscount()));
                        }
                    }

                    break;
                case 7:
                    logger.log(Level.INFO,"Returning to Store Owner Menu...");
                    break;
                default:
                    logger.log(Level.INFO,INVALID);
            }
        } while (choice != 7);
    }







    public static void communicationAndNotificationsMenu(Scanner scanner, SweetProject s,User us) {
        int choice;
        s.isExist();
        Scanner check =new Scanner(System.in);
        do {
            logger.log(Level.INFO, "Communication and Notifications Menu:");
            logger.log(Level.INFO, "1. Send Message");
            logger.log(Level.INFO, "2. Respond to Message");
            logger.log(Level.INFO, "3. Back to Store Owner Menu");


            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    User userstoreowner = new User(us.getUsername(), us.getPass(), 2, us.getEmail(), us.getCity());

                    logger.log(Level.INFO, "Displaying Users with UserLevel 3:");
                    for (User usersshow : SweetProject.getUsers()) {
                        if (usersshow.getUserlevel() == 3) {
                            logger.log(Level.INFO, USER_DETAILS_LOG, usersshow);
                        }
                    }

                    logger.log(Level.INFO, "Enter name of user who you want to message:");
                    String usernameee = scanner.nextLine();
                    logger.log(Level.INFO, () -> "Enter your message to " + usernameee + ":");
                    String msg = check.nextLine();

                    StoreOwnerMessages message = new StoreOwnerMessages();
                    message.storeOwnersendmesseges(userstoreowner, msg, usernameee);

                    logger.log(Level.INFO, "Messages List:");
                    for (StoreOwnerMessages sto : StoreOwnerMessages.getMessegaesList()) {
                        if (logger.isLoggable(Level.INFO)) {
                            logger.log(Level.INFO, "Store owner message: {0}", sto);
                        }
                    }

                    break;
                case 2:
                    logger.log(Level.INFO, "2. Respond to Message");

                    User userownerr = new User(us.getUsername(), us.getPass(), 2, us.getEmail(), us.getCity());

                    StoreOwnerMessages messagee = new StoreOwnerMessages();

                    logger.log(Level.INFO, () -> "Displaying Messages for User: " + us.getUsername());
                    for (MessagingClass sto : MessagingClass.getMessages()) {
                        if (sto.getRecivername().equalsIgnoreCase(us.getUsername())&&logger.isLoggable(Level.INFO)) {

                                logger.log(Level.INFO, sto.toString());

                        }
                    }

                    logger.log(Level.INFO, "Enter name of user who you want to respond to:");
                    String usernae = scanner.nextLine();
                    logger.log(Level.INFO, () -> "Enter your response to " + usernae + ":");

                    String msgg = check.nextLine();

                    messagee.storeResponsemessege(userownerr, usernae, msgg);

                    logger.log(Level.INFO, () -> "Displaying Responses for Store Owner: " + us.getUsername());
                    for (StoreOwnerMessages stom : StoreOwnerMessages.getMessegaesList()) {
                        if (stom.getStorownerename().equalsIgnoreCase(us.getUsername())) {
                            logger.log(Level.INFO, "StoreOwnerMessage details: {0}", stom);
                        }
                    }

                    break;
                case 3:
                    break;
                default:
                    logger.log(Level.INFO,INVALID);
            }
        } while (choice != 3);
    }





    public static void accountManagementMenu(Scanner scanner, SweetProject s,User us) {
        int choice;
        s.isExist();
        do {
            logger.log(Level.INFO, "Account Management Menu:");
            logger.log(Level.INFO, "1. Update Account Details");
            logger.log(Level.INFO, "2. Back to Store Owner Menu");


            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    logger.log(Level.INFO, "Updating Account Details...");

                    for (User stotoup : SweetProject.getUsers()) {
                        if (stotoup.getUsername().equalsIgnoreCase(us.getUsername())) {
                            logger.log(Level.INFO, "Current User Details: {0}", stotoup);
                        }
                    }

                    Scanner updated = new Scanner(System.in);

                    logger.log(Level.INFO, "Enter your name to ensure Update: ");
                    String empna = updated.nextLine();

                    logger.log(Level.INFO, "Enter your new pass to Update: ");
                    String news = updated.nextLine();

                    logger.log(Level.INFO, "Enter your new City to Update 'Nablus' OR 'Jenin': ");
                    String ncity = updated.nextLine();

                    int userlevelll = 2;
                    String emaill = empna+news+EMAIL;
                    User updatedstoreowner = new User(empna, news, userlevelll, emaill, ncity);

                    StoreOwnerAccountManegment stoup = new StoreOwnerAccountManegment();
                    stoup.updateStoreowneraccount(updatedstoreowner);

                    for (User stot : SweetProject.getUsers()) {
                        if (stot.getUsername().equalsIgnoreCase(us.getUsername())) {
                            logger.log(Level.INFO, "Updated User Details: {0}", stot);
                        }
                    }


                    break;
                case 2:
                    break;
                default:
                    logger.log(Level.INFO,INVALID);
            }
        } while (choice != 2);
    }




    public static void orderManagementMenu(Scanner scanner, SweetProject s,User us) {
        int choice;
        String name;
        double pricee;
        double disco;
        s.isExist();
        us.getPass();
        do {
            logger.log(Level.INFO, "Order Management:");
            logger.log(Level.INFO, "1. Show Orders");
            logger.log(Level.INFO, "2. Update Order Details");
            logger.log(Level.INFO, "3. Back to Store Owner Menu");


            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    logger.log(Level.INFO,"Showing all orders...");
                    OrderManegmentClass or=new OrderManegmentClass();
                    or.showOrders();
                    break;
                case 2:
                    logger.log(Level.INFO,"Updating order details...");
                    OrderManegmentClass ord=new OrderManegmentClass();
                    ord.showOrders();
                    Scanner status=new Scanner(System.in);
                    logger.log(Level.INFO,"Enter Order Num you want to Update :\n");
                    int ordnum=scanner.nextInt();
                    name="";
                    pricee=0.0;
                    disco=0.0;
                    for(OrderManegmentClass orde :OrderManegmentClass.getOrderlist()){
                        if(orde.getOrdernum()==ordnum){
                            name=orde.getName();
                            pricee=orde.getDiscount();
                            disco=orde.getDiscount();
                        }
                    }
                    logger.log(Level.INFO,"Enter new Order status you want to Update :\n");
                    String ordstatus=status.nextLine();
                    OrderManegmentClass odertoupdate=new OrderManegmentClass(name,pricee,disco,ordnum,ordstatus);
                    ord.orderUpdate(odertoupdate);
                    ord.showOrders();
                    break;
                case 3:
                    break;
                default:
                    logger.log(Level.INFO,INVALID);
            }
        } while (choice != 3);
    }







    public static void beneficiaryUserMenu(Scanner scanner ,SweetProject s,User us) {
        int choice;
        do {
            logger.log(Level.INFO, "User Menu:");
            logger.log(Level.INFO, "1. User Account Management");
            logger.log(Level.INFO, "2. Exploration and Purchase");
            logger.log(Level.INFO, "3. Communication and Feedback");
            logger.log(Level.INFO, "4. Back to Main Menu");


            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    logger.log(Level.INFO,"Managing user account...");
                    userAccountManagementMenu(scanner, s,us);
                    break;
                case 2:
                    logger.log(Level.INFO,"Exploring and purchasing desserts...");
                    explorationAndPurchaseMenu(scanner, s,us);

                    break;
                case 3:
                    logger.log(Level.INFO,"Communicating and providing feedback...");
                    communicationAndFeedbackMenu(scanner, s,us);
                    break;
                case 4:
                    break;
                default:
                    logger.log(Level.INFO,INVALID);
            }
        } while (choice != 4);

    }





    public static void userAccountManagementMenu(Scanner scanner, SweetProject s,User us) {
        int choice;
        String username;
        String userpass;
        do {
            logger.log(Level.INFO, "User Account Management:");
            logger.log(Level.INFO, "1. SignUp for new User");
            logger.log(Level.INFO, "2. Login into system");
            logger.log(Level.INFO, "3. Update Account Details");
            logger.log(Level.INFO, "4. Upload a new dessert creation with details");
            logger.log(Level.INFO, "5. Back to User Menu");


            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Signup sig=new Signup();
                    Scanner vvv=new Scanner(System.in);

                    logger.log(Level.INFO,ENTER_NAME_PROMPT);
                    String usernamee=vvv.nextLine();
                    Scanner cii=new Scanner(System.in);

                    logger.log(Level.INFO,"Enter your pass pls :");
                    String userpasss=cii.nextLine();

                    logger.log(Level.INFO,"Enter your city pls 'Nablus OR jenin' :");
                    String cityy =vvv.nextLine();
                    us.setCity(cityy);
                    us.setUsername(usernamee);
                    us.setPass(userpasss);
                    int userlevel=3;
                    String email=usernamee+userpasss+EMAIL;
                    User usersign=new User(usernamee,userpasss,userlevel,email,cityy);
                    sig.addnewuserforuseronly(usersign);

                    for(User uuu: SweetProject.getUsers()){
                        if (uuu.getUsername().equalsIgnoreCase(usernamee)) {
                            logger.log(Level.INFO, USER_DETAILS_LOG, uuu);
                        }

                    }
                    break;


                case 2:
                    logger.log(Level.INFO,"Logging into the system...");

                    Scanner vv=new Scanner(System.in);
                    logger.log(Level.INFO,ENTER_NAME_PROMPT);
                    username=vv.nextLine();
                    Scanner ciii=new Scanner(System.in);

                    logger.log(Level.INFO,"Enter your pass pls :");
                    userpass=ciii.nextLine();
                    boolean sss=false;
                    if( s.isValidUser(SweetProject.getUsers(),username,userpass))
                    {
                        for(User u : SweetProject.getUsers()){
                            if(u.getUsername().equals(username)&&u.getPass().equals(userpass)&&u.getUserlevel()==3){
                                sss=true;
                                logger.log(Level.INFO, "User {0} logged in successfully.", username);
                                beneficiaryUserMenu(scanner,s,us);
                            }}}

                    if(!sss){
                        logger.log(Level.WARNING, "Invalid login attempt for username: {0}", username);
                    }
                    break;



                case 3:
                    logger.log(Level.INFO, "Updating account details...");

                    UserAccountManegment useraccount = new UserAccountManegment();

                    logger.log(Level.INFO, "Current user details before update:");
                    for (User usup : SweetProject.getUsers()) {
                        if (us.getUsername().equalsIgnoreCase(usup.getUsername())) {
                            logger.log(Level.INFO, "User: {0}", usup);
                        }
                    }

                    Scanner updated = new Scanner(System.in);

                    logger.log(Level.INFO, "Enter your name to ensure update:");
                    String usna = updated.nextLine();

                    logger.log(Level.INFO, "Enter your new password to update:");
                    String news = updated.nextLine();

                    logger.log(Level.INFO, "Enter your new city to update ('Nablus' OR 'Jenin'):");
                    String ncity = updated.nextLine();

                    int userlevelll = 3;
                    String emaill = usna+news+EMAIL;
                    User updatedstoreowner = new User(usna, news, userlevelll, emaill, ncity);

                    useraccount.updateUser(updatedstoreowner);

                    logger.log(Level.INFO, "Updated user details:");
                    for (User usup : SweetProject.getUsers()) {
                        if (usup.getUsername().equalsIgnoreCase(usna)) {
                            logger.log(Level.INFO, "User: {0}", usup);
                        }
                    }

                    break;
                case 4:
                    logger.log(Level.INFO, "Uploading a new dessert creation...");

                    Scanner c = new Scanner(System.in);

                    logger.log(Level.INFO, "Enter new Product name:");
                    String proname = c.nextLine();

                    logger.log(Level.INFO, "Enter new Product Description:");
                    String prodisc = c.nextLine();

                    logger.log(Level.INFO, "Enter Expected price of new Product:");
                    double proprice = c.nextDouble();  // Change to nextDouble() to match input type

                    UserShareProducts userpro = new UserShareProducts(proname, prodisc, proprice);
                    userpro.addnewProductForUser(userpro);

                    logger.log(Level.INFO, "Newly added product details:");
                    for (UserShareProducts userproo : UserShareProducts.getUserproducts()) {
                        if (userproo.getProductName().equalsIgnoreCase(proname)) {
                            logger.log(Level.INFO, "User Product: {0}", userproo);
                        }
                    }

                    break;
                case 5:
                    break;
                default:
                    logger.log(Level.INFO,INVALID);
            }
        } while (choice != 5);
    }



    public static void explorationAndPurchaseMenu(Scanner scanner, SweetProject s,User us) {
        int choice;
        s.isExist();
        us.getPass();
        do {
            logger.log(Level.INFO, "Exploration and Purchase:");
            logger.log(Level.INFO, "1. Search for Dessert Recipes");
            logger.log(Level.INFO, "2. Filter Recipes Based on Dietary Needs or Food Allergies");
            logger.log(Level.INFO, "3. Back to User Menu");


            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    logger.log(Level.INFO, "Searching for Dessert Recipes...");
                    logger.log(Level.INFO, "Number\tName\tPrice");
                    for (ProductManegmwntSystem producyres : SweetProject.getProducts()) {
                        logger.log(Level.INFO, "{0}\t{1}\t{2}", new Object[]{producyres.getUniq(), producyres.getProductName(), producyres.getPrice()});
                    }
                    logger.log(Level.INFO, "Enter number of product you want");
                    int prnum = scanner.nextInt();
                    ProductManegmwntSystem prodtosearch = new ProductManegmwntSystem(prnum);
                    UserRecipes userre = new UserRecipes();
                    userre.recipesSearch(prodtosearch);

                    break;

                case 2:
                    logger.log(Level.INFO, "Filtering Recipes Based on Dietary Needs or Food Allergies...");

                    logger.log(Level.INFO, "Name\t\t\tDescription");
                    for (ProductManegmwntSystem producyres : SweetProject.getProducts()) {
                        logger.log(Level.INFO, "{0}\t{1}", new Object[]{producyres.getProductName(), producyres.getProductDescription()});
                    }

                    logger.log(Level.INFO, "Write the name of the thing you are allergic to");
                    Scanner aller = new Scanner(System.in);
                    String allergic = aller.nextLine();

                    UserRecipes userrec = new UserRecipes();
                    logger.log(Level.INFO, "Number\tName\t\t\tDescription\t\t\tPrice");
                    userrec.filterRecipes(allergic);


                    break;
                case 3:
                    break;
                default:
                    logger.log(Level.INFO,INVALID);
            }
        } while (choice != 3);
    }

    public static void communicationAndFeedbackMenu(Scanner scanner, SweetProject s,User us) {
        int choice;

        s.isExist();
        do {
            logger.log(Level.INFO, "Communication and Feedback Menu:");
            logger.log(Level.INFO, "1. Directly communicate with store owners");
            logger.log(Level.INFO, "2. Provide feedback on purchased products");
            logger.log(Level.INFO, "3. Back to User Menu");


            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    logger.log(Level.INFO, "Communicating with store owners...");
                    MessagingClass message = new MessagingClass();
                    logger.log(Level.INFO, "Enter your message to your city Store Owner:");
                    Scanner suermsges = new Scanner(System.in);
                    String usermsg = suermsges.nextLine();
                    User usersend = new User(us.getUsername(), us.getPass(), us.getCity());
                    message.usersendMessages(usersend, usermsg);
                    logger.log(Level.INFO, "Messages sent:");
                    for (MessagingClass msged : MessagingClass.getMessages()) {
                        if (msged.getSendername().equalsIgnoreCase(us.getUsername())&&msged != null) {

                                logger.log(Level.INFO, "Message details: {0}", msged);


                        }
                    }

                    break;
                case 2:
                    logger.log(Level.INFO, "Providing feedback on purchased products...");

                    FeedBack messagees = new FeedBack();
                    logger.log(Level.INFO, "Product list:");
                    logger.log(Level.INFO, "number\tname\t\t\tDescription");
                    for (ProductManegmwntSystem producyres : SweetProject.getProducts()) {
                        logger.log(Level.INFO, "{0}\t{1}\t{2}", new Object[]{
                                producyres.getUniq(),
                                producyres.getProductName(),
                                producyres.getProductDescription()
                        });
                    }

                    logger.log(Level.INFO, "Enter number of product you want:");
                    int feedprodnum = scanner.nextInt();
                    Scanner allerr = new Scanner(System.in);
                    logger.log(Level.INFO, "Enter your feedback message:");
                    String aller = allerr.nextLine();

                    User usersendd = new User(us.getUsername(), us.getPass(), us.getCity());
                    messagees.userFeedback(usersendd, feedprodnum, aller);

                    logger.log(Level.INFO, "Feedback list:");
                    for (FeedBack fd : FeedBack.getFeedBacklist()) {
                        if (fd.getSenderName().equalsIgnoreCase(us.getUsername())&&fd != null) {


                                logger.log(Level.INFO, "Feedback details: {0}", fd);

                        }
                    }

                    break;
                case 3:
                    break;
                default:
                    logger.log(Level.INFO,INVALID);
            }
        } while (choice != 3);
    }


}

