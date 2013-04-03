package swingGuideBook;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.Color;
	import java.awt.event.*;

	public class CheckBoxWithRefreshButton implements  ActionListener{
	    
	    JCheckBox redCB, blueCB, greenCB, yellowCB;
	    JPanel redBox, blueBox, greenBox, yellowBox;
	    JButton refresh;

	    public JPanel createContentPane (){
	        
	        JPanel totalGUI = new JPanel();
	        
	        // We create four checkboxes to control what is currently on-screen.
	        // At the start, we set the red checkbox to 'ticked' or selected.
	        
	        JPanel checkBoxPanel = new JPanel();
	        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.PAGE_AXIS));
	        checkBoxPanel.add(Box.createRigidArea(new Dimension(10,0)));

	        redCB = new JCheckBox("Red");
	        redCB.setSelected(true);
	        
	        checkBoxPanel.add(redCB);
	        checkBoxPanel.add(Box.createHorizontalGlue());
	        
	        blueCB = new JCheckBox("Blue");        
	        checkBoxPanel.add(blueCB);
	        checkBoxPanel.add(Box.createHorizontalGlue());
	        
	        greenCB = new JCheckBox("Green");
	        checkBoxPanel.add(greenCB);
	        checkBoxPanel.add(Box.createHorizontalGlue());
	        
	        yellowCB = new JCheckBox("Yellow");
	        checkBoxPanel.add(yellowCB);
	        checkBoxPanel.add(Box.createRigidArea(new Dimension(10, 0)));
	        
	        // Now we create a simple JPanel that displays our four coloured boxes.

	        JPanel boxPanel = new JPanel(new GridLayout(2, 2, 20, 20));
	        
	        redBox = createSquareJPanel(Color.red, 50);
	        blueBox = createSquareJPanel(Color.blue, 50);
	        greenBox = createSquareJPanel(Color.green, 50);
	        yellowBox = createSquareJPanel(Color.yellow, 50);
	        
	        // This sets all bar the red box to be hidden.
	  
	        blueBox.setVisible(false);
	        greenBox.setVisible(false);
	        yellowBox.setVisible(false);
	        
	        boxPanel.add(redBox);
	        boxPanel.add(blueBox);
	        boxPanel.add(greenBox);
	        boxPanel.add(yellowBox);
	        
	        // Now lets quickly add a refresh button with an actionListener to determine
			// when it is pressed.
	        
	        refresh = new JButton("Refresh");
	        refresh.addActionListener(this);
	        
	        totalGUI.add(checkBoxPanel);
	        totalGUI.add(boxPanel);
	        totalGUI.add(refresh);
	        
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
	    // coloured box to the state of each checkbox.
	        
	    public void actionPerformed(ActionEvent e) {
	        
	        if(e.getSource() == refresh)
	        {
	            redBox.setVisible(redCB.isSelected());
	            blueBox.setVisible(blueCB.isSelected());
	            greenBox.setVisible(greenCB.isSelected());
	            yellowBox.setVisible(yellowCB.isSelected());
	        }
	    }


	    private static void createAndShowGUI() {

	        JFrame.setDefaultLookAndFeelDecorated(true);
	        JFrame frame = new JFrame("[=] JCheckBox [=]");

	        CheckBoxWithRefreshButton demo = new CheckBoxWithRefreshButton();
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