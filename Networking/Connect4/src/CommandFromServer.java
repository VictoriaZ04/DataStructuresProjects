import java.io.Serializable;

public class CommandFromServer implements Serializable
{
    private int command;
    private String data ="";

    public static final int CONNECTED_AS_P1=0;
    public static final int CONNECTED_AS_P2=1;
    public static final int P1_TURN=2;
    public static final int P2_TURN=3;
    public static final int MOVE=4;
    public static final int P1_WINS=5;
    public static final int P2_WINS=6;
    public static final int TIE=7;
    public static final int RESTART=7;

    public CommandFromServer(int command, String data) {
        this.command = command;
        this.data = data;
    }

    public int getCommand() {
        return command;
    }

    public String getData() {
        return data;
    }
}
