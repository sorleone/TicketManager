package it.uniupo.disit.se.lab10.view;

import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;

import it.uniupo.disit.se.lab10.controller.AbstractController;
import it.uniupo.disit.se.lab10.model.Model;

public class DisplayUI extends JPanel implements TicketManagerView {
	
	JLabel label = null;
	
	public DisplayUI() {
		label = new JLabel("currently served: none");
		label.setName("display");
		this.add(label);
	}

	@Override
	public void update(Observable o, Object arg) {

	}

	@Override
	public void addListener(AbstractController listener) {}

	@Override
	public RoleStrategy getRole() {
		return null;
	}
}
