import java.awt.*;
import java.io.IOException;

import javax.swing.*;
public class HeapDisplayFrame extends JFrame
{
    public HeapDisplayFrame(String frameName) throws IOException
    {
        super(frameName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        HeapDisplay p = new HeapDisplay ();
        Insets frameInsets = getInsets();
        int frameWidth = p.getWidth() + (frameInsets.left + frameInsets.right);
        int frameHeight = p.getHeight() + (frameInsets.top + frameInsets.bottom);
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        setLayout(null);
        add(p);
        pack();
        setVisible(true);
    }
}
