package it.uniupo.disit.se.lab10.view;

import it.uniupo.disit.se.lab10.model.Model;

public class CustomerStrategy implements RoleStrategy {

    @Override
    public void incTicketNumber(Model m) {
        m.nextTicket();
    }

    @Override
    public int getTicketNumber(Model m) {
        return m.lastGivenTicket();
    }
}
