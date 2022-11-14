import Error.*;

import java.util.Date;

public class SystemC {
    private User _connectedUser;

    public SystemC(){
        this._connectedUser = null;
    }; //defult constructor
    public boolean AddUser(String _login_id,String _password,int premium,Address address,String phone, String email){
        if(User.UserDict.containsKey(_login_id)){
            return false;
        }
        User newUser= new User(_login_id,_password);
        Customer newCustomer = new Customer(address,phone,email);
        Account newAccount;
        if(premium == 1){
            newAccount = new PremiumAccount(_login_id,newCustomer);
            newCustomer.set_account(newAccount);
        }
        if (premium == 0){
            newAccount = new Account(newCustomer);
            newCustomer.set_account(newAccount);
        }
        newCustomer.set_user(newUser);
        return true;

    }
    public boolean RemoveUser(String Login_id)
    {
        if (User.UserDict.containsKey(Login_id)!= true)
        {
            return false;
        }
        User.UserDict.remove(Login_id);
        return true;
    }

    public boolean loginUser(String _loginid, String password) throws Erorr {
        Erorr error;
        if(this._connectedUser != null){
            error = new there_is_user_connected_EX();
            throw error;
        }

        if(!User.UserDict.containsKey(_loginid)){
            error = new id_is_wrong_EX();
            throw error;

        }
        if(!User.UserDict.get(_loginid).equals(password)){
            error = new pass_is_wrong_EX();
            throw error;
        }
        this._connectedUser = User.UserDict.get(_loginid);
        return true;
    }
    public boolean logoutUser(String _loginid) throws Erorr {
        Erorr error;
        if(this._connectedUser == null){
            error = new there_is_no_user_connected_EX();
            throw error;
        }
        this._connectedUser = null;
        return true;
    }

    public void Create_new_order(Address address) throws Erorr {

        if(_connectedUser==null)
        {
            Erorr error = new there_is_no_user_connected_EX();
            throw error;
        }
        Date currDate = new Date();
        Order order = new Order(currDate,address,_connectedUser.get_customer().get_account());
        System.out.println("Your Order number is: " + order.get_number());

    }



}
