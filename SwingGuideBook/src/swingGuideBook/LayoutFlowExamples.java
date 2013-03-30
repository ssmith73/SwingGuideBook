package swingGuideBook;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class LayoutFlowExamples {
	
	public JPanel createContentPane() {
		JPanel totalGUI = new JPanel();
		/* We create a JPanel with the FlowLayout
		 * FlowLayout is the default layoutManager of the JPanel 
		 * In FlowLayout, widgets are placed one after another 
		 * going left to right. This occurs until the end of 
		 * the JPanel is reached, then a new row is started.
		 * There are three constructors for the FlowLayout.
		 * FlowLayout(); FlowLayout(int alignment)
 * FlowLayout(int alignment, int horizontalSpace, int verticalSpace);
		 */
		
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		mainPanel.setPreferredSize(new Dimension(200,120));
		
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
		
		totalGUI.add(mainPanel);
		totalGUI.setOpaque(true);
		return totalGUI;
	}
	
	/*
	 * In this method, we create a square JPanel of a colour and set
	 * size, specifie by the arguments.
	 */
	private JPanel createSquareJPanel(Color colour,int size) {
		JPanel tempPanel = new JPanel();
		tempPanel.setBackground(colour);
		tempPanel.setMinimumSize(new Dimension(size,size));
		tempPanel.setMaximumSize(new Dimension(size,size));
		tempPanel.setPreferredSize(new Dimension(size,size));
		return tempPanel;
	}
	
	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("[=] FlowLayout [=]");
		
		LayoutFlowExamples demo = new LayoutFlowExamples();
		frame.setContentPane(demo.createContentPane());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this applications GUI
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				createAndShowGUI();
				
			}
		});

	}

}
