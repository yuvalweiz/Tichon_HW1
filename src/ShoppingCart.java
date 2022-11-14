import java.util.Date;
import java.util.Vector;

public class ShoppingCart
{
    private Date _created;
    private User _user;
    private Vector<LineItem> lineItemsVector;
    //private LineItem[] lineItemsArr;

    public Vector<LineItem>  getLineItemsVector() {
        return lineItemsVector;
    }

    //Add lineItem method!

    public User get_user() {
        return _user;
    }

    public void set_user(User _user) {
        this._user = _user;
    }

    public void setCreated(Date created) {
        this._created = created;

    }

    public void AddLineItem(LineItem lineItem)
    {
        this.lineItemsVector.add(lineItem);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "Created = " + _created +
                ", User = " + _user +
                ", lineItems = " + lineItemsVector +
                '}';
    }

    public Date getCreated() {
        return _created;
    }

    public ShoppingCart(Date created) {
        this._created = created;
        this.lineItemsVector = new Vector<LineItem>();
    }
}
