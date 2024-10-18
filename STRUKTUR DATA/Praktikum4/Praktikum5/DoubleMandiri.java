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

class Node {
      int data;
      Node next;
      Node prev;

      Node(int d) {
            data = d;
            next = null;
            prev = null;
      }
}

public class DoubleMandiri {
      Node head; // head of list
      Node tail; // tail of list
      Scanner inp = new Scanner(System.in);

      /* Insert last */
      public void insertEnd(Barang data) {
            Node nn = new Node(data.getId());
            if (tail == null) {
                  head = tail = nn;
            } else {
                  tail.next = nn;
                  nn.prev = tail;
                  tail = nn;
            }
            System.out.println("Node baru " + data.info() + " diposisi belakang");
      }

      /* Insert First */
      public void insertFirst(Barang data) {
            Node nn = new Node(data.getId());
            if (head == null) {
                  head = tail = nn;
            } else {
                  head.prev = nn;
                  nn.next = head;
                  head = nn;
            }
            System.out.println("Node baru " + data.info() + " diposisi depan");
      }

      /* Insert sorted */
      public void insertSorted(Barang data) {
            Node newNode = new Node(data.getId());
            // Kasus 1. Jika List empty
            if (head == null) {
                  head = tail = newNode;
                  System.out.println("Node baru " + data.info() + " paling depan");
                  return;
            }
            // Kasus 2. Jika new node adalah angka paling kecil
            if (data.getId() <= head.data) {
                  newNode.next = head;
                  head.prev = newNode;
                  head = newNode;
                  System.out.println("Node baru " + data.info() + " paling depan");
                  return;
            }

            // Kasus 3: jika new node angka paling besar
            if (data.getId() >= tail.data) {
                  newNode.prev = tail;
                  tail.next = newNode;
                  tail = newNode;
                  System.out.println("Node baru " + data.info() + " paling belakang");
                  return;
            }

            // Kasus 4: diantara head dan tail
            Node current = head;
            while (current != null && current.data < data.getId()) {
                  current = current.next;
            }
            // Insert the node before the current node
            newNode.next = current;
            newNode.prev = current.prev;
            if (current.prev != null) {
                  current.prev.next = newNode;
            }
            current.prev = newNode;
            System.out.println("Node baru " + data.info() + " di tengah");
      }

      // Delete node dengan data tertentu
      public void delete(int data) {
            if (head == null) {
                  System.out.println("List is empty.");
                  return;
            }
            Node current = head;
            // Case 1: Delete the head node
            if (head.data == data) {
                  head = head.next;
                  System.out.println("Node " + data + " dihapus");
                  if (head != null) {
                        head.prev = null;
                  } else {
                        tail = null; // If the list becomes empty
                  }
                  return;
            }

            // Traverse to find the node to delete
            while (current != null && current.data != data) {
                  current = current.next;
            }
            System.out.println("Node " + data + " dihapus");
            // Case 2: Node not found
            if (current == null) {
                  System.out.println("Node " + data + " tidak ditemukan.");
                  return;
            }
            // Case 3: Delete a middle node
            if (current.next != null) {
                  current.next.prev = current.prev;
            } else {
                  tail = current.prev; // jika node yang dihapus adalah tail
            }
            if (current.prev != null) {
                  current.prev.next = current.next;
            }
      }

      public void printListBackward() {
            Node current = head;
            System.out.print("Double LinkedList Backward: ");
            while (current != null) {
                  System.out.print(current.data + " ");
                  current = current.next;
            }
            System.out.println("");
      }

      public void printListForward() {
            Node current = tail;
            System.out.print("Double LinkedList Forward: ");
            while (current != null) {
                  System.out.print(current.data + " ");
                  current = current.prev;
            }
            System.out.println("");
      }

      public void printList() {
            Node current = head;
            System.out.print("Single LinkedList (Terurut): \n");
            while (current != null) {
                  System.out.print(current.data + " ");
                  current = current.next;
            }
      }

      public static void main(String[] args) {
            DoubleMandiri dll = new DoubleMandiri();
            dll.runThis();
      }

      void runThis() {
            // INSERT BIASA

            insertFirst(new Barang(5, "So So", 55));
            insertEnd(new Barang(2, "Clean", 22));
            insertEnd(new Barang(1, "So", 11));
            insertFirst(new Barang(8, "So So Clean", 88));
            insertFirst(new Barang(3, "So Clean", 33));
            insertEnd(new Barang(6, "Clean Clean", 66));
            insertFirst(new Barang(7, "So Clean So Clean", 77));
            insertEnd(new Barang(10, "Clean So So", 100));
            insertEnd(new Barang(9, "So Clean Clean", 99));
            insertEnd(new Barang(4, "Clean So", 44));
            printListBackward();
            printListForward();
            System.out.println(" ");

            // INSERT SORTEd
            insertSorted(new Barang(5, "So So", 17));
            insertSorted(new Barang(2, "Clean", 65));
            insertSorted(new Barang(1, "So", 15));
            insertSorted(new Barang(8, "So So Clean", 32));
            insertSorted(new Barang(3, "So Clean", 41));
            insertSorted(new Barang(6, "Clean Clean", 100));
            insertSorted(new Barang(7, "So Clean So Clean", 100));
            insertSorted(new Barang(10, "Clean So So", 30));
            insertSorted(new Barang(9, "So Clean Clean", 20));
            insertSorted(new Barang(4, "Clean So", 10));
            printListBackward();
            printListForward();
            System.out.println(" ");

            delete(6);
            printListBackward();
            delete(1);
            printListForward();
            delete(9);
      }
}
