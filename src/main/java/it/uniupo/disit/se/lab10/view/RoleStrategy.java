package it.uniupo.disit.se.lab10.view;

import it.uniupo.disit.se.lab10.model.Model;

public interface RoleStrategy {
	public void incTicketNumber(Model m);
	public int getTicketNumber(Model m);
}
