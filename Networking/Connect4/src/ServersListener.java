import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ServersListener implements Runnable{
    private ObjectInputStream ois =null;
    private ObjectOutputStream oos =null;
    private static ArrayList<ObjectOutputStream> outputStreams = new ArrayList<>();
    private char player = '1';
    private static char turn = '1';
    private GameData gameData;
    private static boolean p1Restart, p2Restart;

    public ServersListener(GameData gameData,ObjectInputStream ois, ObjectOutputStream oos, char player) {
        this.ois = ois;
        this.oos = oos;
        this.gameData  =gameData;
        this.player = player;
        outputStreams.add(oos);
    }

    public void run()
    {
        try
        {
            while(true) {
                CommandFromClient com = (CommandFromClient) (ois.readObject());
                if (!gameData.isWinner('1') && !gameData.isWinner('2')
                        && !gameData.isCat()) {
                    if (com.getCommand() == CommandFromClient.MOVE && player == turn) {
                        int c = Integer.parseInt(com.getData().substring(0, 1));
                        int r = Integer.parseInt(com.getData().substring(2));
                        if (gameData.getGrid()[r][c] == ' ') {
                            gameData.getGrid()[r][c] = player;
                            for (ObjectOutputStream os : outputStreams)
                                os.writeObject(new CommandFromServer(CommandFromServer.MOVE, com.getData() + player));
                            if (turn == '1') {
                                turn = '2';
                                for (ObjectOutputStream os : outputStreams)
                                    os.writeObject(new CommandFromServer(CommandFromServer.P2_TURN, ""));
                            } else {
                                turn = '1';
                                for (ObjectOutputStream os : outputStreams)
                                    os.writeObject(new CommandFromServer(CommandFromServer.P1_TURN, ""));
                            }

                            if (gameData.isWinner('1'))
                                for (ObjectOutputStream os : outputStreams)
                                    os.writeObject(new CommandFromServer(CommandFromServer.P1_WINS, ""));
                            if (gameData.isWinner('2'))
                                for (ObjectOutputStream os : outputStreams)
                                    os.writeObject(new CommandFromServer(CommandFromServer.P2_WINS, ""));
                            if (gameData.isCat())
                                for (ObjectOutputStream os : outputStreams)
                                    os.writeObject(new CommandFromServer(CommandFromServer.TIE, ""));
                        }
                    }
                } else if (com.getCommand() == CommandFromClient.RESTART) {
                    if (player == '1') {
                        p1Restart = true;
                    } else {
                        p2Restart = true;
                    }

                    if (p1Restart && p2Restart) {
                        System.out.println("reset");
                        for (ObjectOutputStream os : outputStreams)
                            os.writeObject(new CommandFromServer(CommandFromServer.RESTART, ""));
                        gameData.reset();
                        turn = '1';
                        for (ObjectOutputStream os : outputStreams)
                            os.writeObject(new CommandFromServer(CommandFromServer.P1_TURN, ""));

                        p2Restart = p1Restart = false;
                    }

                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error");
            System.exit(0);
        }
    }
}
