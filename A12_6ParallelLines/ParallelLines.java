import java.awt.*;
import javax.swing.*;

/**
   This class draws a parallel lines illusion.
   There are some equally spaced parallel lines, and between the parallel lines, there are squares of alternating black and white. These squares make it look like the lines are curved and not straight like they actually are.
   it represents, and how to use it.
  
   @author  Chaaruhaas Kandregula
   @version 9/28/2024

   Period - 3
   Assignment - A12.6 - ParallelLines

   Sources - None
 */
public class ParallelLines extends JPanel
{
    private int nLines;
    private int offset;
        
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);  // Call JPanel's paintComponent method
                                //   to paint the background
        
        int width = getWidth();    
        int height = getHeight();
        
        drawIllusion(g, width, height);
    }

    /**
        this method draws a parallel lines illusion with width width and height height using the graphics g;
        @param g
        @param width
        @param height
        @param size
    */
        public void drawIllusion(Graphics g, int width, int height)
        {
            nLines = height-10/40;
            offset = 0;
            for (int i = 0; i < nLines; i++) {
                g.drawLine(10, 10+i*40, width-10, 10+i*40);
                switch (i%4) {
                    case 0:
                        offset = 0;
                        break;
                    case 1:
                        offset = 13;
                        break;
                    case 2:
                        offset = 26;
                        break;
                    case 3: 
                        offset = 13;
                        break;                
                }
                for (int j = 0; 10 + offset + 40*j < width-10; j++) {
                    g.fillRect(10 + offset + 80*j, 10+40*i, 40, 40);
                }
            }
        }

        public static void main(String[] args)  {
        JFrame w = new JFrame("ParallelLines");
        w.setBounds(100, 100, 640, 480);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ParallelLines panel = new ParallelLines();
        panel.setBackground(Color.WHITE);
        Container c = w.getContentPane();
        c.add(panel);
        w.setResizable(true);
        w.setVisible(true);
    }
}
