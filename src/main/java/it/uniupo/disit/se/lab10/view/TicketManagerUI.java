package it.uniupo.disit.se.lab10.view;

import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.uniupo.disit.se.lab10.controller.AbstractController;
import it.uniupo.disit.se.lab10.model.Model;


public class TicketManagerUI extends JPanel implements TicketManagerView {

	JLabel label;
	JButton button;
	private RoleStrategy strategy;
	
	public TicketManagerUI(String uiLabel, RoleStrategy strategy) {
		label = new JLabel("ticket: 0");
		label.setName(uiLabel + "Label");
		button = new JButton(uiLabel + " button.");
		button.setName(uiLabel + "Button");
		this.add(label);
		this.add(button);
		this.strategy = strategy;
	}

	@Override
	public void update(Observable o, Object arg) {
	    if(o instanceof Model) {
	        label.setText("ticket: " + strategy.getTicketNumber((Model)o));
	    }
	}

	@Override
	public void addListener(AbstractController listener) {
	    button.addActionListener(listener);
	}

	@Override
	public RoleStrategy getRole() {
	    return strategy;
	}
}
