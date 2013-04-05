package swingGuideBook;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

// Class implements three different types of listener.
public class TextAreaExample implements  ActionListener, ItemListener{

    JTextArea storyArea;
    JRadioButton boyButton, girlButton;
    JComboBox nameBox;
    JCheckBox cb[] = new JCheckBox[7];

    String objects[] = {"Car", "Bike", "Dragon", "Bus", "Mouse", "Cheese",
                        "Unicycle", "Sinclair C5", "Pony"};

    String places[] = {"Office", "Hospital", "University", "Pool", "Farm",
                       "Castle", "Sewer"};
   //some  
//http://docs.oracle.com/javase/tutorial/uiswing/events/listselectionlistener.html
    public JPanel createContentPane (){

        JPanel totalGUI = new JPanel();

        // The main story for the JTextArea
        String story = "When I was a small boy, I always dreamed of having a Red Car.\n"+ 
                       "I'd travel in it everywhere and go and visit my mum.\n"+
                       "Sometimes I'd go and visit the Office.\n"+
                       "I loved my Red Car and it loved me.\n"; 

        // Plus we instantiate the TextArea.
        storyArea = new JTextArea(story, 5, 30); // (text, rows, columns)
        storyArea.setEditable(false);
        storyArea.setLineWrap(true);
        storyArea.setWrapStyleWord(true);

        // To determine the sex of the user.
        boyButton = new JRadioButton("Boy");
        boyButton.addActionListener(this);
        boyButton.setSelected(true);
       // boyButton.setHorizontalAlignment(SwingConstants.RIGHT); //these don't do anything ?
        
        girlButton = new JRadioButton("Girl");
        girlButton.addActionListener(this);
        //girlButton.setHorizontalAlignment(SwingConstants.LEFT);

        ButtonGroup sexGroup = new ButtonGroup();
        sexGroup.add(boyButton);
        sexGroup.add(girlButton);

        JPanel sexPanel = new JPanel();
        sexPanel.setLayout(new BoxLayout(sexPanel, BoxLayout.PAGE_AXIS));
        sexPanel.add(boyButton);
        sexPanel.add(girlButton);
        
         //creates gap at bottom
        sexPanel.add(Box.createRigidArea(new Dimension(0,30)));

        // To determine the vehicle.
        nameBox = new JComboBox(objects);
        nameBox.setSelectedIndex(0);
        nameBox.addActionListener(this);
        nameBox.addItemListener(this);
        sexPanel.add(nameBox);

        // To determine the places they have been to.
        JPanel cbPanel = new JPanel();
        cbPanel.setLayout(new BoxLayout(cbPanel, BoxLayout.PAGE_AXIS));

        //Add a spacer on left hand side of panel
        cbPanel.add(Box.createRigidArea(new Dimension(10,0)));
        //Add the checkboxes
        for(int i = 0; i < 7; i++)
        {
            cb[i] = new JCheckBox(places[i]);
            cb[i].addItemListener(this);
            cbPanel.add(cb[i]);
            cbPanel.add(Box.createHorizontalGlue());
        }
        cb[0].setSelected(true);
        cbPanel.add(Box.createRigidArea(new Dimension(10,0)));

        // This final bit of code uses a BoxLayout to space out the widgets
        // in the GUI.

        JPanel bottomPanel = new JPanel();
        //allign panels left to right
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));

        bottomPanel.add(Box.createRigidArea(new Dimension(10,0)));
        bottomPanel.add(storyArea);
        bottomPanel.add(Box.createRigidArea(new Dimension(20,0)));
        bottomPanel.add(sexPanel); //jbuttons and jcombobox
        bottomPanel.add(Box.createRigidArea(new Dimension(20,0)));
        bottomPanel.add(cbPanel);
        bottomPanel.add(Box.createRigidArea(new Dimension(10,0)));

        totalGUI.add(bottomPanel);
        totalGUI.setOpaque(true);
        return totalGUI;
    }
    //ListSelectionEvent this does not seem to be required
    // Reports all list selection events that occur on a list. 
    // Lets the user dynamically change the selection mode.
    public void valueChanged(ListSelectionEvent e) 
    {
        sortTextPanel(); 
        System.out.println("ListSelectionEvent occurred");
    }
    
    // For the Action Events. //boy/girl radiobutton, also combobox selection
    public void actionPerformed(ActionEvent e) 
    {
        sortTextPanel();
        System.out.println("ActionEvent occurred");
    }
    // For the Item Events - comboboxes
    public void itemStateChanged(ItemEvent e)
    {
        sortTextPanel();
        System.out.println("ItemEvent occurred");
    }

    // This rewrites the story depending on the actions so far in the various
    // widgets then re-sends the story to the TextArea.
    public void sortTextPanel()
    {
        String story = "When I was a small";

        if(boyButton.isSelected())
        {
            story = story + " boy, I always dreamed of having a";
        }
        else
        {
            story = story + " girl, I always dreamed of having a";
        }
        
        story = story + " "+ objects[nameBox.getSelectedIndex()] + " ";
        story = story + ".\nI'd travel in it everywhere and go and visit my mum.\n";
        story = story + "Sometimes I'd go and visit the ";

        for(int i = 0; i < 7; i++)
        {
            if(cb[i].isSelected())
            story = story + places[i] + " ";
        }
        story = story + "\nI loved my "+ objects[nameBox.getSelectedIndex()] + 
                " and it loved me.\n";

        storyArea.setText(story);
    }

    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("[=] JTextArea [=]");

        TextAreaExample demo = new TextAreaExample();
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