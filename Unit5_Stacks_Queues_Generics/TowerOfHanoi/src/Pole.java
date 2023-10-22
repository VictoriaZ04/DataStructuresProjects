package src;

import java.util.ArrayList;

public class Pole{
    ArrayList<Integer> pole = new ArrayList<Integer>();
    int id;
    public Pole(int id){
        this.id = id;
    }

    public void push(int x){
        pole.add(0, x);
    }

    public int peek(){
        if(pole.size() > 0)
            return pole.get(0);
        return -1;
    }

    public int pop(){
        if(pole.size() > 0)
            return pole.remove(0);
        return -1;
    }
    
    public int size(){
        return pole.size();
    }
    
    public int get(int i){
        if(pole.size() > i)
            return pole.get(i);
        return -1;
    }

    public int getID(){return id;}
}