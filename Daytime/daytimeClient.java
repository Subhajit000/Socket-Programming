import java.net.*;
import java.io.*;
import java.util.Date;

public class daytimeClient
{
	public static void main(String[] args)
	{
		Socket theSocket;
		String hostname;
		DataInputStream thetimeStream;
		if ( args.length>0)
		{
			hostname = args[0];
		}
		else
			hostname= "localhost";
		try
		{
			theSocket = new Socket(hostname,13);
			thetimeStream = new DataInputStream(theSocket.getInputStream());
			String theTime = thetimeStream.readLine();
			System.out.println("It is "+ theTime+ " at "+ hostname);
		}
		catch(UnknownHostException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
	}
}