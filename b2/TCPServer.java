//TCPServer.java
import java.io.*;
import java.net.*;
import java.util.*;
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
int sum;
int N,i;
int[] a;
StringTokenizer  stk;
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
stk=new StringTokenizer(s);
N=stk.countTokens();
a=new int[N];
i=0;
while(stk.hasMoreTokens())
{
a[i]=Integer.parseInt(stk.nextToken().trim());
++i;
}
sum=0;
for(i=0;i<N;i++)
   sum+=a[i];
System.out.println("Tong day so S="+sum);
outp.println(sum);
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
