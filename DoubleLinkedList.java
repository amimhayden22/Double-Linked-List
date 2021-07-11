package DoubleLinkedList;

//Wahid
import java.util.Objects;
import java.util.Scanner;
 
//Kalau Ngedit Jangan Lupa Dikasih Komentar di baris yang diedit yaaa :)

//Ghazi (Edited by Wahid)
class Node {
    public String Nama;
    public Long Nim;
    public String Gender;
    public Node next; // pointer (link) untuk terhubung dengan Node berikutnya
    public Node previous; // pointer (link) untuk terhubung dengan Node sebelumnya
    // -------------------------------------------------------------
 
    public Node(String nama, Long nim, String gender) {
        Nama = nama;
        Nim = nim;
        Gender = gender;
    }
 
    // -------------------------------------------------------------
    public void tampilNode() {
        
        String leftAlignFormat = "| %-15d | %-25s | %-12s |%n";
        System.out.format(leftAlignFormat, Nim, Nama, Gender);
        System.out.format("+-----------------+---------------------------+--------------+%n");
    }
 
    // -------------------------------------------------------------
    public String getGender() {
        return Gender;
    }
 
} // end class Node
 
 
//Wahid
class DoubleLink {
    private Node first; // pointer first digunakan untuk menunjukkan awal list
    private Node last; // pointer last digunakan untuk menunjukkan akhir list
    // -------------------------------------------------------------
 
    public DoubleLink() { // constructor
        first = null; // pointer first diinisialisasi agar tidak menunjuk ke suatu Node tertentu
        last = null; // pointer last diinisialisasi agar tidak menunjuk ke suatu Node tertentu
    }
 
    // -------------------------------------------------------------
    public boolean isEmpty() { // bernilai true jika tidak ada data
        return first == null;
    }
 
    // -------------------------------------------------------------
    // menghapus data di awal list
    public Node deleteFirst() {
        Node temp = first;
        if (first.next == null)
            last = null;
        else
            first.next.previous = null;
        first = first.next;
        return temp;
    }
 
    // -------------------------------------------------------------
    // menghapus data di akhir list
    public Node deleteLast() {
        Node temp = last;
        if (first.next == null)
            first = null;
        else
            last.previous.next = null;
        last = last.previous;
        return temp;
    }
 
    // -------------------------------------------------------------
    // menghapus data tertentu (tidak diawal maupun diakhir list)
    public Node hapus(Long nim) {
        Node indek = first;
        while (!indek.Nim.equals(nim)) {
            indek = indek.next;
            if (indek == null) {
                System.out.println(ConsoleColors.RED + "NIM Tidak Ditemukan" +
                    ConsoleColors.RESET);
                return null; // data tidak ditemukan
            }
        }
        if (indek == first) {
            first = indek.next;
        } else {
            indek.previous.next = indek.next;
 
        }
        if (indek == last) {
            last = indek.previous;
        } else {
            indek.next.previous = indek.previous;
        }
        return indek;
    }
	
	
    public void tampilMaju() {
        System.out.format("+-----------------+---------------------------+--------------+%n");
        System.out.format("| NIM             | Nama                      | Gender       |%n");
        System.out.format("+-----------------+---------------------------+--------------+%n");
        Node indek = first;
        while (indek != null) {
            indek.tampilNode();
            indek = indek.next;
        }
        System.out.println("");
    }

    // -------------------------------------------------------------
    public void tampilMundur() {
        System.out.println("List (last-->first): ");
        Node indek = last;
        while (indek != null) {
            indek.tampilNode();
            indek = indek.previous;
        }
        System.out.println("");
    }

    // -------------------------------------------------------------
    public Boolean checkNim(Long nim) {
        Node indek = first;
        boolean sama = true;
        while (indek != null) {
            if (Objects.equals(indek.Nim, nim)) {
                sama = false;
            }
            indek = indek.next;
        }
        return sama;
    }

    // -------------------------------------------------------------
    public void tampilGrup() {   
        System.out.format("+-----------------+---------------------------+--------------+%n");
        System.out.format("| NIM             | Nama                      | Gender       |%n");
        System.out.format("+-----------------+---------------------------+--------------+%n");
        Node indek = first;
        while (indek != null) {
            if (indek.getGender().equals("L")) {
                indek.tampilNode();
            } else {
            }
            indek = indek.next;
        }
        indek = first;
        while (indek != null) {
            if (indek.getGender().equals("W")) {
                indek.tampilNode();
            } else {
            }
            indek = indek.next;
        }
        System.out.println("");
    }
 
//Ghazi
    public boolean insert(String nama, Long nim, String gender) {
        Node newNode = new Node(nama, nim, gender);
        if (checkNim(nim)) {
            if (isEmpty()) {
                last = newNode;
                first = newNode;
                System.out.println(ConsoleColors.GREEN + "Berhasil Memperbarui Data" +
                    ConsoleColors.RESET);
            } else {
                Node indek = first;
                while (indek != null) {
                    if (indek.Nim > nim) {
                        if (indek == first) {
                            newNode.next = first;
                            newNode.previous = null;
                            first.previous = newNode;
                            first = newNode;
                            return true;
                        } else {
                            indek = indek.previous;
                            newNode.next = indek.next;
                            newNode.previous = indek;
                            indek.next.previous = newNode;
                            indek.next = newNode;
                            return true;
                        }
                    }
                    indek = indek.next;
                }
                newNode.next = null;
                newNode.previous = last;
                last.next = newNode;
                last = newNode;
                return true;
            }
        } else {
            System.out.println(ConsoleColors.RED + "NIM Sudah Digunakan" +
                    ConsoleColors.RESET);
            
        }
        return true;
    }

    public boolean updateData(Long nim) {
        Scanner scan = new Scanner(System.in);
        Node indek = first;
        while (indek != null) {
            if (Objects.equals(indek.Nim, nim)) {
                //hapus(indek.Nim);
                System.out.println("\n-----------------------[ Menu Update ]------------------------");
                
                System.out.println("1. Update Nama         -->   " +indek.Nama);
                System.out.println("2. Update NIM          -->   " +indek.Nim);
                System.out.println("3. Update Gender <L/W> -->   " +indek.Gender);
                System.out.println("4. Keluar Menu Update");

                int pilih = scan.nextInt();
                switch (pilih) {
                
                //Update Nama
                case 1:
                 long nimtetap = indek.Nim;
                 String gendertetap = indek.Gender;
                 hapus(indek.Nim);
                 System.out.print("\nMasukkan Nama baru: ");
                 String inputNamaBaru = scan.next();
                 insert(inputNamaBaru, nimtetap, gendertetap);

                 break;
                
                 //Update NIM
                 case 2:
                 String namatetap = indek.Nama;
                 gendertetap = indek.Gender;
                 hapus(indek.Nim);
                 System.out.print("\nMasukkan NIM baru: ");
                 Long inputNimBaru = scan.nextLong();
                 insert(namatetap, inputNimBaru, gendertetap);

                 break;

                 //Update Gender
                 case 3:
                 namatetap = indek.Nama;
                 nimtetap = indek.Nim;
                 hapus(indek.Nim);
                 System.out.print("\nMasukkan Gender baru <P/W>: ");
                 String inputGenderBaru = scan.next();
                 insert(namatetap, nimtetap, inputGenderBaru);

                 break;
                 default:
                 System.out.println("Pilihan tidak valid! Silahkan masukkan kembali");
                 break;
                 
                }
                return true;
            }
            indek = indek.next;
        }
        System.out.println("NIM tidak ditemukan");
        return false;
    }

    // -------------------------------------------------------------
    public void peek() {
        Node indek = first;
        indek.tampilNode();
        System.out.println("");
    }

    // -------------------------------------------------------------
    public void clear() {
        while (!isEmpty()) {
            deleteFirst();
        }
    }

	    public class ConsoleColors {
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset
    
        // Regular Colors
        public static final String BLACK = "\033[0;30m";   // BLACK
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String YELLOW = "\033[0;33m";  // YELLOW
        public static final String BLUE = "\033[0;34m";    // BLUE
        public static final String PURPLE = "\033[0;35m";  // PURPLE
        public static final String CYAN = "\033[0;36m";    // CYAN
        public static final String WHITE = "\033[0;37m";   // WHITE
    }
	
// Khamim
// Membuat Class Main Untuk Menjalankan Program
    public void menu() { 

        System.out.println("\n--------------------------[ MENU ]----------------------------");
        System.out.println("1. Memasukkan Data");
        System.out.println("2. Menghapus Data");
        System.out.println("3. Mengupdate Data");
        System.out.println("4. Menampilkan Data");
        System.out.println("5. Buat Data Baru (Clear Data)");
        System.out.println("6. Keluar");
        System.out.println("--------------------------------------------------------------");
        Scanner scan = new Scanner(System.in);
        int opsi = scan.nextInt();
        scan.nextLine();
        switch (opsi) {

            // Memasukkan Data
            case 1:
                System.out.println("\n------------------------[ Input Data ]------------------------");
                System.out.print("Masukkan Nama         : ");
                String inputNama = scan.nextLine();
                System.out.print("Masukkan NIM          : ");
                Long inputNim = Long.parseLong(scan.nextLine());
                System.out.print("Masukkan Gender <L/W> : ");
                String inputGender = scan.nextLine();
                insert(inputNama, inputNim, inputGender);
                break; 

            // Menghapus Data
            case 2:
                
                if (isEmpty()) {
                    System.out.println(ConsoleColors.RED + "List Kosong" +
                    ConsoleColors.RESET);
                } else {
                    System.out.println("\n------------------------[ Hapus Data ]------------------------");
                    System.out.print("NIM Mahasiswa yang akan di-hapus: ");
                    inputNim = Long.parseLong(scan.nextLine());
                    hapus(inputNim);
                    System.out.println(ConsoleColors.GREEN + "Berhasil Menghapus Data" +
                    ConsoleColors.RESET);
                }
                break;

            // Mengupdate Data
            case 3:
                System.out.print("\nNIM Mahasiswa yang akan di-update: ");
                Long nimupdate = Long.parseLong(scan.nextLine());
                updateData(nimupdate);
                break;

            // Menampilkan Data
            case 4:
                
                if (isEmpty()) {
                    System.out.println(ConsoleColors.RED + "List Kosong" +
                    ConsoleColors.RESET);
                } else {
                    System.out.println("\n---------------------[ Data Saat Ini ]------------------------");
                    tampilGrup();
                }
                break;

            // Clear data
            case 5:
                if (isEmpty()){
                    System.out.println(ConsoleColors.RED + "List Kosong" +
                    ConsoleColors.RESET);
                }
                else{
                clear();
                System.out.println(ConsoleColors.GREEN + "Berhasil Melakukan Clear Data" +
                    ConsoleColors.RESET);
                }
                break;

            // Keluar Program
            case 6:
            System.out.println(ConsoleColors.GREEN + "Berhasil Keluar Dari Program" +
            ConsoleColors.RESET);
                scan.close();
                System.exit(0);
                break;

            default:
            System.out.println(ConsoleColors.RED + "Pilihan tidak valid! Silahkan masukkan kembali" +
                    ConsoleColors.RESET);  
                break;
        }
        menu();
    }
} // end class DoubleLink2

public class haduh { //ini main class nya ehe :)
    public static void main(String[] args) throws IOException {
        DoubleLink list = new DoubleLink();
        list.menu();
    }
}
