import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class Test {

    @org.junit.jupiter.api.Test
     void test()
    {
        SystemC system = new SystemC();
        String login_id1 ="itayraz";
        String pass1 = "1234";
        //User new_user1 =  new User(login_id1,pass1);
        String login_id2 ="yuvalva";
        String pass2 = "12345";
        //User new_user2 =  new User(login_id2,pass2);

        Address add =  new Address("israel","beer sheve","harzit",5);
        system.AddUser("itayraz","1234",0,add,"0506824544","itay@gamil.com");
        System.out.println("Add user successed");

        system.AddUser("yuvalva","12345",1,add,"0506824545","yuval@gamil.com");
        System.out.println("Add user2 successed");

        try
        {
            system.loginUser(login_id1,pass1);
            System.out.println("login user user1 successed");
//            system.logoutUser(login_id1);
//            System.out.println("logoutuser user1 successed");
            system.RemoveUser(login_id1);
            System.out.println("remove user successed");
            boolean bool = system.loginUser(login_id2,pass2);
            System.out.println(bool + " " +  "loginuser user2 successed");
            system.logoutUser(login_id2);
            System.out.println("logoutuser user2 successed");

        }
        catch(Exception Error)
        {
            System.out.println(Error.getMessage() );
        }
        try
        {
//            system.AddUser("itayraz","1234",0,add,"0506824544","itay@gamil.com");
//            system.loginUser(login_id1,pass1);
            boolean bool = system.loginUser(login_id2,pass2);
            System.out.println(bool + " " +  "loginuser user2 successed");
            System.out.println("Create_new_order successed");

            Customer customer = User.UserDict.get(login_id2).get_customer();
            Account account = customer.get_account();
            system.Create_new_order(add);
            //system.AddProduct("shuko","moshe");

            //account.AddOrder(order);
            //String ordernum = order.get_number();
            //System.out.println(ordernum);
            //Customer customer = new Customer(add,"05066666","cus@gamil.com");
            //PremiumAccount prime_account = new PremiumAccount("account1",customer);
            //system.Add_product_to_order(account.get_lastOrder(),login_id2,"shuko");
            //System.out.println("dd_product_to_order successed");
            system.DisplayOrder();
            System.out.println("DisplayOrder successed");

        }
        catch(Exception Error)
        {
            System.out.println(Error.getMessage());
        }

        system.ShowAllObjects();
     }

}
