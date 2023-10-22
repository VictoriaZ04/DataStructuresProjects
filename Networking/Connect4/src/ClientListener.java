import java.io.ObjectInputStream;

public class ClientListener implements Runnable{
    private ObjectInputStream ois =null;
    private TTTFrame frame = null;

    public ClientListener(ObjectInputStream ois, TTTFrame frame) {
        this.ois = ois;
        this.frame = frame;
    }

    public void run()
    {
        try
        {
            while(true) {
                CommandFromServer com = (CommandFromServer) (ois.readObject());

                if (com.getCommand() == CommandFromServer.CONNECTED_AS_P1) {
                    frame.setText("Waiting for Player 2 to connect");
                    frame.setPlayer('1');
                    frame.setTurn('1');
                }
                if (com.getCommand() == CommandFromServer.CONNECTED_AS_P2) {
                    frame.setText("Player 1's Turn");
                    frame.setPlayer('2');
                    frame.setTurn('1');
                }
                if (com.getCommand() == CommandFromServer.P1_TURN)
                {
                    frame.setTurn('1');
                    if(frame.getPlayer()=='1')
                        frame.setText("It is your turn");
                    else
                        frame.setText("X's Turn");
                }
                if (com.getCommand() == CommandFromServer.P2_TURN)
                {
                    frame.setTurn('1');
                    if(frame.getPlayer()=='1')
                        frame.setText("Player 2's Turn");
                    else
                        frame.setText("It is your turn");
                }
                if (com.getCommand() == CommandFromServer.MOVE)
                {
                    int c = Integer.parseInt(com.getData().substring(0,1));
                    int r = Integer.parseInt(com.getData().substring(2,3));
                    char letter = com.getData().charAt(3);
                    frame.makeMove(c,r,letter);
                }
                if (com.getCommand() == CommandFromServer.P1_WINS) {
                    frame.setText("Player 1 WINS!!! (R to restart)");

                }
                if (com.getCommand() == CommandFromServer.P2_WINS) {
                    frame.setText("Player 2 WINS!!! (R to restart)");

                }
                if (com.getCommand() == CommandFromServer.TIE) {
                    frame.setText("TIE GAME. (R to restart)");
                }
                if(com.getCommand() == CommandFromServer.RESTART)
                    frame.reset();
            }
        }
        catch(Exception e)
        {
            System.out.println("Error");
            System.exit(0);
        }
    }
}
