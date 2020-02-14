import java.io.*;
import java.net.*;
import java.util.Date;

public class TimeServer
{
    public static void main(String[] args)throws IOException
    {
        ServerSocket servSock = null;
        try
        {
            servSock = new ServerSocket(1333); 
        }
        catch(IOException e)
        {
            System.err.println("Could not connect to 1313");
            System.exit(1);
        }
        Socket clntSock = null;  //thread for the server, client type for full duplex communication
        for(;;)
        {
            try
            {
                clntSock= servSock.accept();
            }
            catch(IOException e)
            {
                System.err.println("accept failed");
                System.exit(1);
            }
            ObjectOutputStream timeOut= new ObjectOutputStream(clntSock.getOutputStream());  //not servSock because it will be done by the thread of client type.
            timeOut.writeObject(new Date());
            timeOut.close();
            clntSock.close();
        }
    }
}