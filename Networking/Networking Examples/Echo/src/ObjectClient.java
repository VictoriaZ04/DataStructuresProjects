import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ObjectClient
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		try
		{
			System.out.print("Enter the ip of the Echo Server: ");
			String ip = keyboard.next();
			// connects to the server using the listed ip
			// and port
			Socket connectionToServer 
				= new Socket(ip,8001);
			
			// sets up an input stream 
			// (The server should be setting up a output stream)
			ObjectInputStream is = new 
				ObjectInputStream(connectionToServer.getInputStream());
					
			// sets up am output stream 
			// (The server should be setting up a input stream)
			ObjectOutputStream os = new 
				ObjectOutputStream(connectionToServer.getOutputStream());
				
			while(true)
			{
				System.out.println("\nMessage Menu");
				System.out.println("1. Text");
				System.out.println("2. Number");
				System.out.print("Enter selection: ");
				int x = keyboard.nextInt();
				
				if(x==1)
				{
					keyboard.nextLine();
					System.out.print("Enter a message: ");
					String m = keyboard.nextLine();
					os.writeObject("MESSAGE");
					os.reset();
					os.writeObject(m);
					os.reset();
					String echo = (String)is.readObject();
					System.out.println("From server - "+ echo);
				}
				else if(x==2)
				{
					System.out.print("Enter a number: ");
					Integer i = keyboard.nextInt();
					os.writeObject("NUMBER");
					os.reset();
					os.writeObject(i);
					os.reset();
					String echo = (String)is.readObject();
					System.out.println("From server - "+ echo);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
	}
}