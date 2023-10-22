package House;

import java.awt.*;
import java.awt.image.*;

import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Panel extends JPanel{
    public Panel(){
        super();

        setSize(900,900);



    }

    public void paint(Graphics g){
        File imageFile = new File("house.PNG");
        BufferedImage image = null;
        try{
            image =  ImageIO.read(imageFile);
        }
        catch(IOException e){
            System.out.println(e);
        }
        // JLabel picLabel = new JLabel(new ImageIcon(image));
        // panel.add(picLabel);
        g.drawLine(5, 5, 15, 5);


        //BROWN BRICKS BACK
        g.setColor(new Color(181, 157, 138));

        int[] x_5 = {540, 340, 440};
        int[] y_5 = {360, 360, 240};
        g.fillPolygon(x_5, y_5, 3);


        //BROWN BRICKS FRONT
        g.setColor(new Color(181, 157, 138));

        g.fillRect(40, 300, 10, 85);

        g.fillRect(50, 300, 150, 85);
        int[] x = {130,209,47};
        int[] y = {200,300,300};
        g.fillPolygon(x, y, 3);

        g.fillRect(200, 291, 150, 63);
        int[] x1 = {285,360,210};
        int[] y1 = {200,291,291};
        g.fillPolygon(x1, y1, 3);

        g.fillRect(350, 373, 150, 77);
        int[] x2 = {417, 497, 337};
        int[] y2 = {280,375,375};
        g.fillPolygon(x2, y2, 3);

        g.fillRect(500, 373, 78, 77);


        //BRICKS N STUFF :(
        g.setColor(new Color(204, 177, 155));
        for(int i = 0 ; i < 900; i += 5){
            for(int j = (10 / ((i % 2) + 
            1)); j <  900; j += 10){
                g.drawLine(j, i, j, i + 5);
                g.drawLine(0, i, 900, i);
            }
        }
        
        
        //BACK WINDOWS
        g.setColor(new Color(157, 184, 204));
        // g.fillRect(430, 285, 15, 50);
        int[] xx = {430, 445, 445, 430};
        int[] yy = {285, 285, 315, 300};
        g.fillPolygon(xx, yy, 4);


        //ROOF
        g.setColor(Color.DARK_GRAY);
        // int[] x_0 = {40, 55, 246, 211, 173, 166};
        // int[] y_0 = {300, 295, 248, 290, 255, 245};
        // g.fillPolygon(x_0, y_0, 6);

        int[] x_00 = {170, 240, 246, 211, 173, 166};
        int[] y_00 = {240, 240, 248, 290, 255, 245};
        g.fillPolygon(x_00, y_00, 6);

        int[] x_2 = {350, 360, 387, 350};
        int[] y_2 = {278, 278, 287, 350};
        g.fillPolygon(x_2, y_2, 4);

        int[] x_3 = {387, 350, 440};
        int[] y_3 = {287, 350, 240};
        g.fillPolygon(x_3, y_3, 3);

        int[] x_4 = {387, 350, 440};
        int[] y_4 = {287, 350, 240};
        g.fillPolygon(x_4, y_4, 3);

        int[] x_7 = {415, 350, 350, 400};
        int[] y_7 = {280, 356, 336, 280};
        g.fillPolygon(x_7, y_7, 4);

        int[] x_6 = {460, 515, 582, 497};
        int[] y_6 = {330, 330, 375,375};
        g.fillPolygon(x_6, y_6, 4);


        //DOORS N THINGS
        g.setColor(new Color(130, 103, 82));

        g.fillRect(125, 310, 10, 40);

        //WHITE BRICKS//
        g.setColor(new Color(237, 228, 202));

        g.fillRect(50, 385, 150, 65);
        g.fillRect(200, 354, 150, 96);

        g.fillRect(130, 320, 100, 130);
        int[] x3 = {125, 235, 178};
        int[] y3 = {320,320,250};
        g.fillPolygon(x3, y3, 3);

        //SHADOWS
        g.setColor(new Color(217, 208, 182));

        g.fillRect(161, 372, 45, 78);
        g.drawLine(230, 320, 230, 450);

        //BROWN PATTERN FRONT
        g.setColor(new Color(181, 157, 138));

        g.fillArc(145, 334, 75, 75, 0, 180);
        g.fillRect(130, 362, 100, 10);
        g.fillRect(138, 390, 12, 60);
        g.fillRect(213, 390, 12, 60);


        //DOORS N THINGS
        g.setColor(new Color(130, 103, 82));
        g.fillRect(163, 385, 27, 65);
        g.fillRect(93, 310, 10, 40);

        g.fillRect(260, 305, 10, 35);
        g.fillRect(297, 305, 10, 35);


        //GARAGE
        g.setColor(new Color(135, 114, 96));
        g.fillRect(355, 397, 125, 50);
        g.fillRect(500, 397, 60, 50);


        //WINDOWS//
        g.setColor(new Color(157, 184, 204));
        
        g.fillRect(125, 245, 13, 35);

        g.fillArc(100, 298, 25, 25, 0, 180);
        g.fillRect(100, 310, 25, 40);

        g.fillRect(90, 387, 40, 33);

        g.fillArc(269, 293, 28, 28, 0, 180);
        g.fillRect(270, 305, 27, 35);

        g.fillRect(395, 340, 35, 30);

        g.fillRect(260, 385, 50, 50);

        g.fillArc(163, 350, 41, 50, 0, 180);

        g.fillRect(168, 390, 17, 40);

        g.fillRect(193, 388, 10, 50);



        //WINDOW LINES DSJADKLFJSAL//
        g.setColor(new Color(191, 191, 191));

        g.drawLine(125, 262, 138, 262);
        g.drawLine(131, 245, 131, 280);

        g.drawLine(100, 310, 125, 310);
        g.drawLine(100, 330, 125, 330);

        g.drawLine(270, 305, 297, 305);
        g.drawLine(270, 322, 297, 322);

        g.drawLine(407, 340, 407, 370);
        g.drawLine(418, 340, 418, 370);



        //PAVEMENT
        g.setColor(new Color(237, 235, 216));
        g.fillRect(0, 450, 900, 350);


        //GRASS
        g.setColor(new Color(159, 214, 88));
        int[] x01 = {195, 135, 465, 365};
        int[] y01 = {465, 530, 530, 465};
        g.fillPolygon(x01, y01, 4);
        
        int[] x02 = {0, 0, 75, 160};
        int[] y02 = {465, 530, 530, 465};
        g.fillPolygon(x02, y02, 4);

        int[] x003 = {0, 0, 55};
        int[] y003 = {550, 600, 550};
        g.fillPolygon(x003, y003, 3);

        int[] x004 = {125, 500, 580, 75};
        int[] y004 = {555, 555, 610, 610};
        g.fillPolygon(x004, y004, 4);


        //BUSHES
        g.setColor(new Color(54, 120, 0));
        g.fillRoundRect(205, 425, 160, 35, 20, 20);
        g.fillRoundRect(45, 425, 100, 35, 20, 20);


        //SKY
        g.setColor(new Color(204, 234, 235));
        int[] x03 = {0, 0, 50, 50, 47, 130, 166, 170, 240, 246, 285, 350, 360, 387, 440, 515, 582, 578, 578, 700, 700};
        int[] y03 = {0, 450, 450, 300, 300, 200, 245, 240, 240, 248, 200, 278, 278, 287, 240, 330, 375, 373, 450, 450, 0};
        g.fillPolygon(x03, y03, 21);


        //BUSHES
        g.setColor(new Color(54, 120, 0));
        g.fillRoundRect(205, 425, 150, 35, 20, 20);
        g.fillRoundRect(45, 425, 100, 35, 20, 20);


        //LAWN BRICKS
        g.setColor(new Color(214, 207, 186));
        g.fillRect(195, 450, 180, 10);
        g.fillRect(35, 450, 120, 10);


        //TREES
        g.setColor(new Color(135, 97, 1));
        int[] bark = {87, 97, 77};
        int[] yellindog = {400, 475, 475};
        g.fillPolygon(bark, yellindog, 3);

        int[] bark1 = {312, 302, 322};
        g.fillPolygon(bark1, yellindog, 3);

        g.setColor(new Color(14, 135, 0));

        g.fillOval(50, 350, 75, 75);
        g.fillOval(275, 350, 75, 75);   


        // g.setColor(Color.WHITE);
        // for(int i = 0; i < 900; i += 25){
        //     if(i % 100 == 0){
        //         g.setColor(Color.BLACK);
        //     }
        //     g.drawLine(0, i, 900, i);
        //     g.drawLine(i, 0, i, 900);
        //     if(i % 100 == 0){
        //         g.setColor(Color.WHITE);
        //     }
        // }


        // g.drawImage(image,  -400, 0, null);
        // g.drawImage(image,  -400, 0, null);

    }

   
    

}
