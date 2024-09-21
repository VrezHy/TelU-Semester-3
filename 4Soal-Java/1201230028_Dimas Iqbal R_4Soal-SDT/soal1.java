import java.util.*;

class soall1 {
      int negatif = 0;
      int positif = 0;

      public void hitungMasukan() {
            Scanner input = new Scanner(System.in);
            while (true) {
                  int angka = input.nextInt();
                  if (angka == 0) {
                        break;
                  }
                  if (angka > 0) {
                        positif++;
                  } else if (angka < 0) {
                        negatif++;
                  }
            }
            input.close();
      }

      public String statusNya() {
            if (negatif > positif) {
                  return "negatif";
            } else if (positif > negatif) {
                  return "positif";
            } else {
                  return "imbang";
            }
      }

      public void menampilkanHasil() {
            System.out.println(negatif + " " + positif + " " + statusNya());
      }

}

class mulaiRangkai {
      public static void main(String[] args) {
            soall1 r1 = new soall1();

            System.out.print("Masukkan Bilangan:");
            r1.hitungMasukan();
            System.out.print("Hasil Akhir : ");
            r1.menampilkanHasil();
      }
}
