import java.util.Date;
import java.util.Vector;

public class PremiumAccount extends Account {
    Vector<Product> Products;

    public PremiumAccount(String _id, Customer _customer) {
        super( _customer);
        Products = new Vector<Product>();
    }

    @Override
    public String toString() {
        return "PremiumAccount{" +
                "Products = " + Products +
                '}';
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
}
