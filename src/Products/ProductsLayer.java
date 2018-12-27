package Products;

import Util.Food;
import Util.Common;
import java.awt.Color;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Yeoman
 */
public class ProductsLayer extends JFrame implements ActionListener {

    List<Food> foods = new LinkedList<Food>();
    private static int countItems = 0;
    JPanel topHeaderPanel = new JPanel();
    JPanel bottomHeaderPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel panel = new JPanel();
    JPanel pane = new JPanel();

    JLabel title = new JLabel("Product List");
    JLabel ftitle = new JLabel("Food Name", JLabel.CENTER);
    JLabel quantity = new JLabel("<html>Quantity Left<br/>in Stock</html>",JLabel.CENTER);
    JLabel Price = new JLabel("<html>Price<br/>per Order</html>", JLabel.CENTER);
    JLabel QuantityBasket = new JLabel("<html>Quantities<br/>To Add</html>", JLabel.RIGHT);
    int producstCounts = 0;
    JButton submitBtn = new JButton("Add to in Basket");
    public static boolean validateSelection = true;
    
    public ProductsLayer() {
        createView();

        // Make window exit on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set size
        setSize(new Dimension(1000, 1000));
        // center in the middle of screen
        setLocationRelativeTo(null);
        // Title of Form
        setTitle("Products Form");
        // Disable Resize
        setResizable(false);
    }

    public void createView() {
        JPanel panelMain = new JPanel();
        JPanel RootPanel = new JPanel();

        getContentPane().add(RootPanel);
        // Root layout
        RootPanel.setLayout(new BoxLayout(RootPanel, BoxLayout.Y_AXIS));
        // labels layout
        JPanel labelsPanel = new JPanel(new GridLayout(0, 7));
        // showing products (data) layout
        JPanel datapanel = new JPanel(new GridLayout(0, 7));
        // add scroll to data panel
        JScrollPane datapanelScroll = new JScrollPane(datapanel);
        datapanelScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        datapanelScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        datapanelScroll.setPreferredSize(new Dimension(800, 700));

        topHeaderPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        topHeaderPanel.setPreferredSize(new Dimension(1000, 90));
        bottomHeaderPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        bottomHeaderPanel.setPreferredSize(new Dimension(800, 60));
        datapanel.setPreferredSize(new Dimension(800, 800));
        labelsPanel.setPreferredSize(new Dimension(800, 50));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        footerPanel.setPreferredSize(new Dimension(1000, 90));
//        bottomHeaderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMain.setAlignmentX(Component.CENTER_ALIGNMENT);
        footerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //panelMain including all other panels
        panelMain.add(topHeaderPanel);
        panelMain.add(bottomHeaderPanel);
        panelMain.add(datapanelScroll);
        panelMain.add(footerPanel);
        // Main panel including main panel
        RootPanel.add(panelMain);

        // styles
        labelsPanel.add(new JLabel(" "));
        labelsPanel.add(new JLabel(" "));        
        labelsPanel.add(new JLabel(" "));

        labelsPanel.add(ftitle);
        labelsPanel.add(quantity);
        labelsPanel.add(Price);
        labelsPanel.add(QuantityBasket); 
        ftitle.setHorizontalAlignment(JLabel.CENTER);
        quantity.setHorizontalAlignment(JLabel.CENTER);
        Price.setHorizontalAlignment(JLabel.CENTER);
        QuantityBasket.setHorizontalAlignment(JLabel.CENTER);

        title.setFont(new java.awt.Font("Tahoma", 0, 40));
        ftitle.setFont(new java.awt.Font("Arial Narrow", Font.BOLD, 15));
        quantity.setFont(new java.awt.Font("Arial Narrow", Font.BOLD, 15));
        Price.setFont(new java.awt.Font("Arial Narrow", Font.BOLD, 15));
        QuantityBasket.setFont(new java.awt.Font("Arial Narrow", Font.BOLD, 15));
        submitBtn.setFont(new java.awt.Font("Tahoma", 0, 20));
        submitBtn.setBackground(Color.decode("#4098e3"));
        submitBtn.setForeground(Color.WHITE);
        // panels components
        topHeaderPanel.add(title);
        bottomHeaderPanel.add(labelsPanel);
        footerPanel.add(submitBtn);
        // action listen for submit button
        submitBtn.addActionListener(this);

        /**
         * @Description Calling DataAccess layer for getting all products
         * @See DataAccessLayer.Products()
         * @return HashSet
         */
        DataAccessLayer.Products Products = new DataAccessLayer.Products();
        Iterator<Food> productsList = Products.getAllProducts().iterator();

        while (productsList.hasNext()) {
            Food singleFoodArray = new Food();
            singleFoodArray = productsList.next();
            int productID = singleFoodArray.getId();
            String productName = singleFoodArray.getTitle();
            int productQuantity = singleFoodArray.getQuantity();
            double productPrice = singleFoodArray.getPrice();
            producstCounts++;
            // Checkbox
            JCheckBox button1 = new JCheckBox("");
            datapanel.add(button1);
            // Image
            JButton button2 = new JButton(new ImageIcon(getClass().getResource("/Pictures/" + productName + ".jpg")));
            button2.setBorderPainted(false);
            button2.setFocusPainted(false);
            button2.setContentAreaFilled(false);
            datapanel.add(button2);
            
            datapanel.add(new JLabel(" "));

            // Title
            JLabel button3 = new JLabel("" + productName, JLabel.CENTER);
            button3.setFont(new java.awt.Font("Arial", 0, 18));
            datapanel.add(button3);
            // Quantity
            JLabel button4 = new JLabel("" + productQuantity, JLabel.CENTER);
            button4.setFont(new java.awt.Font("Arial", 0, 18));
            datapanel.add(button4);
            // Price
            JLabel button5 = new JLabel("" + productPrice + "$", JLabel.CENTER);
            button5.setFont(new java.awt.Font("Arial", 0, 18));
            datapanel.add(button5);
            // Number of selections
            JTextField button6 = new JTextField(5);
            button6.setFont(new java.awt.Font("Arial", 0, 20));
            button6.setPreferredSize(new Dimension(2, 2));
            button6.setText("" + 0);
            button6.setEditable(false);
            datapanel.add(button6);
            // EVENT'S
            button6.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char ch = e.getKeyChar();
                    JTextField textField = (JTextField) e.getSource();
                    String text = textField.getText();

                    if (!Common.isNumber(ch)) {
                        e.consume();
                    }
                }
                @Override
                public void keyReleased(KeyEvent e) {
                    JTextField textField = (JTextField) e.getSource();
                    String text = textField.getText();
//                    System.out.println("Text=" + text);
                    char ch = e.getKeyChar();
                    //System.out.println( Integer.parseInt(button6.getText()) );
                    if (Common.isNumber(ch)) {
                        button6.setText(text.replaceFirst("^0+(?!$)", ""));
                    }
                    if (button1.isSelected()) {
                        System.out.println("product_name=" + productName);
                        button1.doClick();
                        button1.doClick(10);
                    }
                    // if user is coming back to change just check validation is false already
                    Helper.clearValidation(validateSelection);
                }
                @Override
                public void keyPressed(KeyEvent e) {
                    JTextField textField = (JTextField) e.getSource();
                    String text = textField.getText();
                    if (text.isEmpty()) {
                        button6.setText("0");
                    }
                }
            });
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (button1.isSelected()) {
                        button6.setEditable(true); // making quantity to add in bakset enabled
                        countItems++;
                        foods.add(new Food(productID, productName, productQuantity, productPrice, Integer.parseInt(button6.getText())));
                        System.out.println( button6.getText() );
                        //JOptionPane.showMessageDialog(panel, Integer.parseInt(button6.getText()));
                    } else {
                        button6.setEditable(false); // making quantity to add in bakset enabled
                        //button6.setText("0");
                        countItems--;
                        foods.remove(new Food(productID, productName, productQuantity, productPrice, Integer.parseInt(button6.getText())));
                        //System.out.println(foods);
                        System.out.println(button6.getText());
                    }
                }
            });
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            validateSelection = Helper.checkForEmptySelections(foods.size());
            if (validateSelection == false) {
                JOptionPane.showMessageDialog(null, "SORRY, Please select a Product first", "No Product Selected", JOptionPane.ERROR_MESSAGE);
            } else {
                validateSelection = Helper.validateProductsSelections(foods);                
            }
            if(validateSelection) {
                Basket.BasketLayer BasketPLayer = new Basket.BasketLayer(foods, countItems);
                BasketPLayer.setVisible(true);
                setVisible(false);
                dispose();
            }
        }
    }
}
