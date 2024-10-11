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
    Barang data;
    Node next;

    Node(Barang b) {
        data = b;
        next = null;
    }
}

public class Barang123 {
    Node head;
    Node sortedHead;

    // insert tidak urut
    public void insert(Barang data) {
        Node nn = new Node(data);
        if (head == null) {
            head = nn;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = nn;
        }
        System.out.println("Node baru " + data.getId() + " ditambahkan");
    }

    // sorted id
    public void insertSorted(Barang data) {
        Node nn = new Node(data);
        if (sortedHead == null || sortedHead.data.getId() > nn.data.getId()) {
            nn.next = sortedHead;
            sortedHead = nn;
        } else {
            Node current = sortedHead;
            while (current.next != null && current.next.data.getId() < nn.data.getId()) {
                current = current.next;
            }
            nn.next = current.next;
            current.next = nn;
        }
        System.out.println("Node baru " + data.getId() + " ditambahkan");
    }

    // delet tidak urut
    public int delete(int id) {
        if (head == null) {
            System.out.println("List kosong");
            return 0;
        } else if (head.data.getId() == id) {
            head = head.next;
            System.out.println("Node " + id + " telah dihapus");
            return 0;
        } else {
            Node current = head;
            Node prec = head;
            while (current != null) {
                if (current.data.getId() == id) {
                    prec.next = current.next;
                    System.out.println("Node " + id + " telah dihapus");
                    return 0;
                }
                prec = current;
                current = current.next;
            }
        }
        System.out.println("Node " + id + " tidak ditemukan");
        return 0;
    }

    // delete sorted
    public int deleteSorted(int id) {
        if (sortedHead == null) {
            System.out.println("List kosong");
            return 0;
        } else if (sortedHead.data.getId() == id) {
            sortedHead = sortedHead.next;
            System.out.println("Node " + id + " telah dihapus");
            return 0;
        } else {
            Node current = sortedHead;
            Node prec = sortedHead;
            while (current != null) {
                if (current.data.getId() == id) {
                    prec.next = current.next;
                    System.out.println("Node " + id + " telah dihapus");
                    return 0;
                }
                prec = current;
                current = current.next;
            }
        }
        System.out.println("Node " + id + " tidak ditemukan");
        return 0;
    }

    // Print list tidak urut
    public void printList() {
        Node current = head;
        System.out.print("Single LinkedList (Tidak terurut): \n");
        while (current != null) {
            System.out.print(current.data.info() + " \n");
            current = current.next;
        }
    }

    // Print sorted
    public void printListSorted() {
        Node current = sortedHead;
        System.out.print("Single LinkedList (Terurut): \n");
        while (current != null) {
            System.out.print(current.data.info() + " \n");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Barang123 sll = new Barang123();
        sll.runThis();
        sll.runThisSorted();
    }

    void runThis() {
        System.out.println("Data Tidak terurut : ");
        insert(new Barang(5, "So So", 55));
        insert(new Barang(2, "Clean", 22));
        insert(new Barang(1, "So", 11));
        insert(new Barang(8, "So So Clean", 88));
        insert(new Barang(3, "So Clean", 33));
        insert(new Barang(6, "Clean Clean", 66));
        insert(new Barang(7, "So Clean So Clean", 77));
        insert(new Barang(10, "Clean So So", 100));
        insert(new Barang(9, "So Clean Clean", 99));
        insert(new Barang(4, "Clean So", 44));
        printList();
        System.out.println(" ");

        delete(4);
        delete(1);
        delete(10);
        delete(99);
        printList();
        System.out.println(" ");

    }

    void runThisSorted(){
    System.out.println("Node terurut berdasarkan ID :");
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
    printListSorted();
    System.out.println(" ");

    deleteSorted(4);
    deleteSorted(1);
    deleteSorted(10);
    deleteSorted(99);
    printListSorted();
    System.out.println(" ");
    }
}
