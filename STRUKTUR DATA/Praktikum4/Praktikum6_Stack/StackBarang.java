import java.io.*;
import java.util.Scanner;

class Barang {
  private int id;
  private String nama;
  private int stok;

  public Barang(int id, String nama, int stok) {
    this.id = id;
    this.nama = nama;
    this.stok = stok;
  }

  public int getId() {
    return id;
  }

  public String info() {
    return id + " " + nama + " " + stok;
  }
}

class Nodes {
  Barang data;
  Nodes next;
  
  Nodes(Barang d) {
    data = d;
    next = null;
  }
}

public class StackBarang {
  Nodes top; // top of stack
  Scanner inputs = new Scanner(System.in);

  public void push(Barang data) {
    Nodes newNo = new Nodes(data);

    if (top == null) {
      // Kasus 1. Jika stack empty
      // maka top diisi dengan Nodes baru
      top = newNo;
    } else {
      // Kasus 2. jika stack ada Nodes
      // New Nodes diletakkan paling, dan top lama menjadi next
      newNo.next = top;
      top = newNo;
    }
    System.out.println("PUSH " + data.info());
  }

  public void pop() {
    Nodes Nodes = null;
    // Kasus 1. Jika stack empty
    if (top == null) {
      // Jika stack kosong, berikan informasi stack kosong
      System.out.println("Stack kosong");
      return;
    } else {
      // Jika stack ada, Nodes baru akan diisi dengan top
      // next dari top akan menjadi top baru
      // untuk membersihkan Nodes baru, set next dengan null
      Nodes = top;
      top = top.next;
      Nodes.next = null;
    }
    System.out.println("POP " + Nodes.data.info());
  }

  public void delete(int id) {
    if (top == null) {
      // jika stack, tampilkan informasi stack kosong
      System.out.println("Stack kosong");
      return;
    }
    // Case 1: Delete the top Nodes
    if (id == top.data.getId()) {
      // jika data yang dicari sama dengan data top
      if (top.next == null) {
        // jika Nodes selanjutnya dari top adalah null
        top = null;
      } else {
        top = top.next;
      }
      System.out.println("DELETE : " + id);
      return;
    }
    Nodes current = top; // data iterasi yang akan dihapus
    Nodes prev = top; // Nodes sebelumnya
    // Traverse untuk menemukan Nodes
    while (current != null && current.data.getId() != id) {
      prev = current;
      current = current.next;
    }
    // jika Nodes tidak ditemukan, posisi berada paling akhir
    if (current == null) {
      System.out.println("DELETE : " + id + " NOT FOUND");
      return;
    }
    // jika Nodes ditemukan di pertengahan atau akhir
    if (current.next != null) {
      // jika Nodes bukan bagian paling akhir
      // gunakan prev untuk menghubungkan Nodes prev dan next Nodes
      prev.next = current.next;
    } else {
      // Jika Nodes paling akhir, set next dari prev dengan null
      prev.next = null;
    }
    System.out.println("DELETE : " + id);
    current = null;
  }

  public void print() {
    if (top == null) {
      // jika stack kosong, tampilkan stack kosong
      System.out.println("Stack Kosong");
      return;
    } else {
      Nodes current = top;
      System.out.print("Stack : ");
      // Ulang hingga Nodes berada paling akhir
      while (current != null) {
        System.out.print(current.data.info() + " ");
        current = current.next;
      }
      System.out.println("");
    }
  }

  public static void main(String[] args) {
    StackBarang nnd = new StackBarang();
    nnd.runThis();
  }

  void runThis() {
    push(new Barang(5, "So So", 17));
    push(new Barang(2, "Clean", 65));
    push(new Barang(1, "So", 15));
    push(new Barang(8, "So So Clean", 32));
    push(new Barang(3, "So Clean", 41));
    push(new Barang(6, "Clean Clean", 100));
    push(new Barang(7, "So Clean So Clean", 100));
    push(new Barang(10, "Clean So So", 30));
    push(new Barang(9, "So Clean Clean", 20));
    print();
    pop();
    print();
    pop();
    print();
    delete(2);
    print();
    delete(4);
    print();
    delete(6);
    print();
  }
}