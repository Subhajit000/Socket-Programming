import java.io.*;
import java.net.*;

class StringCaseChangeserver
{
    public static void main(String[] args)throws Exception
    {
        String clientstr;
        String capitalstr;
        ServerSocket servSock = new ServerSocket(2345);
        while(true)
        {
            Socket connectionSocket = servSock.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientstr = inFromClient.readLine();
            capitalstr = clientstr.toUpperCase() + '\n';
            outToClient.writeBytes(capitalstr);
            inFromClient.close();
            outToClient.close();
            connectionSocket.close();
            
        }
        
    }
}