import java.util.Date;

public class DelayedPayment extends Payment{
    private Date paymentDate;

    public DelayedPayment(String ID, Date PAID, Float TOTAL, String DETAILS, Date PAYMENTDATE) {
        super( PAID, TOTAL, DETAILS);
        this.paymentDate = PAYMENTDATE;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
