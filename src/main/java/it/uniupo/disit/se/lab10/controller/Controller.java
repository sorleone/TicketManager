package it.uniupo.disit.se.lab10.controller;

import java.awt.event.ActionEvent;

import it.uniupo.disit.se.lab10.model.Model;
import it.uniupo.disit.se.lab10.view.TicketManagerView;

public class Controller extends AbstractController {

    private Model model;
    private TicketManagerView view;
    
    public Controller(TicketManagerView view, Model model) {
        this.view = view;
        this.model = model;
        this.view.addListener(this);
        this.model.addObserver(this.view);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        view.getRole().incTicketNumber(model);
    }
}
