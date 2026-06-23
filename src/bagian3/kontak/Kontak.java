package bagian3.kontak;

public class Kontak {
    // Atribut: data yang dimiliki setiap kontak
    private String nama;
    private String nomor;
    private String email; // Tambahan atribut email (Soal 2)
    
    // Constructor: disesuaikan untuk menerima parameter email (Soal 2)
    public Kontak(String nama, String nomor, String email) {
        this.nama = nama;
        this.nomor = nomor;
        this.email = email;
    }
    
    // Getter
    public String getNama() {
        return nama;
    }
    
    public String getNomor() {
        return nomor;
    }

    public String getEmail() { // Tambahan getter email (Soal 2)
        return email;
    }
    
    // Mengubah objek menjadi baris teks dengan pemisah semikolon (Soal 2)
    public String keBaris() {
        return nama + ";" + nomor + ";" + email;
    }
    
    // Mengembalikan keterangan lengkap kontak untuk ditampilkan (Soal 2)
    public String info() {
        return nama + " - " + nomor + " (" + email + ")";
    }
}