package it.uniupo.disit.se.lab10.model;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


public class TestModel {
    
	@Test
	public void nextTicketTest() {
	    Model ticketManager = new TicketManager();
	    assertEquals(0, ticketManager.lastGivenTicket());
	    ticketManager.nextTicket();
	    assertEquals(1, ticketManager.lastGivenTicket());
	}
}
