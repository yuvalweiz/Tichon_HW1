import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @org.junit.jupiter.api.Test
    void addUser() {
        Address adress = new Address("ISRAEL","B7","mekor haim",12);
        User.AddUser("itay","123",0,adress,"052","walla.com");
        if(User.UserDict.containsKey("itay"))
            System.out.println("itay is in");
        if(!User.AddUser("itay","123",0,adress,"052","walla.com"))
            System.out.println("false");
        User.RemoveUser("itay");
        if(!User.UserDict.containsKey("itay"))
            System.out.println("itay is out");


    }

    @org.junit.jupiter.api.Test
    void removeUser() {
    }
}