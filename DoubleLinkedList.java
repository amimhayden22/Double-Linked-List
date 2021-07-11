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
 
//Ghazi
    public void insertFirst(int theData) {
		Node newNode = new Node(da);
		if(isEmpty())
			last = newNode;
		else
			first.previous = newNode;
		      newNode.next = first;
		      first = newNode;
	}
	
} // End Class DoubleLink

// Khamim
// Membuat Class Main Untuk Menjalankan Program
class Main {
    public static void main(String[] args) {
        Scanner pilihMenu = new Scanner(System.in);
        // Bagian sini aku masih belum paham, nanti yang dimasukkan apa saja bang
        DoubleLinkedList theStack = new DoubleLinkedList();
        while (true) {
            theStack.menu();
            pilihan = pilihMenu.nextInt();
            switch (pilihan) {
                case 1: {
                    System.out.println("Menu Memasukkan Data");
                    break;
                }
                case 2: {
                    System.out.println("Menu Menghapus Data");
                    break;
                }
                case 3: {
                    System.out.println("Menu Memperbarui Data");
                    break;
                }
                case 4: {
                    System.out.println("Menu Menampilkan Data");
                    break;
                }
                case 5: {
                    System.out.println("Keluar");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Menu tidak ada!");
                }
            };
        }
    }   
} // End Class Main
