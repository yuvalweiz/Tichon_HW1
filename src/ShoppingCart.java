import java.util.Date;

public class ShoppingCart
{
    private Date _created;

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
