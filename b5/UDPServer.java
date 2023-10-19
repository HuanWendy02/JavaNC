import java.net.*;
import java.io.*;
class UDPServer{
public static void main(String[] args)
{
try{
DatagramSocket  cl=new DatagramSocket(4444);
String s;
byte[]  inBuff=new byte[256];
DatagramPacket  recvdata=new DatagramPacket(inBuff, inBuff.length);
cl.receive(recvdata);
s= new String(recvdata.getData());
InetAddress addrclient=recvdata.getAddress();
int  pclient=recvdata.getPort();
System.out.println("Chuoi nhan duoc: "+s);
s=s.toUpperCase();
byte[]  outBuff =s.getBytes();
DatagramPacket  senddata=new DatagramPacket(outBuff, outBuff.length, addrclient, pclient);
cl.send(senddata);
System.out.println("Da gui chuoi "+s+" ve client.");
}
catch(IOException e)
{}
}
}

