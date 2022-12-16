//Depot Class

public class DepotItems {
    // Required Instance Variables For A Depot.
    private int nativeProducts;
    private int externalProducts;
    private int initialAllowance;
    private int productPrice;
    private int deliveryPrice;

    public DepotItems() {
        // Constructor For A Depot, Which will assign Random Values To The Instance Variables
        this.deliveryPrice = (int) (Math.random() *5);
        this.productPrice = (int) (Math.random() *5);
        this.initialAllowance = (int)((Math.random() * (100 - 50) + 50));
        this.nativeProducts = (int)((Math.random() * (40 - 15) + 15));
        this.externalProducts = (int)((Math.random() * (30 - 2) + 2));
    }

    // Checking If Native Products Fulfill The Required Conditions
    public boolean checkNativeProducts()
    {
        if(this.nativeProducts > 15 && this.nativeProducts < 40)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    // Checking If External Products Fulfill The Required Conditions
    public boolean checkExternalProducts()
    {
        if(this.externalProducts > 2 && this.externalProducts < 30)
        {
            return true;
        }

        else
        {
            return false;
        }
    }
    // Checking If The Trade Between 2 Depots Are Possible Or Not
    public boolean checkTrade(DepotItems depot)
    {
        if(this.initialAllowance <= 0 || this.initialAllowance < depot.finalPrice())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    // returns the final price of the product
    public int finalPrice()
    {
        return this.productPrice + this.deliveryPrice;
    }

    public int getNativeProducts() {
        return nativeProducts;
    }

    public void setNativeProducts(int nativeProducts) {
        this.nativeProducts = nativeProducts;
    }

    public int getExternalProducts() {
        return externalProducts;
    }

    public void setExternalProducts(int externalProducts) {
        this.externalProducts = externalProducts;
    }

    public int getInititalAllowance() {
        return initialAllowance;
    }

    public void setInititalAllowance(int inititalAllowance) {
        this.initialAllowance = inititalAllowance;
    }


}
