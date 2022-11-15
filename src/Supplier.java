import java.util.HashMap;
import java.util.Vector;

public class Supplier
{
    private static int Curr_Id=0;
    String _id;
    String _name;
    public static HashMap<String, Supplier> SupllierDict = new HashMap<String, Supplier>();
    Vector<Product> productsVec;

    @Override
    public String toString() {
        return "Supplier{" +
                "ID = '" + _id + '\'' +
                ", Name = '" + _name + '\'' +
                ", Products = " + productsVec +
                '}';
    }

    public Supplier(String _name) {
        this._id ="S-"+ String.valueOf(Curr_Id);
        Curr_Id++;
        this._name = _name;
        this.productsVec = new Vector<>();
        SupllierDict.put(this._id,this);


    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public void Add_Product(Product p )
    {
        productsVec.add(p);
    }
    public void Delete_Product(String Product_Id)
    {
        for(int i=0;i<productsVec.size();i++)
        {
            if (productsVec.get(i).get_id().equals(Product_Id))
            {
                productsVec.remove(i);
                return;
            }
        }
    }
}
