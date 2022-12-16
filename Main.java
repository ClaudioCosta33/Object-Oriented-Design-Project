import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	System.out.println("Please wait while system is making calculations........");
        Connector company[] = new CompanyDetails[3]; //Dynamic array of Companies
        company[0] = new CompanyDetails("Big-Alpha");
        company[1] = new CompanyDetails("Big-Beta");
        company[2] = new CompanyDetails("Big-Cappa");   
        
        depotTrade(company);

        //Our Menu Driver Function Which will display
        //Options as asked after simulation is done.
        WriteFileData writer = WriteFileData.getInstance(); //Singleton Design Pattern Is Used Here
        
        // write data in the files
        writer.writeAllData(CompanyDetails.getTransactions());
        writer.dataAlpha(CompanyDetails.getaTransactions());
        writer.dataBeta(CompanyDetails.getbTransactions());
        writer.dataCappa(CompanyDetails.getcTransactions());
        menuDriverFunction(company);

    }
    
    public static void depotTrade(Connector company[]) {
        //Starts the simulation between all companies
        company[0].depotTrade(company[1]);
        company[0].depotTrade(company[2]);
        company[1].depotTrade(company[0]);
        company[1].depotTrade(company[2]);
        company[2].depotTrade(company[0]);
        company[2].depotTrade(company[1]);
    }
    
    public static void menuDriverFunction(Connector company[]) { 
        System.out.println("Welcome To Trading Simulator.......");
        displayInstructions(); //Will Display Instructions
        Scanner scanner = new Scanner(System.in); //Scanner Object for taking input from the user.
        char choice;
        boolean command = true;
        do {
            choice = scanner.next().charAt(0);
            switch (choice) {
                case '0': {
                    System.out.println("\n");
                    displayInstructions();
                    break;
                }
                case '1': {

                    System.out.println(CompanyDetails.getTransactions());
                    displayInstructions();
                    break;
                }
                case '2': {
                    System.out.println("Companies : ");
                    System.out.println("A For Alpha");
                    System.out.println("B For Beta");
                    System.out.println("C For Cappa");
                    char companyy = scanner.next().charAt(0);
                    if (companyy == 'A' || companyy == 'a') {
                        System.out.println(CompanyDetails.getaTransactions());
                    } else if (companyy == 'B' || companyy == 'b') {
                        System.out.println(CompanyDetails.getbTransactions());
                    } else if (companyy == 'C' || companyy == 'c') {
                        System.out.println(CompanyDetails.getcTransactions());
                    } else {
                        System.out.println("Invalid Input");
                    }
                    displayInstructions();
                    break;
                }
                case '3': {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Depots Information Of Company " + company[i].getName() + " : ");
                        company[i].DisplayStockInformation();
                        System.out.println("\n\n");
                    }
                    displayInstructions();
                    break;
                }

                case '4': {
                    command =false;
                    break;
                }

                default: {
                    System.out.println("Invalid Input.");
                    System.out.println("Please Enter Again.");
                    displayInstructions();
                    break;
                }
            }
        } while (command);
    }

    public static void displayInstructions() { //Function Containing Instructions
        System.out.println("Select one : ");
        System.out.println("0 - Show instructions.");
        System.out.println("1 - All transactions.");
        System.out.println("2 - All transactions for determined company.");

    }


}
