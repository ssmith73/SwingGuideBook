package swingGuideBook;
import javax.swing.*;
import java.awt.Color;

public class JButtonTests {
	
	public JPanel createContentPane () {
		//place all components on this JPanel
		JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null); //manually place components on panel
		
		//Build a panel to hold title labels.
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setLocation(10,0);
		titlePanel.setSize(250,30);
		totalGUI.add(titlePanel);
		
		//place two labels on the titlePanel
		JLabel redLabel = new JLabel("Red Team");
		redLabel.setLocation(0,0);
		redLabel.setSize(100,30);
		redLabel.setHorizontalAlignment(SwingConstants.CENTER);
		redLabel.setForeground(Color.red);
		titlePanel.add(redLabel);
		
		JLabel blueLabel = new JLabel("Blue Team");
		blueLabel.setLocation(120,0);
		blueLabel.setSize(100,30);
		blueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		blueLabel.setForeground(Color.blue);
		titlePanel.add(blueLabel);
		
		//Build a panel to hold score labels
		JPanel scorePanel = new JPanel();
		scorePanel.setLayout(null);
		scorePanel.setLocation(10,40);
		scorePanel.setSize(250,30);
		totalGUI.add(scorePanel);
		
		JLabel redScore = new JLabel("0");
		redScore.setLocation(0,0);
		redScore.setSize(100,30);
		redScore.setHorizontalAlignment(SwingConstants.CENTER);
		scorePanel.add(redScore);
		
		JLabel blueScore = new JLabel("0");
		blueScore.setLocation(120,0);
		blueScore.setSize(100,30);
		blueScore.setHorizontalAlignment(SwingConstants.CENTER);
		scorePanel.add(blueScore);
		
		//create a JPanel to contain all the JButtons.
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setLocation(10,80);
		buttonPanel.setSize(250,70);
		totalGUI.add(buttonPanel);
		
		//create a button and manipulate
		JButton redButton = new JButton("Red Score");
		redButton.setLocation(0,0);
		redButton.setSize(100,30);
		buttonPanel.add(redButton);
		
		JButton blueButton = new JButton("Blue Score");
		blueButton.setLocation(120,0);
		blueButton.setSize(100,30);
		buttonPanel.add(blueButton);
		
		JButton resetButton = new JButton("Reset Score");
		resetButton.setLocation(0,40);
		resetButton.setSize(220,30);
		buttonPanel.add(resetButton);
		
		totalGUI.setOpaque(true);
		return totalGUI;
	}
	private static void createAndShowGui() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("[=] JButton Scores [=]");
		
		//create and setup content pane
		JButtonTests demo = new JButtonTests();
		frame.setContentPane(demo.createContentPane());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250,190);
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
