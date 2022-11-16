import java.util.Date;
import java.util.Vector;

public class PremiumAccount extends Account {
    Vector<Product> Products;

    public PremiumAccount(String _id, Customer _customer) {
        super( _customer);
        Products = new Vector<Product>();

    }

    public Vector<Product> getProducts() {
        return Products;
    }

    public void setProducts(Vector<Product> products) {
        Products = products;
    }

    @Override
    public String toString() {

        return "This Account is a Premium account" + "\n"+
                "Account's ID = " + this.get_id()+"\n"+
                "Account's open date = " + this.get_open()+"\n"+
                "Account's balance = " + this.get_balance()+"\n"+
                "Account's customer ID = " + this.get_customer()+"\n"+
                "Orders = " + this.getMyOrders()+"\n"+
                "Payments = " + this.getPayments()+"\n"+
                "Account's Products = " + Products+"\n"
                ;
    }

    public Product GetProduct(String Productname)
    {
        for (int i=0;i<Products.size();i++)
        {
            if(Products.get(i).get_name().equals(Productname))
            {
                return Products.get(i);
            }
        }
        return null;
    }

    public void AddProduct(Product prod){
        Products.add(prod);
    }

    public void AddProductByName(String name){
        AddProduct(SystemC.PrductDict.get(name));

    }
}
