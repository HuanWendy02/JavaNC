import java.io.*;
import java.net.*;
class areaClient{
public static void main(String[] args)
{
//Khai bao bien
Socket cl=null;
BufferedReader inp=null;//luong nhap
PrintWriter outp=null.//luong xuat
BufferedReader key=null;//luong nhap tu ban phim
String ipserver= "127.0.0.1";//Chuoi dia chi server
int portserver=3456; //dia chi cong server
String r; //ban kinh r la chuoi so
//Tao socket va ket noi toi server
try{
cl=new Socket(ipserver,portserver);
//tao luong nha/xuatp kieu ky tu cho socket
inp=new BufferedReader(new InputStreamReader(cl.getInputStream()));
outp=new PrintWriter(cl,getOutputStream(),true);
//tao luong nhap tu ban phim
key=new BufferedReader(new InputStreamReader(System.in));
//Nhap ban kinh r tu ban phim
System.out.print("r=");
r=key.readLine().trim();
//gui r toi server
outp.println(r);
//Nhan dien tich tra ve tu server va hien thi
System.out.println("Area:"+inp.readLine());
//ket thuc chuong trinh
if(inp!=null)
inp.close();
if(key!=null)
key.close();
if(outp!=null)
outp.close();
if(cl!=null)
cl.close();
}
cacth(IOException e)
{
System.out.println(e);
}