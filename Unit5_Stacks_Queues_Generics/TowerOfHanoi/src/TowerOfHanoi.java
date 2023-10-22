package src;

import java.awt.*;
import java.awt.image.*;

import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import java.awt.image.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.Scanner;

public class TowerOfHanoi extends JPanel implements KeyListener {
    private BufferedImage buffer;
    private int discs;
    Pole key1 = null;
    Pole key2 = null;
    Pole pole1 = new Pole(1);
    Pole pole2 = new Pole(2);
    Pole pole3 = new Pole(3);
    
    boolean win;
    int moves;

    public TowerOfHanoi(){
        super();

        Scanner sc = new Scanner(System.in);

        setSize(700,700);

        buffer = new BufferedImage(700, 700, BufferedImage.TYPE_4BYTE_ABGR);        

        System.out.print("How Many Discs Would You Like To Play With? (3 - 7): ");
        discs = sc.nextInt();

        for(int i = discs; i > 0; i--){
            pole1.push(i);
        }

        win = false;
        moves = 0;

        addKeyListener(this);

    }

    public void paint(Graphics g){
       
        Graphics bg = buffer.getGraphics();
        bg.setColor(Color.WHITE);
        bg.fillRect(0, 0, 700, 700);

        bg.setColor(Color.BLACK);
        for(int i = 1; i <= 3; i++){
            if(key1 != null && key1.getID() == i)
                bg.setColor(Color.RED);

            bg.fillRect(160 * i, 180, 10, 720);

            bg.setColor(Color.BLACK);
            
        }
        
        int height = 480/discs;

        bg.setColor(Color.MAGENTA);

        for(int i = 0; i < pole1.size(); i++){
            
            int width = ((pole1.get(i)) * 24);
            bg.fillRect(160 - (width - 10)/2, i * height + 200 + ((discs - pole1.size()) * height), width, height);
        }
        for(int i = 0; i < pole2.size(); i++){
            
            int width = ((pole2.get(i)) * 24);
            bg.fillRect(320 - (width - 10)/2, i * height + 200 + ((discs - pole2.size()) * height), width, height);
        }
        for(int i = 0; i < pole3.size(); i++){
            
            int width = ((pole3.get(i)) * 24);
            bg.fillRect(480 - (width - 10)/2, i * height + 200 + ((discs - pole3.size()) * height), width, height);
        }

        if(win){
            bg.setColor(Color.GREEN);

            bg.setFont(new Font("Times New Roman", Font.BOLD, 40));

            bg.drawString("You Won in " + moves + " moves!", 200, 330);
            
        }

        g.drawImage(buffer, 0, 0, null);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        if(key == '1'){
            if(key1 == null)
                key1 = pole1;
            else
                key2 = pole1;
        } 
        if(key == '2'){
            if(key1 == null)
                key1 = pole2;
            else
                key2 = pole2;

        }  
        if(key == '3'){
            if(key1 == null)
                key1 = pole3;
            else
                key2 = pole3;

        }  
        
        if(key2 != null && !win){
            
            if((key1.peek() < key2.peek() || key2.peek() == -1) && key1.peek() != -1){
                key2.push(key1.pop());
                moves++;
                
            }
            
            key1 = null;
            key2 = null;
        }
        
        if(pole3.size() == discs)
            win = true;

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    public boolean checkWin(){
        return pole3.size() == discs;
    }

   
    @Override
    public void addNotify() {

        super.addNotify();
        requestFocus();
    }

}
