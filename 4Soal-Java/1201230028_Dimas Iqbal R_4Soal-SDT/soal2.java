import java.util.*;

class mencariGenap {
      int berapaGenap = 0;
      int genapBesar = 0;

      public void menghitungGenap() {
            Scanner input = new Scanner(System.in);

            while (true) {
                  int angka = input.nextInt();
                  if (angka == 0) {
                        break;
                  }
                  if (angka % 2 == 0) {
                        berapaGenap++;
                        if (angka > genapBesar) {
                              genapBesar = angka;
                        }
                  }
            }
            input.close();
      }

      public void tampilkanHasil() {
            System.out.println(berapaGenap + " " + genapBesar);
      }
}

class cariGenap {
      public static void main(String[] args){
            mencariGenap mg = new mencariGenap();

            System.out.print("Masukkan Bilangan : ");
            mg.menghitungGenap();
            System.out.print("Hasil akhir : ");
            mg.tampilkanHasil();
      }
}