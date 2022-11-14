package Error;

public class there_is_user_connected_EX extends Erorr {
    public there_is_user_connected_EX() {
        super("There is already a user connected to the system.");
    }

    @Override
    public String getMessage() {
        return "There is already a user connected to the system.";
    }
}
