import java.io.*;
import java.net.*;

public class ObjectServer
{
	public static void main(String[] args)
	{
		try
		{
			// creates a socket where clients can connect wit a
			// given port number
			ServerSocket serverSocket = new ServerSocket(8001);
		
			// waits for a client to connect and makes a socket
			// for that connection
			Socket connectionToClient = serverSocket.accept();
			
			System.out.println("A client has connected");
			
			// sets up am output stream 
			// (The client should be setting up a input stream)
			ObjectOutputStream os = new 
				ObjectOutputStream(connectionToClient.getOutputStream());
				
			// sets up an input stream 
			// (The client should be setting up a output stream)
			ObjectInputStream is = new 
				ObjectInputStream(connectionToClient.getInputStream());	
			
			while(true)
			{
				// waits for client to send an object
				String text = (String)is.readObject();
				
				// if it gets MESSAGE it reads a String and echos it
				if(text.equals("MESSAGE"))
				{
					String message = (String)is.readObject();
					System.out.println("Received message: "+message);
					os.writeObject("Echo: "+message);
					os.reset();
				}
				// if it gets NUMBER it reads a Integer and echos it
				else if(text.equals("NUMBER"))
				{
					Integer num = (Integer)is.readObject();
					System.out.println("Received number: "+num);
					os.writeObject("Echo: "+num);
					os.reset();
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		
	}
}