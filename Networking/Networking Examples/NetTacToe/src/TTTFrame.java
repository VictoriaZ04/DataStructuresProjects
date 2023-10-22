import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;

public class TTTFrame extends JFrame implements KeyListener {
    private String text = "";
    private char player ='x';
    private char turn = 'x';
    private GameData gameData = null;
    private ObjectOutputStream oos;
    public TTTFrame(GameData gameData, ObjectOutputStream oos)
    {
        super("TTT Game");
        this.gameData = gameData;
        this.oos = oos;
        addKeyListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400,460);
        setAlwaysOnTop(true);
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman",Font.BOLD,30));
        g.drawString(text,20,50);

        g.setColor(Color.RED);
        for(int y =0;y<=1; y++)
            g.drawLine(0,(y+1)*133+60,getWidth(),(y+1)*133+60);
        for(int x =0;x<=1; x++)
            g.drawLine((x+1)*133,60,(x+1)*133,getHeight());

        for(int r=0; r<gameData.getGrid().length; r++)
            for(int c=0; c<gameData.getGrid().length; c++)
            {
                if(gameData.getGrid()[r][c] == 'x')
                {
                    g.drawLine(c*133,r*133+60,(c+1)*133,(r+1)*133+60);
                    g.drawLine((c+1)*133,r*133+60,(c)*133,(r+1)*133+60);
                }
                else if(gameData.getGrid()[r][c] == 'o')
                {
                    g.drawOval(c*133+10,r*133+60+10,133-20,133-20);
                }
            }

    }


    public void setText(String text) {
        this.text = text;
        repaint();
    }

    public char getPlayer() {
        return player;
    }

    public void setPlayer(char player) {
        this.player = player;
    }

    public char getTurn() {
        return turn;
    }

    public void setTurn(char turn) {
        this.turn = turn;
    }

    public void makeMove(int c, int r, char letter)
    {
        gameData.getGrid()[r][c] = letter;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("typed"+e.getKeyChar());
        try {
            switch (e.getKeyChar()) {
                case '1':
                    oos.writeObject(new CommandFromClient(CommandFromClient.MOVE,"0,0"));
                    break;
                case '2':
                    oos.writeObject(new CommandFromClient(CommandFromClient.MOVE,"1,0"));
                    break;
                case '3':
                    oos.writeObject(new CommandFromClient(CommandFromClient.MOVE,"2,0"));
                    break;
                case '4':
                    oos.writeObject(new CommandFromClient(CommandFromClient.MOVE,"0,1"));
                    break;
                case '5':
                    oos.writeObject(new CommandFromClient(CommandFromClient.MOVE,"1,1"));
                    break;
                case '6':
                    oos.writeObject(new CommandFromClient(CommandFromClient.MOVE,"2,1"));
                    break;
                case '7':
                    oos.writeObject(new CommandFromClient(CommandFromClient.MOVE,"0,2"));
                    break;
                case '8':
                    oos.writeObject(new CommandFromClient(CommandFromClient.MOVE,"1,2"));
                    break;
                case '9':
                    oos.writeObject(new CommandFromClient(CommandFromClient.MOVE,"2,2"));
                    break;
                case 'r':
                    setText("Waiting for restart from "+other());
                    oos.writeObject(new CommandFromClient(CommandFromClient.RESTART,""));
                    break;
            }
        }
        catch(Exception ex)
        {}
    }

    public void reset()
    {
        gameData.reset();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public char other()
    {
        if(player=='x')
            return 'o';
        else
            return 'x';
    }
}
