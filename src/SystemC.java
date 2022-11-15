import Error.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

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
            newAccount.set_customer(newCustomer);
        }
        if (premium == 0){
            newAccount = new Account(newCustomer);
            newCustomer.set_account(newAccount);
            newAccount.set_customer(newCustomer);
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
        //SellerProduct.Add_Line_Item(new LineItem(77,77));
        //for (int i=0;i<SellerProduct.getLineItemsVec().size();i++) // I dont think we need this

          //  if (SellerProduct.getLineItemsVec().get(i).getQuantity()==0)
            //{
              //  SellerProduct.getLineItemsVec().remove(i);
            //}

        //}
        //SellerProduct.getLineItemsVec().get(0).setQuantity(SellerProduct.getLineItemsVec().get(0).getQuantity()-1);//

       // int price=SellerProduct.getLineItemsVec().get(0).getPrice();
        Buyerorder.AddProduct(SellerProduct,50);



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
        if(myOrder.getLineItemsVec() != null){
        for(int i=0;i<myOrder.getLineItemsVec().size();i++){
            quan = myOrder.getLineItemsVec().get(i).getQuantity();
            price = myOrder.getLineItemsVec().get(i).getPrice();
            sum = sum + (quan * price);
        }}
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
        PrductDict.put(prod.get_name(),prod);
    }

    public void Delete_Product (String Product_name) throws Erorr {
        Erorr e;
        if(PrductDict.containsKey(Product_name)==false)
        {
            e=new product_is_not_exist();
            throw e;
        }
        PrductDict.remove(Product_name);
    }

    public void ShowAllObjects()
    {
        Vector<LineItem> lineitemss = new Vector<LineItem>();
        Account account;
        User user;
        Order order;
        ShoppingCart shoppingCart;
        Payment payment;
       for(var entry : User.UserDict.entrySet())
       {
           user = entry.getValue();
           if (user!=null)
           {
               System.out.println(user.toString());
               System.out.println(user.toString());
           }

           account = entry.getValue().get_customer().get_account();
           System.out.println( account.toString());
           if (account.getPayments().size()!=0) {

               for (int i = 0; i < account.getPayments().size(); i++)
               {

                   System.out.println(account.getPayments().get(i));
               }
           }

           HashMap<String,Order> Orders=entry.getValue().get_customer().get_account().getOrderDict();
           for(var orderentry : Orders.entrySet()) {
               System.out.println(orderentry.getValue().toString());
               if(orderentry.getValue().getPayments().size()!=0) {
                   for (int j = 0; j < orderentry.getValue().getPayments().size(); j++) {
                       payment = orderentry.getValue().getPayments().get(j);
                       System.out.println(payment.toString());
                   }
               }

           }

   // public void ShowObjectID(String ID){

 //  }
            shoppingCart = entry.getValue().get_shcart();
           if (shoppingCart!=null)
           {
               System.out.println(shoppingCart.toString());
           }



       }
        for(var entry : Supplier.SupllierDict.entrySet())
        {
            System.out.println(entry.getValue().toString());
        }
        for(var entry : PrductDict.entrySet())
        {
            System.out.println(entry.getValue().toString());
             lineitemss= entry.getValue().getLineItemsVec();
            for (int i=0;i<lineitemss.size();i++)
            {
                System.out.println(lineitemss.get(i).toString());
            }

        }
    }
    public boolean ShowObjectID(String ID) throws Erorr { //T-Payment|P-Product|A-Account|C-Customer|O-Order|S-Supllier
        Erorr error;
        Character firstChar = ID.charAt(0);
        if(firstChar.equals("T")){
            for(var entry : User.UserDict.entrySet()){
                Vector<Payment> payments =entry.getValue().get_customer().get_account().getPayments();
                for(int i =0;i<payments.size();i++){
                    if(payments.get(i).getId().equals(ID)){
                        System.out.println(payments.get(i).toString());
                        return true;
                    }
                }
            }
            error = new id_is_wrong_EX();
            throw error;

        }
        if(firstChar.equals("P")){
            if(!PrductDict.containsKey(ID)){
                error = new product_is_not_exist();
                throw error;
            }
            System.out.println(PrductDict.get(ID));
            return true;
        }
        if(firstChar.equals("A")){
            for(var entry : User.UserDict.entrySet()){
                if(entry.getValue().get_customer().get_account().get_id().equals(ID)){
                    System.out.println(entry.getValue().get_customer().get_account());
                    return true;
                }
            }
            error = new id_is_wrong_EX();
            throw error;
        }
        if(firstChar.equals("C")){
            for(var entry : User.UserDict.entrySet()){
                if(entry.getValue().get_customer().get_id().equals(ID)){
                    System.out.println(entry.getValue().get_customer());
                    return true;
                }
            }
            error = new id_is_wrong_EX();
            throw error;
        }
        if(firstChar.equals("O")){
            for(var entry : User.UserDict.entrySet()){
                for(var entry2 : entry.getValue().get_customer().get_account().getOrderDict().entrySet()){
                    if(entry2.getValue().get_number().equals(ID)){
                        System.out.println(entry2.getValue());
                        return true;
                    }
                }
            }
            error = new order_is_not_exist();
            throw error;

        }
        if(firstChar.equals("S")){
            if(!Supplier.SupllierDict.containsKey(ID)){
                error = new id_is_wrong_EX();
                throw error;
            }
            System.out.println(Supplier.SupllierDict.get(ID));
            return true;

        }
        error = new id_is_wrong_EX();
        throw error;

    }

    public boolean ShowObjectUSER (String ID) throws Erorr {
        Erorr error;
        if(!User.UserDict.containsKey(ID)){
            error = new id_is_wrong_EX();
            throw error;
        }
        System.out.println(User.UserDict.get(ID));
        return true;
    }

    public boolean ShowObjectSupplier(String ID) throws Erorr {
        Erorr error;
        if(!Supplier.SupllierDict.containsKey(ID)){
            error = new id_is_wrong_EX();
            throw error;
        }
        System.out.println(Supplier.SupllierDict.get(ID));
        return true;
    }

    public boolean ShowObjectProduct(String ID) throws Erorr {
        Erorr error;
        if(!PrductDict.containsKey(ID)){
            error = new product_is_not_exist();
            throw error;
        }
        System.out.println(PrductDict.get(ID));
        return true;
    }

    public ImmediatePayment AddImmediatePayment(String orderid,String details,Boolean Phoneconfirmation) throws Erorr {
        float sum =0;
        Erorr e;
        Order order = Account.OrderDict.get(orderid);
        if(order==null)
        {
            e= new order_is_not_exist();
            throw e;
        }
        if (order.getLineItemsVec().size()==0)
        {
            sum =0;
        }
        else
        {
            for (int i=0;i<order.getLineItemsVec().size();i++)
            {
                sum +=order.getLineItemsVec().get(i).getQuantity()*order.getLineItemsVec().get(i).getPrice();
            }
        }

        Date date = new Date();

        return new ImmediatePayment(date,sum,details,Phoneconfirmation);
    }

    public DelayedPayment AddDelayedPayment(String orderid,String details,Date PaymentDate) throws Erorr {
        float sum =0;
        Erorr e;
        Order order = Account.OrderDict.get(orderid);
        if(order==null)
        {
            e= new order_is_not_exist();
            throw e;
        }
        if (order.getLineItemsVec().size()==0)
        {
            sum =0;
        }
        else
        {
            for (int i=0;i<order.getLineItemsVec().size();i++)
            {
                sum +=order.getLineItemsVec().get(i).getQuantity()*order.getLineItemsVec().get(i).getPrice();
            }
        }
        Date date = new Date();
        return new DelayedPayment(date,sum,details,PaymentDate);
    }
}
