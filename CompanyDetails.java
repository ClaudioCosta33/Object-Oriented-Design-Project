
//Our Company Class which Implements Container That Is used To Implement Iterator Design Pattern
//It Also Implements Connector That Is Used To Implement Strategy Design Pattern
public class CompanyDetails implements Container, Connector {

    //Instance Variables;
    private String name;
    private DepotItems[] depots;

    //Static Variables Containing Transaction Details
    private static String transactions = "";
    private static String aTransactions = "";
    private static String bTransactions = "";
    private static String cTransactions = "";

    //Constructor
    public CompanyDetails(String name) {
        this.name = name;
        this.depots = new DepotItems[40];
        for (int i = 0; i < 40; i++) {
            this.depots[i] = new DepotItems();
        }
    }

    //Overriding Container function which will return the Iterator
    @Override
    public Iterator getIterator() {
        return new DepotIterator();
    }

    //Function Used To Display Each Depots Information
    public void DisplayStockInformation() {
        for (int j = 0; j < 40; j++) {
            System.out.println("\n\n");
            System.out.println("Depot #" + (j + 1) + " : ");
            System.out.println("Own Product Stocks = " + this.depots[j].getNativeProducts());
            System.out.println("Foreign Product Stocks = " + this.depots[j].getExternalProducts());
            System.out.println("Cash Balance = " + this.depots[j].getInititalAllowance());
        }
    }

    @Override
    public DepotItems[] getDepots() {
        return this.depots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    //here is the most important part of the program, it will trade between the depots, takes a company as parameter so they can trade
    @Override
    public void depotTrade(Connector company) {

        String transaction1 = "Company " + this.name + " Transaction Details With Company " + company.getName() + " : \n";
        this.transactions += transaction1;
        switch (this.name) {
            case "Big-Alpha":
                aTransactions += transaction1;
                break;
            case "Big-Beta":
                bTransactions += transaction1;
                break;
            default:
                cTransactions += transaction1;
                break;
        }
        int tempExt = 0;
        int tempNat = 0;
        int i = 0;
        for (Iterator iterator = getIterator(); iterator.hasNext() && i < 40; i++) { //Creating Iterator Instance
            String transactionData1 = "Depot #" + (i + 1);
            this.transactions += transactionData1;
            switch (this.name) {
                case "Big-Alpha":
                    aTransactions += transactionData1;
                    break;
                case "Big-Beta":
                    bTransactions += transactionData1;
                    break;
                default:
                    cTransactions += transactionData1;
                    break;
            }
            for (int j = 0; j < 40; j++) {
                String transaction2 = "\n\n\nPurchasing External Products : \n\n"
                        + "Before Transaction \n\nDetails Of Company " + this.name + " : \n"
                        + "Native Products = " + this.depots[i].getNativeProducts()
                        + ", External Products = " + this.depots[i].getExternalProducts()
                        + ", Allowance = " + this.depots[i].getInititalAllowance()
                        + "\n\nDetails Of Company " + company.getName() + " : \n"
                        + "Native Products = " + company.getDepots()[j].getNativeProducts()
                        + ", External Products = " + company.getDepots()[j].getExternalProducts()
                        + ", Allowance = " + company.getDepots()[j].getInititalAllowance()
                        + "\n.................................................................";
                this.transactions += transaction2;
                switch (this.name) {
                    case "Big-Alpha":
                        aTransactions += transaction2;
                        break;
                    case "Big-Beta":
                        bTransactions += transaction2;
                        break;
                    default:
                        cTransactions += transaction2;
                        break;
                }
                // 
                while (this.depots[i].checkExternalProducts() && this.depots[i].checkTrade(company.getDepots()[j]) && company.getDepots()[j].checkNativeProducts()) {
                    tempExt = this.depots[i].getExternalProducts() + 1;
                    
                    this.depots[i].setExternalProducts(tempExt);
                    
                    int price = this.depots[i].getInititalAllowance() - company.getDepots()[j].finalPrice();
                    this.depots[i].setInititalAllowance(price);
                    
                    tempNat = company.getDepots()[j].getNativeProducts() - 1;
                    company.getDepots()[j].setNativeProducts(tempNat);
                    
                    int price2 = company.getDepots()[j].getInititalAllowance() + company.getDepots()[j].finalPrice();
                    company.getDepots()[j].setInititalAllowance(price2);

                }
                
                String transaction3 = "\n\nAfter Transaction \n\nDetails Of Company " + this.name + " : \n\n"
                        + "" + "Native Products = " + this.depots[i].getNativeProducts()
                        + "" + ", External Products = " + this.depots[i].getExternalProducts()
                        + "" + ", Allowance = " + this.depots[i].getInititalAllowance()
                        + "\n\nDetails Of Company " + company.getName() + " : \n"
                        + "Native Products = " + company.getDepots()[j].getNativeProducts()
                        + ", External Products = " + company.getDepots()[j].getExternalProducts()
                        + ", Allowance = " + company.getDepots()[j].getInititalAllowance()
                        + "\n................................................................."
                        + "\n................................................................."
                        + "\n\n";
                this.transactions += transaction3;
                if (this.name.equals("Big-Alpha")) {
                    aTransactions += transaction3;
                } else if (this.name.equals("Big-Beta")) {
                    bTransactions += transaction3;
                } else {
                    cTransactions += transaction3;
                }

            }
        }

    }

    private class DepotIterator implements Iterator { // Private internal class implementing Iterator, which will help

        int index;                                    // To implement  Iterator Logic.

        @Override
        public boolean hasNext() { // Will Check If Depot has next object or not
            if (index < depots.length) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Object next() { // If Depot has another object it will return next Object
            if (this.hasNext()) {
                return depots[index++];
            } else {
                return null;
            }
        }
    }

    public static String getTransactions() {
        return transactions;
    }

    public static String getaTransactions() {
        return aTransactions;
    }

    public static String getbTransactions() {
        return bTransactions;
    }

    public static String getcTransactions() {
        return cTransactions;
    }
}
