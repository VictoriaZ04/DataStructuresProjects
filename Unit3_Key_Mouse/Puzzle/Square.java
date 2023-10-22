import java.awt.image.*;

public class Square {
    public int pos;
    public boolean empty;

    public Square(boolean empty){
        this.empty = empty;
    }

    public Square(boolean empty, int pos){
        this.pos = pos;
        this.empty = empty;
    }

    public int getPos(){return pos;}
    public boolean getEmpty(){return empty;}

    public void setPos(int pos){this.pos = pos;}
    public void setEmpty(boolean empty){this.empty = empty;}


}
