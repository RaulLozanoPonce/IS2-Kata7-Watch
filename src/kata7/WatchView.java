package kata7;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import javax.swing.JPanel;

public class WatchView extends JPanel{

    private final Image image;
    private Point[] points = new Point[0];

    public WatchView(Image image){
        this.image = image;
    }
    
    public void paint(Point[] points){
        this.points = points;
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
        int width = 3;
        g.drawImage(image, 0, 0, this);
        for (Point point : points)  
            paintLine((Graphics2D) g, point, 2*(width--));
    }
    
    private void paintLine(Graphics2D g, Point point, int width) {
        int ox = getWidth()/2;
        int oy = getHeight()/2;
        g.setStroke(new BasicStroke(width));
        if(width == 2){
            g.setColor(Color.red);
        }else{
            g.setColor(Color.black);
        }
        g.drawLine(ox - point.x/5, oy + point.y/5, ox + point.x, oy - point.y);
        if(width == 2){
            int radio = 15;
            g.fillOval(ox - radio/2, oy - radio/2, radio, radio);
        }
    }
}