import Error.*;

import java.util.Date;
import java.util.HashMap;

public class SystemC {
    private User _connectedUser;
    private HashMap<String, Product> PrductDict = new HashMap<String, Product>();

    public SystemC(){
        this._connectedUser = null;
    } //defult constructor
    public boolean AddUser(String _login_id,String _password,int premium,Address address,String phone, String email){
        if(User.UserDict.containsKey(_login_id)){
            return false;
        }
        User newUser= new User(_login_id,_password);
        Customer newCustomer = new Customer(address,phone,email);
        Account newAccount;
        if(premium == 1){
            newAccount = new PremiumAccount(_login_id,newCustomer);
            newCustomer.set_account(newAccount);
        }
        if (premium == 0){
            newAccount = new Account(newCustomer);
            newCustomer.set_account(newAccount);
        }
        newCustomer.set_user(newUser);
        newUser.set_customer(newCustomer);
        Date date = new Date();
        ShoppingCart cart = new ShoppingCart(date);
        return true;

    }
    public boolean RemoveUser(String Login_id) throws Erorr {
        if (User.UserDict.containsKey(Login_id)!= true)
        {
            return false;
        }
        if(_connectedUser!=null && _connectedUser.get_login_id().equals(Login_id)){
            logoutUser(_connectedUser.get_login_id());
        }
        User.UserDict.remove(Login_id);
        return true;
    }

    public boolean loginUser(String _loginid, String password) throws Erorr {
        Erorr error;
        if(this._connectedUser != null){
            error = new there_is_user_connected_EX();
            throw error;
        }

        if(!User.UserDict.containsKey(_loginid)){
            error = new id_is_wrong_EX();
            throw error;

        }
        if(!User.UserDict.get(_loginid).get_password().equals(password)){
            error = new pass_is_wrong_EX();
            throw error;
        }
        this._connectedUser = User.UserDict.get(_loginid);
        return true;
    }
    public boolean logoutUser(String _loginid) throws Erorr {
        Erorr error;
        if(this._connectedUser == null){
            error = new there_is_no_user_connected_EX();
            throw error;
        }
        this._connectedUser = null;
        return true;
    }

    public void Create_new_order(Address address) throws Erorr {

        if(_connectedUser==null)
        {
            Erorr error = new there_is_no_user_connected_EX();
            throw error;
        }
        Date currDate = new Date();
        Order order = new Order(currDate,address,_connectedUser.get_customer().get_account());
        _connectedUser.get_customer().get_account().AddOrder(order);
        _connectedUser.get_customer().get_account().set_lastOrder(order.get_number());
        System.out.println("Your Order number is: " + order.get_number());

    }

    public void Add_product_to_order(String Order_ID,String Login_ID,String Product_Name) throws Erorr {
        Erorr error ;

        if (_connectedUser == null)
        {
            error = new there_is_no_user_connected_EX();
            throw error;
        }
        User sellerUser = User.UserDict.get(Login_ID);
        if (sellerUser == null)
        {

            error=new id_is_wrong_EX();
            throw error;
        }
        Account Seller_account = sellerUser.get_customer().get_account();
        if(!(Seller_account instanceof PremiumAccount))
        {
            error = new not_premium_user();
            throw error;
        }

        Order Buyerorder = _connectedUser.get_customer().get_account().getOrder(Order_ID);
        if (Buyerorder == null)
        {
            error = new order_is_not_exist();
            throw error;
        }
        Product SellerProduct = ((PremiumAccount) Seller_account).GetProduct(Product_Name);
        if (SellerProduct==null)
        {
            error = new product_is_not_exist();
            throw error;
        }
        for (int i=0;i<SellerProduct.getLineItemsVec().size();i++)
        {
            if (SellerProduct.getLineItemsVec().get(i).getQuantity()==0)
            {
                SellerProduct.getLineItemsVec().remove(i);
            }

        }
        SellerProduct.getLineItemsVec().get(0).setQuantity(SellerProduct.getLineItemsVec().get(0).getQuantity()-1);
        int price=SellerProduct.getLineItemsVec().get(0).getPrice();
        Buyerorder.AddProduct(SellerProduct,price);



    }
    public void DisplayOrder() throws Erorr {
        Erorr erorr;
        if(_connectedUser == null){
            erorr = new there_is_no_user_connected_EX();
            throw erorr;
        }
        Order myOrder = _connectedUser.get_customer().get_account().getOrder(_connectedUser.get_customer().get_account().get_lastOrder());
        if(myOrder == null){
            erorr = new order_is_not_exist();
            throw erorr;
        }
        int price;
        int quan;
        float sum = 0;
        for(int i=0;i<myOrder.getLineItemsVec().size();i++){
            quan = myOrder.getLineItemsVec().get(i).getQuantity();
            price = myOrder.getLineItemsVec().get(i).getPrice();
            sum = sum + (quan * price);
        }
        myOrder.set_total(sum);

        System.out.println("Order Number: " + myOrder.get_number());
        System.out.println("Order Date: " + myOrder.get_ordered());
        System.out.println("Shipment Date: " + myOrder.get_shipped());
        System.out.println("Shipment Address: " + myOrder.get_ship_to());
        System.out.println("Order status: " + myOrder.get_status());
        System.out.println("Total payment: " + myOrder.get_total());

    }

    public void LinkProduct (String name,int price,int Quan) throws Erorr {
        Erorr error;
        if (_connectedUser == null)
        {
            error = new there_is_no_user_connected_EX();
            throw error;
        }
        Account account = _connectedUser.get_customer().get_account();
        if(!(account instanceof PremiumAccount))
        {
            error = new not_premium_user();
            throw error;
        }
        Product product = PrductDict.get(name);
        if(product == null){
            error = new product_is_not_exist();
        }
        LineItem lineItem = new LineItem(Quan,price);
        product.getLineItemsVec().add(lineItem);
        ((PremiumAccount) account).AddProduct(product);

    }


    public void AddProduct(String name,String supllierName){
        Supplier supnik = new Supplier(supllierName);
        Product prod = new Product(name,supnik);
        supnik.Add_Product(prod);
        PrductDict.put(prod.get_id(),prod);
    }


}
