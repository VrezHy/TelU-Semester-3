import java.io.*;

class Node {
      int data;
      Node next;

      Node(int d) {
            data = d;
            next = null;
      }
}

public class sllMandiri {
      Node head; // head of list

      /* Insert last tidak terurut */
      public int insert(int data) {
            Node nn = new Node(data);
            Node current = head;
            if (current == null) {
                  head = nn;
            } else {
                  while (current.next != null) {
                        current = current.next;
                  }
                  current.next = nn;
            }
            System.out.println("Node baru " + data + " ditambahkan");
            return 0;
      }

      /* Insert sorted */
      public void insertSorted(int data) {
            Node nn = new Node(data); // node baru
            if (head == null || head.data >= nn.data) {
                  nn.next = head;
                  head = nn;
            } else {
                  Node current = head;
                  // Cari posisi yang tepat untuk menyisipkan node
                  while (current.next != null && (current.next.data < nn.data)) {
                        current = current.next;
                  }
                  nn.next = current.next;
                  current.next = nn;
            }
            System.out.println("Node baru " + data + " ditambahkan");
      }

      /* Delete */
      public int delete(int data) {
            if (head == null) {
                  System.out.println("List kosong");
                  return 0;
            } else {
                  if (head.data == data) {
                        head = head.next;
                        System.out.println("Node " + data + " telah dihapus");
                        return 0;
                  } else {
                        Node current = head;
                        Node prec = head;
                        while (current != null) {
                              if (current.data == data) {
                                    prec.next = current.next;
                                    current.next = null;
                                    System.out.println("Node " + data + " telah dihapus");
                                    return 0;
                              }
                              prec = current;
                              current = current.next;
                        }
                  }
            }
            System.out.println("Node " + data + " tidak ditemukan");
            return 0;
      }

      /* Pencarian */
      public void cariData(int data) {
            Node current = head;
            int position = 1;

            while (current != null) {
                  if (current.data == data) {
                        System.out.println("Data " + data + " ditemukan pada urutan ke-" + position);
                        return;
                  }
                  current = current.next;
                  position++;
            }
            System.out.println("Data " + data + " tidak ditemukan");
      }

      public void printList() {
            Node current = head;
            System.out.print("Single LinkedList: ");
            while (current != null) {
                  System.out.print(current.data + " ");
                  current = current.next;
            }
            System.out.println("");
      }

      public static void main(String[] args) {
            sllMandiri sll = new sllMandiri();
            sll.runThis();
      }

      void runThis() {
            System.out.println("Proses pengisian data:");
            insert(5);
            insert(1);
            insert(3);
            insert(2);
            insert(7);
            insert(6);
            insert(9);
            insert(8);
            printList();

            System.out.println("\nPencarian data:");
            cariData(3);
            cariData(10);
            cariData(6);
            cariData(99);
            cariData(9);
            cariData(39);
            cariData(11);
      }
}
