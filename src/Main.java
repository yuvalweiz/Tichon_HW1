import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        SystemC system = new SystemC();
        Scanner scanner = new Scanner(System.in);
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

            System.out.println("Make your choice");
            int choice = scanner.nextInt();
            switch (choice) {

                //First case for finding the addition
                case 1:
                    System.out.println("Enter Login_id ");
                    String login_id = scanner.nextLine();
                    System.out.println("Enter password");
                    String pass = scanner.nextLine();
                    System.out.println("Premium Account - Yes enter 1/Not enter 0");
                    int p_account = scanner.nextInt();
                    System.out.println("Enter customer country");
                    String customer_country = scanner.nextLine();
                    System.out.println("Enter customer city");
                    String customer_city = scanner.nextLine();
                    System.out.println("Enter customer street");
                    String customer_street = scanner.nextLine();
                    System.out.println("Enter customer number");
                    int customer_addres_num = scanner.nextInt();
                    Address address = new Address(customer_country, customer_city, customer_street, customer_addres_num);
                    System.out.println("Enter customer phone");
                    String customer_phone = scanner.nextLine();
                    System.out.println("Enter customer email");
                    String customer_email = scanner.nextLine();
                    if(!system.AddUser(login_id, pass, p_account, address, customer_phone, customer_email))
                    {
                        System.out.println("user is not valid");

                    }
                    break;
                //default case to display the message invalid choice made by the user
                default:
                    System.out.println("Invalid choice!!! Please make a valid choice. \\n\\n");

            }
        }

    }
}