package it.uniupo.disit.se.lab10.model;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestModel {
    
    private Model ticketManager;
    
    @Before
    public void setUp() {
        ticketManager = new TicketManager();
    }
    
	@Test
	public void nextTicketTest() {
	    assertEquals(0, ticketManager.lastGivenTicket());
	    ticketManager.nextTicket();
	    assertEquals(1, ticketManager.lastGivenTicket());
	}
	
   @Test
    public void serveNextTest() {
        assertEquals(0, ticketManager.lastGivenTicket());
        assertEquals(0, ticketManager.ticketToServe());
        ticketManager.serveNext();
        assertEquals(0, ticketManager.ticketToServe());
        ticketManager.nextTicket();
        ticketManager.serveNext();
        assertEquals(1, ticketManager.ticketToServe());
    }
}
