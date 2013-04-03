package swingGuideBook;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class GridBagLayoutExample1{

	public JPanel createContentPane (){

		JPanel totalGUI = new JPanel();

		// We create a JPanel with the GridBagLayout.
		// We also create a GridBagConstraints Object.

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// For each item we create to add to the mainPanel...

		JPanel red = createSquareJPanel(Color.red, 50);

		// We need to define the GridBagConstraints.
		// This defines the widget to go in grid (0,0)

		c.gridx = 0;
		c.gridy = 0;

		// This tells the widget not to change size
		// to fit the cell. 

		c.fill = GridBagConstraints.NONE;
		

		// Once we are happy with the constraints we set.
		// We can add the widget to the JPanel.
		// Remember to add the constraints as the second argument.

		mainPanel.add(red, c);

		// The constraints we used for the previous one are still in c
		// so we can use them again for the next widget if we wish.

		JPanel blue = createSquareJPanel(Color.blue, 60);
		c.gridx = 1;
		// c.gridy = 0 is still set from the previous constraints.
		// c.fill = GridBagConstraints.NONE; is still set too.

		mainPanel.add(blue, c);

		JPanel green = createSquareJPanel(Color.green, 70);
		c.gridx = 2;
		mainPanel.add(green, c);

		JPanel orange = createSquareJPanel(Color.orange, 80);
		c.gridx = 3;
		mainPanel.add(orange, c);

		JPanel yellow = createSquareJPanel(Color.yellow, 90);
		c.gridx = 4;
		mainPanel.add(yellow, c);

		// We finish by adding the mainPanel to the totalGUI
		// and returning the JPanel to be set as the content pane.

		totalGUI.add(mainPanel);
		totalGUI.setOpaque(true);
		return totalGUI;
	}

	// In this method, we create a square JPanel of a colour and set size
	// specified by the arguments.

	private JPanel createSquareJPanel(Color color, int size)
	{
		JPanel tempPanel = new JPanel();
		tempPanel.setBackground(color);
		tempPanel.setMinimumSize(new Dimension(size, size));
		tempPanel.setMaximumSize(new Dimension(size, size));
		tempPanel.setPreferredSize(new Dimension(size, size));
		return tempPanel;
	}

	private static void createAndShowGUI() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("[=] GridBagLayout [=]");

		GridBagLayoutExample1 demo = new GridBagLayoutExample1();
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