
import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        /* System initialization  */
        SystemC system = new SystemC();
        Supplier osem = new Supplier("Osem");
        Supplier EastWest = new Supplier("EastWest");
        Product bamba = new Product("Bamba",osem);
        Product ramen = new Product("Ramen",EastWest);
        system.AddUser("Dani","Dani123",0,null,null,null);
        system.AddUser("Dana","Dana123",1,null,null,null);
        PremiumAccount danaIsPremium = (PremiumAccount) User.UserDict.get("Dana").get_customer().get_account();
        danaIsPremium.AddProduct(bamba);


        Scanner scanner = new Scanner(System.in);
        int choice;
        while(true) {

            System.out.println("Press 1 for Add user");
            System.out.println("Press 2 for Remove user");
            System.out.println("Press 3 for Login user ");
            System.out.println("Press 4 for Logout user ");
            System.out.println("Press 5 for Create new order");
            System.out.println("Press 6 for Add product to order");
            System.out.println("Press 7 for Display order");
            System.out.println("Press 8 for Link Product ");
            System.out.println("Press 9 for Add Product ");
            System.out.println("Press 10 for Delete Product ");
            System.out.println("Press 11 for ShowAllObjects ");
            System.out.println("Press 12 for ShowObjectId ");
            System.out.println("Press 13 to Quit\n \n ");

            choice = scanner.nextInt();

            switch (choice) {

                //First case for finding the addition
                case 1:
                    System.out.println("Enter login_id: ");
                    String login_id = scanner.next();
                    System.out.println("Enter password:");
                    String pass = scanner.next();
                    System.out.println("Premium account: - Yes enter 1/Not enter 0");
                    int p_account = scanner.nextInt();
                    System.out.println("Enter customer country: ");
                    String customer_country = scanner.next();
                    System.out.println("Enter customer city: ");
                    String customer_city = scanner.next();
                    System.out.println("Enter customer street: ");
                    String customer_street = scanner.next();
                    System.out.println("Enter customer number: ");
                    int customer_addres_num = scanner.nextInt();
                    Address address = new Address(customer_country, customer_city, customer_street, customer_addres_num);
                    System.out.println("Enter customer phone: ");
                    String customer_phone = scanner.next();
                    System.out.println("Enter customer email: ");
                    String customer_email = scanner.next();
                    if(!system.AddUser(login_id, pass, p_account, address, customer_phone, customer_email))
                    {
                        System.out.println("User is not valid");

                    }
                    break;

                case 2:
                    try
                    {
                        System.out.println("Enter login_id: ");
                        login_id = scanner.next();
                        if(!system.RemoveUser(login_id))
                        {
                            System.out.println("User does not exist");
                        }
                        break;
                    }
                    catch(Exception Error)
                    {
                        System.out.println(Error.getMessage());
                    }


                case 3:
                    try
                    {
                        System.out.println("Enter login_id: ");
                        login_id = scanner.next();
                        System.out.println("Enter password: ");
                        pass = scanner.next();
                        if(!system.loginUser(login_id,pass))
                        {
                            System.out.println("Login problem");
                        }
                    }
                    catch(Exception Error) {
                        System.out.println(Error.getMessage());
                    }
                    break;
                case 4:
                    try
                    {
                        System.out.println("Enter login_id: ");
                        login_id = scanner.next();
                        if(!system.logoutUser(login_id))
                        {
                            System.out.println("logout problem");
                        }
                    }
                    catch(Exception Error) {
                        System.out.println(Error.getMessage());
                    }
                    break;
                case 5:
                    try
                    {
                        System.out.println("Enter login_id: ");
                        login_id = scanner.next();
                        System.out.println("Enter customer country: ");
                        customer_country = scanner.next();
                        System.out.println("Enter customer city: ");
                        customer_city = scanner.next();
                        System.out.println("Enter customer street: ");
                        customer_street = scanner.next();
                        System.out.println("Enter customer number: ");
                        customer_addres_num = scanner.nextInt();
                        address = new Address(customer_country, customer_city, customer_street, customer_addres_num);
                        system.Create_new_order(address);
                    }
                    catch(Exception Error) {
                        System.out.println(Error.getMessage());
                    }
                    break;
                case 6:
                    try
                    {
                        System.out.println("Enter Order_id: ");
                        String order_id = scanner.next();
                        System.out.println("Enter Login_id: ");
                        login_id = scanner.next();
                        System.out.println("Enter Product_name: ");
                        String product_name = scanner.next();
                        system.Add_product_to_order(order_id,login_id,product_name);
                    }
                    catch(Exception Error)
                    {

                        System.out.println(Error.getMessage());
                    }
                    break;
                case 7:
                    try
                    {
                        system.DisplayOrder();
                    }
                    catch(Exception Error)
                    {

                        System.out.println(Error.getMessage());
                    }
                    break;
                case 8:
                    try
                    {
                        System.out.println("Enter name: ");
                        String name = scanner.next();
                        System.out.println("Enter price: ");
                        int price = scanner.nextInt();
                        System.out.println("Enter Product_name: ");
                        int Quan = scanner.nextInt();
                        system.LinkProduct(name,price,Quan);
                    }
                    catch(Exception Error)
                    {

                        System.out.println(Error.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Enter name: ");
                    String name = scanner.next();
                    System.out.println("Enter price: ");
                    String supllierName = scanner.next();
                    system.AddProduct(name,supllierName);
                    break;

                //default case to display the message invalid choice made by the user
                default:
                    System.out.println("Invalid choice!!! Please make a valid choice. \\n\\n");

            }
        }

    }

}