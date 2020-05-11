package Client;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
/**
 * The following class called FrameTicTac creates a GUI for my Tic Tac Game,
 *   
 * @author SIH , Saman
 * @version 1.0
 * @since Feb 13, 2020
 */
public class FrameTicTac extends JFrame{


	/**
	 * f1, f2,f3, f4,f5,f6, f7,f8 and f9 are the button for Tic Tac Game
	 */
	JButton f1, f2,f3, f4,f5,f6, f7,f8,f9;
	/**
	 * boxMessage, boxName and boxMark  are a text area 
	 */
	private JTextArea boxMessage, boxName,boxMark;
	/**
	 * buttonsPanel, messagePanel and player(i.e. name of the player) Panel are  the panel for this GUI  
	 */
	private JPanel buttonsPanel,messagePanel,playerPanel;
	/**
	 * titleLabel, markLabel and nameLabel are label for this GUI  
	 */
	private JLabel titleLabel,markLabel,nameLabel;
	/**
	 * mark is a sign
	 */
	//	char mark;
	/**
	 * mark1 is a sign just for my JTectArea
	 */
	String mark1;


	/**
	 * Constructs a Frame object that that create a grid Layout  
	 *  and call other panels to complete the frame and the end closing
	 *@param s - name of the GUI
	 *@param mark and mark1 are the same and sign of the player
	 *@param playerName is name of the player
	 */
	public FrameTicTac (String s,String mark1,String playerName) throws IOException {
		super(s);
		//		this.mark=mark;
		this.mark1=mark1;

		setLayout (new GridLayout(2,2,20,20));

		buttonsPanel();
		messagePanel();
		playerPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(700, 400);

		setBoxName(playerName);
		setBoxMark(mark1);
	}
	///////////////////////////////////////////
	///////////buttonsPanel to West-North//////
	/**
	 * the following method, create a panel just for buttons in the West-North of my original
	 * layout. the layout for this panel is grid layout 
	 * at the end, I add this panel to my original panel
	 */
	public void buttonsPanel() {

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout( new GridLayout(3,3,10,10));


		f1 = new JButton ("");
		f2 = new JButton ("");
		f3 = new JButton ("");
		f4 = new JButton ("");
		f5 = new JButton ("");
		f6 = new JButton ("");
		f7 = new JButton ("");
		f8 = new JButton ("");
		f9 = new JButton ("");


		buttonsPanel.add(f1);
		buttonsPanel.add(f2);
		buttonsPanel.add(f3);
		buttonsPanel.add(f4);
		buttonsPanel.add(f5);
		buttonsPanel.add(f6);
		buttonsPanel.add(f7);
		buttonsPanel.add(f8);
		buttonsPanel.add(f9);


		getContentPane().add( buttonsPanel);   // Add Panel1 to West-North

	}
	/**
	 * the following method, is a helper that add my button to listener
	 */
	public void addCalcListener (ActionListener listenForCalcButton) {

		f1.addActionListener(listenForCalcButton);
		f2.addActionListener(listenForCalcButton);
		f3.addActionListener(listenForCalcButton);
		f4.addActionListener(listenForCalcButton);
		f5.addActionListener(listenForCalcButton);
		f6.addActionListener(listenForCalcButton);
		f7.addActionListener(listenForCalcButton);
		f8.addActionListener(listenForCalcButton);
		f9.addActionListener(listenForCalcButton);

	}

	///////////////////////////////////////////
	///////////Message Panel to East-North//////////
	/**
	 * the following method, create a panel just for messages in the East-North of my original
	 * layout. the layout for this panel is Border layout 
	 * at the end, I add this panel to my original panel
	 */
	public void messagePanel() {
		messagePanel = new JPanel();

		messagePanel.setLayout( new BorderLayout() );
		boxMessage = new JTextArea();
		titleLabel=new JLabel("Message Window:");
		boxMessage.setEditable(false);


		messagePanel.add(titleLabel, "North");
		messagePanel.add(boxMessage, "Center");

		getContentPane().add( messagePanel);    // Add Panel1 to East-North


	}

	///////////////////////////////////////////
	///////////player(name) Panel to West-South//////////
	/**
	 * the following method, create a panel just for printing the name of player and its mark in the East-North of my original
	 * layout. the layout for this panel is grid layout 
	 * at the end, I add this panel to my original panel
	 */
	public void playerPanel() {
		playerPanel = new JPanel();

		playerPanel.setLayout( new GridLayout(2,2,5,5) );




		markLabel=new JLabel("   Player");
		nameLabel=new JLabel("   User Name");
		boxName = new  JTextArea();
		boxMark = new  JTextArea();

		boxName.setEditable(false);
		boxMark.setEditable(false);

		playerPanel.add(markLabel);
		playerPanel.add(boxMark);
		playerPanel.add(nameLabel);
		playerPanel.add(boxName);


		getContentPane().add( playerPanel);  // Add player(name) Panel to West-South
	}

	/**
	 * setters for BoxMessage, setBoxName and BoxMark  
	 */


	public void setBoxMessage(String boxmessage) {
		boxMessage.setText(boxmessage); 
	}

	public void setBoxName(String boxname) {
		boxName.setText(boxname);
	}

	public void setBoxMark(String boxmark) {
		boxMark.setText(boxmark);
	}





}
