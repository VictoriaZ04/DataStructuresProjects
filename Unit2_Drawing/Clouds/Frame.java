package Clouds;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{
    public Frame(String title){
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        pack();

        Panel p = new Panel();

        Insets insets = getInsets();

        int width = p.getWidth() + insets.left + insets.right;
        int height = p.getHeight() + insets.top + insets.bottom;

        setPreferredSize(new Dimension(700, 700));
        setLayout(null);

        add(p);

        pack();

        setVisible(true);
    }
}
