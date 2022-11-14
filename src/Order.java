import java.io.ObjectInputFilter;
import java.util.Date;

public class Order {
    private static int Curr_Id=0;
    private String _number;
    private Date _ordered;
    private Date _shipped;
    private Address _ship_to;
    private OrderStatus _status;
    private float _total;
    private Account _account;
    private LineItem[] lineItemsArr;

    public Order(Date _ordered, Address _ship_to, Account _account) {
        this._number = "#" + String.valueOf(Curr_Id) ;
        Curr_Id++;
        this._ordered = _ordered;
        this._ship_to = _ship_to;
        this._status = OrderStatus.New;
        this._total = 0;
        this._account = _account;
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
