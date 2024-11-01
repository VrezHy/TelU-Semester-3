import java.io.*;

class Pasien {
  int noUrut;
  String nama;

  Pasien(int nu, String nama) {
    this.noUrut = nu;
    this.nama = nama;
  }

  String info() {
    return noUrut + " " + nama;
  }

  int getNoUrut() {
    return noUrut;
  }
}

class NodePs {
  Pasien data;
  NodePs next;

  NodePs(Pasien d) {
    data = d;
    next = null;
  }
}

public class QueueListPasien {
  NodePs head; // head of list
  NodePs tail; // tail of list
  /* Tambah antrian */

  public int enqueue(String nama) {
    // Pastikan bahwa no urut pasien akan selalu terurut, sehingga
    int noUrut = (tail == null) ? 1 : tail.data.getNoUrut() + 1;
    // Jika Queue kosong, no urut dari 1
    // Jika Queue tidak kosong, no urut diambil dari no urut last NodePs +1
    Pasien NewPasien = new Pasien(noUrut, nama);
    NodePs nn1 = new NodePs(NewPasien);
    if (head == null) {
      head = nn1;
      tail = nn1;
    } else {
      tail.next = nn1;
      tail = nn1;
    }
    System.out.println("Node baru " + noUrut + " dengan nama " + nama + " ditambahkan");
    return noUrut;
  }

  /* Ambil Urutan */
  public int dequeue() {
    // Pengambilan NodePs urutan dari yang paling ujung
    NodePs current = null;
    if (head == null) {
      System.out.println("List kosong");
      return 0;
    } else if (head == tail) {
      head = null;
      tail = null;
    } else {
      current = head;
      head = current.next;
      current.next = null;
    }
    System.out.println("Data diambil " + current.data.info());
    return current.data.getNoUrut();
  }

  /* jika no antrian depan tidak ada, maka ambil antrian yang ada */
  public int ambilAntrianTengah(int noUrut) {
    // Jika list kosong
    // NodePs current = null;
    // NodePs prev = null;
    if (head == null) {
      // Jika List kosong
      System.out.println("List Kosong");
      return 0;
    } else if ((head.data.getNoUrut() == noUrut) && (head == tail)) {
      // jika hanya ada 1 NodePs
      head = head.next;
      System.out.println("Data Tengah" + noUrut + " telah diambil");
      return 0;
    } else {
      // Jika pasien yang datang sesuai no urut tidak ada, maka akan diambil nextnya
      NodePs current = head;
      NodePs prec = head;
      while (current != null) {
        if (current.data.getNoUrut() == noUrut) {
          prec.next = current.next;
          System.out.println("Data Tengah " + noUrut + " telah diambil");
          return 0;
        }
        prec = current;
        current = current.next;
      }
      // sampai ketemu
      // Lakukan pemanggilan pasien sesuai urutan hingga ketemu atau hingga akhir
      // Queue
      System.out.println("Data " + noUrut + " tidak ditemukan");
      return 0;
    }
    
  }

  public void printList() {
    NodePs current = head;
    System.out.println("\nDaftar antrian : ");
    while (current != null) {
      System.out.println(current.data.info());
      current = current.next;
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    QueueListPasien sll = new QueueListPasien();
    sll.runThis();
  }

  void runThis() {
    enqueue("Gandalf The Grey");
    enqueue("Aragorn");
    enqueue("Legolas");
    enqueue("Gimli");
    enqueue("Boromir");
    enqueue("Frodo Baggins");
    enqueue("Samwise Gamgee");
    enqueue("Meri");
    enqueue("Pippin");
    printList();
    ambilAntrianTengah(5);
    printList();
    dequeue();
    printList();
    enqueue("Gandalf The White");
    printList();
  }
}