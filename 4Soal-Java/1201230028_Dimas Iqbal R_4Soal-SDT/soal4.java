import java.util.*;

class faktorBagi {
      public boolean bilPositif(int angka) {
            int pembagian = 0;
            for (int i = 1; i <= angka / 2; i++) {
                  if (angka % i == 0) {
                        pembagian += i;
                  }
            }
            return pembagian == angka;
      }

      public void stringBilangan(int angka) {
            if (bilPositif(angka)) {
                  System.out.println("Sempurna");
            } else {
                  System.out.println("Tidak sempurna");
            }
      }
}

class faktorFaktor {
      public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            faktorBagi bp = new faktorBagi();
            System.out.print("Masukkan Bilangan : ");
            int angka = input.nextInt();
            bp.stringBilangan(angka);
            input.close();
      }
}