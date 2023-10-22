public class WumpusSquare {
    private boolean gold = false;
    private boolean ladder = false;
    private boolean pit  = false;
    private boolean breeze = false;
    private boolean wumpus = false;
    private boolean deadWumpus = false;
    private boolean stench = false;
    private boolean checked = false;

    private boolean visited = false;

    public boolean getGold(){return gold;}
    public boolean getLadder(){return ladder;}
    public boolean getPit(){return pit;}
    public boolean getBreeze(){return breeze;}
    public boolean getWumpus(){return wumpus;}
    public boolean getDeadWumpus(){return deadWumpus;}
    public boolean getStench(){return stench;}
    public boolean getVisited(){return visited;}


    public boolean getChecked(){return checked;}

    public void setGold(boolean c){gold = c;}
    public void setLadder(boolean c){ladder = c;}
    public void setPit(boolean c){pit = c;}
    public void setBreeze(boolean c){breeze = c;}
    public void setWumpus(boolean c){wumpus = c;}
    public void setDeadWumpus(boolean c){deadWumpus = c;}
    public void setStench(boolean c){stench = c;}
    public void setVisited(boolean c){visited = c;}

    public void setChecked(boolean c){checked = c;}


    public String toString(){
        if(getGold())
            return "G";
        else if(getLadder())
            return "L";
        else if(getPit())
            return "P";
        else if(getWumpus())
            return "W";
        else if(getDeadWumpus())
            return "D";
        return "*";
    }

}
