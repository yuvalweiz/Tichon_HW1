package Error;

public class product_is_not_exist extends Erorr {

    public product_is_not_exist() {
        super("The product is not exists.");
    }

    @Override
    public String getMessage() {
        return "The product is not exists.";
    }
}
