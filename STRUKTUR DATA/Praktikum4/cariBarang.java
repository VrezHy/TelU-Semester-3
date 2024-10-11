class Barang2 {
      private int id;
      private String nama;
      private int stok;

      public Barang2(int id, String nama, int stok) {
            this.id = id;
            this.nama = nama;
            this.stok = stok;
      }

      public int getId() {
            return id;
      }

      public void setStok(int stok) {
            this.stok = stok;
      }

      public String info() {
            return id + " " + nama + " " + stok;
      }

}

class Node2 {
      Barang2 data;
      Node2 next;

      Node2(Barang2 b) {
            data = b;
            next = null;
      }
}

public class cariBarang {
      Node2 head;

      // insert tidak urut
      public void insert(Barang2 data) {
            Node2 nn = new Node2(data);
            if (head == null) {
                  head = nn;
            } else {
                  Node2 current = head;
                  while (current.next != null) {
                        current = current.next;
                  }
                  current.next = nn;
            }
            System.out.println("Node baru " + data.getId() + " ditambahkan");
      }

      /* Pencarian */
      public void cariData(int id) {
            Node2 current = head;
            int position = 1;

            while (current != null) {
                  if (current.data.getId() == id) {
                        System.out.println("Data dengan ID " + id + " ditemukan pada urutan ke-" + position);
                        return;
                  }
                  current = current.next;
                  position++;
            }
            System.out.println("Data dengan ID " + id + " tidak ditemukan");
      }

      public void updateStok(int id, int newStok) {
            Node2 current = head;

            while (current != null) {
                  if (current.data.getId() == id) {
                        current.data.setStok(newStok);
                        System.out.println("Stok barang dengan ID " + id + " telah diupdate menjadi " + newStok);
                        return;
                  }
                  current = current.next;
            }
            System.out.println("Barang dengan ID " + id + " tidak ditemukan.");
      }

      public void printList() {
            Node2 current = head;
            if (current == null) {
                  System.out.println("List kosong");
                  return;
            }
            System.out.println("Data dalam list:");
            while (current != null) {
                  System.out.println(current.data.info());
                  current = current.next;
            }
      }

      public static void main(String[] args) {
            cariBarang sll = new cariBarang();
            sll.runThisCari();
      }

      void runThisCari() {
            System.out.println("Mencari Data : ");
            insert(new Barang2(5, "So So", 55));
            insert(new Barang2(2, "Clean", 22));
            insert(new Barang2(1, "So", 11));
            insert(new Barang2(8, "So So Clean", 88));
            insert(new Barang2(3, "So Clean", 33));
            insert(new Barang2(6, "Clean Clean", 66));
            insert(new Barang2(7, "So Clean So Clean", 77));
            insert(new Barang2(10, "Clean So So", 100));
            insert(new Barang2(9, "So Clean Clean", 99));
            insert(new Barang2(4, "Clean So", 44));
            printList();
            System.out.println("--------------------------------");
            cariData(2);
            cariData(3);
            cariData(99);
            System.out.println("--------------------------------");
            updateStok(1, 100);
            updateStok(2, 2000);
            updateStok(99, 99);
            System.out.println("--------------------------------");
            printList();
      }
}
