import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.lang.Math;
import java.awt.geom.Ellipse2D;
import java.awt.BasicStroke;
public class DrawArea extends JComponent {
   private Image image;
   private Graphics2D g2;
   private int currentX, currentY, oldX, oldY;
   
   public DrawArea() {
      setDoubleBuffered(false);
      addMouseListener(
         new MouseAdapter() {
            public void mousePressed (MouseEvent e){
               oldX = e.getX();
               oldY = e.getY();
            }
         });
      addMouseMotionListener(
         new MouseMotionAdapter() {
            public void mouseDragged (MouseEvent e){
               currentX = e.getX();
               currentY = e.getY();
            
               if (g2 != null && Global.isPencilEnabled == true){ // Draw freehand
                     g2.setStroke(new BasicStroke((float)Global.stroke));
                  g2.drawLine(oldX, oldY, currentX, currentY);
                  repaint();
                  oldX = currentX;
                  oldY = currentY;
               }
            }
         });
      addMouseListener(
         new MouseAdapter() {
            public void mouseReleased (MouseEvent e){
               currentX = e.getX();
               currentY = e.getY();
            
               if (g2 != null && Global.isLineEnabled == true){ //Draw Line
                     g2.setStroke(new BasicStroke(Global.stroke));
                  g2.drawLine(oldX, oldY, currentX, currentY);
                  repaint();
               }
               if (g2 != null && Global.isRectangleEnabled == true){ //Draw Frame
                     g2.setStroke(new BasicStroke(Global.stroke));
                  if (oldX < currentX && oldY < currentY)
                     g2.drawRect(oldX, oldY, Math.abs(currentX - oldX), Math.abs(currentY - oldY));
                  else if (oldX > currentX && oldY < currentY)
                     g2.drawRect(currentX, oldY, Math.abs(currentX - oldX), Math.abs(currentY - oldY));
                  else if (oldX < currentX && oldY > currentY)
                     g2.drawRect(oldX, currentY, Math.abs(currentX - oldX), Math.abs(currentY - oldY));
                  else if (oldX > currentX && oldY > currentY)
                     g2.drawRect(currentX, currentY, Math.abs(currentX - oldX), Math.abs(currentY - oldY));
                  repaint();
               }
               if (g2 != null && Global.isRectangleFilled == true){ //Draw Rectangle
                     g2.setStroke(new BasicStroke(Global.stroke));
                  if (oldX < currentX && oldY < currentY)
                     g2.fillRect(oldX, oldY, Math.abs(currentX - oldX), Math.abs(currentY - oldY));
                  else if (oldX > currentX && oldY < currentY)
                     g2.fillRect(currentX, oldY, Math.abs(currentX - oldX), Math.abs(currentY - oldY));
                  else if (oldX < currentX && oldY > currentY)
                     g2.fillRect(oldX, currentY, Math.abs(currentX - oldX), Math.abs(currentY - oldY));
                  else if (oldX > currentX && oldY > currentY)
                     g2.fillRect(currentX, currentY, Math.abs(currentX - oldX), Math.abs(currentY - oldY));
                  repaint();
               }
               if (g2 != null && Global.isRingEnabled == true){ //Draw Ring
                     g2.setStroke(new BasicStroke(Global.stroke));
                  if (oldX < currentX && oldY < currentY)
                        g2.draw(new Ellipse2D.Double(oldX, oldY, Math.abs(currentX - oldX), Math.abs(currentY - oldY)));
                  if (oldX > currentX && oldY < currentY)
                        g2.draw(new Ellipse2D.Double(currentX, oldY, Math.abs(currentX - oldX), Math.abs(currentY - oldY)));
                  if (oldX < currentX && oldY > currentY)
                        g2.draw(new Ellipse2D.Double(oldX, currentY, Math.abs(currentX - oldX), Math.abs(currentY - oldY)));
                  if (oldX > currentX && oldY > currentY)
                        g2.draw(new Ellipse2D.Double(currentX, currentY, Math.abs(currentX - oldX), Math.abs(currentY - oldY)));
                  repaint();
               }
               if (g2 != null && Global.isEllipseEnabled == true){ //Draw Ellipse
                     g2.setStroke(new BasicStroke(Global.stroke));
                  if (oldX < currentX && oldY < currentY)
                        g2.fill(new Ellipse2D.Double(oldX, oldY, Math.abs(currentX - oldX), Math.abs(currentY - oldY)));
                  if (oldX > currentX && oldY < currentY)
                        g2.fill(new Ellipse2D.Double(currentX, oldY, Math.abs(currentX - oldX), Math.abs(currentY - oldY)));
                  if (oldX < currentX && oldY > currentY)
                        g2.fill(new Ellipse2D.Double(oldX, currentY, Math.abs(currentX - oldX), Math.abs(currentY - oldY)));
                  if (oldX > currentX && oldY > currentY)
                        g2.fill(new Ellipse2D.Double(currentX, currentY, Math.abs(currentX - oldX), Math.abs(currentY - oldY)));
                  repaint();
               }
            }
         });
   }
   
   protected void paintComponent(Graphics g){
      if (image == null) {
         image = createImage(getSize().width, getSize().height);
         g2 = (Graphics2D) image.getGraphics();
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      }
      
      g.drawImage(image, 0, 0, null);
   }
   
   public void clear(){
      g2.clearRect(0,0, getSize().width, getSize().height);
      repaint();
   }
   
   public void red() {
      g2.setPaint(Color.red);
   }
   
   public void orange() {
      g2.setPaint(Color.orange);
   }
   
   public void yellow() {
      g2.setPaint(Color.yellow);
   }
   
   public void green() {
      g2.setPaint(Color.green);
   }
   
   public void blue() {
      g2.setPaint(Color.blue);
   }
   
   public void magenta() {
      g2.setPaint(Color.magenta);
   }
   
   public void white() {
      g2.setPaint(Color.white);
   }
   
   public void black() {
      g2.setPaint(Color.black);
   }
}
