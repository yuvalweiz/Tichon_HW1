package Error;

public class not_premium_user extends Erorr {
    public not_premium_user() {
        super("The user is not premium!");
    }
    @Override
    public String getMessage() {
        return "The user is not premium!";
    }
}
