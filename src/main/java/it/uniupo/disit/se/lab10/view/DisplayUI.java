package it.uniupo.disit.se.lab10.view;

import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;

import it.uniupo.disit.se.lab10.controller.AbstractController;

public class DisplayUI extends JPanel implements TicketManagerView {
	
	JLabel label = null;
	
	public DisplayUI() {
		label = new JLabel("currently served: none");
		label.setName("display");
		this.add(label);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener(AbstractController listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RoleStrategy getRole() {
		// TODO Auto-generated method stub
		return null;
	}

}
