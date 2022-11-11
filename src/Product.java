import javax.sound.sampled.Line;

public class Product {
    private String _id;
    private String _name;
    private LineItem[] lineItemsArr;
    private Supplier _supplier;

    public Product(String _id, String _name, Supplier _supplier) {
        this._id = _id;
        this._name = _name;
        this._supplier = _supplier;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }


}
