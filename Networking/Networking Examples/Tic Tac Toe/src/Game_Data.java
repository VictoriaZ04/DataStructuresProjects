import java.io.Serializable;

public class Game_Data implements Serializable
{
	private int status 							= 0;
	private char turn 							= 'X';
	public static final int WAITING_FOR_O 		= 0;
	public static final int WAITING_RESTART_O 	= 6;
	public static final int WAITING_RESTART_X 	= 7;
	public static final int PLAYER_LEFT			= 8;
	public static final int PLAYING				= 1;
	public static final int X_WINS 				= 5;
	public static final int O_WINS 				= 2;
	public static final int CAT 				= 4;
	private char[][] board						= null;
	
	public Game_Data(int status)
	{
		this.status = status;
		turn = 'X';
		board = new char[3][3];
		for(int r=0;r<board.length; r++)
			for(int c=0; c<board[0].length; c++)
				board[r][c]=' ';
	}
	
	public void update(Game_Data game)
	{
		this.status = game.getStatus();
		turn = game.getTurn();
		for(int r=0;r<board.length; r++)
			for(int c=0; c<board[0].length; c++)
				board[r][c]=game.getSpot(r,c);
	}
	
	public char board(int r, int c)
	{
		if(r<0 || c<0 || c>=getNumberOfCols() || r>=getNumberOfRows())
			return '*';
		else
			return board[r][c];
	}
	
	public boolean changeSpot(int r, int c, char letter)
	{
		if(r<0 || c<0 || c>=getNumberOfCols() || r>=getNumberOfRows()
			|| board[r][c]!=' ')
			return false;
		else
		{
			board[r][c]=letter;
			changeTurns();
			updateStatus();
			return true;
		}
	}
	
	public int getStatus()
	{	return status;	}
	
	public char getTurn()
	{	return turn;	}
	
	public void changeTurns()
	{
		if(getTurn()=='X')
			setTurn('O');
		else
			setTurn('X');
	}
	
	public void setStatus(int status)
	{
		this.status = status;	}
	
	public void setTurn(char turn)
	{	this.turn = turn;	}
	
	public char getSpot(int r, int c)
	{	return board[r][c];	}
	
	public void setSpot(int r, int c, char letter)
	{	board[r][c] = letter;	}
	
	public void reset()
	{
		turn = 'X';
		status = PLAYING;	
		board = new char[3][3];
		for(int r=0;r<board.length; r++)
			for(int c=0; c<board[0].length; c++)
				board[r][c]=' ';
	}
	
	public int getNumberOfRows()
	{
		return board.length;
	}
	
	public int getNumberOfCols()
	{
		return board[0].length;
	}
	
	public boolean isCat()
	{
		if(board[0][0] !=' ' && board[0][1] !=' ' && board[0][2] !=' '
			&& board[1][0] !=' ' && board[1][1] !=' ' && board[1][2] !=' '
			&& board[2][0] !=' ' && board[2][1] !=' ' && board[2][2] !=' '
			&& !isWinner('X') && !isWinner('O'))
			return true;
		else
			return false;
	}
	
	public void updateStatus()
	{
		if(isWinner('X'))
		{
			setStatus(Game_Data.X_WINS);
			System.out.println("X wins");
		}
		else if(isWinner('O'))
		{
			setStatus(Game_Data.O_WINS);
			System.out.println("O wins");
		}
		else if(isCat())
			setStatus(Game_Data.CAT);
		else
			setStatus(Game_Data.PLAYING);
	}
	
	public boolean isWinner(char letter)
	{
		if((board[0][0] ==letter && board[0][1] ==letter && board[0][2] ==letter) 
		|| (board[1][0] ==letter && board[1][1] ==letter && board[1][2] ==letter)
		|| (board[2][0] ==letter && board[2][1] ==letter && board[2][2] ==letter)
			
		|| (board[0][0] ==letter && board[1][0] ==letter && board[2][0] ==letter)
		|| (board[0][1] ==letter && board[1][1] ==letter && board[2][1] ==letter)
		|| (board[0][2] ==letter && board[1][2] ==letter && board[2][2] ==letter)
		
		|| (board[0][0] ==letter && board[1][1] ==letter && board[2][2] ==letter)
		|| (board[0][2] ==letter && board[1][1] ==letter && board[2][0] ==letter))
			return true;
		else
			return false;
	}
}
