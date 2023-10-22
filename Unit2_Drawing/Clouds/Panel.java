package Clouds;

import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel{
    public Panel(){
        super();

        setSize(900,900);


    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,900,900);
        g.setColor(new Color(0,5,100));
        g.fillOval(25, 25, 600, 600);
        
        
        g.setColor(Color.WHITE);
        System.out.println("yeee");
        
        for(int j = 0; j < 5; j++){
            int x = (int)(Math.random() * 900);
            int y = (int)(Math.random() * 900);
            for(int i = 0; i < 100; i++){
                
                random(g, x + (i * 5), y);
            }
        }
        
        g.setColor(Color.GREEN);
        g.drawOval(25, 25, 600, 600);
    }

    public boolean random(Graphics g, int x, int y){
        try{
            g.fillRect(x, y, 1, 1);
        }
        catch(Exception e){
            System.out.println("yuyuy");
            return false;
        }
        for(int i = 1; i <= 3; i++){
            if((int)(Math.random() * (24)) == 0){
                random(g, x + (i * 2) - 1, y - (i * 2) - 1);
            }
            if((int)(Math.random() * (24)) == 0){
                random(g, x + (i * 2) - 1, y + (i * 2) - 1);
            }
            if((int)(Math.random() * (24)) == 0){
                random(g, x - (i * 2) - 1, y + (i * 2) - 1);
            }
            if((int)(Math.random() * (24)) == 0){
                random(g, x - (i * 2) - 1, y - (i * 2) - 1);
            }
            if((int)(Math.random() * (24)) == 0){
                random(g, x, y - (i * 2) - 1);
            }
            if((int)(Math.random() * (24)) == 0){
                random(g, x, y + (i * 2) - 1);
            }
            if((int)(Math.random() * (24)) == 0){
                random(g, x - (i * 2) - 1, y);
            }
            if((int)(Math.random() * (24)) == 0){
                random(g, x + (i * 2) - 1, y);
            }
    }
        
        return false;
    }

}
