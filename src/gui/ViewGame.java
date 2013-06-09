package gui;

import gameContent.Definitions;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class ViewGame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7544028496657097934L;
	
	private JTextArea overView = new JTextArea("OverView");
	private JTextArea eventLog = new JTextArea("EventLog");
	private JButton buyWeaponOne = new JButton("Buy Weapon One");
	private JButton buyWeaponTwo = new JButton("Buy Weapon One");
	private JButton buyWeaponThree = new JButton("Buy Weapon One");
	private JButton buyWeaponFour = new JButton("Buy Weapon One");
	private JTextField villainOne = new JTextField("VillainOne");
	private JTextField countVillainOne = new JTextField();
	private JTextField villainTwo = new JTextField("VillainTwo");
	private JTextField countVillainTwo = new JTextField();
	private JButton sendButton = new JButton("Send");

	public ViewGame() {
		setSize(600, 300);		
		setTitle("Da Imba Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MigLayout mig = new MigLayout("wrap 4",
				"[200]10[100]50[100]10[50]",
				"");
		setLayout(mig);
		
		
		Definitions.enemyCounterList.add(countVillainOne);
		Definitions.enemyCounterList.add(countVillainTwo);

		
		
		this.add(overView, "w 200, h 70, span 1 2");
		this.add(buyWeaponOne, "w 100");
		this.add(villainOne, "w 100");
		this.add(countVillainOne, "w 50");
		this.add(buyWeaponTwo, "w 100");
		this.add(villainTwo, "w 100");
		this.add(countVillainTwo, "w 50");
		this.add(eventLog, "span 3, w 470, h 70");
		this.add(getSendButton(), "w 200");



	}

	public JButton getSendButton() {
		return sendButton;
	}


}
