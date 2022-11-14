package Error;

public class this_user_is_not_connected_EX extends Erorr {
    public this_user_is_not_connected_EX() {
        super("This user is not connected to the System.");
    }

    @Override
    public String getMessage() {
        return "This user is not connected to the System.";
    }
}
