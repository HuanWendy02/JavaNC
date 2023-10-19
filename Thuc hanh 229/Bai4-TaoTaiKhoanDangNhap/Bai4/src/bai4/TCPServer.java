package bai4;

import static bai4.HandleData.handleDataFromClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Doan Huu Minh
 */
public class TCPServer {
    public static void main(String[] args) {
        ServerSocket srs = null;
        BufferedReader inp = null;//Doc du lieu tu may khach gui den 
        PrintWriter outp = null;//Nhan du lieu tu may khach 
        Socket cl = null;
        int port = 3456;
        
        try{
            srs = new ServerSocket(port);
            System.out.println("Start server");
            //Cho phep may khach truy cap den may chu 
            cl = srs.accept();
            inp = new BufferedReader(new InputStreamReader(cl.getInputStream()));
            outp = new PrintWriter(cl.getOutputStream() ,  true);
            
            String request = inp.readLine();
            System.out.println("Data from client " + request);
            //Doc du lieu tu may khach and xu ly 
            boolean checkLogin = handleDataFromClient(request);
            
            //Neu thanh cong gui ve success cho client con that bai gui ve faill
            if(checkLogin){
                outp.println("success");
            }else{
                outp.println("fail");
            }
        }catch(IOException ex){
            System.out.println(ex);
        }finally{
            try{
               inp.close();
               outp.close();
               srs.close();
               cl.close();
            }catch(IOException ex){
            System.out.println(ex);
            }
        }  
        
        
    }
}
