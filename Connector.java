// Interface For Implementing Strategy Design Pattern
public interface Connector {
    void depotTrade(Connector company);
     String getName();
     DepotItems[] getDepots();

    void DisplayStockInformation();
}
