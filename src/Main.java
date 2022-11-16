
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args) throws IOException {
        /* System initialization  */
        SystemC system = new SystemC();
        //Supplier osem = new Supplier("Osem");
        //Supplier EastWest = new Supplier("EastWest");
        //Product bamba = new Product("Bamba",osem);
        system.AddProduct("Bamba","Osem");
        system.AddProduct("Ramen","EastWest");
        //Product ramen = new Product("Ramen",EastWest);
        system.AddUser("Dani","Dani123",0,null,null,null);
        system.AddUser("Dana","Dana123",1,null,null,null);
        PremiumAccount danaIsPremium = (PremiumAccount) User.UserDict.get("Dana").get_customer().get_account();
        danaIsPremium.AddProductByName("Bamba");
        /* End of System initialization  */


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int choice;
        String login_id;
        int p_account;
        String pass;
        String customer_country;
        String customer_city;
        String customer_street;
        Address address;
        String customer_phone;
        String customer_email;
        int customer_addres_num;
        while(true)
        {

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
                    try {
                        System.out.println("Enter login id: ");
                        login_id = reader.readLine();
                        System.out.println("Enter password: ");
                        pass = reader.readLine();
                        System.out.println("Premium account: - Yes enter 1/No enter 0");
                         p_account = scanner.nextInt();
                        System.out.println("Enter customer country: ");
                        customer_country = reader.readLine();
                        System.out.println("Enter customer city: ");
                        customer_city = reader.readLine();
                        System.out.println("Enter customer street: ");
                        customer_street = reader.readLine();
                        System.out.println("Enter customer number: ");
                        customer_addres_num = scanner.nextInt();
                        address = new Address(customer_country, customer_city, customer_street, customer_addres_num);
                        System.out.println("Enter customer phone: ");
                        customer_phone = reader.readLine();
                        System.out.println("Enter customer email: ");
                        customer_email = reader.readLine();
                        if (!system.AddUser(login_id, pass, p_account, address, customer_phone, customer_email)) {
                            System.out.println("User is not valid");
                            break;

                        }
                    }
                    catch (Exception InputMismatchException ) {
                        System.out.println("Your input invalid, please try agian!");
                        scanner.nextLine();
                        break;
                    }
                    System.out.println("The user was successfully added");
                    break;

                case 2:
                    try
                    {
                        System.out.println("Enter login id: ");
                        login_id = reader.readLine();
                        if (!system.RemoveUser(login_id))
                        {
                            System.out.println("User does not exist");
                            break;
                        }
                    }
                    catch (Exception Error)
                    {
                        System.out.println(Error.getMessage());
                        break;
                    }
                    System.out.println("The user was successfully removed");
                    break;
                case 3:
                    try
                    {
                        System.out.println("Enter login id: ");
                        login_id = reader.readLine();
                        System.out.println("Enter password: ");
                        pass = reader.readLine();
                        if (!system.loginUser(login_id, pass))
                        {
                            System.out.println("Login problem");
                            break;
                        }
                    }
                    catch (Exception Error)
                    {
                        System.out.println(Error.getMessage());
                        break;
                    }
                    System.out.println("The user was successfully logged in");
                    break;
                case 4:
                    try
                    {
                        System.out.println("Enter login id: ");
                        login_id = reader.readLine();
                        if (!system.logoutUser(login_id))
                        {
                            System.out.println("logout problem");
                            break;
                        }
                    }
                    catch (Exception Error)
                    {
                        System.out.println(Error.getMessage());
                        break;
                    }
                    System.out.println("The user was successfully Logged out");
                    break;
                case 5:
                    try
                    {
                        System.out.println("Enter login id: ");
                        login_id = reader.readLine();
                        System.out.println("Enter customer country: ");
                        customer_country = reader.readLine();
                        System.out.println("Enter customer city: ");
                        customer_city = reader.readLine();
                        System.out.println("Enter customer street: ");
                        customer_street = reader.readLine();
                        System.out.println("Enter customer number: ");
                        customer_addres_num = scanner.nextInt();
                        address = new Address(customer_country, customer_city, customer_street, customer_addres_num);
                        system.Create_new_order(address);
                    }
                    catch (Exception Error)
                    {
                        System.out.println(Error.getMessage());
                        break;
                    }
                    System.out.println("A new order has been successfully created");
                    break;
                case 6:
                    try
                    {
                        System.out.println("Enter order id: ");
                        String order_id = reader.readLine();
                        System.out.println("Enter seller login id: ");
                        login_id = reader.readLine();
                        System.out.println("Enter product name: ");
                        String product_name = reader.readLine();
                        try
                        {
                            system.Add_product_to_order(order_id, login_id, product_name);

                        }
                        catch (Exception Error)
                        {
                            System.out.println(Error.getMessage());
                            break;

                        }
                        System.out.println("Do you want to add payment method? Yes enter 1/Not enter 0");
                        int want_payment = scanner.nextInt();
                        if (want_payment == 0)
                        {
                            break;
                        }
                        if (want_payment == 1)
                        {
                            System.out.println("Which payment method you prefer? ");
                            System.out.println("For delayed payment press 1 ");
                            System.out.println("For immediate payment press 0 ");
                            int payment_type = scanner.nextInt();
                            if (payment_type == 1)
                            {
                                System.out.println("Enter details");
                                String details = reader.readLine();
                                System.out.println("Enter payment date in the following format: ");
                                System.out.println("DD/MM/YYYY");
                                String payment_date = reader.readLine();
                                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(payment_date);
                                DelayedPayment delayed_payment = system.AddDelayedPayment(order_id, details, date);
                                System.out.println(delayed_payment.toString());

                            }
                            if (payment_type == 0)
                            {
                                System.out.println("Enter details");
                                String details = reader.readLine();
                                System.out.println("Payment with phoneconfirmation? Yes enter 1/Not enter 0");
                                int pc = scanner.nextInt();
                                if (pc == 0)
                                {
                                    ImmediatePayment immediate_payment  = system.AddImmediatePayment(order_id, details, false);
                                    System.out.println(immediate_payment.toString());

                                }
                                if (pc == 1)
                                {
                                    ImmediatePayment immediate_payment= system.AddImmediatePayment(order_id, details, true);
                                    System.out.println(immediate_payment.toString());

                                }

                            }
                        }

                    }
                    catch (Exception Error)
                    {

                        System.out.println(Error.getMessage());
                        break;
                    }
                    System.out.println("Adding a product to the order was done successfully");
                    break;
                case 7:
                    try
                    {
                        system.DisplayOrder();
                    } catch (Exception Error)
                    {

                        System.out.println(Error.getMessage());
                        break;
                    }
                    System.out.println("Display order done");
                    break;
                case 8:
                    try
                    {
                        System.out.println("Enter product name: ");
                        String name = reader.readLine();
                        System.out.println("Enter price: ");
                        int price = scanner.nextInt();
                        System.out.println("Enter product quantity: ");
                        int Quan = scanner.nextInt();
                        system.LinkProduct(name, price, Quan);
                    }
                    catch (Exception Error)
                    {
                        System.out.println(Error.getMessage());
                        break;
                    }
                    System.out.println("Link product done");

                    break;
                case 9:
                    System.out.println("Enter name: ");
                    String name = reader.readLine();
                    System.out.println("Enter supplier: ");
                    String supllierName = reader.readLine();
                    system.AddProduct(name, supllierName);

                    System.out.println("Product has been added");
                    break;
                case 10:
                    try
                    {
                        System.out.println("Enter product name: ");
                        name = reader.readLine();
                        system.Delete_Product(name);
                    }
                    catch (Exception Error)
                    {

                        System.out.println(Error.getMessage());
                        break;
                    }
                    System.out.println("Product has been deleted");
                    break;
                case 11:
                    system.ShowAllObjects();
                    System.out.println("Show all objects done");
                    break;
                case 12:
                    int choose;
                    while (true)
                    {
                        System.out.println("Please choose category: ");
                        System.out.println("Press 1 for user");
                        System.out.println("Press 2 for product");
                        System.out.println("Press 3 for supplier ");
                        System.out.println("Press 4 for other object");
                        System.out.println("Press 5 to return \n \n ");

                        choose = scanner.nextInt();
                        switch (choose)
                        {
                            case 1:
                                try
                                {
                                    System.out.println("Enter id: ");
                                    String id = reader.readLine();
                                    system.ShowObjectUSER(id);
                                }
                                catch (Exception Error)
                                {
                                    System.out.println(Error.getMessage());
                                    break;
                                }
                                System.out.println("Show user id was done");
                                break;

                            case 2:
                                try
                                {
                                    System.out.println("Enter id: ");
                                    String id = reader.readLine();
                                    system.ShowObjectProduct(id);
                                }
                                catch (Exception Error)
                                {
                                    System.out.println(Error.getMessage());
                                    break;
                                }
                                System.out.println("Show product id was done");

                                break;

                            case 3:
                                try
                                {
                                    System.out.println("Enter id:");
                                    String id = reader.readLine();
                                    system.ShowObjectSupplier(id);
                                }
                                catch (Exception Error)
                                {
                                    System.out.println(Error.getMessage());
                                    break;
                                }
                                System.out.println("Show supplier id was done");
                                break;

                            case 4:
                                try
                                {
                                    System.out.println("Enter id: ");
                                    String id = reader.readLine();
                                    system.ShowObjectID(id);
                                }
                                catch (Exception Error)
                                {
                                    System.out.println(Error.getMessage());
                                    break;
                                }
                                System.out.println("Show object id was done");
                                break;

                            case 5:
                                break;

                            default:
                                System.out.println("Invalid choice!Please make a valid choice. \\n\\n");
                        }
                    }
                case 13:
                    return;
                //default case to display the message invalid choice made by the user
                default:
                    System.out.println("Invalid choice!Please make a valid choice. \\n\\n");

            }

        }

    }

}