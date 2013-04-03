package swingGuideBook;

import javax.swing.*;
import java.awt.*;

public class CheckBoxExample {
	JCheckBox redCB,blucCB,greenCB,yellowCB;
	
	public JPanel createContentPane() {
		JPanel totalGUI = new JPanel();
		
		//Create 4 checkboxes to control what is currently on-screen
		//At the start, we set the red checkbox to 'ticked' or selected
		
		JPanel checkBoxPanel = new JPanel();
		checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.PAGE_AXIS));
		checkBoxPanel.add(Box.createRigidArea(new Dimension(10,0)));
		
		redCB = new JCheckBox("Red");
		redCB.setSelected(true);
		checkBoxPanel.add(redCB);
		checkBoxPanel.add(Box.createHorizontalGlue());
		
		blucCB = new JCheckBox("Blue");
		checkBoxPanel.add(blucCB);
		checkBoxPanel.add(Box.createHorizontalGlue());
		
		greenCB = new JCheckBox("Green");
		checkBoxPanel.add(greenCB);
		checkBoxPanel.add(Box.createHorizontalGlue());
		
		yellowCB = new JCheckBox("Yellow");
		checkBoxPanel.add(yellowCB);
		checkBoxPanel.add(Box.createHorizontalGlue());
		
		//Now we create a simple JPanel that displays our four coloured boxes
		JPanel boxPanel = new JPanel(new GridLayout(2,2,20,20));
		
		JPanel redBox = createSquareJPanel(Color.red, 50);
		JPanel blueBox = createSquareJPanel(Color.blue, 50);
		JPanel greenBox = createSquareJPanel(Color.green, 50);
		JPanel yellowBox = createSquareJPanel(Color.yellow, 50);
		
		//Set all bars the red box to be hidden
		blueBox.setVisible(false);
		greenBox.setVisible(false);
		yellowBox.setVisible(false);
		
		boxPanel.add(redBox);
		boxPanel.add(blueBox);
		boxPanel.add(greenBox);
		boxPanel.add(yellowBox);
		
		totalGUI.add(checkBoxPanel);
		totalGUI.add(boxPanel);
		
		totalGUI.setOpaque(true);
		return totalGUI;
	}
	
	private JPanel createSquareJPanel(Color color, int size) {
		JPanel tempPanel = new JPanel();
		tempPanel.setBackground(color);
		tempPanel.setMinimumSize(new Dimension(size,size));
		tempPanel.setMaximumSize(new Dimension(size,size));
		tempPanel.setPreferredSize(new Dimension(size,size));
		return tempPanel;
	}
	
	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("[=] JCheckBox [=]");
		
		CheckBoxExample demo = new CheckBoxExample();
		frame.setContentPane(demo.createContentPane());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		//SChedule a job for the event-dispatching thread:
		//creating and showing this applications's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
