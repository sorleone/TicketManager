package it.uniupo.disit.se.lab10.model;

public class TicketManager extends Model {
    
    private int lastGivenTicket;
    private int ticketToServe;
    
    @Override
    public int ticketToServe() {
        return this.ticketToServe;
    }

    @Override
    public int lastGivenTicket() {
        return this.lastGivenTicket;
    }

    @Override
    public void serveNext() {
        if(ticketToServe < lastGivenTicket) {
            ticketToServe++;
        }
        setChanged();
        notifyObservers();
    }

    @Override
    public void nextTicket() {
        this.lastGivenTicket++;
        setChanged();
        notifyObservers();
    }
}
