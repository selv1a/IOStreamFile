package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {
        // 1. Membuat objek pengelola dan mengisinya dengan format baru (Nama, Nomor, Email)
        BukuKontak buku = new BukuKontak("kontak.txt");
        buku.tambahKontak(new Kontak("Andi", "0811111", "andi@email.com"));
        buku.tambahKontak(new Kontak("Budi", "0822222", "budi@email.com"));
        buku.tambahKontak(new Kontak("Citra", "0833333", "citra@email.com"));
        
        buku.tampilkanSemua();
        buku.simpanKeBerkas();
        
        System.out.println("\n------------------------------------\n");
        
        // 2. Menguji Method cariKontak() (Soal 1)
        buku.cariKontak("Budi");  // Skenario: Ditemukan
        buku.cariKontak("Siti");  // Skenario: Tidak ditemukan
        
        System.out.println("\n------------------------------------\n");
        
        // 3. Menguji Method hapusKontak() (Soal 3)
        buku.hapusKontak("Andi"); // Menghapus Andi dan otomatis simpan ke berkas
        
        System.out.println("\n------------------------------------\n");
        
        // 4. Membuktikan berkas diperbarui dengan memuatnya ke objek baru
        BukuKontak bukuLain = new BukuKontak("kontak.txt");
        bukuLain.muatDariBerkas();
        bukuLain.tampilkanSemua(); // Andi seharusnya sudah tidak ada
        System.out.println("Jumlah kontak saat ini: " + bukuLain.jumlahKontak());
    }
}