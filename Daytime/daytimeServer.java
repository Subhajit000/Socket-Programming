import java.io.*;
import java.net.*;
import java.util.Date;

public class daytimeServer
{
	public static final int daytimePort = 13;
	
	public static void main(String[] args)throws IOException
	{
		ServerSocket theServer;
		Socket theConnection;
		PrintStream p;
		try
		{
			theServer = new ServerSocket(daytimePort);
			try
			{
				while(true)
				{
					theConnection = theServer.accept();		
					p= new PrintStream(theConnection.getOutputStream());
					p.println(new Date());
					theConnection.close();
				}
			}
			catch(IOException e)
			{
				theServer.close();
				System.err.println(e);
			}
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
	}
}