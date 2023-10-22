public class WumpusMap {
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLUMNS = 10;
    public static final int NUM_PITS = 98;
    private WumpusSquare[][] grid = new WumpusSquare[NUM_ROWS][NUM_COLUMNS];
    private int ladderC;
    private int ladderR;
    public int wumpusC;
    public int wumpusR;

    public void createMap(){
        for(int r = 0; r < NUM_ROWS; r++){
            for(int c = 0; c < NUM_COLUMNS; c++){
                grid[r][c] = new WumpusSquare();
            }
        }
        for(int i = 0; i < NUM_PITS; i++){
            int c = (int)(Math.random() * 10);
            int r = (int)(Math.random() * 10);

            if(grid[r][c].getPit())
                i--;
            else{    
                grid[r][c].setPit(true);
                try{grid[r - 1][c].setBreeze(true);}catch(Exception e){System.out.println(e);}
                try{grid[r + 1][c].setBreeze(true);}catch(Exception e){System.out.println(e);}
                try{grid[r][c - 1].setBreeze(true);}catch(Exception e){System.out.println(e);}
                try{grid[r][c + 1].setBreeze(true);}catch(Exception e){System.out.println(e);}

            }
        }

        boolean x = true;
        while(x){
            int c = (int)(Math.random() * 10);
            int r = (int)(Math.random() * 10);
            if(!grid[r][c].getPit()){
                grid[r][c].setGold(true);
                x = false;
            }

        }

        x = true;
        while(x){
            int c = (int)(Math.random() * 10);
            int r = (int)(Math.random() * 10);
            if(!grid[r][c].getPit() && !grid[r][c].getGold()){
                grid[r][c].setWumpus(true);
                x = false;
                wumpusC = c;
                wumpusR = r;
                try{grid[r - 1][c].setStench(true);}catch(Exception e){System.out.println(e);}
                try{grid[r + 1][c].setStench(true);}catch(Exception e){System.out.println(e);}
                try{grid[r][c - 1].setStench(true);}catch(Exception e){System.out.println(e);}
                try{grid[r][c + 1].setStench(true);}catch(Exception e){System.out.println(e);}

            }

        }

        x = true;
        while(x){
            int c = (int)(Math.random() * 10);
            int r = (int)(Math.random() * 10);
            if(!grid[r][c].getPit() && !grid[r][c].getWumpus() && !grid[r][c].getGold()){
                grid[r][c].setLadder(true);
                ladderC = c;
                ladderR = r;
                x = false;
               
            }

        }


    }

    public int getLadderCol(){return ladderC;}
    public int getLadderRow(){return ladderR;}
    public WumpusSquare getSquare(int col, int row){return grid[row][col];}

    public boolean isSolvable(int r, int c){
        try{
            if(grid[r][c].getChecked() || grid[r][c].getPit()){
                return false;
            }
            if(grid[r][c].getGold()){
                grid[r][c].setChecked(true);
                return true;
            }
            else{
                grid[r][c].setChecked(true);
                return (isSolvable(r + 1, c) || isSolvable(r - 1, c) || isSolvable(r, c + 1) || isSolvable(r, c - 1));

            }
        }
        catch(Exception e){
            return false;
        }
    }

    public String toString(){
        String ret = "";
        for(WumpusSquare[] r: grid){
            for(WumpusSquare c: r){
                ret += c.toString();
            }
            ret += "\n";
        }
        return ret;
    }
}
