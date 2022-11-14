import static org.junit.jupiter.api.Assertions.*;

public class Test {

    @org.junit.jupiter.api.Test
     void test()
    {
        SystemC system = new SystemC();
        String login_id1 ="itayraz";
        String pass1 = "1234";
        User new_user1 =  new User(login_id1,pass1);
        String login_id2 ="yuvalva";
        String pass2 = "12345";
        User new_user2 =  new User(login_id2,pass2);

        Address add =  new Address("israel","beer sheve","harzit",5);
        system.AddUser("itayraz","1234",0,add,"0506824544","itay@gamil.com");
        System.out.println("Add user successed");
        system.AddUser("yuvalva","12345",1,add,"0506824545","yuval@gamil.com");
        System.out.println("Add user2 successed");
        try
        {
//            system.loginUser(login_id2,pass2);
//            System.out.println("loginuser user2 successed");
            system.RemoveUser(login_id1);
            System.out.println("remove user successed");
            system.loginUser(login_id2,pass2);
            System.out.println("loginuser user2 successed");
            system.logoutUser(login_id2);
            System.out.println("logoutuser user2 successed");

        }
        catch(Exception Error)
        {
            System.out.println(Error.getMessage());
        }
        try
        {
            system.Create_new_order(add);
            System.out.println("Create_new_order successed");

        }
        catch(Exception Error)
        {
            System.out.println(Error.getMessage());
        }


     }

}
