package swingGuideBook;

	import java.awt.*;
	import java.awt.event.*;
	import java.util.Arrays;
	import javax.swing.*;
	import javax.swing.text.*;

	/* 
	 * This class add a check on the number of character used for the username, 
	 * and limits it to 8 characters.
	 * 1: It does this by extending the JTextField class and in the 
	 *    constructor, call the super().constructor with a new KTextField 
	 *    object, and empty string, and the maximum number of characters 
	 *    to allows.  Also a private int length is declared as an argument
	 * 2: The extended KJTextField, calls the super()constructor, with 3
	 *    arguments, a document, string, and length argument.
	 *    This has the effect of overriding the document type, normally 
	 *    passed (as a default document) to the JTextField constructor.
	 * 3: The new extra document class, overrides the default document
	 *    is passed the length term, and is a method of this class.
	 * 4: The new document class, which extends PlainDocument, which extends
	 *    document class, overrides the insertString() method, by adding a
	 *    max number of characters that can be in the username string.
	 *    
	 *    insertString
	 *    public void insertString(int offset, String str, AttributeSet a)
                  throws BadLocationException
     *             
     *    Inserts a string of content. This will cause a DocumentEvent of 
     *    Parameters:
     *    offset - the offset into the document to insert the content >= 0. 
     *    All positions that track change at or after the given location 
     *    will move. 
     *    str - the string to insert
     *    a - the attributes to associate with the inserted content. 
     *    This may be null if there are no attributes.
     *    Throws:
     *    BadLocationException - the given insert position is not a valid 
     *    position within the document
     *    The insertString is only changed to add a check on the length of 
     *    the string username
	            if (!((getLength() + str.length()) > maxlength)) {
	                super.insertString(offset, str, a);
	      So the insertString is allowed to happen, or not, depending on 
	      the lenght of the username intered into the text box
	      
	 */
	public class JTextFieldSetMinStringLength implements  ActionListener{

	    JPanel textPanel, panelForTextFields, completionPanel;
	    JLabel titleLabel, usernameLabel, passwordLabel, userLabel, passLabel;
	    KTextField usernameField;
	    JPasswordField loginField;
	    JButton loginButton;

	    public JPanel createContentPane (){

	        // We create a bottom JPanel to place everything on.
	        JPanel totalGUI = new JPanel();
	        totalGUI.setLayout(null);

	        titleLabel = new JLabel("Login Screen");
	        titleLabel.setLocation(0,0);
	        titleLabel.setSize(290, 30);
	        titleLabel.setHorizontalAlignment(0);
	        totalGUI.add(titleLabel);

	        // Creation of a Panel to contain the JLabels
	        textPanel = new JPanel();
	        textPanel.setLayout(null);
	        textPanel.setLocation(10, 35);
	        textPanel.setSize(70, 80);
	        totalGUI.add(textPanel);

	        // Username Label
	        usernameLabel = new JLabel("Username");
	        usernameLabel.setLocation(0, 0);
	        usernameLabel.setSize(70, 40);
	        usernameLabel.setHorizontalAlignment(4);
	        textPanel.add(usernameLabel);

	        // Login Label
	        passwordLabel = new JLabel("Password");
	        passwordLabel.setLocation(0, 40);
	        passwordLabel.setSize(70, 40);
	        passwordLabel.setHorizontalAlignment(4);
	        textPanel.add(passwordLabel);

	        // TextFields Panel Container
	        panelForTextFields = new JPanel();
	        panelForTextFields.setLayout(null);
	        panelForTextFields.setLocation(110, 40);
	        panelForTextFields.setSize(100, 70);
	        totalGUI.add(panelForTextFields);

	        // Username Textfield
	        usernameField = new KTextField(8);
	        usernameField.setLocation(0, 0);
	        usernameField.setSize(100, 30);
	        panelForTextFields.add(usernameField);

	        // Login Textfield
	        loginField = new JPasswordField(8);
	        loginField.setEchoChar('&');
	        loginField.setLocation(0, 40);
	        loginField.setSize(100, 30);
	        panelForTextFields.add(loginField);

	        // Creation of a Panel to contain the completion JLabels
	        completionPanel = new JPanel();
	        completionPanel.setLayout(null);
	        completionPanel.setLocation(240, 35);
	        completionPanel.setSize(70, 80);
	        totalGUI.add(completionPanel);

	        // Username Label
	        userLabel = new JLabel("Wrong");
	        userLabel.setForeground(Color.red);
	        userLabel.setLocation(0, 0);
	        userLabel.setSize(70, 40);
	        completionPanel.add(userLabel);

	        // Login Label
	        passLabel = new JLabel("Wrong");
	        passLabel.setForeground(Color.red);
	        passLabel.setLocation(0, 40);
	        passLabel.setSize(70, 40);
	        completionPanel.add(passLabel);

	        // Button for Logging in
	        loginButton = new JButton("Login");
	        loginButton.setLocation(130, 120);
	        loginButton.setSize(80, 30);
	        loginButton.addActionListener(this);
	        totalGUI.add(loginButton);

	        totalGUI.setOpaque(true);    
	        return totalGUI;
	    }

	    /* With this action performed, we simply check to see if the username and
	     * password match "Bob" as the username and "Robert" as the password.
	     * If they do, we set the labels ajacent to them to "Correct!" and color
	     * them green.
	     * At the end, we check if both labels are green. If they are, we set the
	       screen to be 'Logging In'.
	     */

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

	            // Here, because we use a password field, we use the getPassword
	            // command. This is more secure.
	            // Once we are finished with the char array with the correct answer
	            // we change it back to blank.
	            // You may ask why we do this when the char array we compare it to
	            // is in clear text one line above.
	            // Obviously we'd store this in an encrypted database. (or something
	            // along those lines!)

	            char[] answer = {'I', 'n', 'g', 'e', 'r', 's','0','l','l'};
	            char[] input = loginField.getPassword();

	            if(Arrays.equals(input, answer))
	            {
	                passLabel.setForeground(Color.green);
	                passLabel.setText("Correct!");
	                for(int i = 0; i < input.length; i++)
	                {
	                    input[i] = ' ';
	                }
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
	        JFrame frame = new JFrame("[=] KTextField of MVC [=]");

	        JTextFieldSetMinStringLength demo = new JTextFieldSetMinStringLength();
	        frame.setContentPane(demo.createContentPane());
	        
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(310, 200);
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

	    class KTextField extends JTextField {

			private static final long serialVersionUID = 1L;
			private int length = 0;

			/* Constructor for KTextField, requires a single integer argument
	         * Creates a TextField with a fixed length of string input.
			 * Constructor does the following
			 * 
			 * ---->>>>super() accesses the class that has been extended <<<<<------
			 * 
			 * relevant constructor for JTextField (the one that has 3 arguments)
			 * JTextField(Document doc, String text, int columns)
			 * 
			 * Constructs a new JTextField that uses the given text storage model and the given number of colum
			 * 
			 * public JTextField(Document doc, String text, int columns)
			 * 
			 * Constructs a new JTextField that uses the given text storage model 
			 * and the given number of columns. This is the constructor through which 
			 * the other constructors feed. If the document is null, a default model 
			 * is created.
			 * 
			 * Parameters:
			 * doc - the text storage to use; if this is null, a default will be 
			 * provided by calling the createDefaultModel method
			 * text - the initial string to display, or null
			 * columns - the number of columns to use to calculate the preferred 
			 * width >= 0; if columns is set to zero, the preferred width will 
			 * be whatever naturally results from the component implementation
			 * Throws: IllegalArgumentException - if columns < 0
			 *
			 * 1: build a fixedLengthPlainDocument object with argument = length
			 * 2: passes in 3 arguments to the constructor of the JTextField
			 * 		the doc type, a string, and the length
			 *      the doc type is also passed the maxlength of the string
			 *      allowed.
			 * 
			 */
	        public KTextField(int length) {
	            super(new FixedLengthPlainDocument(length), "", length);
	        }
	    }

	    class FixedLengthPlainDocument extends PlainDocument {

			private static final long serialVersionUID = 1L;
			private int maxlength;

			// Constructor for FixedLengthPlainDocument
	        // creates a Plain Document with a maximum length called maxlength.
	        FixedLengthPlainDocument(int maxlength) {
	            this.maxlength = maxlength;
	        }

	        // This is the method used to insert a string to a Plain Document.
	        //insertString is a child method of document.PlainDocument
	        //here we ovverride it to add the stringlenght functionality
	        public void insertString(int offset, String str, AttributeSet a) throws
	                BadLocationException {

	            // If the current length of the string
	            // + the length of the string about to be entered
	            // (through typing or copy and paste)
	            // is less than the maximum length passed as an argument..
	            // We call the Plain Document method insertString.
	            // If it isn't, the string is not entered.

	            if (!((getLength() + str.length()) > maxlength)) {
	                super.insertString(offset, str, a);
	            }
	        }
	    }
	}