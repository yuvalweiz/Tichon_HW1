import javax.sound.sampled.Line;
import java.util.Dictionary;
import java.util.Vector;

public class Product {
    private String _id;
    private static int Curr_id=0;
    private String _name;
    private Vector<LineItem> lineItemsVec;

    public Supplier get_supplier() {
        return _supplier;
    }

    @Override
    public String toString() {
        return
                "Product's ID = '" + _id + "\n" +
                "Product's Name = '" + _name + "\n" +
                "LineItems = " + lineItemsVec +"\n"+
                "Product's Supplier ID = " + _supplier._id + "\n"
                ;
    }

    private Supplier _supplier;



    public Product(String _name, Supplier _supplier) {


        //this._id="P-"+String.valueOf(Curr_id);
        //Curr_id++;
        this._id = _name;
        this._name = _name;
        this._supplier = _supplier;
        this.lineItemsVec = new Vector<LineItem>();
    }


    public void set_id(String _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public Vector<LineItem> getLineItemsVec() {
        return lineItemsVec;
    }

    public String get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public void Add_Line_Item (LineItem lineitem)
    {
        this.lineItemsVec.add(lineitem);
    }



}
