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
	int yellowScoreAmount = 0;
	
	JPanel 	titlePanel,scorePanel,buttonPanel;
	JLabel 	yellowLabel,redLabel,blueLabel,redScore,blueScore,yellowScore;
	JButton yellowButton,redButton,blueButton,resetButton;
	
	public JPanel createContentPane () {
		//place all components on this JPanel
		JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null); //manually place components on panel
		
		//Build a panel to hold title labels.
		titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setLocation(10,0);
		titlePanel.setSize(410,30);
		totalGUI.add(titlePanel);
		
		//place two labels on the titlePanel
		redLabel = new JLabel("Red Team");
		redLabel.setLocation(0,0);
		redLabel.setSize(120,30);
		redLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//redLabel.setForeground(Color.red);
		//redLabel.setBackground(Color.black);
		redLabel.setOpaque(true);
		titlePanel.add(redLabel);
		
		blueLabel = new JLabel("Blue Team");
		blueLabel.setLocation(130,0);
		blueLabel.setSize(120,30);
		blueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//blueLabel.setForeground(Color.blue);
		//blueLabel.setBackground(Color.black);
		blueLabel.setOpaque(true);
		titlePanel.add(blueLabel);
		
		yellowLabel = new JLabel("Yellow Team");
		yellowLabel.setLocation(260,0);
		yellowLabel.setSize(120,30);
		yellowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//yellowLabel.setForeground(Color.yellow);
		//yellowLabel.setBackground(Color.black);
		yellowLabel.setOpaque(true);
		titlePanel.add(yellowLabel);
		
		//Build a panel to hold score labels
		scorePanel = new JPanel();
		scorePanel.setLayout(null);
		scorePanel.setLocation(10,40);
		scorePanel.setSize(400,30);
		totalGUI.add(scorePanel);
		
		redScore = new JLabel("" + redScoreAmount);
		redScore.setLocation(0,0);
		redScore.setSize(120,30);
		redScore.setHorizontalAlignment(SwingConstants.CENTER);
		scorePanel.add(redScore);
		
		blueScore = new JLabel("" + blueScoreAmount);
		blueScore.setLocation(130,0);
		blueScore.setSize(120,30);
		blueScore.setHorizontalAlignment(SwingConstants.CENTER);
		scorePanel.add(blueScore);
		
		yellowScore = new JLabel("" + yellowScoreAmount);
		yellowScore.setLocation(260,0);
		yellowScore.setSize(120,30);
		yellowScore.setHorizontalAlignment(SwingConstants.CENTER);
		scorePanel.add(yellowScore);
		
		//create a JPanel to contain all the JButtons.
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setLocation(10,80);
		buttonPanel.setSize(400,70);
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
		
		yellowButton = new JButton("Yellow Score");
		yellowButton.setLocation(260,0);
		yellowButton.setSize(120,30);
		yellowButton.addActionListener(this);
		buttonPanel.add(yellowButton);
		
		resetButton = new JButton("Reset Score");
		resetButton.setLocation(0,40);
		resetButton.setSize(380,30);
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
		frame.setSize(410,190);
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
		else if(e.getSource() == yellowButton) {
			yellowScoreAmount +=3;
			yellowScore.setText("" + yellowScoreAmount);
		}
		else if(e.getSource() == resetButton) {
			redScoreAmount = 0;
			blueScoreAmount = 0;
			yellowScoreAmount = 0;
			redScore.setText("" + redScoreAmount);
			blueScore.setText("" + blueScoreAmount);
			yellowScore.setText("" + blueScoreAmount);
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
