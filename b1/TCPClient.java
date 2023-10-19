//TCPClient.java
import java.io.*;
import java.net.*;
class TCPClient{
public static void main(String[] args)
{
Socket  cl=null;
BufferedReader   inp=null, key=null;
PrintWriter  outp=null;
String   ipsvr="localhost";
int   psvr=3456;
String s;
try{
cl=new Socket(ipsvr,psvr);
inp=new BufferedReader(new InputStreamReader(cl.getInputStream()));
outp=new PrintWriter(cl.getOutputStream(), true);
while(true)
{
key=new BufferedReader(new InputStreamReader(System.in));
System.out.print("Nhap chuoi:");
s=key.readLine();
outp.println(s);
if(s.equalsIgnoreCase("quit"))
  break;
s=inp.readLine();
System.out.println("Chuoi nhan tu server:"+s);
}
}
catch(IOException e)
{
System.out.println(e);
}
finally{
try{
key.close();
inp.close();
outp.close();
cl.close();
}
catch(IOException ex)
{
System.out.println(ex);
}
}
}
}
