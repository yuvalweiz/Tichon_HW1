import java.util.Date;

public class Payment {
    private static int Curr_id=0;
    private String id;
    private Date paid;
    private Float total;
    private String details;

    public Payment(Date PAID, Float TOTAL, String DETAILS){
        this.id = "T-"+String.valueOf(Curr_id);//T- yani TASHLUM
        Curr_id++;
        this.paid = PAID;
        this.total = TOTAL;
        this.details = DETAILS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "ID = '" + id + '\'' +
                ", Paid = " + paid +
                ", Total = " + total +
                ", Details = '" + details + '\'' +
                '}';
    }

    public void setPaid(Date paid) {
        this.paid = paid;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
