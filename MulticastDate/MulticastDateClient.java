
import java.io.*;
import java.net.*;
import java.util.Date;

public class MulticastDateClient
{
    public static void main(String[] args)throws IOException
    {
        MulticastSocket socket = new MulticastSocket(1313);
        InetAddress group = InetAddress.getByName("230.0.0.1");
        socket.joinGroup(group);    //client joining the group
        for(int i=0;i<100;i++)
        {
            byte[] buf = new byte [256];    //byte array individual elements having size in bytes
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String received = new String(packet.getData());
            System.out.println("Currrent server time: "+received);
        }
        socket.leaveGroup(group);
        socket.close();
    }
}