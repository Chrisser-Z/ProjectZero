package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.DataOUT;
import network.*;

public class Controller {

	private ViewGame gameView;
	private View view;
	private Model model;
	private Emitter emitter;

	public Controller() {
		model = new Model();
		view = new View();		
		gameView = new ViewGame();
		emitter = new Emitter();
		

	gameView.getSendButton().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			emitter.emitData();
		}
		});
	}

	public void showGui() {
		//this.view.setVisible(true);
		this.gameView.setVisible(true);
	}

}
