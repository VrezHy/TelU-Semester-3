import java.util.Scanner;

//programmerLegend
class programmerLegend {
      public static double hitungTotalKekuatan(double logicalPower, double bugTracingPower, double endurancePower) {
            return (2 * logicalPower) + (3 * bugTracingPower) - (0.5 * endurancePower);
      }

      public static void main(String[] args) {
            Scanner inp = new Scanner(System.in);

            System.out.print("Masukkan jumlah Programmer : ");
            int N = inp.nextInt();

            for (int i = 1; i <= N; i++) {
                  System.out.println("Programmer " + i + " : ");
                  System.out.print("Masukkan Logical Power : ");
                  int logicalPower = inp.nextInt();
                  System.out.print("Masukkan Bug Tracing Power : ");
                  int bugTracingPower = inp.nextInt();
                  System.out.print("Masukkan Endurance Power : ");
                  int endurancePower = inp.nextInt();
                  
                  double totalKekuatan = hitungTotalKekuatan(logicalPower, bugTracingPower, endurancePower);
                  System.out.print("Total kekuatan Programmer " + i + " = "+ totalKekuatan);
                  System.out.println();
            }
            inp.close();
      }

}