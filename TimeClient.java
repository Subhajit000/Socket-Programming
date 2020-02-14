import java.io.*;
import java.net.*;
import java.util.Date;

public class TimeClient
{
    public static void main(String[] args)throws IOException
    {
        Socket timeSocket=null;
        ObjectInputStream timeIn=null;
        try
        {
            timeSocket=new Socket("localhost",1333);
            timeIn=new ObjectInputStream(timeSocket.getInputStream());
        }
        catch(UnknownHostException e)
        {
            System.out.println("Server 'localost' is unknown");
            System.exit(1);
        }
        catch(IOException e)
        {
            System.err.println("error during connection to localhost");
            System.exit(1);
        }
        try
        {
            Date serverDate=(Date)timeIn.readObject();
            System.out.println("Current server time: "+serverDate);
        }
        catch(ClassNotFoundException e)
        {
            System.err.println("Not an object returned");
            System.exit(1);
        }
        timeIn.close();
        timeSocket.close();
    }
}