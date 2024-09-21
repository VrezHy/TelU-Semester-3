import java.util.*;

class mengecekPrima {
      public boolean diPrima(int angka){
            if (angka <= 1) {
                  return false;
            }
            for (int i = 2; i <= 2; i++) {
                  if (angka % i == 0) {
                        return false;
                  }
            }
            return true;
      }
      public void cekBil(int angka) {
            if(diPrima(angka)){
                  System.out.println("Prima");
            } else {
                  System.out.println("Bukan Prima");
            }
      }
}

class runPrima {
      public static void main(String[] args){
            Scanner input = new Scanner(System.in);
            mengecekPrima mp = new mengecekPrima();

            System.out.print("Masukkan Bilangan : ");
            int angka = input.nextInt();
            mp.cekBil(angka);
            input.close();
      }
}
