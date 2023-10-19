import java.io.*;
import java.net.*;
class NewThread extends Thread
{
private int count;
private Socket cl=null;
private BufferedReader inp=null;//luong nhap
private PrintWriter outp=null;//luong xuat
NewThread(Socket cl, int count)
{
super();//Truy xuất cấu tử lớp Thread
this.cl=cl;
this.count=count;
start();
}
//cai dat phuong thuc run-Luong moi
public void run()
{
try{
//tao luong nhap /xuat cho socket cl
inp=new BufferedReader(new InputStreamReader(cl.getInputStream()));
outp=new PrintWriter(cl.getOutputStream(),true);
//Doc ban kinh gui toi tu client
double r=Double.parseDouble(inp.readLine().trim());
// lay dia chi client
InetAddress addrclient=cl.getInetAddress();
//lay so cong phia client
int portclient=cl.getPort();
//Tinh dien tich
double area=3.14*r*r;
//Hien thi
System.out.println("Luong thu:"+count+",
client:"+addrclient.getHostName()+
", ip:"+addrclient.getHostAddress()+",port:"+portclient+
", r="+r+",area:"+area);
//Gui dien tich ve cho client tuong ung
outp.println(area);
//ket thuc luong
inp.close();
outp.close();
cl.close();
}
catch(IOException e)
{
System.out.println(e);
}}}
class AreaThreadServer{
public static void main(String[] args)
{
int count;
ServerSocket svr=null;
Socket cl=null;
int portserver=3456;
try{
svr=new ServerSocket(portserver);
count=0;
while(true){
cl=svr.accept();
new NewThread(cl, count);
count++;
}}
catch(IOException e)
{
System.out.println(e);
}