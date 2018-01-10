package it.uniupo.disit.se.lab10.model;

import java.util.Observable;

public abstract class  Model extends Observable {
	
	/**
	 * Restituisce il numero da visualizzare sul display.
	 * @return
	 */
	public abstract int ticketToServe();
	
	/**
	 * Restituisce l'ultimo numero consegnato ad un cliente.
	 * @return
	 */
	public abstract int lastGivenTicket();
	
	/**
	 * Incrementa il contatore del cliente correntemente servito (se minore del contatore dei clienti in attesa).
	 * Potenziale cambio di stato del model (da visualizzare sulla view lato servitore e display)
	 */
	public abstract void serveNext();
	
	/**
	 * Incrementa contatore dei clienti in attesa.
	 * Provoca un cambio di stato del model (da visualizzare sulla view lato cliente).
	 */
	public abstract void nextTicket();
}