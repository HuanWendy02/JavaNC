import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;

class TCPServer {
  public static void main(String[] args) {
    ServerSocket svr = null;
    Socket cl = null;
    BufferedReader inp = null;
    PrintWriter outp = null;
    int pserver = 3456;
    String s;
    try {
      svr = new ServerSocket(pserver);
      System.out.println("Server đã săn sang.");
      cl = svr.accept();

      inp = new BufferedReader(new InputStreamReader(cl.getInputStream()));
      outp = new PrintWriter(cl.getOutputStream(), true);

      s = inp.readLine();
      System.out.println(s);
      String [] tokens = s.split("\\s+");
      int sum = 0;
      int [] receivedArray = new int[tokens.length];
      for (int i = 0 ; i < tokens.length ; i++){
        receivedArray[i] = Integer.parseInt(tokens[i]);
        sum+=receivedArray[i];
      }
      Arrays.sort(receivedArray);

      String str = "";
      str = str.concat(String.valueOf("Sum " + sum));
      str = str.concat("\nMảng đã sắp xếp tăng dần: ");
      for (int i = 0 ; i <  receivedArray.length ; i++){
       str =  str.concat(String.valueOf(receivedArray[i])).concat(" ");
      }
      outp.println(str);
      /*
      Note : Nếu đặt dấu xuống dòng vào giữa chuỗi trong biến str ,sau đó gọi outp.println(str) , thì PrintWriter
      tự động thêm 1 dòng trống dữ liệu khi nó gửi đi , làm cho máy khách không đọc được dữ liệu khi nó gặp được dòng
      trống đầu, cách khắc phục là sủ dụng print thay vì println để gửi chuỗi dữ liệu cho máy khách , sau đó gửi 1 dòng
      trống sau chuỗi dữ liệu
       */
    } catch (IOException e) {
      System.out.println(e);
    } finally {
      try {
        inp.close();
        outp.close();
        cl.close();
        svr.close();
      } catch (IOException ex) {
        System.out.println(ex);
      }
    }
  }
}