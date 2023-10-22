import java.awt.*;
import javax.swing.*;

import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panel extends JPanel implements MouseListener {
    private BufferedImage buffer;
    private final int WIN = 0;
    private final int PLAYING = 1;
    private int status = 1;
    private int moves = 0;

    private boolean image = true;
    private int empty;

    Square[] sq = new Square[16];
    BufferedImage[] turtle = { ImageIO.read(new File("turtle/img1.png")), ImageIO.read(new File("turtle/img2.png")),
        ImageIO.read(new File("turtle/img3.png")), ImageIO.read(new File("turtle/img4.png")),
        ImageIO.read(new File("turtle/img5.png")), ImageIO.read(new File("turtle/img6.png")),
        ImageIO.read(new File("turtle/img7.png")), ImageIO.read(new File("turtle/img8.png")),
        ImageIO.read(new File("turtle/img9.png")), ImageIO.read(new File("turtle/img10.png")),
        ImageIO.read(new File("turtle/img11.png")), ImageIO.read(new File("turtle/img12.png")),
        ImageIO.read(new File("turtle/img13.png")), ImageIO.read(new File("turtle/img14.png")),
        ImageIO.read(new File("turtle/img15.png")), ImageIO.read(new File("turtle/img16.png")) };

    BufferedImage[] numbers = { ImageIO.read(new File("numbers/img1.png")), ImageIO.read(new File("numbers/img2.png")),
        ImageIO.read(new File("numbers/img3.png")), ImageIO.read(new File("numbers/img4.png")),
        ImageIO.read(new File("numbers/img5.png")), ImageIO.read(new File("numbers/img6.png")),
        ImageIO.read(new File("numbers/img7.png")), ImageIO.read(new File("numbers/img8.png")),
        ImageIO.read(new File("numbers/img9.png")), ImageIO.read(new File("numbers/img10.png")),
        ImageIO.read(new File("numbers/img11.png")), ImageIO.read(new File("numbers/img12.png")),
        ImageIO.read(new File("numbers/img13.png")), ImageIO.read(new File("numbers/img14.png")),
        ImageIO.read(new File("numbers/img15.png")), ImageIO.read(new File("numbers/img16.png")) };

    public Panel() throws IOException {
        setSize(1000, 800); // width,height
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);

        reset();
        addMouseListener(this);

    }

    public void paint(Graphics g) {
        // code to draw to the screen using Graphics Commands
        Graphics bg = buffer.getGraphics();

        for (int i = 0; i < 16; i++) {

            if(image){
                bg.drawImage(turtle[sq[i].getPos()], ((i) % 4) * 192, (i / 4) * 192, null);
            }else{
                bg.drawImage(numbers[sq[i].getPos()], ((i) % 4) * 192, (i / 4) * 192, null);
            }

        }

        bg.setColor((image)?new Color(150, 150, 150):new Color(180, 180, 180));
        bg.fillRoundRect(844, 150, 70, 30, 30, 33);
        bg.setColor(Color.GRAY);
        bg.drawRoundRect(844, 150, 70, 30, 30, 30);
        bg.setColor(new Color(200, 200, 200));
        bg.fillOval(844 + ((image)?0:40), 150, 30, 30);

        bg.setColor(Color.black);
        bg.setFont(new Font("Courier", Font.PLAIN, 20));
        bg.drawString("Turtle", 790, 172);
        bg.drawString("Numbers", 920, 177);

        if (win()) {
            status = WIN;
            bg.setColor(Color.WHITE);
            bg.fillRoundRect(242, 288, 284, 192, 75, 75);
            bg.setColor(Color.GRAY);
            bg.drawRoundRect(242, 288, 284, 192, 75, 75);

            bg.setColor(Color.black);
            bg.setFont(new Font("Courier", Font.PLAIN, 30));
            bg.drawString("YOU WIN!!!", 353, 384);
            
        }

        bg.setFont(new Font("Courier", Font.PLAIN, 20));

        bg.setColor(new Color(87, 96, 150));
        bg.fillRoundRect(834, 70, 120, 50, 30, 30);
        bg.setColor(new Color(71, 77, 115));
        bg.drawRoundRect(834, 70, 120, 50, 30, 30);
        bg.setColor(Color.WHITE);
            bg.drawString("New Game", 847, 103);

        bg.setColor(new Color(200, 200, 200));
        bg.fillRoundRect(800, 250, 175, 75, 30, 30);
        bg.setColor(Color.BLACK);
        bg.drawString("Moves:", 850, 270);
        bg.drawString("" + moves , 875, 300);
        
        

        
        


        g.drawImage(buffer, 0, 0, null);

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        int r = (e.getX()) / 192;
        int c = (e.getY()) / 192;
        int pos = r + c * 4;

        if (status == PLAYING) {
            try {
                if (sq[pos - 4].getEmpty()) {
                    moves++;
                    sq[pos - 4].setEmpty(false);
                    sq[pos - 4].setPos(sq[pos].getPos());
                    sq[pos].setEmpty(true);
                    sq[pos].setPos(15);
                }
            } catch (Exception j) {
                j = null;
            }

            try {
                if (sq[pos + 4].getEmpty()) {
                    moves++;
                    sq[pos + 4].setEmpty(false);
                    sq[pos + 4].setPos(sq[pos].getPos());
                    sq[pos].setEmpty(true);
                    sq[pos].setPos(15);
                }
            } catch (Exception j) {
                j = null;
            }

            try {
                if (sq[pos - 1].getEmpty() && r != 0) {
                    moves++;
                    sq[pos - 1].setEmpty(false);
                    sq[pos - 1].setPos(sq[pos].getPos());
                    sq[pos].setEmpty(true);
                    sq[pos].setPos(15);
                }
            } catch (Exception j) {
                j = null;
            }

            try {
                if (sq[pos + 1].getEmpty() && r != 3) {
                    moves++;
                    sq[pos + 1].setEmpty(false);
                    sq[pos + 1].setPos(sq[pos].getPos());
                    sq[pos].setEmpty(true);
                    sq[pos].setPos(15);
                }
            } catch (Exception j) {
                j = null;
            }

        }
        if((e.getY() < 120 && e.getY() > 70) && (e.getX() < 954 && e.getX() > 834)){
            status = PLAYING;
            reset();
        }

        if((e.getY() < 180 && e.getY() > 150) && (e.getX() < 914 && e.getX() > 844)){
            image = !image;
        }

        
        repaint();
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void reset() {
        moves = 0;
        int rand = (int) (Math.random() * 16);
        for (int i = 0; i < 15; i++) {
            sq[i] = new Square(false);
            sq[i].setPos(i);
        }
        sq[15] = new Square(true);
        sq[15].setPos(15);
        empty = 15;

        for (int i = 0; i < 500; i++) {
            rand = (int) (Math.random() * 4);
            try{
                Square temp = sq[empty];
                if(rand == 0){
                    sq[empty] = sq[empty + 4];
                    sq[empty + 4] = temp;
                    empty += 4;
                }
                else if(rand == 1){
                    sq[empty] = sq[empty - 4];
                    sq[empty - 4] = temp;
                    empty -= 4;
                }
                else if(rand == 2 && (empty + 1) % 4 != 0){
                    sq[empty] = sq[empty + 1];
                    sq[empty + 1] = temp;
                    empty += 1;
                }
                else if(rand == 3 && (empty + 1) % 4 != 1){
                    sq[empty] = sq[empty - 1];
                    sq[empty - 1] = temp;
                    empty -= 1;
                }
            }catch(Exception e){
                
            }

            
        }
        
        repaint();
    }

    public void up(){}

    public boolean win() {
        for (int i = 0; i < 16; i++) {
            if (sq[i].getPos() != i) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addNotify() {

        super.addNotify();
        requestFocus();
    }

}