package DoubleLinkedList;

public class DoubleLinkedList {
    
}
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
}
