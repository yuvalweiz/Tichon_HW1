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

    public InputCheck loginUser(String _loginid, String password){
        if(this._connectedUser != null){
            return InputCheck.there_is_user_connected;
        }

        if(!User.UserDict.containsKey(_loginid)){
            return InputCheck.id_is_wrong;
        }
        if(!User.UserDict.get(_loginid).equals(password)){
            return InputCheck.pass_is_wrong;
        }
        this._connectedUser = User.UserDict.get(_loginid);
        return InputCheck.succses;
    }
    public InputCheck logoutUser(String _loginid){
        if(this._connectedUser == null){
            return InputCheck.there_is_no_user_connected;
        }
        return InputCheck.succses;
    }


}
