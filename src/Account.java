import java.util.Date;
import java.util.HashMap;

public class Account {
    private static int Curr_Id=0;
    private  String _id;
    private String _billing_address;
    private boolean _is_closed;
    private Date _open;
    private Date _closed;
    private int _balance;
    private String _lastOrder;
    private HashMap<String, Order> OrderDict = new HashMap<String, Order>();
    private Customer _customer; // wont be able to create account without customer!



    public Account(Customer _customer) {
        this._id = String.valueOf(Curr_Id);
        Curr_Id++;
        this._is_closed = false;
        this._open = new Date();
        this._balance = 0;
        this._customer = _customer;
    }

    public void AddOrder (Order order){
        this.OrderDict.put(order.get_number(),order);
    }

    public void set_lastOrder(String _lastOrder) {
        this._lastOrder = _lastOrder;
    }

    public String get_lastOrder() {
        return _lastOrder;
    }

    public Order getOrder (String number){
        if(!OrderDict.containsKey(number)){
            return null;
        }
        return OrderDict.get(number);
    }

    public void set_customer(Customer _customer) {
        this._customer = _customer;
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
