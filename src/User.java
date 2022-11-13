public class User {
    private String _login_id;
    private String _password;
    private UserState _state;
    private ShoppingCart _shcart;

    public User(String _login_id, String _password) { //SHOULD ADD USER STATE HERE!
        this._login_id = _login_id;
        this._password = _password;
        this._state = _state;
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
