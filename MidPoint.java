/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midpoint;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.JFrame;
import java.util.Scanner;
import java.lang.*;
import java.util.InputMismatchException;
import javax.swing.JComponent;
public class MidPoint {
 
    public static void main(String[] args) {
   Scanner sc=new Scanner(System.in);
    int r ;
    int c ;

   System.out.println("Enter radius r: "); //not high than 300
    r=sc.nextInt();
   System.out.println("Enter center c: ");
    c=sc.nextInt(); //equal r and not 600 or high
   if ( r >= 600){
    System.out.println("error you must enter less then 600 "); 
   }
   
   while((c != r )&&(c < r)){
    System.out.println("your circle is out of boundry, try again! ");
    System.out.println("Enter radius r: "); //not high than 300
    r=sc.nextInt();
   System.out.println("Enter center c: ");
    c=sc.nextInt(); //equal r and not 600 or high
   if ( r >= 600){
    System.out.println("error you must enter less then 600 "); 
   }
   }
   
   MP_CIRCLE circle = new MP_CIRCLE(r,c);
   JFrame f=new JFrame();
   f.setTitle("MP_CIRCLE ");
   f.getContentPane().setBackground(Color.white);
   f.add(circle);
   f.setSize(600,600);
   f.setVisible(true);
   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    }
     
}

class MP_CIRCLE extends JComponent{
    static BufferedImage image;
    static WritableRaster raster;
     int XYsize=600;
     int r;
     int c;
     public MP_CIRCLE(int r,int c){
         image= new BufferedImage(XYsize,XYsize,BufferedImage.TYPE_INT_ARGB);
         raster=image.getRaster();
         repaint();
         this.r=r;
         this.c=c;
     }
          protected void paintComponent(Graphics g){
       int color[]={0,0,0,255};
               int p=1-r;
               int x=0;
               int y=r;
              raster.setPixel(c, c, color);
              raster.setPixel(c, c-y, color);
              raster.setPixel(c, c+y, color);
              raster.setPixel(c-y, c, color);
              raster.setPixel(c+y, c, color);
              while(x<y){
                  x++;
                  if(p<0){
                      p=p+2*x+3;
                  }else{
                         p=p+2*(x-y)+5;
                         y--;
                  }
              raster.setPixel(y+c, x+c, color);
              raster.setPixel(x+c, y+c, color);
              raster.setPixel(c-x, y+c, color);
              raster.setPixel(c-y, x+c, color);
              raster.setPixel(c-y, c-x, color);
              raster.setPixel(c-x, c-y, color);
              raster.setPixel(x+c, c-y, color);
              raster.setPixel(y+c, c-x, color);
              }
              
              g.drawImage(image, 0, 0, null);

          
      }
}
