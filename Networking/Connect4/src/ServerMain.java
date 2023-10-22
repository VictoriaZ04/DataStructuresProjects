import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain
{
    public static void main(String[] args) {
        try
        {
            GameData gameData = new GameData();
            ServerSocket socketSocket = new ServerSocket(8002);

            Socket socketToP1 = socketSocket.accept();

            ObjectInputStream oisP1 = new ObjectInputStream(socketToP1.getInputStream());
            ObjectOutputStream oosP1 = new ObjectOutputStream(socketToP1.getOutputStream());

            System.out.println("Player 1 has connected");

            Thread t = new Thread(new ServersListener(gameData,oisP1,oosP1,'1'));
            t.start();
            oosP1.writeObject(new CommandFromServer(CommandFromServer.CONNECTED_AS_P1,""));

            Socket socketToO = socketSocket.accept();
            ObjectInputStream oisO = new ObjectInputStream(socketToO.getInputStream());
            ObjectOutputStream oosO = new ObjectOutputStream(socketToO.getOutputStream());
            t = new Thread(new ServersListener(gameData,oisO,oosO,'o'));
            t.start();
            oosO.writeObject(new CommandFromServer(CommandFromServer.CONNECTED_AS_P2,""));
            oosP1.writeObject(new CommandFromServer(CommandFromServer.P1_TURN,""));


        }
        catch (Exception e)
        {}
    }
}
