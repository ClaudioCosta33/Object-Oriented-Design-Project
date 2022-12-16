import java.io.BufferedWriter; // Imports the Buffered Writer class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class

// Class Which Is Used To For Writing

public class WriteFileData {

    private static WriteFileData writer = new WriteFileData();


    private WriteFileData(){

    }

     
    // Here we are using the Singleton Pattern to create only one object fo the writer class, that will be inplemented in different functions.

    public static WriteFileData getInstance()
    {
        return writer;
    }


    public void writeAllData(String data){
        try {
            //Making Object for a Buffered Writer class
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("AllData.txt"));
            bufferedWriter.write(data); //Writing the data to the file
            bufferedWriter.newLine(); // For new line
            bufferedWriter.close(); // closes the Buffered Writer
        } catch (IOException e) {
            e.printStackTrace(); // Throws Exception if file is corrupt or for any other reason failed to write data
        }
    }

 
    public void dataAlpha(String data)
    {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Alpha.txt"));
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dataBeta(String data)
    {
        try {
            //Making Object for a Buffered Writer class
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Beta.txt"));
            bufferedWriter.write(data); //Writing the data to the file
            bufferedWriter.newLine(); // For new line
            bufferedWriter.close(); // closes the Buffered Writer
        } catch (IOException e) {
            e.printStackTrace(); // Throws Exception if file is corrupt or for any other reason failed to write data
        }
    }

    public void dataCappa(String data)
    {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Cappa.txt"));
            bufferedWriter.write(data);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
