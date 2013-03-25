package swingGuideBook;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class LayoutBoxLayoutExamples{

    public JPanel createContentPane (){

        // We create a bottom JPanel to place everything on.
        // We set the layout of the main JPanel to be BoxLayout.
        // LINE_AXIS sets them left to right, PAGE_AXIS sets them
        // from top to bottom.
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(new BoxLayout(totalGUI, BoxLayout.LINE_AXIS));

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setMinimumSize(new Dimension(40, 40));
        redPanel.setMaximumSize(new Dimension(40, 40));
        redPanel.setPreferredSize(new Dimension(40, 40));
        //redPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        redPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        totalGUI.add(redPanel);

        // This is the first spacer. This creates a spacer 10px wide that
        // will never get bigger or smaller.
        totalGUI.add(Box.createRigidArea(new Dimension(10,0)));

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.yellow);
        yellowPanel.setMinimumSize(new Dimension(60, 60));
        yellowPanel.setMaximumSize(new Dimension(60, 60));
        yellowPanel.setPreferredSize(new Dimension(60, 60));
        yellowPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//        yellowPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        totalGUI.add(yellowPanel);

        // This spacer takes any spare space and places it as part of the spacer
        // If you drag the window wider, the space will get wider.
        totalGUI.add(Box.createHorizontalGlue());

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setMinimumSize(new Dimension(80, 80));
        greenPanel.setMaximumSize(new Dimension(80, 80));
        greenPanel.setPreferredSize(new Dimension(80, 80));
//        greenPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//        greenPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        greenPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        totalGUI.add(greenPanel);

        // This spacer is a custom spacer.
        // The minimum size acts like a rigid area that
        // will not get any smaller than 10 pixels on the x-axis (horizontal)
        // and not get any smaller than 50 pixels on the y axis (vertical).
        // The way the maximum size is set up means the spacer acts like glue
        // and will expand to fit the available space.

        Dimension minSize = new Dimension(10, 50);
        Dimension prefSize = new Dimension(10, 50);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, 50);
        totalGUI.add(new Box.Filler(minSize, prefSize, maxSize));

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setMinimumSize(new Dimension(100, 100));
        bluePanel.setMaximumSize(new Dimension(100, 100));
        bluePanel.setPreferredSize(new Dimension(100, 100));
        bluePanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//        bluePanel.setAlignmentY(Component.TOP_ALIGNMENT);
        totalGUI.add(bluePanel);
        
        totalGUI.setOpaque(true);
        return totalGUI;
    }

    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("[=] BoxLayout Exercises [=]");

        LayoutBoxLayoutExamples demo = new LayoutBoxLayoutExamples();
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