import java.io.*;
import java.net.*;
import java.util.Scanner;

class TCPClient {
   public static void main(String[] args) {
      Socket cl = null;
      BufferedReader inp = null, key = null;
      PrintWriter outp = null;
      Scanner scanner = new Scanner(System.in);
      String ipserver = "127.0.0.1";
      int pserver = 3456;
      String s;
      try {
         cl = new Socket(ipserver, pserver);
         inp = new BufferedReader(new InputStreamReader(cl.getInputStream()));
         outp = new PrintWriter(cl.getOutputStream(), true);

         int n;
         System.out.println("Nhập số phần tử của mảng : ");
         n = scanner.nextInt();
         int[] array = new int[n];
         for (int i = 0; i < n; i++) {
            System.out.print("Phần tử a[" + (i + 1) + "] = ");
            array[i] = scanner.nextInt();
         }
         for(int item : array){
            String str = String.valueOf(item).concat(" ");
            outp.print(str);
         }
         outp.println();

         String response;
         while ((response = inp.readLine()) != null) {
            System.out.println(response);
         }
      } catch (IOException e) {
         System.out.println(e);
      } finally {
         try {
            inp.close();
            outp.close();
            cl.close();
         } catch (IOException ex) {
            System.out.println(ex);
         }
      }
   }
}
