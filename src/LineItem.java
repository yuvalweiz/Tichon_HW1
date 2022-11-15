public class LineItem {
    private int _quantity;
    private int _price;
    private ShoppingCart shcart;
    private Product _product;

    public void setQuantity(int quantity) {
        this._quantity = quantity;
    }

    public void set_product(Product _product) {
        this._product = _product;
    }

    public Product get_product() {
        return _product;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "Quantity = " + _quantity +
                ", Price = " + _price +
                ", Shopping Cart = " + shcart +
                ", Product = " + _product.get_id() +
                '}';
    }

    public LineItem(int quantity, int price) {
        this._quantity = quantity;
        this._price = price;
    }

    public void setPrice(int price) {
        this._price = price;
    }


    public int getQuantity() {
        return _quantity;
    }

    public int getPrice() {
        return _price;
    }


}
