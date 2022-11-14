package Error;

public class id_is_wrong_EX extends Erorr {
    public id_is_wrong_EX() {

        super("The ID you entered is wrong.");

    }

    @Override
    public String getMessage() {
        return "The ID you entered is wrong.";
    }
}
