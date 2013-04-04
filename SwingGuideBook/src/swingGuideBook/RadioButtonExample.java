package swingGuideBook;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

public class RadioButtonExample implements  ActionListener{

    JRadioButton leadingButton, centerButton, trailingButton;
    JPanel cardPanel;
    String names[] = {"LEADING", "CENTER", "TRAILING"};

    public JPanel createContentPane (){
        
        JPanel totalGUI = new JPanel();
        
        // First, lets get on with creating the RadioButtons.
        // We create each RadioButton, then add it to a ButtonGroup.
        // This ButtonGroup deals with keeping only one selected.
        // We must also add them to a JPanel to display the RadioButtons.
        
        leadingButton = new JRadioButton(names[0]);
        leadingButton.addActionListener(this);
        leadingButton.setSelected(true);
        centerButton = new JRadioButton(names[1]);
        centerButton.addActionListener(this);
        trailingButton = new JRadioButton(names[2]);
        trailingButton.addActionListener(this);
        
        // Create the button group to keep only one selected.
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(leadingButton);
        btnGroup.add(centerButton);
        btnGroup.add(trailingButton);
        
        // Create the JPanel to display the RadioButtons.
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        
        buttonPanel.add(Box.createRigidArea(new Dimension(10,10)));
        buttonPanel.add(leadingButton);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(centerButton);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(trailingButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10,10)));
        
        // We create the first JPanel with the FlowLayout.
        // Although we could just use ONE Panel and simply change the 
        // align using .setAlignment(), this way we can use CardLayout again.
        
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        mainPanel.setPreferredSize(new Dimension(200, 120));
        mainPanel.setBackground(Color.gray);
    
        JPanel red = createSquareJPanel(Color.red, 50);
        JPanel blue = createSquareJPanel(Color.blue, 50);
        JPanel green = createSquareJPanel(Color.green, 50);
        JPanel orange = createSquareJPanel(Color.orange, 50);
        JPanel yellow = createSquareJPanel(Color.yellow, 50);
    
        mainPanel.add(red);
        mainPanel.add(blue);
        mainPanel.add(green);
        mainPanel.add(orange);
        mainPanel.add(yellow);
        
        // Second Panel.

        JPanel mainPanel_2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel_2.setPreferredSize(new Dimension(200, 120));
        mainPanel_2.setBackground(Color.gray);
    
        JPanel red_2 = createSquareJPanel(Color.red, 50);
        JPanel blue_2 = createSquareJPanel(Color.blue, 50);
        JPanel green_2 = createSquareJPanel(Color.green, 50);
        JPanel orange_2 = createSquareJPanel(Color.orange, 50);
        JPanel yellow_2 = createSquareJPanel(Color.yellow, 50);
    
        mainPanel_2.add(red_2);
        mainPanel_2.add(blue_2);
        mainPanel_2.add(green_2);
        mainPanel_2.add(orange_2);
        mainPanel_2.add(yellow_2);

        // Third Panel
        
        JPanel mainPanel_3 = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        mainPanel_3.setPreferredSize(new Dimension(200, 120));
        mainPanel_3.setBackground(Color.gray);
    
        JPanel red_3 = createSquareJPanel(Color.red, 50);
        JPanel blue_3 = createSquareJPanel(Color.blue, 50);
        JPanel green_3 = createSquareJPanel(Color.green, 50);
        JPanel orange_3 = createSquareJPanel(Color.orange, 50);
        JPanel yellow_3 = createSquareJPanel(Color.yellow, 50);
    
        mainPanel_3.add(red_3);
        mainPanel_3.add(blue_3);
        mainPanel_3.add(green_3);
        mainPanel_3.add(orange_3);
        mainPanel_3.add(yellow_3);
        
        // We create the CardPanel and give it plenty of padding.
        
        cardPanel = new JPanel(new CardLayout(50, 50));
        
        cardPanel.add(mainPanel, names[0]);
        cardPanel.add(mainPanel_2, names[1]);
        cardPanel.add(mainPanel_3, names[2]);

        // This sets the widgets on the screen to be layed out in a
        // top to bottom fashion with spacers inbetween.
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        
        bottomPanel.add(Box.createRigidArea(new Dimension(10,0)));
        bottomPanel.add(buttonPanel);
        bottomPanel.add(Box.createRigidArea(new Dimension(20,0)));
        bottomPanel.add(cardPanel);
        bottomPanel.add(Box.createRigidArea(new Dimension(10,0)));
        
        totalGUI.add(bottomPanel);
        totalGUI.setOpaque(true);
        return totalGUI;
    }

    // In this method, we create a square JPanel of a colour and set size
    // specified by the arguments.

    private JPanel createSquareJPanel(Color color, int size) {
        JPanel tempPanel = new JPanel();
        tempPanel.setBackground(color);
        tempPanel.setMinimumSize(new Dimension(size, size));
        tempPanel.setMaximumSize(new Dimension(size, size));
        tempPanel.setPreferredSize(new Dimension(size, size));
        return tempPanel;
    }

    // This actionPerformed simply takes sets the visibility of each
    // coloured box depending on what is selected on the combo box.

    public void actionPerformed(ActionEvent e) {

        // We need to get the current layout of the CardLayout panel
        // before we can change it.
        CardLayout cl = (CardLayout) (cardPanel.getLayout());

        if(e.getSource() == leadingButton)
        {
            cl.show(cardPanel, names[0]);
        }
        else if(e.getSource() == centerButton)
        {
            cl.show(cardPanel, names[1]);
        }
        else if(e.getSource() == trailingButton)
        {
            cl.show(cardPanel, names[2]);
        }
    }

    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("[=] JRadioButtons [=]");

        RadioButtonExample demo = new RadioButtonExample();
        frame.setContentPane(demo.createContentPane());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}