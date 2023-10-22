import java.awt.*;
import javax.swing.*;

import java.awt.image.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.io.*;
import javax.imageio.ImageIO;

public class WumpusPanel extends JPanel implements KeyListener {
    public static final int PLAYING = 0;
    public static final int DEAD = 1;
    public static final int WON = 2;

    private int status = 0;
    private WumpusPlayer player = new WumpusPlayer();
    private WumpusMap map = new WumpusMap();
    private boolean cheat = false;
    boolean kilt = false;

    private BufferedImage floor;
    private BufferedImage arrow;
    private BufferedImage fog;
    private BufferedImage gold;
    private BufferedImage ladder;
    private BufferedImage pit;
    private BufferedImage breeze;
    private BufferedImage wumpus;
    private BufferedImage deadWumpus;
    private BufferedImage stench;
    private BufferedImage playerUp;
    private BufferedImage playerDown;
    private BufferedImage playerLeft;
    private BufferedImage playerRight;

    private BufferedImage buffer;

    public WumpusPanel() {
        setSize(500, 600); // width,height
        buffer = new BufferedImage(getWidth(), 600, BufferedImage.TYPE_4BYTE_ABGR);

        try {
            floor = ImageIO.read(new File("WumpusWorldImages/Floor.gif"));
            arrow = ImageIO.read(new File("WumpusWorldImages/arrow.gif"));
            gold = ImageIO.read(new File("WumpusWorldImages/gold.gif"));
            fog = ImageIO.read(new File("WumpusWorldImages/black.gif"));

            ladder = ImageIO.read(new File("WumpusWorldImages/ladder.gif"));
            pit = ImageIO.read(new File("WumpusWorldImages/pit.gif"));
            breeze = ImageIO.read(new File("WumpusWorldImages/breeze.gif"));
            wumpus = ImageIO.read(new File("WumpusWorldImages/wumpus.gif"));
            deadWumpus = ImageIO.read(new File("WumpusWorldImages/deadwumpus.gif"));
            stench = ImageIO.read(new File("WumpusWorldImages/stench.gif"));
            playerUp = ImageIO.read(new File("WumpusWorldImages/playerUp.PNG"));
            playerDown = ImageIO.read(new File("WumpusWorldImages/playerDown.PNG"));
            playerLeft = ImageIO.read(new File("WumpusWorldImages/playerLeft.PNG"));
            playerRight = ImageIO.read(new File("WumpusWorldImages/playerRight.PNG"));
        } catch (IOException e) {
            System.out.println(e);
        }

        addKeyListener(this);

        WumpusMap map = new WumpusMap();

        reset();

    }

    public void paint(Graphics g) {
        Graphics bg = buffer.getGraphics();
        map.getSquare(player.getCol(), player.getRow()).setVisited(true);
        ;
        bg.fillRect(0, 500, 500, 100);
        for (int r = 0; r < map.NUM_ROWS * 50; r += 50) {
            for (int c = 0; c < map.NUM_COLUMNS * 50; c += 50) {
                WumpusSquare square = map.getSquare(r / 50, c / 50);
                if (square.getVisited() || cheat) {
                    bg.drawImage(floor, r, c, null);

                    if (square.getPit()) {
                        bg.drawImage(pit, r, c, null);
                    } else if (square.getWumpus()) {
                        bg.drawImage(wumpus, r, c, null);
                    } else if (square.getDeadWumpus()) {
                        bg.drawImage(deadWumpus, r, c, null);
                    } else {
                        if (square.getGold()) {
                            bg.drawImage(gold, r, c, null);
                        }

                        if (square.getBreeze()) {
                            bg.drawImage(breeze, r, c, null);
                        }
                        if (square.getStench()) {
                            bg.drawImage(stench, r, c, null);
                        }
                        if (square.getLadder()) {
                            bg.drawImage(ladder, r, c, null);
                        }

                    }

                } else {
                    bg.drawImage(fog, r, c, null);
                }

                bg.drawImage(
                        ((player.getDirection() == 0) ? playerUp
                                : ((player.getDirection() == 1) ? playerRight
                                        : ((player.getDirection() == 2) ? playerDown : playerLeft))),
                        player.getCol() * 50, player.getRow() * 50, null);

            }
        }

        bg.setColor(Color.RED);

        // messages/inventory

        bg.setFont(new Font("Times New Roman", Font.BOLD, 32));
        bg.drawString("Inventory: ", 10, 530);
        bg.drawString("Messages: ", 260, 530);

        if (player.getArrow() && player.getGold()) {
            bg.drawImage(arrow, 10, 540, null);
            bg.drawImage(gold, 60, 540, null);
        } else if (player.getArrow())
            bg.drawImage(arrow, 10, 540, null);
        else if (player.getGold())
            bg.drawImage(gold, 10, 540, null);

        bg.setColor(Color.BLUE);
        WumpusSquare sq = map.getSquare(player.getCol(), player.getRow());
        int y = 0;
        bg.setFont(new Font("Times New Roman", Font.BOLD, 15));

        if (sq.getBreeze()) {
            bg.drawString("You feel a breeze ", 260, 550 + y * 20);
            y++;
        }
        if (sq.getGold()) {
            bg.drawString("You see a glimmer ", 260, 550 + y * 20);
            y++;
        }
        if (sq.getLadder()) {
            bg.drawString("You bump into a ladder ", 260, 550 + y * 20);
            y++;
        }
        if (sq.getPit()) {
            bg.drawString("You fell down a pit to your death ", 260, 550 + y * 20);
            y++;
            status = DEAD;
        }
        if (sq.getWumpus()) {
            bg.drawString("You are eated by the Wumpus ", 260, 550 + y * 20);
            y++;
            status = DEAD;
        }
        if (sq.getStench() || sq.getWumpus() || sq.getDeadWumpus()) {
            bg.drawString("You smell a stench ", 260, 550 + y * 20);
            y++;
        }
        if (kilt) {
            bg.drawString("You hear a scream ", 260, 550 + y * 20);
            y++;
            kilt = false;
        }

        if (status == WON) {
            bg.setColor(Color.WHITE);

            bg.setFont(new Font("Times New Roman", Font.BOLD, 40));
            bg.drawString("YOU WIN!", 150, 250);
            bg.setFont(new Font("Times New Roman", Font.BOLD, 20));
            bg.drawString("Press \"n\" to play again", 150, 280);

        }
        if (status == DEAD) {
            bg.setColor(Color.WHITE);

            bg.setFont(new Font("Times New Roman", Font.BOLD, 40));
            bg.drawString("YOU DIED!", 150, 250);
            bg.setFont(new Font("Times New Roman", Font.BOLD, 20));
            bg.drawString("Press \"n\" to play again", 150, 280);

        }
        g.drawImage(buffer, 0, 0, null);

    }

    public void reset() {
        status = PLAYING;
        do {
            map.createMap();
        } while (!map.isSolvable(map.getLadderRow(), map.getLadderCol()));

        player.setRow(map.getLadderRow());
        player.setCol(map.getLadderCol());
        player.setArrow(true);
        player.setGold(false);
        System.out.println(map.toString());

    }

    @Override
    public void keyTyped(KeyEvent e) {
        char k = e.getKeyChar();
        if (k == 'w') {
            if (status == PLAYING) {
                player.setRow((player.getRow() == 0) ? 0 : player.getRow() - 1);
                player.setDirection(0);
            }

        } else if (k == 's') {
            if (status == PLAYING) {

                player.setRow((player.getRow() == 9) ? 9 : player.getRow() + 1);
                player.setDirection(2);
            }

        } else if (k == 'a') {
            if (status == PLAYING) {

                player.setCol((player.getCol() == 0) ? 0 : player.getCol() - 1);
                player.setDirection(3);
            }

        } else if (k == 'd') {
            if (status == PLAYING) {

                player.setCol((player.getCol() == 9) ? 9 : player.getCol() + 1);
                player.setDirection(1);
            }

        } else if (k == 'i' && status == PLAYING) {
            if (player.getArrow()) {
                player.setArrow(false);
                player.setDirection(0);

                try {
                    if (player.getCol() == map.wumpusC && player.getRow() > map.wumpusR) {
                        map.getSquare(map.wumpusC, map.wumpusR).setDeadWumpus(true);
                        map.getSquare(map.wumpusC, map.wumpusR).setWumpus(false);
                        kilt = true;
                    }
                } catch (ArrayIndexOutOfBoundsException g) {
                    System.out.println(g);
                }
            }

        } else if (k == 'k') {
            if (player.getArrow() && status == PLAYING) {
                player.setArrow(false);
                player.setDirection(2);

                try {
                    if (player.getCol() == map.wumpusC && player.getRow() < map.wumpusR) {
                        map.getSquare(map.wumpusC, map.wumpusR).setDeadWumpus(true);
                        map.getSquare(map.wumpusC, map.wumpusR).setWumpus(false);
                        kilt = true;
                    }
                } catch (ArrayIndexOutOfBoundsException g) {
                    System.out.println(g);
                }
            }
        } else if (k == 'j') {
            if (player.getArrow() && status == PLAYING) {
                player.setArrow(false);
                player.setDirection(3);

                try {
                    if (player.getCol() > map.wumpusC && player.getRow() == map.wumpusR) {
                        map.getSquare(map.wumpusC, map.wumpusR).setDeadWumpus(true);
                        map.getSquare(map.wumpusC, map.wumpusR).setWumpus(false);
                        kilt = true;
                    }
                } catch (ArrayIndexOutOfBoundsException g) {
                    System.out.println(g);
                }
            }

        } else if (k == 'l') {
            if (player.getArrow() && status == PLAYING) {
                player.setArrow(false);
                player.setDirection(1);

                try {
                    if (player.getCol() < map.wumpusC && player.getRow() == map.wumpusR) {
                        map.getSquare(map.wumpusC, map.wumpusR).setDeadWumpus(true);
                        map.getSquare(map.wumpusC, map.wumpusR).setWumpus(false);
                        kilt = true;
                    }
                } catch (ArrayIndexOutOfBoundsException g) {
                    System.out.println(g);
                }
            }
        } else if (k == 'c') {
            if (player.getGold() && player.getCol() == map.getLadderCol() && player.getRow() == map.getLadderRow()) {
                status = WON;
            }
        } else if (k == 'p') {
            if (map.getSquare(player.getCol(), player.getRow()).getGold()) {
                player.setGold(true);
                map.getSquare(player.getCol(), player.getRow()).setGold(false);
            }

        } else if (k == 'n') {
            if (status > 0)
                reset();

        } else if (k == '*') {
            cheat = !cheat;
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addNotify() {

        super.addNotify();
        requestFocus();
    }
}