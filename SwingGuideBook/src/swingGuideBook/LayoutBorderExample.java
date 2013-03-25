package swingGuideBook;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LayoutBorderExample implements  ActionListener{

    JPanel textPanel, panelForTextFields, completionPanel;
    JLabel titleLabel, usernameLabel, passwordLabel, userLabel, passLabel;
    JTextField usernameField, loginField;
    JButton loginButton;

    public JPanel createContentPane (){

        //We create a bottom JPanel to place everything on.
        //This sets the Border Layout to have a horizontal gap of 10
        //and a vertical gap of 2 between each widget.
        
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(new BorderLayout(0, 0)); //hor,ver

        // Setting the preferredSize is basically making sure the widget
        // is not re-sized to be smaller or bigger than this unless it needs to be.
        // Also, when adding, we have the area of the JPanel as a second argument.

        titleLabel = new JLabel("Login Screen");
        titleLabel.setPreferredSize(new Dimension(290, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBackground(Color.green.brighter());
        titleLabel.setOpaque(true);
        totalGUI.add(titleLabel, BorderLayout.PAGE_START); //PAGE_START is NORTH

        //--------------------------------------------------------------------------//
        
        // Creation of a Panel to contain the JLabels for "username" and "password"
        textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(70, 70));
        textPanel.setBackground(Color.gray.brighter());
        textPanel.setOpaque(true);
        totalGUI.add(textPanel, BorderLayout.LINE_START); //LINE_START is left of layout

        // Username Label
        usernameLabel = new JLabel("Username");
        usernameLabel.setPreferredSize(new Dimension(60, 30));
        usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        usernameLabel.setBackground(Color.red);
        usernameLabel.setOpaque(true);
        textPanel.add(usernameLabel);

        // password Label
        passwordLabel = new JLabel("Password");
        passwordLabel.setPreferredSize(new Dimension(60, 30));
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passwordLabel.setBackground(Color.green);
        passwordLabel.setOpaque(true);
        textPanel.add(passwordLabel);

        //--------------------------------------------------------------------------//
        
        // TextFields Panel Container, enter username and password into these
        panelForTextFields = new JPanel();
        panelForTextFields.setPreferredSize(new Dimension(100, 70));
        panelForTextFields.setBackground(Color.cyan);
        panelForTextFields.setOpaque(true);
        totalGUI.add(panelForTextFields, BorderLayout.CENTER);

        // Username Textfield
        usernameField = new JTextField(8);
        usernameField.setPreferredSize(new Dimension(100, 30));
        usernameField.setBackground(Color.yellow);
        usernameField.setOpaque(true);
        panelForTextFields.add(usernameField);

        // Login Textfield
        loginField = new JTextField(8);
        loginField.setPreferredSize(new Dimension(100, 30));
        loginField.setBackground(Color.orange);
        loginField.setOpaque(true);
        panelForTextFields.add(loginField);

        //--------------------------------------------------------------------------//
        
        // Creation of a Panel to contain the username/password STATUS JLabels
        completionPanel = new JPanel();
        completionPanel.setPreferredSize(new Dimension(70, 80));
        totalGUI.add(completionPanel, BorderLayout.LINE_END); //LINE_END is right

        // Username Label
        userLabel = new JLabel("Wrong");
        userLabel.setForeground(Color.red);
        userLabel.setPreferredSize(new Dimension(70, 30));
        userLabel.setBackground(Color.pink);
        userLabel.setOpaque(true);
        completionPanel.add(userLabel);

        // Login Label
        passLabel = new JLabel("Wrong");
        passLabel.setForeground(Color.red);
        passLabel.setPreferredSize(new Dimension(70, 30));
        passLabel.setBackground(Color.pink);
        passLabel.setOpaque(true);
        completionPanel.add(passLabel);

        //--------------------------------------------------------------------------//
        
        // Button for Logging in
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        totalGUI.add(loginButton, BorderLayout.PAGE_END); //Bottom of panel 'SOUTH'

        totalGUI.setOpaque(true);
        return totalGUI;
    }

    // With this action performed, we simply check to see if the username and
    // password match "Bob" as the username and "Robert" as the password.
    // If they do, we set the labels ajacent to them to "Correct!" and color
    // them green.
    // At the end, we check if both labels are green. If they are, we set the
    // screen to be 'Logging In'.

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == loginButton)
        {
            if(usernameField.getText().trim().compareTo("ssmith") == 0)
            {
                userLabel.setForeground(Color.green);
                userLabel.setText("Correct!");
            }
            else
            {
                userLabel.setForeground(Color.red);
                userLabel.setText("Wrong!");
            }

            if(loginField.getText().trim().compareTo("Ingers0ll") == 0)
            {
                passLabel.setForeground(Color.green);
                passLabel.setText("Correct!");
            }
            else
            {
                passLabel.setForeground(Color.red);
                passLabel.setText("Wrong!");
            }

            if((userLabel.getForeground() == Color.green) 
            && (passLabel.getForeground() == Color.green))
            {
                titleLabel.setText("Logging in....");
                loginButton.setEnabled(false);
            }
        }
    }


    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("[=] JTextField of Dreams [=]");

        LayoutBorderExample demo = new LayoutBorderExample();
        frame.setContentPane(demo.createContentPane());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // We no longer manually re-size, we use pack to automatically size the frame.
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