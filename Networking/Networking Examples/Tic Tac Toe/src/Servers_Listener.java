import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Servers_Listener implements Runnable
{
	private ObjectInputStream is;
	private char player = '-';
	private static ArrayList<ObjectOutputStream> osList = new ArrayList<ObjectOutputStream>();
	private ObjectOutputStream os;
	private Game_Data game;
	
	public Servers_Listener(ObjectOutputStream os, ObjectInputStream is,
			Game_Data game, char player)
	{
		this.is			= is;
		this.os			= os;
		this.game 		= game;
		this.player 	= player;
		osList.add(os);
	}
	
	public ObjectInputStream getIS()
	{	return is;	}
	
	public static ArrayList<ObjectOutputStream> getOSList()
	{	return osList;	}
	
	public Game_Data getGame()
	{	return game;	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				Command_To_Server x = (Command_To_Server)is.readObject();
				
				if(game.getStatus()==Game_Data.PLAYING)
				{
					if(x.getCommand()==Command_To_Server.MOVE 
						&& player ==game.getTurn())
						game.changeSpot(x.getRow(),x.getCol(),player);
				}
				else
				{
					if(x.getCommand()==Command_To_Server.NEW_GAME)
					{
						if(game.getStatus()==Game_Data.X_WINS 
							|| game.getStatus()==Game_Data.O_WINS
							|| game.getStatus()==Game_Data.CAT)
						{
							if(player == 'X')
								game.setStatus(Game_Data.WAITING_RESTART_O);
							else
								game.setStatus(Game_Data.WAITING_RESTART_X);
						}
						else if(game.getStatus()==Game_Data.WAITING_RESTART_X 
							&& player=='X')
							game.reset();
						else if(game.getStatus()==Game_Data.WAITING_RESTART_O 
							&& player=='O')
							game.reset();
					}
				}
				
				for(ObjectOutputStream tempOS:osList)
				{
					Command_From_Server a =
						new Command_From_Server(Command_From_Server.UPDATE_GAME,game);
					tempOS.writeObject(a);
					tempOS.reset();
				}
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in Server's Listener: "+ e.getMessage());
			game.setStatus(Game_Data.PLAYER_LEFT);
			for(ObjectOutputStream tempOS:osList)
			{
				try
				{
					Command_From_Server a =
						new Command_From_Server(Command_From_Server.UPDATE_GAME,game);
					tempOS.writeObject(a);
				}
				catch(Exception ex)
				{}
			}
			e.printStackTrace();
		}
		
	}
}


