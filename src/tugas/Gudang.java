package tugas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Gudang {
    private ArrayList<Barang> daftarBarang;

    // Constructor
    public Gudang() {
        this.daftarBarang = new ArrayList<>();
    }

    // Method menambah barang
    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    // Method menampilkan semua barang
    public void tampilkanSemua() {
        if (daftarBarang.isEmpty()) {
            System.out.println("[Gudang Kosong]");
            return;
        }
        for (Barang b : daftarBarang) {
            b.info();
        }
    }

    // Method menyimpan data ke berkas teks
    public void simpanKeBerkas(String namaBerkas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaBerkas))) {
            for (Barang b : daftarBarang) {
                writer.write(b.keBaris());
                writer.newLine();
            }
            System.out.println("Sistem: Data berhasil disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Sistem: Gagal menyimpan berkas! " + e.getMessage());
        }
    }

    // Method memuat data dari berkas teks
    public void muatDariBerkas(String namaBerkas) {
        // Membersihkan data lama terlebih dahulu sebelum memuat yang baru
        daftarBarang.clear();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                // Memisahkan string berdasarkan tanda koma
                String[] data = baris.split(",");
                if (data.length == 3) {
                    String nama = data[0];
                    double harga = Double.parseDouble(data[1]);
                    int stok = Integer.parseInt(data[2]);
                    
                    Barang barang = new Barang(nama, harga, stok);
                    daftarBarang.add(barang);
                }
            }
            System.out.println("Sistem: Data berhasil dimuat dari " + namaBerkas);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Sistem: Gagal memuat berkas! " + e.getMessage());
        }
    }

    // Method menghitung total nilai persediaan (Harga * Stok)
    public double totalNilai() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += b.getHarga() * b.getStok();
        }
        return total;
    }
}