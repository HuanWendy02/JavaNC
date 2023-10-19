//AreaServer.java
import java.io.*;
import java.net.*;
class NewThreadServer    extends Thread
{
private Socket  cl=null;
private BufferedReader  inp;
private PrintWriter  outp;
private double r, area;
int   count;
InetAddress  addr;
int  pclient;
String s;
NewThreadServer(Socket  cl, int count)
{
super();
this.cl=cl;
this.count=count;
start();
}
public void run()
{
try{
inp=new BufferedReader(new InputStreamReader(cl.getInputStream()));
outp=new PrintWriter(cl.getOutputStream(),true);
addr=cl.getInetAddress();
pclient=cl.getPort();
while(true)
{
s=inp.readLine();
if(s.equalsIgnoreCase("Q"))
{
  System.out.println("Client "+addr.getHostName()+" tai cong:"+pclient+" da ket thuc.");
   break;
}
r=Double.parseDouble(s);
area=3.14*r*r;
System.out.println(count+"\t"+addr.getHostName()+"\t"+addr.getHostAddress()+"\t"+pclient+"\t"+r+"\t"+area);
outp.println(area);
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
}
catch(IOException ex)
{
System.out.println(ex);
}
}
}
}
class AreaServer{
public static void main(String[] args)
{
Socket cl=null;
int count=0;
try{
ServerSocket  svr=new ServerSocket(6666);
System.out.println("Sever da san sang hoat dong!");
while(true)
{
cl=svr.accept();
if(cl!=null)
{
  new  NewThreadServer(cl, count);
}
count++;
}
}
catch(IOException e)
{}
}
}



