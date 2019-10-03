import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.Graphics;
import javax.imageio.ImageIO;
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
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JDialog;
import javax.swing.DefaultListModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.lang.Math;
public class OrderUp extends JFrame{
      
      //GUI initializations
      JButton addButton, coutButton;
      JComboBox<String> menuBox;
      JCheckBox sodaBox, gbreadBox, pcheeseBox;
      JList orderItems;
      JRadioButton smallBtn, mediumBtn, largeBtn;
      JDialog itemDialog, coutDialog;
      DefaultListModel model = new DefaultListModel();
      String orderSize, soda, garlicBread, parmesanCheese;
      JMenu menu;
      
      //Math values
      int items;
      float total;
      
      double pSoda = .99;
      double pGB = 2.99;
      double pPC = 1.99;
      int cSmall = 0;
      int cMedium = 0;
      int cLarge = 0;
      int cSoda = 0;
      int cGB = 0;
      int cPC = 0;
      
      //Add to order
      ActionListener actionListener = new ActionListener() {
         public void actionPerformed(ActionEvent e){
            items = 1;
            String order = "";
            String orderSum = ""; 
            if (e.getSource() == addButton) {
               
               
               
               if (((String)menuBox.getSelectedItem()).equals("Select an item")) {
                  itemDialog.setVisible(true);
               }
               else {
                  String orderItem = (String)menuBox.getSelectedItem();
                  if (!sodaBox.isSelected()) { soda = "no";}
                  if (!gbreadBox.isSelected()) { garlicBread = "no";}
                  if (!pcheeseBox.isSelected()) { parmesanCheese = "no";}
                  if (sodaBox.isSelected()) { total += pSoda; items++; cSoda++;}
                  if (gbreadBox.isSelected()) { total += pGB; items++; cGB++;}
                  if (pcheeseBox.isSelected()) { total += pPC; items++; cPC++;}
                  
                  order = orderItem + ", " +
                  "Size: " + orderSize + ", " +
                  "Has soda: " + soda + ", " +
                  "Has garlic bread: " + garlicBread + ", " + 
                  "Has parmesan cheese: " + parmesanCheese;                                                                
               }                               
            orderSum = "You have a total of " + items + " items which comes to a total of $" + total;

            model.addElement(order);
            model.addElement(orderSum);  
            model.addElement("");            
            }
            
            //Checkout      
            else if (e.getSource() == coutButton) {
            model.addElement(""); model.addElement("");
            model.addElement("It looks like your grand total is $" + total);
            model.addElement(""); model.addElement("");
            model.addElement("I hope you enjoy your: ");
            
            if(cSmall != 0){   
               if(cSmall==1){
                  model.addElement(cSmall + " Small entree");
               } 
               else { model.addElement(cSmall + " Small entrees"); } 
            }
            if(cMedium != 0){   
               if(cMedium==1){
                  model.addElement(cMedium + " Medium entree");
               } 
               else { model.addElement(cMedium + " Medium entrees"); } 
            }
            if(cLarge != 0){   
               if(cLarge==1){
                  model.addElement(cLarge + " Large entree");
               } 
               else { model.addElement(cLarge + " Large entrees"); } 
            }
            if(cSoda != 0){   
               if(cSoda==1){
                  model.addElement("1 Soda");
               } 
               else { model.addElement(cSoda + " Orders of Soda"); } 
            }
            if(cGB != 0){   
               if(cGB==1){
                  model.addElement("1 Garlic Bread");
               } 
               else { model.addElement(cGB + " Orders of Garlic Bread"); } 
            }
            if(cPC != 0){   
               if(cPC==1){
                  model.addElement("1 Parmesan Cheese");
               } 
               else { model.addElement(cSoda + " Orders of Parmesan Cheese"); } 
            }                        
            
         total = 0; 
         model.addElement("If you would like to submit another order, please reopen the client");           
    }
  
            
             else if (e.getSource() == smallBtn) {
               orderSize = "small";
               total += 5.99;
               cSmall++;
            } else if (e.getSource() == mediumBtn) {
               orderSize = "medium";
               total += 7.99;
               cMedium++;
            } else if (e.getSource() == largeBtn) {
               orderSize = "large";
               total += 9.99;
               cLarge++;
            } else if (e.getSource() == sodaBox) {
               if (sodaBox.isSelected())
                  soda = "yes";
               else
                  soda = "no";
            } else if (e.getSource() == gbreadBox) {
               if (gbreadBox.isSelected())
                  garlicBread = "yes";
               else
                  garlicBread = "no";
            } else if (e.getSource() == pcheeseBox) {
               if (pcheeseBox.isSelected())
                  parmesanCheese = "yes";
               else
                  parmesanCheese = "no";
            } else if (e.getSource() == coutButton){
               total = 0;
            }
                         
         }
      };
      

   public static void main(String[] args) {
            new OrderUp().show();

   }
   
   public void show() {
         JFrame frame = new JFrame("Order Up");
         Container content = frame.getContentPane();
         JPanel order = new JPanel();
         JPanel size = new JPanel();
         JPanel options = new JPanel();
         JPanel orderList = new JPanel();
         
         Border orderBorder = BorderFactory.createTitledBorder("Order Settings");
         order.setBorder(orderBorder);
         Border sizeBorder = BorderFactory.createTitledBorder("Item Size");
         size.setBorder(sizeBorder);
         Border optionsBorder = BorderFactory.createTitledBorder("Item Options");
         options.setBorder(optionsBorder);
         Border orderReviewBorder = BorderFactory.createTitledBorder("Order Review");
         orderList.setBorder(orderReviewBorder);
         content.add(order, BorderLayout.NORTH);
         content.add(orderList, BorderLayout.SOUTH);
         
         String[] menuItems = {"Select an Item", "Cheese Pizza", "Pepperoni Pizza", "Fettuccine Alfredo", "Spaghetti"};
         menuBox = new JComboBox<>(menuItems);
         order.add(menuBox);
         
         ButtonGroup sizeGroup = new ButtonGroup();
         smallBtn = new JRadioButton("Small, $5.99", true);
         smallBtn.addActionListener(actionListener);
         mediumBtn = new JRadioButton("Medium, $7.99");
         mediumBtn.addActionListener(actionListener);
         largeBtn = new JRadioButton("Large, $9.99");
         largeBtn.addActionListener(actionListener);
         sizeGroup.add(smallBtn);
         sizeGroup.add(mediumBtn);
         sizeGroup.add(largeBtn);
         size.add(smallBtn);
         size.add(mediumBtn);
         size.add(largeBtn);
         order.add(size);
                 
         sodaBox = new JCheckBox("Soda, $0.99");
         sodaBox.addActionListener(actionListener);
         gbreadBox = new JCheckBox("Garlic Bread, $2.99");
         gbreadBox.addActionListener(actionListener);
         pcheeseBox = new JCheckBox("Parmesan Cheese, $1.99");
         pcheeseBox.addActionListener(actionListener);
         options.add(sodaBox);
         options.add(gbreadBox);
         options.add(pcheeseBox);
         order.add(options);
         
         addButton = new JButton("Add to order");
         try {
            Image img = ImageIO.read(getClass().getResource("Images/ic_add_black_24dp.png"));
            addButton.setIcon(new ImageIcon(img));
         }
         catch (Exception ex){
            System.out.println(ex);
         }
         addButton.addActionListener(actionListener);
         order.add(addButton);
         
         coutButton = new JButton("Checkout");
         try {
            Image img = ImageIO.read(getClass().getResource("Images/ic_done_black_24dp.png"));
            coutButton.setIcon(new ImageIcon(img));
         }
         catch (Exception ex){
            System.out.println(ex);
         }
         coutButton.addActionListener(actionListener);       
         orderList.add(coutButton, BorderLayout.EAST);
         
         orderItems = new JList(model);
         content.add(orderItems);
         
         JDialog itemDialog = new JDialog(frame, "Error");
         JLabel label = new JLabel("          Please select an item.");
         itemDialog.add(label);
         itemDialog.setSize(200, 100);
         
         JMenuBar mbar = new JMenuBar();
         
         menu = new JMenu("Info");
         JMenuItem authors = new JMenuItem("Developed by Francis Hayes & Jacob Dangler");
         JMenuItem version = new JMenuItem("v 1.0");
         JMenuItem copyright = new JMenuItem("©2019");
         menu.add(authors);
         menu.add(copyright);
         mbar.add(menu);
         frame.setJMenuBar(mbar);

         
         frame.setSize(1200, 600);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
         
   }
}
