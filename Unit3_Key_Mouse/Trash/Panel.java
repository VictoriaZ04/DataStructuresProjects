import java.awt.*;
import javax.swing.*;


import java.awt.image.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Panel extends JPanel implements MouseListener{
    private BufferedImage buffer;
    private final int ROWS = 20;
    private final int COLS = 20;
    public boolean evil = false;

    private TrashCan[][] trash = new TrashCan[ROWS][COLS];

    public Panel() {
        setSize(320, 350); // width,height
        buffer = new BufferedImage(getWidth(), 350, BufferedImage.TYPE_4BYTE_ABGR);
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                trash[r][c] = new TrashCan();
            }
        }
        
        addMouseListener(this);



    }

    public void paint(Graphics g) {
        // code to draw to the screen using Graphics Commands
        Graphics bg = buffer.getGraphics();
        boolean won = true;

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                
                bg.setColor(Color.BLACK);
                
                bg.drawRect(r * 15 + 10, c * 15 + 10, 10, 10);
            }
        }

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(trash[r][c].getTrash()){
                    won = false;
                    
                    bg.setColor(Color.BLACK);
                    if(evil)
                        bg.setColor(Color.WHITE);
                }
                else{
                    
                    bg.setColor(Color.WHITE);
                    if(evil)
                        bg.setColor(Color.BLACK);
                }

                bg.fillRect(r * 15 + 8, c * 15 + 8, 10, 10);
            }
        }
        
        if(won){
            bg.setColor(Color.RED);
            bg.setFont(new Font("Times New Roman", Font.BOLD, 20));
            if(evil)
                bg.drawString("You Destroyed the Earth!! >:)", 50, 330);
            else
                bg.drawString("You picked up all the trash!", 50, 330);
        }


        g.drawImage(buffer, 0, 0, null);

    }
    public void mousePressed(MouseEvent e){}

    public void mouseClicked(MouseEvent e){
        int r = (e.getX() - 8)/15;
        int c = (e.getY() - 8)/15;
        if((e.getX() - 8) - r * 15 < 10 && (e.getY() - 8) - c * 15 < 10){
            pickupTrash(r, c);

        }

        System.out.println(r + ": " +e.getX() + "\n" + c + ": " + e.getY());

        repaint();
    }

    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}

    public boolean pickupTrash(int r, int c){
        if(r < 0 || r > 19 || c < 0 || c > 19)
        {
            return false;
            
        }
        if(trash[r][c].getTrash()){
            trash[r][c].setTrash(false);
            pickupTrash(r + 1, c);
            pickupTrash(r - 1, c);
            pickupTrash(r, c + 1);
            pickupTrash(r, c - 1);

        }
        return false;
    }

    @Override
    public void addNotify() {

        super.addNotify();
        requestFocus();
    }

}