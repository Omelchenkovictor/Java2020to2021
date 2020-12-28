import java.io.*;

public class Main {

    public static void main(String[] args) {
        int n = 5, clock = 0;
        try {
            FileReader fr = new FileReader("C:\\Java\\projects\\Zadach5-b\\src\\Data.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] arr = line.split(" ");
            int max = 0;
            while (clock < arr.length) {
                 if (Integer.parseInt(arr[clock]) > max) {
                     max = Integer.parseInt(arr[clock]);
                     if ((clock + 1)%n == 0 ) {
                         try {
                             OutputStream writer = new FileOutputStream("C:\\Java\\projects\\Zadach5-b\\src\\Out.txt");
                             String text = String.format("%d", max);
                             //System.out.format("%d", max);
                             writer.write(max);
                             writer.close();
                         }
                         catch(IOException ex){

                             System.out.println(ex.getMessage());
                         }
                     }
                     //System.out.println(clock);
                 }
                clock ++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("finished");

    }
}
