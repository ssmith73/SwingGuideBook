package swingGuideBook;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

//JToggleButton uses an itemListener, not an Action listener
public class ToggleButtonExample implements ItemListener {

	JToggleButton toggleButton;
	JPanel totalGUI;

	public JPanel createContentPane() {
		//create a panel to place everything on
		totalGUI = new JPanel();
		totalGUI.setBackground(Color.red);
		totalGUI.setLayout(null);

		toggleButton = new JToggleButton("OFF");
		toggleButton.setLocation(75,10);
		toggleButton.setSize(100, 100);
		toggleButton.addItemListener(this);
		totalGUI.add(toggleButton);

		totalGUI.setOpaque(true);
		return totalGUI;

	}

	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			toggleButton.setText("On!");
			totalGUI.setBackground(Color.green);
		}
		else {
			toggleButton.setText("Off!");
			totalGUI.setBackground(Color.red);
		}
	}

	private static void createAndShowGui() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("[=] JToggleButton [=]");

		//Create and setup the content pane
		ToggleButtonExample demo = new ToggleButtonExample();
		frame.setContentPane(demo.createContentPane());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250,150);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this applications GUI

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				createAndShowGui();
			}
		});
	}
}

