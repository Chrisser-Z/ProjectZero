package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;



public class View extends JFrame {


	private static final long serialVersionUID = 1L;
	
	
	public JButton sendButton = new JButton("Send");
	public JTextField entryTxtField = new JTextField();
	public JTextField ipTxtField = new JTextField();
	
	
	public View(){
		initGui();
	}
	
	private void initGui() {
		setSize(800, 600);		
		setTitle("TestFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new MigLayout("wrap 2",
				"[][]", 
				"[][]"));
		add(entryTxtField, "w 250::500");	
		add(sendButton);
		add(ipTxtField, "w 250::500");					
	}

}
