package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import network.*;

public class Controller {

	private View _view;
	private Model _model;

	public Controller() {
		this._model = new Model();
		this._view = new View();

		_view.sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!_view.ipTxtField.getText().isEmpty()) {
					DataOUT.setInetsocket(_view.ipTxtField.getText());
					DataOUT.sendData(_view.entryTxtField.getText());
				}
			}
		});
	}

	public void showGui() {
		this._view.setVisible(true);
	}

}
