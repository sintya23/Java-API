import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class MainGUI {
    List<Transaction> transactions = new ArrayList<>();
    SalesReader reader = new SalesReader();
    TransactionProssesor processor = new TransactionProssesor();
    SalesReport report = new SalesReport();


    public void start() {
        JFrame frame = new JFrame("Sales Report");
        frame.setSize(700, 500);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        JButton loadBtn = new JButton("Load Sales File");
        JButton generateBtn = new JButton("Generate Report");

        topPanel.add(loadBtn);
        topPanel.add(generateBtn);

        String[] columns = new String[]{"Id", "Nama", "Qty", "Price"};
        JTable table = new JTable(new DefaultTableModel(columns,0 ));

        JLabel label3 = new JLabel("Tiga");
        loadBtn.addActionListener(e -> {
            List<String> salesData = reader.readFromFile("C:\\Users\\HP\\OneDrive\\Documents\\GitHub\\Java-API\\JavaAPI\\src\\data.txt");
            transactions = processor.parseSalesData(salesData);
            for (Transaction t: transactions) {
                tableModel.addRow(new Object[] {t.Id, t.name, t.quantity, t.price});
            }

        });

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);
        panel.add(label3, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainGUI().start();
    }
}
