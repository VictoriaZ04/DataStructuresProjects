import java.io.*;
import java.net.*;

public class TTT_Server_Main
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket serverSocket = new ServerSocket(8001);
			Game_Data game = new Game_Data(Game_Data.WAITING_FOR_O);
			
			// x connect Code
			Socket xconnectionToClient = serverSocket.accept();
			ObjectOutputStream xos = new 
				ObjectOutputStream(xconnectionToClient.getOutputStream());
			ObjectInputStream xis = new 
				ObjectInputStream(xconnectionToClient.getInputStream());
			
			xos.writeObject(
				new Command_From_Server(Command_From_Server.CONNECTED_AS_X,game));
			xos.reset();
			
			Thread t = new Thread(new Servers_Listener(xos,xis,game,'X'));
			t.start();
			
			System.out.println("X has connected");
			
			// o connect Code
			Socket oconnectionToClient = serverSocket.accept();
			ObjectOutputStream oos = new 
				ObjectOutputStream(oconnectionToClient.getOutputStream());
			ObjectInputStream ois = new 
				ObjectInputStream(oconnectionToClient.getInputStream());
			
			oos.writeObject(new Command_From_Server(Command_From_Server.CONNECTED_AS_O,game));
			oos.reset();
			
			t = new Thread(new Servers_Listener(oos,ois,game,'O'));
			t.start();
			
			System.out.println("O has connected");
			
			game.setStatus(game.PLAYING);
			game.setTurn('X');
			
			Command_From_Server a =
				new Command_From_Server(Command_From_Server.UPDATE_GAME,game);
		
			xos.writeObject(a);
			xos.reset();
			oos.writeObject(a);
			oos.reset();
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e.getMessage());
			e.printStackTrace();
		}
	}
}