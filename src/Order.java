import java.io.ObjectInputFilter;
import java.util.Date;

public class Order {

    private String _number;
    private Date _ordered;
    private Date _shipped;
    private Address _ship_to;
    private OrderStatus _status;
    private float _total;

    public Order(String _number, Date _ordered, Date _shipped, Address _ship_to, OrderStatus _status, float _total) {
        this._number = _number;
        this._ordered = _ordered;
        this._shipped = _shipped;
        this._ship_to = _ship_to;
        this._status = _status;
        this._total = _total;
    }

    public String get_number() {
        return _number;
    }

    public Date get_ordered() {
        return _ordered;
    }

    public Date get_shipped() {
        return _shipped;
    }

    public Address get_ship_to() {
        return _ship_to;
    }

    public OrderStatus get_status() {
        return _status;
    }

    public float get_total() {
        return _total;
    }

    public void set_number(String _number) {
        this._number = _number;
    }

    public void set_ordered(Date _ordered) {
        this._ordered = _ordered;
    }

    public void set_shipped(Date _shipped) {
        this._shipped = _shipped;
    }

    public void set_ship_to(Address _ship_to) {
        this._ship_to = _ship_to;
    }

    public void set_status(OrderStatus _status) {
        this._status = _status;
    }

    public void set_total(float _total) {
        this._total = _total;
    }


}
