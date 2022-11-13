import java.util.Date;

public class PremiumAccount extends Account {

    public PremiumAccount(String _id, String _billing_address, boolean _is_closed, Date _open, Date _closed, int _balance,Customer customer) {
        super(_id, _billing_address, _is_closed, _open, _closed, _balance,customer);
    }
}
