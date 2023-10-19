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
String s="";
int i,N;
String[]  ds;
try{
cl=new Socket(ipsvr,psvr);
inp=new BufferedReader(new InputStreamReader(cl.getInputStream()));
outp=new PrintWriter(cl.getOutputStream(), true);
while(true)
{
key=new BufferedReader(new InputStreamReader(System.in));
System.out.print("Nhap day so N=");
N=Integer.parseInt(key.readLine());
ds=new String[N];
for(i=0;i<N;i++)
{
System.out.print("ds["+i+"]=");
ds[i]=key.readLine();
s=s+ds[i]+" ";
}
outp.println(s);
s=inp.readLine();
System.out.println("Tong day so S="+s);
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
