import java.io.*;
import java.net.*;

class StringCaseChangeClient
{
    public static void main(String[] args)throws Exception
    {
        //Module 1 : sending to server
        String str;
        String modifiedStr;
        System.out.println("Enter the sentence: ");
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost",2345);  
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());   //sending from client to server

        //Module 2 : receiving from the server
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        str= inFromUser.readLine();
        outToServer.writeBytes(str+'\n');   //sending the sentence to the server byte by byte
        modifiedStr = inFromServer.readLine();
        System.out.println("From Server: "+modifiedStr);
        clientSocket.close();
    }

}