
public class WumpusPlayer {
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    private int direction;
    private boolean arrow;
    private boolean gold;
    private int colPosition;
    private int rowPosition;

    public WumpusPlayer(){
        direction = 0;
    }

    public void setDirection(int dir){direction = dir;}
    public void setArrow(boolean arrow){this.arrow = arrow;}
    public void setGold(boolean gold){this.gold = gold;}
    public void setCol(int col){colPosition = col;}
    public void setRow(int row){rowPosition = row;}

    public int getDirection(){return direction;}
    public boolean getArrow(){return arrow;}
    public boolean getGold(){return gold;}
    public int getCol(){return colPosition;}
    public int getRow(){return rowPosition;}
    
}
