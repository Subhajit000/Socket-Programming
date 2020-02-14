import java.net.*;
class ShowMyIp
{
    public static void main(String[] args) throws UnknownHostException
    {
        InetAddress add= InetAddress.getLocalHost();
        System.out.println(add);
    }
}