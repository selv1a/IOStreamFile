// Nama : Selvia Maharani
// NPM  : 2410010480

package tugas;

public class MainTugas {
    public static void main(String[] args) {
        String namaFile = "barang.txt";

        // 1. Menyimpan daftar kategori dalam Array String tetap (minimal 3) & menampilkannya
        String[] kategori = {"Elektronik", "Pakaian", "Makanan"};
        System.out.println("=== DAFTAR KATEGORI TOKO ===");
        for (int i = 0; i < kategori.length; i++) {
            System.out.println((i + 1) + ". " + kategori[i]);
        }
        System.out.println("-------------------------------------\n");

        // 2. Membuat objek Gudang pertama dan menambah minimal 5 barang
        System.out.println("=== PROSES GUDANG AWAL ===");
        Gudang gudangAwal = new Gudang();
        
        gudangAwal.tambahBarang(new Barang("Laptop Asus", 12500000, 5));
        gudangAwal.tambahBarang(new Barang("Baju", 150000, 20));
        gudangAwal.tambahBarang(new Barang("Nasi Goreng", 45000, 12));
        gudangAwal.tambahBarang(new Barang("Mie Goreng", 15000, 8));
        gudangAwal.tambahBarang(new Barang("Headset Gaming", 350000, 15));

        System.out.println("Daftar Barang Gudang Awal:");
        gudangAwal.tampilkanSemua();
        
        // Menyimpan data gudang awal ke berkas teks
        gudangAwal.simpanKeBerkas(namaFile);
        System.out.println("-------------------------------------\n");

        // 3. Membuat objek Gudang BARU untuk pembuktian Load Berkas
        System.out.println("=== PROSES GUDANG BARU (LOAD DATA) ===");
        Gudang gudangBaru = new Gudang();
        
        // Memuat kembali data dari berkas
        gudangBaru.muatDariBerkas(namaFile);
        
        System.out.println("\nMenampilkan Data Gudang Baru:");
        gudangBaru.tampilkanSemua();
        
        // Menampilkan total nilai persediaan
        double totalPersediaan = gudangBaru.totalNilai();
        System.out.println("-------------------------------------");
        System.out.printf("TOTAL NILAI PERSEDIAAN BARANG: Rp%,.2f\n", totalPersediaan);
        System.out.println("=====================================");
    }
}