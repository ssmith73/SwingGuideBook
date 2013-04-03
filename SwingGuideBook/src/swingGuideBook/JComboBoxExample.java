package swingGuideBook;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

public class JComboBoxExample implements  ActionListener{

    JComboBox colorChooser;
    JPanel redBox, blueBox, greenBox, yellowBox;
    JPanel coloredBoxArray[] = new JPanel[4];

    public JPanel createContentPane (){
        
        JPanel totalGUI = new JPanel();

        // To create a JComboBox, we need to pass in an array of Strings.
        // This gives the ComboBox the list of selections you can make.

        String colors[] = {"Red", "Blue", "Green", "Yellow"};
        
        colorChooser = new JComboBox(colors);
        colorChooser.setSelectedIndex(0);
        colorChooser.addActionListener(this);
        
        // Now we create a simple JPanel that displays our four coloured boxes.

        JPanel boxPanel = new JPanel(new GridLayout(2, 2, 20, 20));

        
        coloredBoxArray[0] = createSquareJPanel(Color.red, 50);
        coloredBoxArray[1] = createSquareJPanel(Color.blue, 50);
        coloredBoxArray[2] = createSquareJPanel(Color.green, 50);
        coloredBoxArray[3] = createSquareJPanel(Color.yellow, 50);
        
        //redBox = createSquareJPanel(Color.red, 50);
        //blueBox = createSquareJPanel(Color.blue, 50);
        //greenBox = createSquareJPanel(Color.green, 50);
        //yellowBox = createSquareJPanel(Color.yellow, 50);

        // This sets all bar the blue box to be hidden.

       // redBox.setVisible(false);
       // greenBox.setVisible(false);
       // yellowBox.setVisible(false);
        
        coloredBoxArray[1].setVisible(false);
        coloredBoxArray[2].setVisible(false);
        coloredBoxArray[3].setVisible(false);


        /*
        boxPanel.add(redBox);
        boxPanel.add(blueBox);
        boxPanel.add(greenBox);
        boxPanel.add(yellowBox);
        */

        boxPanel.add(coloredBoxArray[0]);
        boxPanel.add(coloredBoxArray[1]);
        boxPanel.add(coloredBoxArray[2]);
        boxPanel.add(coloredBoxArray[3]);
        
        // This sets the widgets on the screen to be layed out in a
        // top to bottom fashion with spacers inbetween.
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));
        
        bottomPanel.add(Box.createRigidArea(new Dimension(0,10)));
        bottomPanel.add(colorChooser);
        bottomPanel.add(Box.createRigidArea(new Dimension(0,20)));
        bottomPanel.add(boxPanel);
        bottomPanel.add(Box.createRigidArea(new Dimension(0,10)));
        
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

    	int temp;
    	if(e.getSource() == colorChooser)
    	{
    		temp = colorChooser.getSelectedIndex();
    		for(int i=0;i<4;i++) {
    			if(temp == i){
    				coloredBoxArray[i].setVisible(true);
    			}
    			else {
    				coloredBoxArray[i].setVisible(false);
    			}
    		}

    	}
    }
/*        
        if(e.getSource() == colorChooser)
        {
            temp = colorChooser.getSelectedIndex();
            
            switch(temp){
            case 0: 
                redBox.setVisible(true);
                blueBox.setVisible(false);
                greenBox.setVisible(false);
                yellowBox.setVisible(false);
                break;
            case 1:
                redBox.setVisible(false);
                blueBox.setVisible(true);
                greenBox.setVisible(false);
                yellowBox.setVisible(false);
                break;
            case 2:
                redBox.setVisible(false);
                blueBox.setVisible(false);
                greenBox.setVisible(true);
                yellowBox.setVisible(false);
                break;
            case 3:
                redBox.setVisible(false);
                blueBox.setVisible(false);
                greenBox.setVisible(false);
                yellowBox.setVisible(true);
                break;
            }
        }
    }
        */

    private static void createAndShowGUI() {
    
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("[=] JComboBox [=]");

        JComboBoxExample demo = new JComboBoxExample();
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