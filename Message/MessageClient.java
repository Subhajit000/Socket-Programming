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
            clntSock = new Socket("localhost",2020);
        }
        catch(IOException e)
        {
            System.out.println("Cannot connect");
            System.exit(1);
        }
        
        DataOutputStream outToServer = new DataOutputStream(clntSock.getOutputStream());
        outToServer.writeUTF(str1+'\n');

        DataInputStream inFromServer = new DataInputStream(clntSock.getInputStream());
        str=(String) inFromServer.readUTF();
        
        System.out.println(str);
        clntSock.close();
    }
}