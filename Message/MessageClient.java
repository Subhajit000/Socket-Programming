import java.io.*;
import java.net.*;

public class MessageClient
{
    public static void  main(String[] args)throws IOException {
        
        Socket clntSock = null;
        String str;
        String str1= "Hello Server";

        try
        {
            clntSock = new Socket("localhost",2021);
        }
        catch(IOException e)
        {
            System.out.println("Cannot connect");
            System.exit(1);
        }
        
        DataOutputStream outToServer = new DataOutputStream(clntSock.getOutputStream());
        outToServer.writeBytes(str1+'\n');

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clntSock.getInputStream()));
        str= inFromServer.readLine();
        System.out.println(str);
        clntSock.close();
    }
}