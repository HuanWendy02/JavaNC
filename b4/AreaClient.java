//AreaClient.java
import java.io.*;
import java.net.*;
class AreaClient{
public static void main(String[] args)
{
Socket cl=null;
BufferedReader inp=null, key=null;
PrintWriter  outp=null;
String  ipsvr="127.0.0.1";
int  psvr=6666;
String  r, S;
try{
cl=new Socket(ipsvr, psvr);
inp=new BufferedReader(new InputStreamReader(cl.getInputStream()));
outp=new PrintWriter(cl.getOutputStream(), true);
key=new BufferedReader(new InputStreamReader(System.in));
while(true)
{
System.out.print("Nhap ban kinh r=");
r=key.readLine();
outp.println(r);
if(r.equalsIgnoreCase("Q"))
   break;
S=inp.readLine();
System.out.println("Dien tich S="+S);
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
