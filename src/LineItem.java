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
       if(_product!=null) {
           return "LineItem-" +
                   "Quantity = " + _quantity + "\n" +
                   "Price = " + _price + "\n" +
                   "Shopping Cart = " + shcart + "\n" +
                   "Product's ID = " + _product.get_id() + "\n"

                   ;
       }
        return "LineItem-" +
                "Quantity = " + _quantity + "\n" +
                "Price = " + _price + "\n" +
                "Shopping Cart = " + shcart + "\n" +
                  "\n";
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
