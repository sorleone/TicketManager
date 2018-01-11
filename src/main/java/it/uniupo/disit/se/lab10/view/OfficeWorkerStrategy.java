package it.uniupo.disit.se.lab10.view;

import it.uniupo.disit.se.lab10.model.Model;

public class OfficeWorkerStrategy implements RoleStrategy {

    @Override
    public void incTicketNumber(Model m) {
        m.serveNext();
    }

    @Override
    public int getTicketNumber(Model m) {
        return m.ticketToServe();
    }
}
