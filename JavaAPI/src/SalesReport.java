import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class SalesReport {
    public static void writeReport(String outputFile, List<org.example.TransactionData> transaction) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("Sales Report");
            bw.newLine();
            LocalDateTime sekarang = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            bw.write("Denerate at: " + sekarang.format(fmt));
            bw.newLine();
            bw.write("------------------------------");
            bw.newLine();
            bw.write(String.format(Locale.forLanguageTag("id-ID"),
                    "%-10s %-20s %8s"))
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
