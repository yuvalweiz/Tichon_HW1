import java.io.ObjectInputFilter;
import java.util.Date;

public class Order {

    private String _number;
    private Date _ordered;
    private Date _shipped;
    private Address _ship_to;
    private ObjectInputFilter.Status _orderStatus;
    private float _total;

    public Order(String _number, Date _ordered, Date _shipped, Address _ship_to, ObjectInputFilter.Status _orderStatus, float _total) {
        this._number = _number;
        this._ordered = _ordered;
        this._shipped = _shipped;
        this._ship_to = _ship_to;
        this._orderStatus = _orderStatus;
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

    public ObjectInputFilter.Status get_orderStatus() {
        return _orderStatus;
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

    public void set_orderStatus(ObjectInputFilter.Status _orderStatus) {
        this._orderStatus = _orderStatus;
    }

    public void set_total(float _total) {
        this._total = _total;
    }


}
