import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SalesReader {
    public static List<Transaction> readFromFile(String fileName) {
        List<Transaction> transactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.trim().startsWith("#")) continue;
                .add(line);
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }
        return transactions;
    }

}
