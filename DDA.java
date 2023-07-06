
package lab2_graphic;

import com.sun.prism.paint.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.JApplet;

public class DDA extends JApplet{
 
    BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
    WritableRaster raster = image.getRaster();
    
    int x1;
    int x2;
    int y1;
    int y2;

    DDA(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        init();
       }

    public void init() {
        setSize(600, 600);
        repaint();
     }
    
    public void paint(Graphics g) {
       
        int dx, dy;
        int color[] = {255, 0, 0, 255};
        int steps;//يحسب عدد تكرار البروسيس
        dx = x2 - x1;
        dy = y2 - y1;
        
        if(Math.abs(dx) > Math.abs(dy))
            steps = Math.abs(dx);
        else
            steps = Math.abs(dy);
            float Xinc = (float)dx/steps;
            float Yinc = (float)dy/steps;
            raster.setPixel(x1, y1, color);
            float x = x1;
            float y = y1;
            System.out.println("x: " + x1 + " y: " + y1);
        for(int k = 1; k <= steps; k++){
            x+=Xinc;
            y+=Yinc;
            raster.setPixel(Math.round(x), Math.round(y), color);
            System.out.println("x: " + Math.round(x) + " y: " + Math.round(y));
            }
            
        g.drawImage(image, 0, 0, null);
    
    
    }
}

    
    
    

