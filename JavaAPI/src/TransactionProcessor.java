public class TransactionProssesor {

    // Asumsi format: ID_PRODUK,NAMA_PRODUK,KUANTITAS,HARGA_SATUAN
    public TransactionData parseSalesData(String salesData) throws IllegalArgumentException {
        if (salesData == null || salesData.trim().isEmpty()) {
            throw new IllegalArgumentException("Data transaksi tidak boleh kosong.");
        }

        String[] parts = salesData.split(",");

        if (parts.length != 4) {
            throw new IllegalArgumentException("Format data transaksi tidak valid. Harus 4 kolom yang dipisahkan koma.");
        }

        try {
            String productId = parts[0].trim();
            String productName = parts[1].trim();
            int quantity = Integer.parseInt(parts[2].trim());
            double unitPrice = Double.parseDouble(parts[3].trim());

            return new TransactionData(productId, productName, quantity, unitPrice);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Kuantitas atau Harga bukan dalam format angka yang benar.", e);
        }
    }
}
