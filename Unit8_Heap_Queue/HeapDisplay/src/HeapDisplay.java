import java.awt.*;
import javax.swing.*;
import javax.swing.event.MouseInputListener;

import java.awt.image.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.geom.Ellipse2D;

import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Rectangle;



public class HeapDisplay extends JPanel implements MouseInputListener {


    private BufferedImage buffer;
    private BufferedImage buttonz;
    private Ellipse2D[][] buttons = new Ellipse2D[5][4];
    private Rectangle removeButton;
    MaxHeap<Integer> heap = new MaxHeap<Integer>();

    public HeapDisplay() throws IOException {
        setSize(900, 600); // width,height
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        buttonz = ImageIO.read(new File("src/buttonz.png"));


        for(int r = 0; r < 5; r++){
            for(int c = 0; c < 4; c++){
                buttons[r][c] = new Ellipse2D.Float(r * 40, c * 40, 40, 40);
            }
        }

        removeButton = new Rectangle(700, 10, 190, 75);

        addMouseListener(this);

        reset();

    }

    public void paint(Graphics g) {
        Graphics bg = buffer.getGraphics();
        
        bg.setColor(Color.BLACK);
        bg.fillRect(0, 0, 900, 600);
        bg.drawImage(buttonz, 0, 0, null);

        bg.setColor(Color.RED);
        bg.fillRoundRect(700, 10, 190, 75, 30, 30);

        bg.setFont(new Font("Times New Roman", Font.BOLD, 42));
        bg.setColor(Color.WHITE);
        bg.drawString("Remove", 720, 60);

        

     
        // 100 x 100 squares; 50 gap between; 30 on top; 20 on bottom

        int x = 25;
        bg.setColor(Color.GRAY);int 
        y = 50;
        if(heap.size() > 0){
            
            bg.fillRoundRect(400, 30, 70, 70, 30, 30);
            bg.setColor(Color.WHITE);
            bg.drawString(heap.get(0) + "", 400 + x, 30 + y);
        } if(heap.size() > 1){
            bg.setColor(Color.GRAY);
            bg.drawLine(435, 100, 235, 215);
            
            
            bg.fillRoundRect(200, 180, 70, 70, 30, 30);
            bg.setColor(Color.WHITE);
            bg.drawString(heap.get(1) + "", 200 + x, 180 + y);
        }if(heap.size() > 2){
            bg.setColor(Color.GRAY);
            bg.drawLine(435, 100, 635, 215);
            
            bg.fillRoundRect(600, 180, 70, 70, 30, 30);
            bg.setColor(Color.WHITE);
            bg.drawString(heap.get(2) + "", 600 + x, 180 + y);

            
        }if(heap.size() > 3){
            bg.setColor(Color.GRAY);
            bg.drawLine(235, 250, 135, 365);
            
            bg.fillRoundRect(100, 330, 70, 70, 30, 30);
            bg.setColor(Color.WHITE);
            bg.drawString(heap.get(3) + "", 100 + x, 330 + y);

            
        }if(heap.size() > 4){
            bg.setColor(Color.GRAY);
            bg.drawLine(235, 250, 335, 365);
            
            
            bg.fillRoundRect(300, 330, 70, 70, 30, 30);
            bg.setColor(Color.WHITE);
            bg.drawString(heap.get(4) + "", 300 + x, 330 + y);
            
        }if(heap.size() > 5){
            bg.setColor(Color.GRAY);
            bg.drawLine(635, 250, 535, 365);
            
            
            bg.fillRoundRect(500, 330, 70, 70, 30, 30);
            bg.setColor(Color.WHITE);
            bg.drawString(heap.get(5) + "", 500 + x, 330 + y);

            
        }if(heap.size() > 6){
            bg.setColor(Color.GRAY);
            bg.drawLine(635, 250, 735, 365);
            
            
            bg.fillRoundRect(700, 330, 70, 70, 30, 30);
            bg.setColor(Color.WHITE);
            bg.drawString(heap.get(6) + "", 700 + x, 330 + y);
            
        }if(heap.size() > 7){
            bg.setColor(Color.GRAY);
            bg.drawLine(135, 400, 75, 515);

            
            bg.fillRoundRect(40, 480, 70, 70, 30, 30);
            bg.setColor(Color.WHITE);
            bg.drawString(heap.get(7) + "", 40 + x, 480 + y);
        }if(heap.size() > 8){
            bg.setColor(Color.GRAY);
            bg.drawLine(135, 400, 195, 515);

            
            bg.fillRoundRect(160, 480, 70, 70, 30, 30);
            bg.setColor(Color.WHITE);
            bg.drawString(heap.get(8) + "", 160 + x, 480 + y);
        }if(heap.size() > 9){
            bg.setColor(Color.GRAY);
            bg.drawLine(335, 400, 275, 515);

            
            bg.fillRoundRect(240, 480, 70, 70, 30, 30);
            bg.setColor(Color.WHITE);
            bg.drawString(heap.get(9) + "", 240 + x, 480 + y);
        }if(heap.size() > 10){
            bg.setColor(Color.GRAY);
            bg.drawLine(335, 400, 395, 515);

            
            bg.fillRoundRect(360, 480, 70, 70, 30, 30);
            bg.setColor(Color.WHITE);
            bg.drawString(heap.get(10) + "", 360 + x, 480 + y);
        }if(heap.size() > 11){
            bg.setColor(Color.GRAY);
            bg.drawLine(535, 400, 475, 515);

            
            bg.fillRoundRect(440, 480, 70, 70, 30, 30);
            bg.setColor(Color.WHITE);
            bg.drawString(heap.get(11) + "", 440 + x, 480 + y);
        }if(heap.size() > 12){
            bg.setColor(Color.GRAY);
            bg.drawLine(535, 400, 595, 515);

            
            bg.fillRoundRect(560, 480, 70, 70, 30, 30);
            bg.setColor(Color.WHITE);
            bg.drawString(heap.get(12) + "", 560 + x, 480 + y);
        }if(heap.size() > 13){
            bg.setColor(Color.GRAY);
            bg.drawLine(735, 400, 695, 515);

            
            bg.fillRoundRect(640, 480, 70, 70, 30, 30);
            bg.setColor(Color.WHITE);
            bg.drawString(heap.get(13) + "", 640 + x, 480 + y);
        }if(heap.size() > 14){
            bg.setColor(Color.GRAY);
            bg.drawLine(735, 400, 795, 515);
            
            
            bg.fillRoundRect(760, 480, 70, 70, 30, 30);
            bg.setColor(Color.WHITE);
            bg.drawString(heap.get(14) + "", 760 + x, 480 + y);
        }
        
        

        g.drawImage(buffer, 0, 0, null);

    }

    public void reset() {
        

    }

    @Override
    public void addNotify() {

        super.addNotify();
        requestFocus();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        Point p = new Point(x, y);

        if(removeButton.contains(p)){
            heap.remove();
        }
        else if(heap.size() < 15){
            for(int r = 0; r < 5; r++){
                for(int c = 0; c < 4; c++){
                    if(buttons[r][c].contains(p)){
                        heap.add((c * 5) + (r % 5) + 1);
                    }
                }
            }
        }

        repaint();
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
}