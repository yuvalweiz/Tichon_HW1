public class Customer {

    private String _id;
    private Address _address;
    private String _phone;
    private String _email;

    public Customer() {
    }

    public Customer(String _id, Address _address, String _phone, String _email) {
        this._id = _id;
        this._address = _address;
        this._phone = _phone;
        this._email = _email;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Address get_address() {
        return _address;
    }

    public void set_address(Address _address) {
        this._address = _address;
    }

    public String get_phone() {
        return _phone;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }


}
