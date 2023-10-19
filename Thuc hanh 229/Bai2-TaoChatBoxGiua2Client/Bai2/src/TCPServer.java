import java.io.*;
import java.net.*;
import java.util.Scanner;

class TCPServer{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        ServerSocket svr = null;
        Socket cl = null;
        BufferedReader inp = null;
        PrintWriter outp = null;

        String message;
        int port = 3456;
        try{

            svr = new ServerSocket(port);
            System.out.println("Start conversation");
            cl = svr.accept();

            inp = new BufferedReader(new InputStreamReader(cl.getInputStream()));//Đọc dữ liệu từ luồng đầu vào
            outp = new PrintWriter(cl.getOutputStream(), true);//Gửi dữ liệu đến luồng đầu ra của kết nối

            while(true){
                message = inp.readLine();
                System.out.println("Minh : " + message);
                System.out.print("Huân : ");
                String response = scanner.nextLine();
                outp.println(response);
                if(response.equalsIgnoreCase("bye")){
                    break;
                }
            }
        }catch(IOException ex){
            System.out.println(ex);
        }finally{
            try{
                inp.close();
                outp.close();
                cl.close();
                svr.close();
            }catch(IOException ex){
                System.out.println(ex);
            }
        }
    }
}