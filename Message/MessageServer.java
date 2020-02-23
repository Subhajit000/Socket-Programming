import java.io.*;
import java.net.*;

public class MessageServer
{
    public static void main(String[] args)throws IOException {

        String fromClnt;

        ServerSocket servSock = null;
        try
        {
            servSock = new ServerSocket(2020);
        }
        catch(IOException e)
        {
            System.out.println("Could not connect to the port");
            System.exit(1);
        }

        Socket clntSock = null;
        while(true)
        {
            try{
                clntSock = servSock.accept();
            }
            catch(IOException e)
            {
                System.out.println("Could not connect");
                System.exit(1);
            }

            DataInputStream inFromClient =new DataInputStream(clntSock.getInputStream());
            fromClnt = (String) inFromClient.readUTF();

            DataOutputStream outToClient = new DataOutputStream(clntSock.getOutputStream());
            outToClient.writeUTF("Message from Client: "+ fromClnt + " " + "Welcome to the server");
            outToClient.close();
            clntSock.close();
        }


    }
}