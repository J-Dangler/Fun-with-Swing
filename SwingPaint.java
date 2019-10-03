import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
public class SwingPaint {
   JButton clearBtn;
   JRadioButton redBtn, orangeBtn, yellowBtn, greenBtn, blueBtn, magentaBtn, whiteBtn, blackBtn, lineBtn, rectangleBtn, filledRectangleBtn, ringBtn, ellipseBtn, pencilBtn;
   JSlider strokeSldr;
   JLabel status = new JLabel("Test");
   //JToggleButton;
   DrawArea drawArea;
   ActionListener actionListener = 
      new ActionListener() {
      
         public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {
               drawArea.clear();
            } else if (e.getSource() == redBtn) {
               drawArea.red();
            } else if (e.getSource() == orangeBtn) {
               drawArea.orange();
            } else if (e.getSource() == yellowBtn) {
               drawArea.yellow();
            } else if (e.getSource() == greenBtn) {
               drawArea.green();
            } else if (e.getSource() == blueBtn) {
               drawArea.blue();
            } else if (e.getSource() == magentaBtn) {
               drawArea.magenta();
            } else if (e.getSource() == whiteBtn) {
               drawArea.white();
            } else if (e.getSource() == blackBtn) {
               drawArea.black();
            } else if (e.getSource() == pencilBtn) {
               Global.isLineEnabled = false;
               Global.isPencilEnabled = true;
               Global.isRectangleEnabled = false;
               Global.isRectangleFilled = false;
               Global.isRingEnabled = false;
               Global.isEllipseEnabled = false;
            } else if (e.getSource() == lineBtn) {
               Global.isLineEnabled = true;
               Global.isPencilEnabled = false;
               Global.isRectangleEnabled = false;
               Global.isRectangleFilled = false;
               Global.isRingEnabled = false;
               Global.isEllipseEnabled = false;
            } else if (e.getSource() == rectangleBtn) {
               Global.isLineEnabled = false;
               Global.isPencilEnabled = false;
               Global.isRectangleEnabled = true;
               Global.isRectangleFilled = false;
               Global.isRingEnabled = false;
               Global.isEllipseEnabled = false;
            } else if (e.getSource() == filledRectangleBtn) {
               Global.isLineEnabled = false;
               Global.isPencilEnabled = false;
               Global.isRectangleEnabled = false;
               Global.isRectangleFilled = true;
               Global.isRingEnabled = false;
               Global.isEllipseEnabled = false;
            } else if (e.getSource() == ringBtn) {
               Global.isLineEnabled = false;
               Global.isPencilEnabled = false;
               Global.isRectangleEnabled = false;
               Global.isRectangleFilled = false;
               Global.isRingEnabled = true;
               Global.isEllipseEnabled = false;
            } else if (e.getSource() == ellipseBtn) {
               Global.isLineEnabled = false;
               Global.isPencilEnabled = false;
               Global.isRectangleEnabled = false;
               Global.isRectangleFilled = false;
               Global.isRingEnabled = false;
               Global.isEllipseEnabled = true;
            }
            
                        
            
         }
      };
      
   public static void main(String[] args) {
      Global.isPencilEnabled = true;
      new SwingPaint().show();
   }
   
   public void show() {
      JFrame frame = new JFrame("Paint 2");
      Container content = frame.getContentPane();
      content.setLayout(new BorderLayout());
      drawArea = new DrawArea();
   
      content.add(drawArea, BorderLayout.CENTER);
   
      JPanel controls = new JPanel();
      JPanel colors = new JPanel();
      JPanel tools = new JPanel();
      JPanel thickness = new JPanel();
      controls.add(colors);
      controls.add(tools);
      controls.add(thickness);
      
      Border toolBorder = BorderFactory.createTitledBorder("Tools");
      controls.setBorder(toolBorder);
      Border colorBorder = BorderFactory.createTitledBorder("Colors");
      colors.setBorder(colorBorder);
      Border shapeBorder = BorderFactory.createTitledBorder("Shapes");
      tools.setBorder(shapeBorder);
      Border thicknessBorder = BorderFactory.createTitledBorder("Stroke");
      thickness.setBorder(thicknessBorder);
   
      ButtonGroup colorGroup = new ButtonGroup();
      ButtonGroup toolGroup = new ButtonGroup();
   
      redBtn = new JRadioButton("Rd");
      redBtn.addActionListener(actionListener);
      redBtn.setToolTipText("Red");
      orangeBtn = new JRadioButton("Og");
      orangeBtn.addActionListener(actionListener);
      orangeBtn.setToolTipText("Orange");
      yellowBtn = new JRadioButton("Yw");
      yellowBtn.addActionListener(actionListener);
      yellowBtn.setToolTipText("Yellow");
      greenBtn = new JRadioButton("Gn");
      greenBtn.addActionListener(actionListener);
      greenBtn.setToolTipText("Green");
      blueBtn = new JRadioButton("Bl");
      blueBtn.addActionListener(actionListener);
      blueBtn.setToolTipText("Blue");
      magentaBtn = new JRadioButton("Mg");
      magentaBtn.addActionListener(actionListener);
      magentaBtn.setToolTipText("Magenta");
      whiteBtn = new JRadioButton("Wt");
      whiteBtn.addActionListener(actionListener);
      whiteBtn.setToolTipText("White");
      blackBtn = new JRadioButton("Bk", true);
      blackBtn.addActionListener(actionListener);
      blackBtn.setToolTipText("Black");
      pencilBtn = new JRadioButton("Pn", true);
      pencilBtn.addActionListener(actionListener);
      pencilBtn.setToolTipText("Pencil");
      lineBtn = new JRadioButton("Ln");
      lineBtn.addActionListener(actionListener);
      lineBtn.setToolTipText("Line");
      rectangleBtn = new JRadioButton("Fr");
      rectangleBtn.addActionListener(actionListener);
      rectangleBtn.setToolTipText("Frame");
      filledRectangleBtn = new JRadioButton("Rc");
      filledRectangleBtn.addActionListener(actionListener);
      filledRectangleBtn.setToolTipText("Rectangle");
      ringBtn = new JRadioButton("Rn");
      ringBtn.addActionListener(actionListener);
      ringBtn.setToolTipText("Ring");
      ellipseBtn = new JRadioButton("El");
      ellipseBtn.addActionListener(actionListener);
      ellipseBtn.setToolTipText("Ellipse");
      clearBtn = new JButton("Clear");
      clearBtn.addActionListener(actionListener);
      clearBtn.setToolTipText("©2019 Created in conjunction by " + Global.authors);
      
      strokeSldr = new JSlider(1, 10, 1);
      strokeSldr.setMinorTickSpacing(1);
      strokeSldr.setPaintTicks(true);
      strokeSldr.setToolTipText("Stroke: 1");
      strokeSldr.addChangeListener(
               new ChangeListener() {
                  public void stateChanged(ChangeEvent e) {
                     Global.stroke = ((JSlider)e.getSource()).getValue();
                     strokeSldr.setToolTipText("Stroke: " + ((JSlider)e.getSource()).getValue());
                  }
               });
   
      
      colorGroup.add(redBtn);
      colorGroup.add(orangeBtn);
      colorGroup.add(yellowBtn);
      colorGroup.add(greenBtn);
      colorGroup.add(blueBtn);
      colorGroup.add(magentaBtn);
      colorGroup.add(whiteBtn);
      colorGroup.add(blackBtn);
      toolGroup.add(pencilBtn);
      toolGroup.add(lineBtn);
      toolGroup.add(rectangleBtn);
      toolGroup.add(filledRectangleBtn);
      toolGroup.add(ringBtn);
      toolGroup.add(ellipseBtn);
      colorGroup.add(clearBtn);
   
   
      colors.add(redBtn);
      colors.add(orangeBtn);
      colors.add(yellowBtn);
      colors.add(greenBtn);
      colors.add(blueBtn);
      colors.add(magentaBtn);
      colors.add(whiteBtn);
      colors.add(blackBtn);
      tools.add(pencilBtn);
      tools.add(lineBtn);
      tools.add(rectangleBtn);
      tools.add(filledRectangleBtn);
      tools.add(ringBtn);
      tools.add(ellipseBtn);
      thickness.add(strokeSldr);
      controls.add(clearBtn);
   
      content.add(controls, BorderLayout.NORTH);
   
      frame.setSize(1080, 840);
      
      frame.setResizable(false);
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frame.setVisible(true);
   }
}