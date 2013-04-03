package swingGuideBook;
import javax.swing.*;
import java.awt.*;

public class CalculatorLayout{
   
    // Creating the buttons and Strings used for the content pane.
    JButton[] numbers = new JButton[10];
    JButton[] controllers = new JButton[4];
    JButton[] equals = new JButton[1];
    JButton[] editors = new JButton[3];
    
    String[] numbers_name = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    String[] controllers_name = {"+", "-", "*", "/"};
    String[] equals_name = {"="};
    String[] editors_name = {"Backspace", "C", "CE"};
    
    JTextField answer;
    
    public JPanel createContentPane (){
        
        // The instantiation of all the Buttons needed for the calculator.
        JPanel totalGUI = new JPanel();
        
        JPanel answers_panel = new JPanel();
        answers_panel.setSize(new Dimension(20,20));
        answer = new JTextField("0", 20);
        answers_panel.add(answer);
        //answers_panel.setBackground(Color.red);
        //answers_panel.setOpaque(true);
        
        
        JPanel numbers_panel = new JPanel();
        numbers_panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;       
        c.fill = GridBagConstraints.NONE;      
        
   //     panelMaker(numbers, numbers_name, numbers_panel, Color.blue);
        
  //  private static void panelMaker(JButton[] buttons, String[] strings, JPanel panel, Color colour)
        
      	int button_count = 0;
        for(int row = 0; row < 4; row++) {
        	c.gridy = row;
        	System.out.println("ROW: " + row);
        	for(int col = 0; col < 3; col++) {
        		System.out.println("button_count: " + button_count);
        		if(row == 3 && col == 1)
        			break;
        		c.gridx = col;
        		numbers[button_count] = new JButton(numbers_name[button_count]);
        		numbers[button_count].setForeground(Color.blue);
        		numbers_panel.add(numbers[button_count],c);
        		button_count++;
        		System.out.println("COL: " + col);
        	}
        }
        
        
        
        JPanel controllers_panel = new JPanel();
        panelMaker(controllers, controllers_name, controllers_panel, Color.red);
        
        JPanel equals_panel = new JPanel();
        panelMaker(equals, equals_name, equals_panel, Color.BLACK);
        
        JPanel editors_panel = new JPanel();
        panelMaker(editors, editors_name, editors_panel, Color.orange);
        //editors_panel.setBackground(Color.black);
        //editors_panel.setOpaque(true);
        
        // **** ANSWERS HERE **** //
        // Here is where you set the layouts of the different panels.
        // With different Layouts used, you can place things differently.
        // You may need to edit the code outside of this area if you wish to 
        // impress and use more complicated layouts.
        
	        // We create a JPanel with the GridLayout.
	        //                                  (rows,cols, hgap,vgap)
        //normal grid layout sets the rows to be the same, i.e. the largest
        //of all the rows, this skews the layout
        
        totalGUI.setLayout(new GridBagLayout());
        GridBagConstraints d = new GridBagConstraints();
        d.gridx = 0;
        d.gridy = 0;       
        d.fill = GridBagConstraints.NONE;      
        
        controllers_panel.setLayout(new FlowLayout());
        equals_panel.setLayout(new FlowLayout());
        editors_panel.setLayout(new FlowLayout());
        
        // The panels are added to the back panel.
        totalGUI.add(answers_panel,d);
        d.gridy = 1;       
        totalGUI.add(editors_panel,d);
        d.gridy = 2;       
        totalGUI.add(controllers_panel,d);
        d.gridy = 3;       
        totalGUI.add(numbers_panel,d);
        d.gridy = 4;       
        totalGUI.add(equals_panel,d);
        
        totalGUI.setOpaque(true);
        return totalGUI;
    }
    
    // Creates the buttons needed for each panel.
    private static void panelMaker(JButton[] buttons, String[] strings, JPanel panel, Color colour)
    {
        for(int i = 0; i < buttons.length; i++)
        {
            buttons[i] = new JButton(strings[i]);
            buttons[i].setForeground(colour);
            panel.add(buttons[i]);
        }
    }

    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("[=] Calculator [=]");

        CalculatorLayout demo = new CalculatorLayout();
        frame.setContentPane(demo.createContentPane());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Remember, because we are no longer using Absolute Positioning,
        // we use the .pack() command.
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

// *************************************************************
// Name : CalculatorLayout.java
// Author : Stuart Davidson
// Date : 14/05/2007
// Description : A template for students to attempt the third exercise.
// Version : 1.0
// *************************************************************