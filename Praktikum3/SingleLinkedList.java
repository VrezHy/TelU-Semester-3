import java.io.*;

class Node {
      int data;
      Node next;

      Node(int d) {
            data = d;
            next = null;
      }
}

public class SingleLinkedList {
      Node head; // head of list
      /* Insert last tidak terurut */
      Node sortedHead;

      public int insert(int data) {
            Node nn = new Node(data);
            Node current = head;
            if (current == null) {
                  nn.next = null;
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
            Node current = sortedHead;
            // Jika list kosong atau data lebih kecil dari head
            if (sortedHead == null || sortedHead.data >= nn.data) {
                  nn.next = sortedHead;
                  sortedHead = nn;
            } else {
                  // Cari posisi yang tepat untuk menyisipkan node
                  while (current.next != null && (current.next.data < nn.data)) {
                        current = current.next;
                  }
                  nn.next = current.next;
                  current.next = nn;
            }
            System.out.println("Node baru " + data + " ditambahkan");
      } // eoinsertSorted
      
      /* Delete */

      public int delete(int data) {
            // Jika list kosong
            if (sortedHead == null) {
                  System.out.println("List kosong");
                  return 0;
            } else {
                  // Cek apakah data yang dicari ada di head
                  if (sortedHead.data == data) {
                        sortedHead = sortedHead.next;
                        System.out.println("Node " + data + " telah dihapus");
                        return 0;
                  } else {
                        // jika data yang dicari bukan di head
                        Node current = sortedHead;
                        Node prec = sortedHead;
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
      } // eodelete

      public void printList() {
            Node current = head;
            System.out.print("Single LinkedList: ");
            while (current != null) {
                  System.out.print(current.data + " ");
                  current = current.next;
            }
            System.out.println("");
      } // eoprintlist

      public void printListSorted() {
            Node current = sortedHead;
            System.out.print("Single LinkedList: ");
            while (current != null) {
                  System.out.print(current.data + " ");
                  current = current.next;
            }
            System.out.println("");
      } // eoprintlist

      public static void main(String[] args) {
            SingleLinkedList sll = new SingleLinkedList();
            sll.runThis();
            sll.insertSortedData();
            sll.deleteData();
      }

      void runThis() {
            // Buat proses pengisian data
            System.out.println("Deret tidak terurut");
            insert(5);
            insert(1);
            insert(3);
            insert(2);
            insert(7);
            insert(6);
            insert(9);
            insert(8);
            printList();
            System.out.println(" ");
      }

      void insertSortedData() {
            System.out.println("Deret terurut");
            insertSorted(5);
            insertSorted(1);
            insertSorted(3);
            insertSorted(2);
            insertSorted(7);
            insertSorted(6);
            insertSorted(9);
            insertSorted(8);
            printListSorted();
            System.out.println(" ");
      }

      void deleteData() {
            // Menghapus nilai 5, 1, 9 dan 99
            System.out.println("Penghapusan nilai 5:");
            delete(5);
            printListSorted();
            System.out.println("");

            System.out.println("Penghapusan nilai 1:");
            delete(1);
            printListSorted();
            System.out.println("");

            System.out.println("Penghapusan nilai 9:");
            delete(9);
            printListSorted();
            System.out.println("");

            System.out.println("Penghapusan nilai 99 (tidak ada):");
            delete(99);
            printListSorted();
            System.out.println("");
      }

} // eoSingleLinkList
