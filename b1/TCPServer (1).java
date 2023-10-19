//TCPServer.java
import java.io.*;
import java.net.*;
class TCPServer{
public static void main(String[] args)
{
ServerSocket svr=null;
Socket cl=null;
InetAddress  addr;
int pclient;
String s;
int psvr=3456;
BufferedReader  inp=null;
PrintWriter  outp=null;
try{
svr=new ServerSocket(psvr);
System.out.println("Server da san sang!");
cl=svr.accept();
inp=new BufferedReader(new InputStreamReader(cl.getInputStream()));
outp=new PrintWriter(cl.getOutputStream(),true);
addr=cl.getInetAddress();
System.out.println("client: "+addr.getHostName()+", IP:"+addr.getHostAddress()+", port:"+cl.getPort());
while(true)
{
s=inp.readLine();
if (s.equalsIgnoreCase("quit"))
 break;
System.out.println("Chuoi nhan duoc:"+s);
s=s.toUpperCase();
outp.println(s);
}
}
catch(IOException e)
{
System.out.println(e);
}
finally{
try{
inp.close();
outp.close();
cl.close();
svr.close();
}
catch(IOException  ex)
{
System.out.println(ex);
}
}
}
}
