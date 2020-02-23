import java.io.*;
import java.net.*;

public class MessageServer
{
    public static void main(String[] args)throws IOException {

        String fromClnt;

        ServerSocket servSock = null;
        try
        {
            servSock = new ServerSocket(2021);
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

            BufferedReader inFromClient =new BufferedReader(new InputStreamReader(clntSock.getInputStream()));
            fromClnt = inFromClient.readLine();

            DataOutputStream outToClient = new DataOutputStream(clntSock.getOutputStream());
            outToClient.writeBytes("Message from Client: "+ fromClnt + " " + "Welcome to the server");
            outToClient.close();
            clntSock.close();
        }


    }
}