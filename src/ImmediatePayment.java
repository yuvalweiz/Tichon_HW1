import java.util.Date;

public class ImmediatePayment extends Payment {
    private Boolean phoneConfirmation;

    public ImmediatePayment( Date PAID, Float TOTAL, String DETAILS, Boolean PHONECONFIRMATION) {
        super( PAID, TOTAL, DETAILS);
        this.phoneConfirmation = PHONECONFIRMATION;
    }

    @Override
    public String toString() {
        return "ImmediatePayment{" +
                "phoneConfirmation=" + phoneConfirmation +
                '}';
    }

    public Boolean getPhoneConfirmation() {
        return phoneConfirmation;
    }

    public void setPhoneConfirmation(Boolean phoneConfirmation) {
        this.phoneConfirmation = phoneConfirmation;
    }
}
