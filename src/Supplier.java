public class Supplier
{
    String _id;
    String _name;
    Product[] productsArr;

    public Supplier(String _id, String _name) {
        this._id = _id;
        this._name = _name;
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
