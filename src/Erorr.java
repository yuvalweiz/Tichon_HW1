public abstract class Erorr extends Exception{

    public Erorr(String s) {
    }

    public class id_is_wrong_EX extends Erorr
    {
        public id_is_wrong_EX() {
            super("The ID you entered is wrong.");
        }
    }
    public class pass_is_wrong_EX extends Erorr
    {

        public pass_is_wrong_EX() {
            super("The ID you entered is wrong.");
        }
    }
    public class there_is_user_connected_EX extends Erorr
    {
        public there_is_user_connected_EX() {
            super("The ID you entered is wrong.");
        }
    }
    public class there_is_no_user_connected_EX extends Erorr
    {
        public there_is_no_user_connected_EX() {
            super("The ID you entered is wrong.");
        }
    }
    public class this_user_is_not_connected_EX extends Erorr
    {
        public this_user_is_not_connected_EX() {
            super("The ID you entered is wrong.");
        }
    }


    }




// id_is_wrong, pass_is_wrong,there_is_user_connected,succses,there_is_no_user_connected,this_user_is_not_connected;
