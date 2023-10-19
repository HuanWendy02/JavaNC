//TCPServer.java
import java.io.*;
import java.net.*;
class TCPServer{
public static void main(String[] args)
{
ServerSocket   svr=null;
Socket cl=null;
BufferedReader  inp=null;
PrintWriter  outp=null;
InetAddress  addr;
int  pserver=3456;
String s;
int  pclient;
try{
svr=new ServerSocket(pserver);
System.out.println("Server đã săn sang.");
cl=svr.accept();
inp=new BufferedReader(new InputStreamReader(cl.getInputStream()));
outp=new PrintWriter(cl.getOutputStream(), true);
addr=cl.getInetAddress();
pclient=cl.getPort();
System.out.println("client:");
System.out.println("Name:"+addr.getHostName());
System.out.println("IP:"+addr.getHostAddress());
System.out.println("Port:"+pclient);
while(true)
{
s=inp.readLine();
if(s.equalsIgnoreCase("quit"))
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
catch(IOException ex)
{
System.out.println(ex);
}
}
}
}