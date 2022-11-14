import java.util.HashMap;

public class User {
    private String _login_id;
    private String _password;
    private UserState _state;
    private ShoppingCart _shcart;

    public void set_customer(Customer _customer) {
        this._customer = _customer;
    }

    @Override
    public String toString() {
        return "User{" +
                "_login_id='" + _login_id + '\'' +
                ", _password='" + _password.length() + '\'' +
                ", _state=" + _state +
                ", _shcart=" + _shcart +
                ", _customer=" + _customer +
                '}';
    }

    private Customer _customer;
    public static HashMap<String, User> UserDict = new HashMap<String, User>();

    public Customer get_customer() {
        return _customer;
    }

    public User(String _login_id, String _password) { //SHOULD ADD USER STATE HERE!
        this._login_id = _login_id;
        this._password = _password;
        UserDict.put(_login_id,this);
        this._state = UserState.New;
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
