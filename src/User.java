import java.util.HashMap;

public class User {
    private String _login_id;
    private String _password;
    private UserState _state;
    private ShoppingCart _shcart;
    private Customer _Customer;
    public void set_Customer(Customer _Customer) {
        this._Customer = _Customer;
    }


    public static HashMap<String, User> UsersDic = new HashMap<String, User>();

    public User(String _login_id, String _password) { //SHOULD ADD USER STATE HERE!
        this._login_id = _login_id;
        this._password = _password;
        this._state = _state;
        UsersDic.put(_login_id,this);
    }

    public static boolean AddUser(String loginId,String password,int premium,Address address, String phone,String email){
        if(User.UsersDic.containsKey(loginId)){
            return false;
        }
        User newUser = new User(loginId,password);
        Customer newCustomer = new Customer(loginId,address,phone,email);
        newUser.set_Customer(newCustomer);
        if(premium == 1) {
            PremiumAccount newPremiumAccount = new PremiumAccount(loginId, newCustomer);
            newPremiumAccount.set_customer(newCustomer);
            newCustomer.set_account(newPremiumAccount);
        }
        if(premium == 0){
            Account newAccount = new Account(loginId,newCustomer);
            newAccount.set_customer(newCustomer);
            newCustomer.set_account(newAccount);
        }

        return true;
    }

    public void set_shcart(ShoppingCart _shcart) {
        this._shcart = _shcart;
    }

    public ShoppingCart get_shcart() {
        return _shcart;
    }

    public String get_login_id() {
        return _login_id;
    }

    public void set_login_id(String _login_id) {
        this._login_id = _login_id;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public UserState get_state() {
        return _state;
    }

    public void set_state(UserState _state) {
        this._state = _state;
    }
}
