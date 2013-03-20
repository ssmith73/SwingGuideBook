package swingGuideBook;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.Color;

public class JLabelTests{

    public JPanel createContentPaneTLights (){
    	
        // We create a bottom JPanel to place everything on.
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);
        
        // Creation of a Panel to contain the JLabels
        // It is a panel 260x30, so labels must be smaller than this?
        JPanel textPanel = new JPanel();
        textPanel.setLayout(null); //manually assign position of textPanel components
        textPanel.setLocation(10, 10);
        textPanel.setSize(60, 250);
        textPanel.setOpaque(false); //don't let it cover the rest
        //textPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        //textPanel.setBackground(Color.black);
        totalGUI.add(textPanel);
        
        //Create and configure 3 labels, to place on the textPanel, STOP, READY, GO
        JLabel stopLabel = new JLabel("STOP");
        stopLabel.setLocation(0, 0);
        stopLabel.setSize(60, 20); 
        stopLabel.setHorizontalAlignment(SwingConstants.CENTER);
        stopLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        //stopLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        //stopLabel.setOpaque(true);
        //stopLabel.setBackground(Color.red);
        textPanel.add(stopLabel);

        JLabel rdyLabel = new JLabel("READY");
        rdyLabel.setLocation(0, 0);
        rdyLabel.setSize(60, 110); 
        rdyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rdyLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        //stopLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        //stopLabel.setOpaque(true);
        //rdyLabel.setBackground(Color.green);
        textPanel.add(rdyLabel);

        JLabel goLabel = new JLabel("GO");
        goLabel.setLocation(0, 0);
        goLabel.setSize(60, 190); 
        goLabel.setHorizontalAlignment(SwingConstants.CENTER);
        goLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        //stopLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        //stopLabel.setOpaque(true);
        //goLabel.setBackground(Color.yellow);
        textPanel.add(goLabel);

        
        
        // Creates a panel to hold the 'lights'
        JPanel panelForPanels = new JPanel();
        panelForPanels.setLayout(null);
        panelForPanels.setLocation(15,30);
        panelForPanels.setSize(50,250);
 //       panelForPanels.setBackground(Color.white);
//        panelForPanels.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        panelForPanels.setOpaque(true);
        totalGUI.add(panelForPanels);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setLocation(0, 0);
        redPanel.setSize(50, 50);
        panelForPanels.add(redPanel);

        JPanel orangePanel = new JPanel();
        orangePanel.setBackground(Color.orange);
        orangePanel.setLocation(0, 70);
        orangePanel.setSize(50, 50);
        panelForPanels.add(orangePanel);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setLocation(0,140);
        greenPanel.setSize(50, 50);
        panelForPanels.add(greenPanel);
        
        totalGUI.setOpaque(true);
        return totalGUI;
    }
    
    public JPanel createContentPane (){

        // We create a bottom JPanel to place everything on.
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);

        // Creation of a Panel to contain the JLabels
        // It is a panel 260x30, so labels must be smaller than this?
        JPanel textPanel = new JPanel();
        textPanel.setLayout(null); //manually assign position of textPanel components
        textPanel.setLocation(10, 10);
        textPanel.setSize(260, 20);
        //textPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        //textPanel.setBackground(Color.blue);
        totalGUI.add(textPanel);

        /* First JLabel, outputs "Red".
         * Added to the 'textPanel' JPanel
         * The source material is odd here, is gives a label size 
         * of 50,40 - 40 in the y-direction is 10 greater than the 
         * JPanel.textPanel container - this even looks fine, but
         * the extra 10 simply gets clipped at the bottom and the
         * text looks ok - setting it to 30 makes more sense.
         */
        
        //Create and configure 4 labels, to place on the textPanel
        JLabel redLabel = new JLabel("Red");
        redLabel.setLocation(0, 0);
        redLabel.setSize(50, 20); 
        redLabel.setHorizontalAlignment(SwingConstants.CENTER);
        redLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        //redLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        //redLabel.setOpaque(true);
        //redLabel.setBackground(Color.red);
        textPanel.add(redLabel);

        // Second JLabel, outputs "Yellow"
        JLabel yellowLabel = new JLabel("Yellow");
        yellowLabel.setLocation(70, 0);
        yellowLabel.setSize(50, 20);
        yellowLabel.setHorizontalAlignment(SwingConstants.CENTER);
        yellowLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        textPanel.add(yellowLabel);

        JLabel greenLabel = new JLabel("Green");
        greenLabel.setLocation(140, 0);
        greenLabel.setSize(50, 20);
        greenLabel.setHorizontalAlignment(SwingConstants.CENTER);
        greenLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        textPanel.add(greenLabel);

        JLabel blueLabel = new JLabel("Blue");
        blueLabel.setLocation(210, 0);
        blueLabel.setSize(50, 20);
        blueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        blueLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        textPanel.add(blueLabel);

        
        // Creates a panel to hold the coloured box panels.
        JPanel panelForPanels = new JPanel();
        panelForPanels.setLayout(null);
        panelForPanels.setLocation(10, 30);
        panelForPanels.setSize(260, 50);
        //panelForPanels.setBackground(Color.green);
//        panelForPanels.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        totalGUI.add(panelForPanels);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setLocation(0, 0);
        redPanel.setSize(50, 50);
        panelForPanels.add(redPanel);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.yellow);
        yellowPanel.setLocation(70, 0);
        yellowPanel.setSize(50, 50);
        panelForPanels.add(yellowPanel);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setLocation(140, 0);
        greenPanel.setSize(50, 50);
        panelForPanels.add(greenPanel);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setLocation(210, 0);
        bluePanel.setSize(50, 50);
        panelForPanels.add(bluePanel);
        
        totalGUI.setOpaque(true);
        return totalGUI;
    }

    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("[=] JLabel Fables [=]");
        JFrame trafficLightsFrame = new JFrame("This is supposed to look like traffic lights");

        //Create and set up the content pane.
        JLabelTests demo = new JLabelTests();
        frame.setContentPane(demo.createContentPane());
        
        JLabelTests trafficLightDemo = new JLabelTests();
        trafficLightsFrame.setContentPane(trafficLightDemo.createContentPaneTLights());
        

        // The other bits and pieces that make our program a bit more stable.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(290, 130);
        frame.setVisible(true);
        
        trafficLightsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        trafficLightsFrame.setSize(90, 300);
        trafficLightsFrame.setLocation(0,150);
        trafficLightsFrame.setVisible(true);

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