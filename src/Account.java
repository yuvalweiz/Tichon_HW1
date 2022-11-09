import java.util.Date;

public class Account {
    private String _id;
    private String _billing_address;
    private boolean _is_closed;
    private Date _open;
    private Date _closed;
    private int _balance;

    public Account(String _id, String _billing_address, boolean _is_closed, Date _open, Date _closed, int _balance) {
        this._id = _id;
        this._billing_address = _billing_address;
        this._is_closed = _is_closed;
        this._open = _open;
        this._closed = _closed;
        this._balance = _balance;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_billing_address() {
        return _billing_address;
    }

    public void set_billing_address(String _billing_address) {
        this._billing_address = _billing_address;
    }

    public boolean is_is_closed() {
        return _is_closed;
    }

    public void set_is_closed(boolean _is_closed) {
        this._is_closed = _is_closed;
    }

    public Date get_open() {
        return _open;
    }

    public void set_open(Date _open) {
        this._open = _open;
    }

    public Date get_closed() {
        return _closed;
    }

    public void set_closed(Date _closed) {
        this._closed = _closed;
    }

    public int get_balance() {
        return _balance;
    }

    public void set_balance(int _balance) {
        this._balance = _balance;
    }



}
