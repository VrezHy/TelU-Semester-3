import java.util.Scanner;

//Descending
class kelolaArray2 {
      int jumlahAngka = 10;
      int[] arrOfInt = new int[jumlahAngka];
      Scanner inp = new Scanner(System.in);

      public static void main(String[] args) {
            kelolaArray2 kai = new kelolaArray2();
            kai.inputAndSort();
            kai.traversal();
      }// eomain

      void inputAndSort() {
            int val = 0;
            int temp = -999;
            for (int a = 0; a < jumlahAngka; a++) {
                  System.out.print("Val : ");
                  val = inp.nextInt();
                  if (a > 0) {
                        for (int b = 0; b < a; b++) {
                              if (val > arrOfInt[b]) {
                                    temp = arrOfInt[b];
                                    arrOfInt[b] = val;
                                    val = temp;
                              }
                        }
                  }
                  arrOfInt[a] = val;
            }
      }// eorunthis

      void traversal() {
            for (int a = 0; a < jumlahAngka; a++) {
                  System.out.print(arrOfInt[a] + " ");
            }
      }// eotraversal
}// eof