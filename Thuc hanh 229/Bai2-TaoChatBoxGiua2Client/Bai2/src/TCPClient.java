import java.io.*;
import java.net.*;

class TCPClient{

    public static void main(String[]args){
        Socket cl = null;
        BufferedReader inp = null, key = null;
        PrintWriter outp = null;
        String ipServer = "127.0.0.1";
        int portServer = 3456;
        String message;
        try{

            cl = new Socket(ipServer, portServer);
            //InputStreamReader : Lớp này có tác dụng để đọc dữ liệu từ 1 InputStream và chuyển nó thành dữ liệu ký tự
            //characters) bằng cách sử dụng 1 bộ giải mã decoder

            inp = new BufferedReader(new InputStreamReader(cl.getInputStream()));
            outp = new PrintWriter(cl.getOutputStream(), true);//set true đảm bảo dữ liệu sẽ được gửi đi , k còn nằm trong bộ đệm
            key = new BufferedReader(new InputStreamReader(System.in));
            //Ghi du lieu den luong dau ra cua may chu

            while(true){
                System.out.print("Minh : ");
                message = key.readLine();
                outp.println(message);
                String response = inp.readLine();
                System.out.println("Huân : " + response);

                if(message.equalsIgnoreCase("bye")) {
                    return;
                }
            }
        }catch(IOException ex){
            System.out.print(ex);
        }finally{
            try{
                key.close();
                inp.close();
                outp.close();
                cl.close();
            }catch(IOException ex){
                System.out.print(ex);
            }
        }
    }
}