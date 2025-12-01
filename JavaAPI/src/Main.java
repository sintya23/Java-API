import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static <Transaction> void main(String[] args) {
        List<String> salesData = new ArrayList<String>();
        SalesReader reader = new SalesReader();
        salesData = reader.readFromFile("C:\\Users\\HP\\OneDrive\\Documents\\GitHub\\Java-API\\JavaAPI\\src\\data.txt");

        List<Transaction> transactionData = new ArrayList<>();
        TransactionProcessor transactionProcessor = new TransactionProcessor();
        transactionData = transactionProcessor.parseSalesData(salesData);

        SalesReport report = new SalesReport();
        String reportFileName = "report.txt";
        report.writeReport(reportFileName.transactionData);
    }
}