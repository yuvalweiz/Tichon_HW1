import java.util.HashMap;

public class User {
    private String _login_id;
    private String _password;
    private UserState _state;
    private ShoppingCart _shcart;

    public void set_customer(Customer _customer) {
        this._customer = _customer;
    }

    private Customer _customer;
    public static HashMap<String, User> UserDict = new HashMap<String, User>();

    public User(String _login_id, String _password) { //SHOULD ADD USER STATE HERE!
        this._login_id = _login_id;
        this._password = _password;
        UserDict.put(_login_id,this);
        this._state = UserState.New;
    }

    public static boolean AddUser(String _login_id,String _password,int premium,Address address,String phone, String email){
        if(User.UserDict.containsKey(_login_id)){
            return false;
        }
        User newUser= new User(_login_id,_password);
        Customer newCustomer = new Customer(_login_id,address,phone,email);
        Account newAccount;
        if(premium == 1){
            newAccount = new PremiumAccount(_login_id,newCustomer);
            newCustomer.set_account(newAccount);
            newAccount.set_customer(newCustomer);
        }
        if (premium == 0){
            newAccount = new Account(_login_id,newCustomer);
            newCustomer.set_account(newAccount);
            newAccount.set_customer(newCustomer);
        }
        newCustomer.set_user(newUser);
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
