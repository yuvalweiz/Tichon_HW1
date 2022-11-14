package Error;

public class pass_is_wrong_EX extends Erorr {

    public pass_is_wrong_EX() {
        super("The Password you entered is wrong.");
    }

    @Override
    public String getMessage() {
        return "The Password you entered is wrong.";
    }
}

