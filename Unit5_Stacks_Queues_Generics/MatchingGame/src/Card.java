package src;

public class Card {
    public int card;
    public boolean flipped;
    public boolean exists;

    public Card(int card){
        this.card = card;
        this.flipped = false;
        this.exists = true;
    }

    public int getCard(){return card;}
    public boolean getFlipped(){return flipped;}
    public boolean exists(){return exists;}
    public void setExists(boolean exists){this.exists = exists;}
    public void setFlipped(boolean flipped){this.flipped = flipped;}
    public void setCard(int card){this.card = card;}

}
