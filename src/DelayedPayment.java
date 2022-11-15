import java.util.Date;

public class DelayedPayment extends Payment{
    private Date paymentDate;

    @Override
    public String toString() {
        return "DelayedPayment: " +
                "paymentDate=" + paymentDate
                ;
    }

    public DelayedPayment(Date PAID, Float TOTAL, String DETAILS, Date PAYMENTDATE) {
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
