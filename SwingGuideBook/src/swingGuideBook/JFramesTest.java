package swingGuideBook;
import javax.swing.*;

/*
 *    --------Root Pane --(top level containers)------
 *   |												  |
 *   |	 JFrame, JDialog or JApplet					  |	
 *   |												  |
 *   |    -------------Layered Pane -----------------------
 *   |   |			  								       |
 *   |   |										           |
 *   |   | 	   -------------Content Pane -----------------------
 *   |   |	  |		 	  								        |
 *   |   |	  |_MENU BAR__(not actually part of content pane)___|
 *   |   |    |		 	  								        |
 *   |   |    |		 	  								        |
 *   |   |	  | All text, buttons and graphics go on this pane	|	
 *    ---|	  |		(contains all visible components of root)								 		    |	
 *       |	  |										 		  	|	
 *        ----| Content pane can be accessed directly, but  	|
 * 			  | better to use a JPanel as a layer on top of it. |
 *             -------------------------------------------------
 *               
 *               AND A GLASS PANE OVER ALL 
 *               
 */


	public class JFramesTest {
		private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("[=] Hello World [=]");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		frame.setSize(400,100);
		frame.pack(); //useful only when layout managers are used
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				createAndShowGUI();
			}
		});
	}


}
