package src;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.image.*;
import java.io.File;
import java.time.LocalTime;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panel extends JPanel implements MouseListener, Runnable {
    public final int CARD_WIDTH = 48;
    public final int CARD_HEIGHT = 68;

    BufferedImage buffer;
    String[] letters = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    MyMap<Integer, BufferedImage> images = new MyMap<Integer, BufferedImage>();

    BufferedImage cardBack;

    MatchGame game;

    public int counter = 0;

    public Panel() {

        super();

        setSize(1000, 600);

        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);

        BufferedImage card = new BufferedImage(CARD_WIDTH, CARD_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);

        for (int i = 0; i < 13; i++) {
            images.put(i, new BufferedImage(CARD_WIDTH, CARD_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR));
            Graphics c = images.get(i).getGraphics();

            c.setColor(Color.WHITE);
            c.fillRect(0, 0, CARD_WIDTH, CARD_HEIGHT);
            c.setColor(Color.BLACK);
            c.drawRect(7, 7, CARD_WIDTH - 14, CARD_HEIGHT - 14);

            c.setColor(Color.BLACK);
            c.setFont(new Font("Arial", Font.BOLD, 20));
            c.drawString(letters[i], CARD_WIDTH / 2 - 7, CARD_HEIGHT / 2 + 5);

        }

        try {
            cardBack = ImageIO.read(new File("src/cardBack.png"));
        } catch (Exception e) {
            System.out.println(e);
        }

        game = new MatchGame();

        Thread j = new Thread(this);
        j.start();

        addMouseListener(this);

    }

    public void paint(Graphics g) {
        Graphics bg = buffer.getGraphics();
        if(game.status != game.LIMBO){
            bg.setColor(new Color(100, 100, 100));
            bg.fillRect(0, 0, 1000, 700);

            bg.setColor(new Color(0, 100, 0));
            bg.fillRect(246, 0, 502, 700);

            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 6; c++) {
                    Card tempCard = game.getItem(r, c);
                    if (tempCard.exists()) {
                        if (!tempCard.getFlipped() && tempCard.getCard() != -1)
                            bg.drawImage(cardBack, 261 + (r * 53), 81 + (c * 73), null);
                        else if (tempCard.getFlipped() && tempCard.getCard() != -1) {
                            bg.drawImage(images.get(tempCard.getCard()), 261 + (r * 53), 81 + (c * 73), null);
                        }
                    }
                }
            }
            Color grey = new Color(200, 200, 200);
            Color green = new Color(100, 200, 100);

            bg.setColor((game.getStatus() == game.PLAYER_ONE) ? green : grey);
            bg.fillRoundRect(30, 20, 170, 30, 15, 15);
            bg.setColor(Color.BLACK);
            bg.setFont(new Font("Arial", Font.BOLD, 20));
            bg.drawString("PLAYER 1", 65, 42);

            bg.setColor((game.getStatus() == game.PLAYER_TWO) ? green : grey);
            bg.fillRoundRect(778, 20, 170, 30, 15, 15);
            bg.setColor(Color.BLACK);
            bg.drawString("PLAYER 2", 811, 42);

            bg.setFont(new Font("Arial", Font.BOLD, 15));
            bg.drawString("Set", 844, 70);
            bg.drawString("Set", 93, 70);


            for (int i = 0; i < 13; i++) {
                if (game.getPlayer1().contains(i)) {
                    bg.setColor(green);
                } else {
                    bg.setColor(grey);
                }
                bg.fillRoundRect((i % 2 == 0) ? 50 : 120, (((int) i / 2) * 70) + 75, 50, 50, 15, 15);

                bg.setColor(Color.BLACK);
                bg.drawString(letters[i], (i % 2 == 0) ? 65 : 135, (((int) i / 2) * 70) + 110);
            }

            for (int i = 0; i < 13; i++) {
                if (game.getPlayer2().contains(i)) {
                    bg.setColor(green);
                } else {
                    bg.setColor(grey);
                }
                bg.fillRoundRect((i % 2 == 0) ? 798 : 868, (((int) i / 2) * 70) + 75, 50, 50, 15, 15);

                bg.setColor(Color.BLACK);
                bg.drawString(letters[i], (i % 2 == 0) ? 813 : 883, (((int) i / 2) * 70) + 110);
            }
            // System.out.println("");

            g.drawImage(buffer, 0, 0, null);
        }
        else{
            bg.setFont(new Font("Arial", Font.BOLD, 50));
            bg.setColor(Color.BLACK);
            bg.drawString(((game.checkWin() == 1)?"PLAYER ONE ":"PLAYER TWO ") + "WINS!", 250, 300);

            g.drawImage(buffer, 0, 0, null);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(game.flipped != 2){
            int r = (e.getX() - 261) / 53;
            int c = (e.getY() - 81) / 73;

            if(e.getX() - 261 >= 0 && e.getY() - 81 >= 0)
            game.playerTurn(r, c);
        }
        repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addNotify() {

        super.addNotify();
        requestFocus();
    }

    @Override
    public void run() {
        while (true) {
            if (game.flipped == 2) {
                counter++;
            } else {
                counter = 0;
            }

            if (counter >= 1000) {
                game.unflip();
            } else {
                repaint();
            }

            if(game.checkWin() == 0){
                repaint();
            }
            else{
                game.unflip();
                repaint();
            }

            try {
                Thread.sleep(1);
            } catch (Exception e) {
                // prints the error message
                System.out.println("Error sleeping: " + e);
            }
        }
    }

}
