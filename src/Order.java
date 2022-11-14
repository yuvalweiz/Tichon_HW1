import java.io.ObjectInputFilter;
import java.util.Date;
import java.util.Vector;

public class Order {
    private static int Curr_Id=0;
    private String _number;
    private Date _ordered;
    private Date _shipped;
    private Address _ship_to;
    private OrderStatus _status;
    private float _total;
    private Account _account;
    private Vector<LineItem> LineItemsVec;

    public Order(Date _ordered, Address _ship_to, Account _account) {
        this._number = "#" + String.valueOf(Curr_Id) ;
        Curr_Id++;
        this._ordered = _ordered;
        this._ship_to = _ship_to;
        this._status = OrderStatus.New;
        this._total = 0;
        this._account = _account;
    }

    public Product getProductFromLineItem(String product_name){
        for(int i=0;i<LineItemsVec.size();i++){
            if(LineItemsVec.get(i).get_product().get_name().equals(product_name)){
                return LineItemsVec.get(i).get_product();
            }
        }
        return null;
    }

    public void AddProductQuantity(Product product){
        for(int i=0;i<LineItemsVec.size();i++){
            if(LineItemsVec.get(i).get_product().get_name().equals(product.get_name())){
                LineItemsVec.get(i).setQuantity(LineItemsVec.get(i).getQuantity()+1);
            }
        }
    }

    public void AddProduct(Product product,int price){
        LineItem newLineItem = new LineItem(1,price);
        newLineItem.set_product(product);
        this.LineItemsVec.add(newLineItem);
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
