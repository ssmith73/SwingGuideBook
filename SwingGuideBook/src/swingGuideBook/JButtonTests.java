package swingGuideBook;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JButtonTests implements ActionListener {
	/*
	 * JButtons use ActionListeners, buttons, textFields and menuItems all 
	 * use ActionListeners
	 */
	
	int redScoreAmount = 0;
	int blueScoreAmount = 0;
	
	JPanel 	titlePanel,scorePanel,buttonPanel;
	JLabel 	redLabel,blueLabel,redScore,blueScore;
	JButton redButton,blueButton,resetButton;
	
	public JPanel createContentPane () {
		//place all components on this JPanel
		JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null); //manually place components on panel
		
		//Build a panel to hold title labels.
		titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setLocation(10,0);
		titlePanel.setSize(250,30);
		totalGUI.add(titlePanel);
		
		//place two labels on the titlePanel
		redLabel = new JLabel("Red Team");
		redLabel.setLocation(0,0);
		redLabel.setSize(100,30);
		redLabel.setHorizontalAlignment(SwingConstants.CENTER);
		redLabel.setForeground(Color.red);
		titlePanel.add(redLabel);
		
		blueLabel = new JLabel("Blue Team");
		blueLabel.setLocation(120,0);
		blueLabel.setSize(100,30);
		blueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		blueLabel.setForeground(Color.blue);
		titlePanel.add(blueLabel);
		
		//Build a panel to hold score labels
		scorePanel = new JPanel();
		scorePanel.setLayout(null);
		scorePanel.setLocation(10,40);
		scorePanel.setSize(250,30);
		totalGUI.add(scorePanel);
		
		redScore = new JLabel("" + redScoreAmount);
		redScore.setLocation(0,0);
		redScore.setSize(120,30);
		redScore.setHorizontalAlignment(SwingConstants.CENTER);
		redScore.setBackground(Color.red);
		try {
			redScore.wait(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		redScore.setBackground(Color.blue);
		scorePanel.add(redScore);
		
		blueScore = new JLabel("" + blueScoreAmount);
		blueScore.setLocation(130,0);
		blueScore.setSize(120,30);
		blueScore.setHorizontalAlignment(SwingConstants.CENTER);
		scorePanel.add(blueScore);
		
		//create a JPanel to contain all the JButtons.
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setLocation(10,80);
		buttonPanel.setSize(260,70);
		totalGUI.add(buttonPanel);
		
		//create a button and manipulate
		redButton = new JButton("Red Score");
		redButton.setLocation(0,0);
		redButton.setSize(120,30);
		redButton.addActionListener(this);
		buttonPanel.add(redButton);
		
		blueButton = new JButton("Blue Score");
		blueButton.setLocation(130,0);
		blueButton.setSize(120,30);
		blueButton.addActionListener(this);
		buttonPanel.add(blueButton);
		
		resetButton = new JButton("Reset Score");
		resetButton.setLocation(0,40);
		resetButton.setSize(250,30);
		resetButton.addActionListener(this);
		buttonPanel.add(resetButton);
		
		totalGUI.setOpaque(true);
		return totalGUI;
	}
	private static void createAndShowGui() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("[=] JButton Scores with Action Buttons [=]");
		
		//create and setup content pane
		JButtonTests demo = new JButtonTests();
		frame.setContentPane(demo.createContentPane());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(280,190);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == redButton) {
			redScoreAmount++;
			redScore.setText("" + redScoreAmount);
		}
		else if(e.getSource() == blueButton) {
			blueScoreAmount++;
			blueScore.setText("" + blueScoreAmount);
		}
		else if(e.getSource() == resetButton) {
			redScoreAmount = 0;
			blueScoreAmount = 0;
			redScore.setText("" + redScoreAmount);
			blueScore.setText("" + blueScoreAmount);
		}
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
