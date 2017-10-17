/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as;

/**
 *
 * @author srikanthkatti
 */
import java.util.Scanner;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.awt.event.*;

/**
 *
 * @author srikanthkatti
 */
 class send implements Runnable 
    {
     Scanner s=new Scanner(System.in);
     Thread t;
     send()
     {
         t=new Thread(this);
         t.start();
     }
public void run () 
{
  byte[] sendata=new byte[1024];
  while(true)
  {
try
{
  DatagramSocket ss =new DatagramSocket();
InetAddress ipa=InetAddress.getByName("192.168.2.7");
//InetAddress ipa1=InetAddress.getByName("192.168.2.6");
//System.out.print("srikanth: ");
String sent =s.next();
sent="Srikanth: "+sent;
sendata=sent.getBytes();
DatagramPacket sendPacket=new DatagramPacket(sendata,sendata.length,ipa,3000);
//DatagramPacket sendPacket1=new DatagramPacket(sendata,sendata.length,ipa1,3000);
ss.send(sendPacket);
//ss.send(sendPacket1);
ss.close();   
}

catch(Exception e)
{
    
}
    }
 }
 }
class receive implements Runnable
{
  Thread t;  
public void run () 
{
   byte[] receivedata =new byte[1024];
    while(true)
    {
   try
    {
        DatagramSocket cs =new DatagramSocket(3000);


DatagramPacket receivepacket=new DatagramPacket(receivedata,receivedata.length);

String mess1=null;
while(mess1==null)
{
 cs.receive(receivepacket);
 String mess=new String(receivepacket.getData());
 mess1=mess;
}
System.out.println(mess1);
cs.close();
    }   
   catch(Exception e)
           {
               
           }
}
}
receive()
{
   t=new Thread(this);
    t.start();
}
}

public class As {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        // TODO code application logic here
        //while(true)
        
        
        new receive();
        new send();
        
        
    }
    
}