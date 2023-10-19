import java.net.*;
import java.io.*;
class UDPClient{
public static void main(String[] args)
{
try{
DatagramSocket  cl=new DatagramSocket();
String s="Hello";
byte[]  outBuff =s.getBytes();
DatagramPacket  senddata=new DatagramPacket(outBuff, outBuff.length, InetAddress.getByName("127.0.0.1"), 4444);
cl.send(senddata);
byte[]  inBuff=new byte[256];
DatagramPacket  recvdata=new DatagramPacket(inBuff, inBuff.length);
cl.receive(recvdata);
s= new String(recvdata.getData());
System.out.println(s);
}
catch(IOException e)
{}
}
}

