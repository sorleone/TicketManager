package it.uniupo.disit.se.lab10.controller;

import java.awt.event.ActionListener;

import it.uniupo.disit.se.lab10.model.Model;
import it.uniupo.disit.se.lab10.view.TicketManagerView;

public abstract class AbstractController implements ActionListener {

	protected Model model;
	protected TicketManagerView view;
	
}