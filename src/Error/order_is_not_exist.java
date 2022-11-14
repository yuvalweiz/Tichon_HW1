package Error;

public class order_is_not_exist extends Erorr {
    public order_is_not_exist() {
        super("The order is not exist.");
    }

    @Override
    public String getMessage() {
        return "The order is not exist.";
    }
}
