package it.uniupo.disit.se.lab10.view;

import java.util.Observer;

import it.uniupo.disit.se.lab10.controller.AbstractController;

public interface TicketManagerView extends Observer {
	public void addListener(AbstractController listener);	
	public RoleStrategy getRole();
}