import java.util.Date;

public class ShoppingCart
{
    private Date _created;
    private User _user;
    private LineItem[] lineItemsArr;

    public LineItem[] getLineItemsArr() {
        return lineItemsArr;
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

    public Date getCreated() {
        return _created;
    }

    public ShoppingCart(Date created) {
        this._created = created;
    }
}
