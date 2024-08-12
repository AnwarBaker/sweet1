package sweetsys;

import java.util.Scanner;

public class MainSweetSystem {




    public static void main(String[] args) {







SweetProject s= new SweetProject();
        s.users.add(new User("anwar", "123", 1,"anwar123@gmail.com","Jenin"));
        s.users.add(new User("ahmad", "1234", 3,"ahmad1234@gmail.com","Nablus"));
        s.users.add(new User("yasmine", "12345", 2,"yasmine12345@gmail.com","nablus"));
        s.users.add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com","Jenin"));

        s.users.add(new User("rama", "1", 3,"rama1@gmail.com","Jenin"));
        s.users.add(new User("lana", "34", 3,"lana34@gmail.com","Nablus"));
        s.users.add(new User("haya", "12", 2,"haya12@gmail.com","jenin"));
        s.users.add(new User("loay", "56", 3,"loay56@gmail.com","Jenin"));
        s.setUsers(s.users);




  s.products.add(new ProductManegmwntSystem(1,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"not finished",5));
  s.products.add(new ProductManegmwntSystem(2,"Cheesecake","Jenin","Creamy cheesecake with a graham cracker crust",5.0,30.0,"not finished",10));
  s.products.add(new ProductManegmwntSystem(3,"Cupcake","Nablus","Vanilla cupcake with buttercream frosting",3.0,20.0,"not finished",12));
  s.products.add(new ProductManegmwntSystem(4,"Lemon Tart","jenin","Tangy lemon curd in a buttery shortcrust pastry",4.0,25.0,"not finished",7));
  s.products.add(new ProductManegmwntSystem(5,"Apple Pie","Jenin","Traditional apple pie with a flaky crust and cinnamon-spiced filling",3.5,24.0,"not finished",30));
  s.products.add(new ProductManegmwntSystem(6,"Creme Brulee ","Nablus","Rich custard topped with a layer of hard caramel",1.5,15.0,"not finished",35));

  s.products.add(new ProductManegmwntSystem(7,"Brownies","Nablus","Fudgy chocolate brownies with a crackly top",8.0,35.0,"not finished",6));
  s.products.add(new ProductManegmwntSystem(8,"Panna Cotta","Jenin","Italian dessert made with sweetened cream and set with gelatin",12.0,55.0,"not finished",50));
  s.products.add(new ProductManegmwntSystem(9,"Macarons","jenin","Delicate almond meringue cookies filled with flavored buttercream",2.0,10.0,"not finished",40));
  s.setProducts(s.products);


  MessagingClass m=new MessagingClass();
  m.messages.add(new MessagingClass("loay","haya","heelo mr haya can i send you amessage"));
  m.messages.add(new MessagingClass("lana","haya","heelo mr haya can i send you amessage"));
  m.messages.add(new MessagingClass("rama","yasmine","heelo mr yasmine can i send you amessage"));



        StoreOwnerMessages store=new StoreOwnerMessages();
        store.messegaesList.add(new StoreOwnerMessages("haya","loay","yes sure...",1));
        store.messegaesList.add(new StoreOwnerMessages("haya","lana","yes sure...",1));
        store.messegaesList.add(new StoreOwnerMessages("yasmine","rama","yes sure...",1));
store.setMessegaesList(store.messegaesList);






   FeedBack feed=new FeedBack();

 feed.feedBacklist.add(new FeedBack("the product is so tasty",1,"lana","Nutella cake"));
 feed.feedBacklist.add(new FeedBack("perfect product",2,"tarneem","Cupcake"));
 feed.feedBacklist.add(new FeedBack("prodcut need more chocolate",3,"loay","Brownies"));
 feed.feedBacklist.add(new FeedBack("the product is so bad",4,"rama","Macarons"));
feed.setFeedBacklist(feed.feedBacklist);


UserShareProducts usershare=new UserShareProducts();
usershare.userproducts.add(new UserShareProducts("new cake","Tangy lemon curd in a buttery shortcrust pastry",15.0));
        usershare.userproducts.add(new UserShareProducts("new Macarons","Delicate almond meringue cookies filled with flavored buttercream",25.0));
        usershare.userproducts.add(new UserShareProducts("Better Cheesecake","Creamy cheesecake",10.0));
        usershare.setUserproducts(usershare.userproducts);


OrderManegmentClass order=new OrderManegmentClass();
order.orderlist.add(new OrderManegmentClass("loay",25.0,2.5,1,"done"));
        order.orderlist.add(new OrderManegmentClass("lana",20.0,3.0,2,"done"));
        order.orderlist.add(new OrderManegmentClass("rama",15.0,1.0,3,"processing"));
        order.setOrderlist(order.orderlist);


        Scanner scanner = new Scanner(System.in);
    int choice;
String adminname;
String adminpass;
String storename;
String storepass;
String username;
String userpass;

        do{
        System.out.println("Welcome to the Sweet Management System!");
        System.out.println("Please choose an option:");
        System.out.println("1. Admin");
        System.out.println("2. Store Owner");
        System.out.println("3. User");
        System.out.println("4. Exit");

        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Scanner c=new Scanner(System.in);
                System.out.println("Enter your Name pls :");
                adminname=c.nextLine();
                Scanner cin=new Scanner(System.in);

                System.out.println("Enter your pass pls :");
                adminpass=cin.nextLine();
                boolean f=false;

                if( s.isValidUser(s.getUsers(),adminname,adminpass))
                {
                    for(User u :s.getUsers()){
                        if(u.getUsername().equals(adminname)&&u.getPass().equals(adminpass)&&u.getUserlevel()==1){
                    f=true;
                    System.out.println("You are Welcome Admin "+adminname);
                    User testcons =new User(adminname,adminpass,1,u.getEmail(),u.getCity());
                    s.login(testcons);

                adminMenu(scanner);}}}

                if(!f) {
                    System.out.println("you are not valid try again");
                }
                break;



            case 2:

                Scanner v=new Scanner(System.in);
                System.out.println("Enter your Name pls :");
                storename=v.nextLine();
                Scanner ci=new Scanner(System.in);

                System.out.println("Enter your pass pls :");
                storepass=ci.nextLine();
             boolean ss=false;
                if( s.isValidUser(s.getUsers(),storename,storepass))
                {
                    for(User u :s.getUsers()){
                        if(u.getUsername().equals(storename)&&u.getPass().equals(storepass)&&u.getUserlevel()==2){
                            ss=true;
                    System.out.println("You are Welcome Store Owner "+storename);
                storeOwnerMenu(scanner,s);
                        }}}
                if(!ss) { System.out.println("you are not valid try again");}
                break;
            case 3:


                Scanner vv=new Scanner(System.in);
                System.out.println("Enter your Name pls :");
                username=vv.nextLine();
                Scanner cii=new Scanner(System.in);

                System.out.println("Enter your pass pls :");
                userpass=cii.nextLine();
                boolean sss=false;
                if( s.isValidUser(s.getUsers(),username,userpass))
                {
                    for(User u :s.getUsers()){
                        if(u.getUsername().equals(username)&&u.getPass().equals(userpass)&&u.getUserlevel()==3){
                            sss=true;
                            System.out.println("You are Welcome User "+username);

                beneficiaryUserMenu(scanner);
                        }}}

                if(!sss){
                    System.out.println("you are not valid try again");}
                break;

            case 4:
                System.out.println("Exiting the system. Goodbye!");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (choice != 4);

        scanner.close();
}

 public static void adminMenu(Scanner scanner) {
    int choice;
     SweetProject s = new SweetProject();
    do {
        System.out.println("Admin Menu:");
        System.out.println("1. User Management");
        System.out.println("2. Monitoring and Reporting");
        System.out.println("3. Content Management");
        System.out.println("4. Back to Main Menu");

        choice = scanner.nextInt();

        switch (choice) {
            case 1:

                System.out.println("Managing user accounts...");
                userManagementMenu(scanner, s);



                break;
            case 2:
                System.out.println("Monitoring profits and generating reports...");
                monitoringAndReportingMenu(scanner, s);


                break;
            case 3:
                System.out.println("Managing content...");

                contentManagementMenu(scanner,s);
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (choice != 4);
}







    public static void userManagementMenu(Scanner scanner, SweetProject s) {
        int choice;
        do {
            String newname;
            String newpass;
            String email;
            String city;
            int UselLevel;

            System.out.println("1. Add New Account");
            System.out.println("2. Update User Account");
            System.out.println("3. Delete User Account");
            System.out.println("4. Back to Admin Menu");

            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.println("Enter new account name ");
                    Scanner cin=new Scanner(System.in);
                    newname=cin.nextLine();
                    System.out.println("Enter new account pass ");
                    newpass=cin.nextLine();
                    System.out.println("Enter new account Uselevel :\n '1' for admin \n '2' for store owner \n '3' for User ");
                    UselLevel=cin.nextInt();
                    System.out.println("Enter new account city 'Nablus' OR 'Jenin' ");
                    Scanner scan=new Scanner(System.in);
                    city=scan.nextLine();
                    email=newname+newpass+"@gmail.com";
                    User user=new User(newname,newpass,UselLevel,email,city);
                    signup sign =new signup();

                    sign.addnewuser(user);
                    s.ShowEachTypeOfUsers();

                    break;
                case 2:

                    s.Update();

                    break;
                case 3:
                s.Delete();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }


    public static void monitoringAndReportingMenu(Scanner scanner, SweetProject s) {
        int choice;
        do {
            System.out.println("1. Generate Financial Reports");
            System.out.println("2. Identify Best-Selling Products in Each Store");
            System.out.println("3. Gather and Display User Statistics by City");
            System.out.println("4. Back to Admin Menu");

            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.println("Generating financial reports...");
                  SalesReport sales=new SalesReport();
                  sales.ShoewSalesReport();

                    break;

                case 2:
                    System.out.println("Identifying best-selling products in each store...\n");
AdminReports a=new AdminReports();
a.SeperateEachCity();
a.ShowBestSellinForNablus();
a.ShowBestSellinForJenin();

                    break;

                case 3:
                    System.out.println("Gathering and displaying user statistics by city...\n");
                    AdminReports aa=new AdminReports();

                aa.SeperateEachUserToCities();

                break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }






    public static void contentManagementMenu(Scanner scanner,SweetProject s) {
        int choice;
        do {
            System.out.println("Content Management Menu:");
            System.out.println("1. Update Recipes");
            System.out.println("2. Delete Recipes");
            System.out.println("3. Show Feedback");
            System.out.println("4. Respond to Feedback");
            System.out.println("5. Back to Admin Menu");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    System.out.println("Updating recipe...");
                    ContentSection c=new ContentSection();

                    c.UpdateUserRecipes();

                    break;
                case 2:

                    System.out.println("Deleting recipe...");
                    ContentSection cc=new ContentSection();
                    cc.DeleteUserRecipes();



                    break;
                case 3:

                    System.out.println("Showing feedback...");
FeedBack f=new FeedBack();
f.ShowFeedBack();

                    break;
                case 4:
                    // Show feedback functionality
                    System.out.println("Responding to feedback...");

                    AdminFeedback adminfeed =new AdminFeedback();
                    User userfeedback=new User();

                    User uuu=new User("anwar",userfeedback.getPass(),1,userfeedback.getEmail(),userfeedback.getCity());
                    adminfeed.AdminResponseMessege(uuu);

                    break;
                case 5:

                    System.out.println("Returning to Admin Menu...");

                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }









    public static void storeOwnerMenu(Scanner scanner,SweetProject s) {
    int choice;
    do {
        System.out.println("Store Owner Menu:");
        System.out.println("1. Product Management");
        System.out.println("2. Communication and Notifications");
        System.out.println("3. Account Management");
        System.out.println("4. Order Management");
        System.out.println("5. Back to Main Menu");

        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Managing products...");
                productManagementMenu(scanner ,s);
                break;
            case 2:

                System.out.println("Communication and Notifications...");
                communicationAndNotificationsMenu(scanner, s);

                break;

            case 3:
                System.out.println("Account Management...");
                accountManagementMenu(scanner, s);

                break;
            case 4:
                System.out.println("Managing orders...");
                orderManagementMenu(scanner, s);
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (choice != 5);
}







    public static void productManagementMenu(Scanner scanner, SweetProject s) {
        int choice;
        do {
            System.out.println("Product Management Menu:");
            System.out.println("1. Add New Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Show Sales Report");
            System.out.println("5. Show Best Selling Products");
            System.out.println("6. Implement Dynamic Discount");
            System.out.println("7. Back to Store Owner Menu");

            choice = scanner.nextInt();
            scanner.nextLine();

            String proname;
            String prodisc;
            double price;

            switch (choice) {
                case 1:
                    System.out.println("Adding new product...\n");


                    System.out.println("Enter Product Name : \n");
                    proname=scanner.nextLine();
                    System.out.println("Enter Product Discription : \n");
                    prodisc=scanner.nextLine();
                    System.out.println("Enter Product Price  : \n");
                   price=scanner.nextInt();

                    ProductManegmwntSystem pro=new ProductManegmwntSystem(10,proname,"nablus",prodisc,price);



                    s.addnewProduct(pro);
                    for (ProductManegmwntSystem p :s.getProducts()){
                        System.out.println(p);
                    }

                    break;
                case 2:
                    System.out.println("Updating product...");
                    s.ProductUpdate();
                    break;
                case 3:
                    System.out.println("Deleting product...");
                    s.DeleteProduct();
                    break;
                case 4:
                    System.out.println("Showing sales report...");
                    SalesReport saless =new SalesReport();
                    saless.ShoewSalesReport();
                    break;
                case 5:
                    System.out.println("Showing best selling products...");
                    AdminReports aaa=new AdminReports();
                    aaa.SeperateEachCity();

                    aaa.ShowBestSellinForJenin();


                    aaa.ShowBestSellinForNablus();
                    break;
                case 6:
                    System.out.println("Implementing dynamic discount...");
                   SalesReport sal=new SalesReport();
                   sal.addDiscount();
                    break;
                case 7:
                    System.out.println("Returning to Store Owner Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }







    public static void communicationAndNotificationsMenu(Scanner scanner, SweetProject s) {
        int choice;
        do {
            System.out.println("Communication and Notifications Menu:");
            System.out.println("1. Send Message");
            System.out.println("2. Respond to Message");
            System.out.println("3. Back to Store Owner Menu");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                  User userstoreowner=new User("yasmine", "12345", 3,"yasmine12345@gmail.com","Jenin");
                  StoreOwnerMessages message=new StoreOwnerMessages();
                  message.StoreOwnerSendMesseges(userstoreowner);
                    break;
                case 2:

                    User userowner=new User("yasmine", "12345", 3,"yasmine12345@gmail.com","Jenin");
                    StoreOwnerMessages messagee=new StoreOwnerMessages();
                    messagee.StoreResponseMessege(userowner);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }





    public static void accountManagementMenu(Scanner scanner, SweetProject s) {
        int choice;
        do {
            System.out.println("Account Management Menu:");
            System.out.println("1. Update Account Details");
            System.out.println("2. Back to Store Owner Menu");

            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.println("Updating Account Details...");
                    StoreOwnerAccountManegment st=new StoreOwnerAccountManegment();
                    st.UpdateStoreOwnerAccount();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 2);
    }




    public static void orderManagementMenu(Scanner scanner, SweetProject s) {
        int choice;
        do {
            System.out.println("Order Management:");
            System.out.println("1. Show Orders");
            System.out.println("2. Update Order Details");
            System.out.println("3. Back to Store Owner Menu");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Showing all orders...");
                    OrderManegmentClass or=new OrderManegmentClass();
                    or.ShowOrders();
                    break;
                case 2:
                    System.out.println("Updating order details...");
                    OrderManegmentClass ord=new OrderManegmentClass();
                    ord.OrderUpdate();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }







public static void beneficiaryUserMenu(Scanner scanner) {
    int choice;
    do {
        System.out.println("User Menu:");
        System.out.println("1. User Account Management");
        System.out.println("2. Exploration and Purchase");
        System.out.println("3. Communication and Feedback");
        System.out.println("4. Back to Main Menu");

        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Managing user account...");
                // Add functionality here
                break;
            case 2:
                System.out.println("Exploring and purchasing desserts...");
                // Add functionality here
                break;
            case 3:
                System.out.println("Communicating and providing feedback...");
                // Add functionality here
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (choice != 4);

}
}
