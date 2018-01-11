package it.uniupo.disit.se.lab10.view;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniupo.disit.se.lab10.model.Model;
import it.uniupo.disit.se.lab10.model.TicketManager;

public class TestView {

    private Model ticketManager;
    
    @Before
    public void setUp() {
        ticketManager = new TicketManager();
    }
    
	@Test
	public void customerStrategyTest() {
        RoleStrategy customerRole = new CustomerStrategy();
        assertEquals(0, customerRole.getTicketNumber(ticketManager));
        customerRole.incTicketNumber(ticketManager);
        assertEquals(1, customerRole.getTicketNumber(ticketManager));
	}
}




