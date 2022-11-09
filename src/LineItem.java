public class LineItem {
    private int _quantity;
    private int _price;
    public void setQuantity(int quantity) {
        this._quantity = quantity;
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
