import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @org.junit.jupiter.api.Test
    void addUser() {
        SystemC system = new SystemC();
        Address adress = new Address("ISRAEL","B7","mekor haim",12);
        system.AddUser("itay","123",0,adress,"052","walla.com");
        if(User.UserDict.containsKey("itay"))
            System.out.println("itay is in");
        if(!system.AddUser("itay","123",0,adress,"052","walla.com"))
            System.out.println("false");
        system.RemoveUser("itay");
        if(!User.UserDict.containsKey("itay"))
            System.out.println("itay is out");


    }

    @org.junit.jupiter.api.Test
    void removeUser() {
    }
}